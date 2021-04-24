package es.uma.informatica.project;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import modelo.er.jpa.ejb.GestionAlumno;
import modelo.er.jpa.ejb.GestionGrupo;
import modelo.er.jpa.ejb.GestionMatricula;
import modelo.er.jpa.exceptions.AlumnoNoEncontradoException;
import modelo.er.jpa.exceptions.AsignaturaExistenteException;
import modelo.er.jpa.exceptions.AsignaturaNoEncontradaException;
import modelo.er.jpa.exceptions.GrupoNoEncontradoException;
import modelo.er.jpa.exceptions.MatriculaNoEncontradaException;
import modelo.er.jpa.proyect.Alumno;
import modelo.er.jpa.proyect.Asignatura;
import modelo.er.jpa.proyect.Expediente;
import modelo.er.jpa.proyect.Matricula;
import modelo.er.jpa.proyect.Grupo;
import modelo.er.jpa.proyect.Matricula;
import modelo.er.jpa.exceptions.AsignaturaExistenteException;
import modelo.er.jpa.exceptions.AsignaturaNoEncontradaException;
import modelo.er.jpa.exceptions.MatriculaNoEncontradaException;

public class JunitTests {

	private static final String ALUMNO_EJB = "java:global/classes/AlumnoEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrazabilidadTest";
	private static final String MATRICULA_EJB = "java:global/classes/MatriculaEJB";

	public static EJBContainer ejbContainer;
	public static Context ctx;

	private GestionAlumno gestionAlumno;
	private GestionMatricula gestionMatricula;
	private GestionGrupo gestionGrupo;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

