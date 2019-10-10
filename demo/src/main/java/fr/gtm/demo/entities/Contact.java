package fr.gtm.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "contacts")
@NamedQueries({ @NamedQuery(name = "Contact.getByNom", query = "SELECT c FROM Contact c WHERE c.nom like :nom") })
public class Contact implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_contact")
	private long id;
	@Column(length = 5)
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	private String nom;
	private String prenom;
	@OneToOne(cascade = CascadeType.ALL)
	private Adresse adresse;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "emails", joinColumns = @JoinColumn(name = "fk_contact"))
	@Column(name = "email")
	private List<String> emails = new ArrayList<String>();

	public Contact() {
	}

	public Contact(Civilite civilite, String nom, String prenom) {
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
	}

	public void addEmail(String email) {
		emails.add(email);
	}

	public void addEmails(String... emails) {
		for (String email : emails) {
			this.emails.add(email);
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		return "Contact [civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
