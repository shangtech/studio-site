package net.shangtech.studio.manager.controller;

import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.studio.entity.PhotoWorks;
import net.shangtech.studio.service.IPhotoWorksService;
import net.shangtech.studio.service.IStyleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/style")
public class StyleController {
	
	@Autowired private IStyleService service;
	@Autowired private IPhotoWorksService worksService;
	
	@ModelAttribute
	public void menu(Model model){
		model.addAttribute("menu", "style");
	}
	
	@RequestMapping({"", "/"})
	public String Index(Pagination<PhotoWorks> pagination, Model model){
		return index(null, pagination, model);
	}
	
	@RequestMapping("/{id}")
	public String index(@PathVariable Long id, Pagination<PhotoWorks> pagination, Model model){
		if(id == null){
			worksService.findAllByPage(pagination);
		}
		else{
			worksService.findByStyleByPage(pagination, id);
		}
		model.addAttribute("pagination", pagination);
		model.addAttribute("id", id);
		model.addAttribute("list", service.findAll());
		return "manager.style";
	}
	
	
	
}
