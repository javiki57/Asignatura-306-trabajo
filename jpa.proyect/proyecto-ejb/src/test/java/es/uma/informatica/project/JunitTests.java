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

import es.uma.informatica.sii.jpa.ejb.GestionAlumno;
import es.uma.informatica.sii.jpa.ejb.GestionGrupo;
import es.uma.informatica.sii.jpa.ejb.GestionMatricula;
import es.uma.informatica.sii.jpa.exceptions.AlumnoNoEncontradoException;
import es.uma.informatica.sii.jpa.exceptions.AsignaturaExistenteException;
import es.uma.informatica.sii.jpa.exceptions.AsignaturaNoEncontradaException;
import es.uma.informatica.sii.jpa.exceptions.GrupoExistenteException;
import es.uma.informatica.sii.jpa.exceptions.GrupoNoEncontradoException;
import es.uma.informatica.sii.jpa.exceptions.MatriculaNoEncontradaException;
import es.uma.informatica.sii.jpa.proyect.Alumno;
import es.uma.informatica.sii.jpa.proyect.Asignatura;
import es.uma.informatica.sii.jpa.proyect.Expediente;
import es.uma.informatica.sii.jpa.proyect.Grupo;
import es.uma.informatica.sii.jpa.proyect.Grupo_por_Asignatura;
import es.uma.informatica.sii.jpa.proyect.Matricula;

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
	
	/*@Requisitos({"RF3"})
	@Test
	public void testEliminarAsignatura() {
		try {

			Asignatura Calculo = new Asignatura();

			Matricula matri = new Matricula();

			List<Asignatura> listaAsignatura = matri.getListado_Asignaturas();
			listaAsignatura.add(Calculo);

			gestionMatricula.eliminarAsignatura(Calculo, matri);

			assertEquals(0, listaAsignatura.size());

		} catch (Exception e) {
			fail("No deberia lanzarse esto");

		} 
	}*/
	
	/*@Requisitos({"RF3"})
	@Test
	public void testAniadirAsignatura() {
		try {
			Asignatura asi = new Asignatura();

			Matricula matri = new Matricula();

			List<Asignatura> listaAsignatura = matri.getListado_Asignaturas();

			gestionMatricula.aniadirAsignatura(asi, matri);

			assertEquals(1, listaAsignatura.size());

		} catch (AsignaturaExistenteException e) {
			fail("No deberia de salir esto");
		}
	}
	*/
	/*@Requisitos({"RF2"})
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
	}*/
	
	@Requisitos({"RF2"})
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
	
	@Requisitos({"RF2"})
	@Test
	public void testModificarAlumno() {
		try {
			Alumno Trunks = new Alumno();
			Alumno al = Trunks;
			Trunks.setCodigo_Postal_Notificacion("cpNot");
			Trunks.setDireccion_Notificacion("direccNot");
			Trunks.setEmail_Personal("trinksEmail");
			Trunks.setTelefono(111111111);
			Trunks.setMovil(222222222);
			
			gestionAlumno.actualizarAlumno(Trunks);
			
			assertEquals(al,Trunks);			
			
		} catch (AlumnoNoEncontradoException ee) {
			fail("No se ha modificado bien el alumno");
		} 
	}
	
	@Requisitos({"RF10,RF11,RF12,RF13"})
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
	
	@Requisitos({"RF15"})
	@Test
	public void testDarDeBajaMatricula() {
		try{
			
			Matricula matricula = new Matricula();
			matricula.setEstado(true);
			
			gestionMatricula.darDeBajaMatricula(matricula);
			
			assertEquals(false,matricula.getEstado());
			
		}catch(Exception e){
			fail("No deberia de salir esto");
			
		}
	}	

	@Requisitos({"RF5"})
	@Test
	public void testMostrarMatriculas() {
		
		/*try {
		
			Matricula matriculaDeVegeta = new Matricula();
		
			gestionMatricula.mostrarMatriculas(matriculaDeVegeta);
			
			assertNotEquals(gestionMatricula.mostrarMatriculas(matriculaDeVegeta),null);
			
		
		}catch(MatriculaNoEncontradaException e){
			fail("Está very mal");
		}
		*/
	}
	
	/*@Requisitos({"RF14"})
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
	}*/
	
	/*@Requisitos({"RF3"})
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
			
		}catch (AsignaturaExistenteException e) {
			fail("Asignatura existente");
		}
	}*/
	
	@Requisitos({"RF6"})
	@Test 
	public void testBuscarMatricula(){
		try {
			Alumno alumno = new Alumno();
			Expediente exp = new Expediente();
			exp.setActiva(true);
			Matricula m = new Matricula();
			m.setEstado(true);
			
			List<Matricula> listaM = new ArrayList();
			listaM.add(m);
			exp.setMatricula(listaM);
			
			List<Expediente> listaE = new ArrayList();
			listaE.add(exp);
			alumno.setExpediente(listaE);
			
			gestionAlumno.buscarMatriculas(alumno);
			
			assertNotEquals(gestionAlumno.buscarMatriculas(alumno),null);
			
		}catch(AlumnoNoEncontradoException e) {
			fail("Fallo al buscar los alumnos matriculados");
		}
	}

	@Requisitos({"RF4"})
	@Test
	public void testCrearGrupo() {
		try {
			Asignatura Calculo = new Asignatura();
			Grupo primeroA = new Grupo();
			
			List<Grupo_por_Asignatura> lista = primeroA.getGrupo();
			
			gestionGrupo.crearGrupo(Calculo, primeroA);
			
			assertNotEquals(lista.size(),0);
			
		}catch(AsignaturaNoEncontradaException | GrupoExistenteException e) {
			fail("No se ha creado el grupo correctamente");
		}
	}
	
	@Requisitos({"RF4"})
	@Test
	public void testBorrarGrupo() {
		try {
			Grupo primeroA = new Grupo();
			
			List<Grupo> lista = new ArrayList();
			lista.add(primeroA);
			gestionGrupo.borrarGrupo(primeroA);
			
			assertEquals(lista,null);		
			
		}catch(GrupoNoEncontradoException e) {
			fail("No se ha borrado el grupo correctamente");
		}
	}
	

	@Requisitos({"RF4"})
	@Test
	public void testMostrarGrupo() {
		
		try {
			Grupo primeroA = new Grupo();
			
			gestionGrupo.mostrarGrupo(primeroA);
			assertNotEquals(gestionGrupo.mostrarGrupo(primeroA),null);
		}catch(GrupoNoEncontradoException e) {
			fail("No se ha mostrado correctamente");
		}
		
	}
	
	@Requisitos({"RF4"})
	@Test
	public void testActualizarGrupo() {
		
		try {
			Grupo primeroA = new Grupo();
			//primeroA.setId((long)1);
			primeroA.setCurso("segundo");
			primeroA.setLetra('A');
			
			Grupo primeroB = new Grupo();
			//primeroA.setId((long)1);
			primeroA.setCurso("primero");
			primeroA.setLetra('A');
			
			gestionGrupo.actualizarGrupo(primeroA);
			
			assertNotEquals(primeroA,primeroB);
			
			
			
		}catch(GrupoNoEncontradoException e) {
			
		}
		
	}
}
