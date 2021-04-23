package es.uma.informatica.project;


import static org.junit.Assert.*;

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
import modelo.er.jpa.exceptions.MatriculaException;
import modelo.er.jpa.exceptions.MatriculaNoEncontradaException;
import modelo.er.jpa.proyect.Alumno;
import modelo.er.jpa.proyect.Asignatura;
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

	


}
