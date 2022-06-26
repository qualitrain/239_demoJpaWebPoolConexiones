package qtx.jpa.gui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import qtx.jpa.dominio.Persona;


public class A_ConsultaPersonas {

	public static void main(String[] args) {
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("bdPuntoDeVenta");
			EntityManager em = fabrica.createEntityManager();
					    
			int id = 1;
		    Persona unaPersona = em.find(Persona.class, id);
		    if(unaPersona != null)
		    	System.out.println("La persona con id " + id + " se llama "+ unaPersona.getNombre());
		    else
		    	System.out.println("La persona con id " + id + " no existe ");
	}
}

