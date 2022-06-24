/**
 * 
 */
package sn.siggi.domaine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * @author nabyFall
 *
 */
@Entity
@Table(name = "departements")
public class Departement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dep")
	private Integer id;
	@NotEmpty(message="Name is required")
	private String nomDep;
	
	@OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
	private List<Employe> employes;
	
	public Departement() { }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomDep() {
		return nomDep;
	}

	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
}
