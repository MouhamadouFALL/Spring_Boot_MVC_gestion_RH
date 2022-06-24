/**
 * 
 */
package sn.siggi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.siggi.domaine.Departement;
import sn.siggi.repository.DepartementRepository;

/**
 * @author nabyFall
 *
 */
@Service
public class DepartementService {

	@Autowired
	private DepartementRepository repo;
	
	@Transactional
	public void create(Departement dep) {
		repo.save(dep);
	}
	
	@Transactional
	public void update(Departement dep) {
		
		Optional<Departement> optional = repo.findById(dep.getId());
		if (optional.isPresent()) {
			repo.save(dep);
		}
	}
	
	public Departement reseach(Integer id) {
		
		Departement dep = null;
		Optional<Departement> optional = repo.findById(id);
		if (optional.isPresent())
			dep = optional.get();
		
		return dep;
	}
	
	public List<Departement> list(){
		
		List<Departement> deps = repo.findAll();
		
		return deps;
	}
	
	@Transactional
	public void delete(Integer id) {
		
		if (repo.existsById(id)) repo.deleteById(id);
	}
}
