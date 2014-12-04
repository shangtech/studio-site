package net.shangtech.studio.manager.controller;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.studio.entity.SpecialPage;
import net.shangtech.studio.service.ISpecialPageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping({""})
	public String index(Pagination<SpecialPage> pagination, Model model){
		return index(null, pagination, model);
	}
	
	@RequestMapping({"/{id}"})
	public String index(@PathVariable Long id, Pagination<SpecialPage> pagination, Model model){
		service.findAllByPage(pagination);
		model.addAttribute("pagination", pagination);
		model.addAttribute("id", id);
		if(id != null){
			SpecialPage special = service.find(id);
			model.addAttribute("special", special);
		}
		return "manager.special";
	}
	
	@RequestMapping("/save")
	public String save(SpecialPage special, Pagination<SpecialPage> pagination, Model model){
		if(special.getId() == null){
			service.save(special);
		}
		else {
			service.update(special);
		}
		return index(pagination, model);
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public AjaxResponse remove(@RequestParam Long id){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		service.delete(id);
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
}
