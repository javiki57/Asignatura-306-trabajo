package es.uma.informatica.project;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modelo.er.jpa.ejb.GestionAlumno;
import modelo.er.jpa.ejb.GestionMatricula;

public class JunitTests {
	
	private static final String ALUMNO_EJB = "java:global/classes/AlumnoEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrazabilidadTest";
	private static final String MATRICULA_EJB = "java:global/classes/MatriculaEJB";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;
	
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

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
