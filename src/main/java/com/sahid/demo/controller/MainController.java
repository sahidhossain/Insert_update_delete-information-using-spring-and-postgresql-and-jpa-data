package com.sahid.demo.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sahid.demo.model.Student;
import com.sahid.demo.repo.StudentRepository;
import com.sahid.demo.service.StudentService;

@Controller
public class MainController {

	@Autowired
	StudentService ss;

	@Autowired
	StudentRepository sr;

	Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("Messege");
		return "index";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String studentform(Model model) {
		model.addAttribute("student", new Student());
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String studentsubmit(@ModelAttribute Student student, Model model) {
		model.addAttribute("student", student);
		model.addAttribute("student", new Student());
		if (student.getEmail() == null || student.getEmail().length() <= 0 || student.getPassword().equals(null)
				|| student.getPassword().length() <= 0) {
			model.addAttribute("error1", "Please fill up all the fields correctly");
		} else {
			Student getresponseid = sr.save(student);
			if (getresponseid.getId() > 0) {
				model.addAttribute("success", "Data is Inserted Successfully");
			} else {
				model.addAttribute("error2", "Data not inserted");
			}
		}
		return "form";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String allData(Model model) {
		model.addAttribute("student", ss.getAllStudentData());
		return "all";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete_method(@RequestParam(name = "id") Long id, Model model, RedirectAttributes redirect) {
		Long i = ss.deleteOne(id);
		if (i > 0) {
			redirect.addFlashAttribute("delete", "ID " + i + " Deleted Successfully");
		} else {
			redirect.addFlashAttribute("not_delete", "Data is not deleted");
		}

		return "redirect:/all";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit_student_form(@ModelAttribute Student student, @RequestParam(name = "id") Long id, Model model) {
		model.addAttribute("student", ss.findOne(id));
		return "edit_form";
	}

	@RequestMapping(value = "/edit_form", method = RequestMethod.POST)
	public String student_update(@ModelAttribute Student student, @RequestParam(name = "id") Long id, Model model) {
		Student get_update_id = ss.update(student);
		if (student.getEmail() == null || student.getEmail().length() <= 0 || student.getPassword().equals(null)
				|| student.getPassword().length() <= 0) {
			model.addAttribute("error1", "Please fill up all the fields correctly");
			return "edit_form";
		} else {
			if (get_update_id.getId() > 0) {
				model.addAttribute("update", "ID " + get_update_id.getId() + " is Updated Successfully");
			} else {
				model.addAttribute("error2", "Data not Updated");
			}
		}
		model.addAttribute("student", new Student());

		return "edit_form";
	}

}
