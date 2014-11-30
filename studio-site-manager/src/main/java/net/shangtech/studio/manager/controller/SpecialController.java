package net.shangtech.studio.manager.controller;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.studio.entity.SpecialPage;
import net.shangtech.studio.service.ISpecialPageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/special")
public class SpecialController {
	
	@Autowired private ISpecialPageService service;
	
	@ModelAttribute
	public void menu(Model model){
		model.addAttribute("menu", "special");
	}
	
	@RequestMapping({"/", "/list"})
	public String list(Model model){
		
		return "manager.special.list";
	}
	
	@RequestMapping({"/edit", "/create"})
	public String form(Model model){
		return "manager.special.form";
	}
	
	@RequestMapping("/save")
	public String save(SpecialPage special){
		return "redirect:/special";
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public AjaxResponse remove(@RequestParam Long id){
		return null;
	}
}
