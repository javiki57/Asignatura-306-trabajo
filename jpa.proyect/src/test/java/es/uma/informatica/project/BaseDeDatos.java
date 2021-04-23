package es.uma.informatica.project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import antlr.collections.List;
import modelo.er.jpa.proyect.*;

public class BaseDeDatos {

	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Asignatura Calculo = new Asignatura();
		//Calculo.setNombre("Calculo");
		Asignatura PL = new Asignatura();
		Asignatura Discretas = new Asignatura();
		
		for(Asignatura as : new Asignatura [] {Calculo,PL,Discretas}) {
			em.persist(as);
		}
		
		Matricula matricula = new Matricula();
		
		
		
		
		
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
