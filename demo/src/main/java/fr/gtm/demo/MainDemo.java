package fr.gtm.demo;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.gtm.demo.dao.ContactDAO;
import fr.gtm.demo.entities.Adresse;
import fr.gtm.demo.entities.Civilite;
import fr.gtm.demo.entities.Contact;

public class MainDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
		ContactDAO dao = new ContactDAO(emf);

		Contact c1 = new Contact(Civilite.Mme, "Doe", "Manon");
		c1.addEmail("manon@gmail.com");
		c1.setAdresse(new Adresse("avenue de la grande armee", "75008", "Paris"));
		dao.create(c1);

//		List<Contact> contacts = dao.getContactsByCivilite(Civilite.Mme);
//		contacts.forEach(System.out::println);
//		List<Contact> contacts2 = dao.getContactsByNom("D");
//		contacts2.forEach(System.out::println);
		
//		Contact c2 = dao.getContactById(c1.getId());
//		List<String> emails = dao.getEmails(c2);
//		emails.forEach(System.out::println);

		emf.close();
	}

}
