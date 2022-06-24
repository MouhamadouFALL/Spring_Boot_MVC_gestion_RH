/**
 * 
 */
package sn.siggi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.siggi.domaine.Employe;
import sn.siggi.repository.EmployeRepository;

/**
 * @author nabyFall
 *
 */
@Service
public class EmployeService {
	
	@Autowired
	private EmployeRepository repo;
	
	
	@Transactional
	public void create(Employe e) {
		
		repo.save(e);
	}
	
	@Transactional
	public void update(Employe e) {
		
		if (repo.existsById(e.getId()))
			repo.save(e);
	}
	
	public Employe reseach(Integer id) {
		
		Employe e = null;
		Optional<Employe> optional = repo.findById(id);
		if (optional.isPresent())
			e = optional.get();
		
		return e;
	}
	
	public List<Employe> list(){
		
		List<Employe> employes = repo.findAll();
		return employes;
	}
	
	@Transactional
	public void delete(Integer id) {
		
		if (repo.existsById(id))
			repo.deleteById(id);
	}

}
