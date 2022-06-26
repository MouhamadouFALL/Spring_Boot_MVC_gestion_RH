/**
 * 
 */
package sn.siggi.controller;

import java.util.List;
import java.util.Optional;

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
import sn.siggi.domaine.Employe;
import sn.siggi.service.DepartementService;
import sn.siggi.service.EmployeService;

/**
 * @author nabyFall
 *
 */
@Controller
public class EmployeController {

	@Autowired
	private EmployeService employeService;
	@Autowired
	private DepartementService depService;
	
	@GetMapping("/listEmploy")
	public String listDep(Model model) {
		
		List<Employe> employes = employeService.list();
		model.addAttribute("employes", employes);
		return "listEmploy";
	}
	
	
	@GetMapping("/addEmploy")
	public String viewFormDep(Model model) {
		
		Employe em = new Employe();
		model.addAttribute("em", em);
		//model.addAttribute("titre", "Form Employ");
		List<Departement> deps = depService.list();
		model.addAttribute("deps", deps);
		
		return "addEmploy";
		
	}
	
	// Enregistrer un Employ
	@PostMapping("/saveEmploy")
	public String save(@Valid @ModelAttribute("em") Employe em, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			// List<Departement> deps = depService.list();
			// model.addAttribute("deps", deps);
			return "addEmploy";
		}
			
		employeService.create(em);
		return "redirect:/listEmploy";
	}
	
	// Modification Department
	@GetMapping("/editEmploy{id}")
	public String editDetail(@PathVariable(value="id") Integer id, Model model) {
		
		Employe em = employeService.reseach(id);
		List<Departement> deps = depService.list();
		model.addAttribute("em", em);
		model.addAttribute("deps", deps);
		
		return "editEmploy";
	}
	
	@PostMapping("/editEmploy")
	public String edit(@Valid @ModelAttribute("em") Employe em, BindingResult result) {
		
		if (result.hasErrors())
			return "editEmploy";
		employeService.update(em);
		return "redirect:/listEmploy";
	}
	
	
	@GetMapping("/deleteEmploy{id}")
	public String delete(@PathVariable(value = "id") Integer id) {
		
		employeService.delete(id);
		return "redirect:/listEmploy";
	}

}
