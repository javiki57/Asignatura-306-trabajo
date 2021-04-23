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
import modelo.er.jpa.ejb.GestionMatricula;
import modelo.er.jpa.proyect.Asignatura;

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

	/*
	@Test
	public void testEliminarAsignatura() {
		try {
			final String asignatura = "Calculo";
			gestionMatricula.eliminarAsignatura(asignatura, m);
			
			List<Asignatura> lista;
			assertEquals(0, lista.size());
			
			
		} catch() {
			
		}
	}

	
	@Test
	public void testAniadirAsignatura() {
		try {
			final String asignatura = "Calculo";
			
			Asignatura asi = new Asignatura();
			
			
		} catch() {
			
		}
	}

	@Test
	public void testMostrarAlumno() {
		try {
			
			
		} catch() {
			
		}
	}
	
	@Test
	public void testEliminarAlumno() {
		try {
			
			
		} catch() {
			
		}
	}
	
	@Test
	public void testAniadirAlumno() {
		try {
			
			
		} catch() {
			
		}
	}
	*/

}
