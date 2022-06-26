/**
 * 
 */
package sn.siggi.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

/**
 * @author nabyFall
 *
 */

@Entity
@Table(name = "employes")
public class Employe implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="Name is required")
	private String nom;
	@NotEmpty(message="Name is required")
	private String prenom;
	
	@ManyToOne
	@JoinColumn(name = "id_dep")
	private Departement departement;
	
	@Transient
	private Integer idDep;
	
	
	public Employe() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Integer getIdDep() {
		return idDep;
	}

	public void setIdDep(Integer idDep) {
		this.idDep = idDep;
	}

}
