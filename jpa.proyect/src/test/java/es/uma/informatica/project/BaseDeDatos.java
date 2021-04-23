package es.uma.informatica.project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import modelo.er.jpa.proyect.*;

public class BaseDeDatos {

	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Alumno Vegeta = new Alumno();
		Vegeta.setDNI("15784968D");
		
		Alumno Goten = new Alumno();
		Goten.setDNI("54869214N");
		
		Alumno Trunks = new Alumno();
		Trunks.setDNI("98754826Y");

		for (Alumno al : new Alumno [] {Vegeta, Trunks, Goten}) {
			em.persist(al);
		}
		
	}

}