	@Before
	public void setUp() throws Exception {
		gestionMatricula = (GestionMatricula) ctx.lookup(MATRICULA_EJB);
		gestionAlumno = (GestionAlumno) ctx.lookup(ALUMNO_EJB);
		BaseDeDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testEliminarAsignatura() {
		try {

			Asignatura Calculo = new Asignatura();

			Matricula matri = new Matricula();

			List<Asignatura> listaAsignatura = matri.getListado_Asignaturas();
			listaAsignatura.add(Calculo);

			gestionMatricula.eliminarAsignatura(Calculo, matri);

			assertEquals(0, listaAsignatura.size());

		} catch (MatriculaNoEncontradaException e) {
			fail("No deberia lanzarse esto");

		} catch (AsignaturaNoEncontradaException e) {
			fail("No deberia de saltar esto");
		}
	}

	@Test
	public void testAniadirAsignatura() {
		try {
			Asignatura asi = new Asignatura();

			Matricula matri = new Matricula();

			List<Asignatura> listaAsignatura = matri.getListado_Asignaturas();

			gestionMatricula.aniadirAsignatura(asi, matri);

			assertEquals(1, listaAsignatura.size());

		} catch (AsignaturaNoEncontradaException e) {
			fail("No deberia de salir esto");
		} catch (MatriculaNoEncontradaException e) {
			fail("No deberia de salir esto");
		} catch (AsignaturaExistenteException e) {
			fail("No deberia de salir esto");
		}
	}
	
	@Test 
	public void testMostrarAlumno() { 
		try {
			Alumno Vegeta = new Alumno();
			Vegeta.setDNI("15784964D");
			gestionAlumno.mostrarAlumno(Vegeta);
			
			assertNotEquals(gestionAlumno.mostrarAlumno(Vegeta),null);
	  
		} catch (AlumnoNoEncontradoException ee) {
			fail("No deberia de salir tito");
		} 
	}
	
	@Test
	public void testEliminarAlumno() {
		try {
			Alumno Trunks = new Alumno();
			
			List<Alumno> lista = null;
			lista.add(Trunks);
	
			gestionAlumno.eliminarAlumno(Trunks);
			
			assertEquals(0, lista.size());
		} catch (AlumnoNoEncontradoException ee) {
			fail("No deberia de salir tito");
		} 
	}
	
	@Test
	public void testAsignarGrupoAlumno() {
		try {
			Alumno al1 = new Alumno();
			
			
			gestionGrupo.asignarGrupoAlumno(al1);//Este metodo le asignara un grupo al alumno
			
			
			Grupo grupo =al1.getExpediente().get(0).getMatriculas().get(0).getAsignatura_matricula().get(0).getGrupo();
		
			
			assertNotEquals(grupo,null);
			
		}catch(GrupoNoEncontradoException | AlumnoNoEncontradoException e) {
			fail("No deberia de salir esto ");
			
		}
	}
	@Test
	public void testDarDeBajaMatricula() {
		try{
			
			Matricula matricula = new Matricula();
			matricula.setEstado(true);
			
			gestionMatricula.darDeBajaMatricula(matricula);
			
			assertEquals(false,matricula.getEstado());
			
		}catch(MatriculaNoEncontradaException e){
			fail("No deberia de salir esto");
			
		}
	}	

	public void testMostrarMatricula() {
		
		try {
		
			Matricula matriculaDeVegeta = new Matricula();
		
			gestionMatricula.mostrarMatriculas(matriculaDeVegeta);
			
			assertNotEquals(gestionMatricula.mostrarMatriculas(matriculaDeVegeta),null);
			
		
		}catch(MatriculaNoEncontradaException e){
			fail("Está very mal");
		}
		
	}
	@Requisitos({"RF14"})
	@Test
	public void testMostrarAlumnosNuevos() {
		try {
			Alumno al1 = new Alumno();
			Alumno al2 = new Alumno();
			Alumno al3 = new Alumno();
			Expediente e1 = new Expediente();
			Expediente e2 = new Expediente();
			Expediente e3 = new Expediente();
			Matricula m1 = new Matricula();
			Matricula m2 = new Matricula();
			Matricula m3 = new Matricula();
			
			al1.setNombre_Completo("Juan jose perez");
			al2.setNombre_Completo("Joaquin Ramirez pacheco");
			al3.setNombre_Completo("Alberto Bueno Guapo");
			
			e1.setActiva(true);
			e2.setActiva(true);
			e3.setActiva(true);
			
			m1.setEstado(true);
			m2.setEstado(true);
			m3.setEstado(true);
			m1.setNuevo_Ingreso(false);
			m2.setNuevo_Ingreso(true);
			m3.setNuevo_Ingreso(true);
			
			List <Matricula> lm1 = new ArrayList<>();
			lm1.add(m1);
			e1.setMatricula(lm1);
			List <Matricula> lm2 = new ArrayList<>();
			lm2.add(m2);
			e2.setMatricula(lm2);
			List <Matricula> lm3 = new ArrayList<>();
			lm3.add(m3);
			e3.setMatricula(lm3);
			
			List<Expediente> le1 = new ArrayList<>();
			le1.add(e1);
			al1.setExpediente(le1);
			List<Expediente> le2  = new ArrayList<>();
			le2.add(e2);
			al2.setExpediente(le2);
			List<Expediente> le3 = new ArrayList<>();
			le3.add(e3);
			al3.setExpediente(le3);
			
			List<Alumno> alumnos =  new ArrayList<>();
			//alumnos.add(al1);
			alumnos.add(al2);
			alumnos.add(al3);
			
			gestionAlumno.mostrarAlumnosNuevos(al1);
			assertEquals(gestionAlumno.mostrarAlumnosNuevos(al1), alumnos);
			
		}catch(AlumnoNoEncontradoException e){
			fail("Esto esta mal");
		}
	}
	
	@Requisitos({"RF3"})
	@Test
	public void testIntercambiarAsignaturas() {
		try {
			Asignatura Calculo = new Asignatura();
			Asignatura PL = new Asignatura();
			Matricula m = new Matricula();
			
			List<Asignatura> lista = new ArrayList<>();
			lista.add(Calculo);
			m.setListado_Asignaturas(lista);
			
			List<Asignatura> listaNueva = new ArrayList<>();
			listaNueva.add(PL);
			
			gestionMatricula.intercambiarAsignaturas(Calculo, PL, m);
			assertEquals(lista, listaNueva);
			
		}catch (AsignaturaNoEncontradaException e) {
			fail("Asignatura no encontrada");
		}catch(MatriculaNoEncontradaException e) {
			fail("Matricula no encontrada");
		}catch (AsignaturaExistenteException e) {
			fail("Asignatura existente");
		}
	}
	
	@Requisitos({RF-06})
	@Test 
	public List<Alumno> testBuscarMatricula(){
		try {
			Alumno alumno1 = new Alumno();
			
			return gestionAlumno.buscarMatriculas(alumno1);
			
		}catch(AlumnoNoEncontradoException e) {
			throw new RuntimeException(e);
		}
	}


}
