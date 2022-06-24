/**
 * 
 */
package sn.siggi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sn.siggi.domaine.Departement;
import sn.siggi.service.DepartementService;

/**
 * @author nabyFall
 *
 */
@Controller
public class DepartementController {

	@Autowired
	private DepartementService depService;
	
	@GetMapping("/list")
	public String listDep(Model model) {
		
		List<Departement> deps = depService.list();
		model.addAttribute("deps", deps);
		return "list";
	}
	
	@GetMapping("/addDep")
	public String viewFormDep(Model model) {
		
		Departement dep = new Departement();
		model.addAttribute("dep", dep);
		return "addDep";
	}
	
	// Enregistrer un Departement
	@PostMapping("/saveDep")
	public String save(@Valid @ModelAttribute("dep") Departement dep, BindingResult result, Model model) {
		
		if (result.hasErrors())
			return "addDep";
		depService.create(dep);
		return "redirect:/list";
	}
	
	// Modification Department
	
	@GetMapping("/edit{id}")
	public String editDetail(@PathVariable(value="id") Integer id, Model model) {
		
		Departement dep = depService.reseach(id);
		model.addAttribute("dep", dep);
		
		return "edit";
	}
	
	@PostMapping("/edit")
	public String edit(@Valid @ModelAttribute("dep") Departement dep, BindingResult result) {
		
		if (result.hasErrors())
			return "edit";
		depService.update(dep);
		return "redirect:/list";
	}
	
	@GetMapping("/delete{id}")
	public String delete(@PathVariable(value = "id") Integer id) {
		
		depService.delete(id);
		return "redirect:/list";
	}
	
	@GetMapping({"/", "/index", "/home", "/accueil"})
	public String home() {
		
		return "index";
	}
}
