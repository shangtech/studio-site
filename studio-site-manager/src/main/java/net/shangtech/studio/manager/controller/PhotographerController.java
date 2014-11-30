package net.shangtech.studio.manager.controller;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.studio.entity.Photographer;
import net.shangtech.studio.service.IPhotographerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/photographer")
public class PhotographerController {
	
	@Autowired private IPhotographerService service;
	
	@ModelAttribute
	public void menu(Model model){
		model.addAttribute("menu", "photographer");
	}
	
	@RequestMapping({"", "/list"})
	public String list(Pagination<Photographer> pagination, Model model){
		service.findAllByPage(pagination);
		model.addAttribute("pagination", pagination);
		return "manager.photographer.list";
	}
	
	@RequestMapping({"/edit", "/create"})
	public String form(@RequestParam(required = false) Long id, Model model){
		Photographer photographer = new Photographer();
		if(id != null){
			photographer = service.find(id);
		}
		model.addAttribute("photographer", photographer);
		return "manager.photographer.form";
	}
	
	@RequestMapping("/save")
	public String save(Photographer photographer){
		if(photographer.getId() == null){
			service.save(photographer);
		}
		else{
			service.update(photographer);
		}
		return "redirect:/photographer/list";
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public AjaxResponse remove(@RequestParam Long id){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		Photographer old = service.find(id);
		if(old != null){
			service.delete(id);
		}
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
	
}
