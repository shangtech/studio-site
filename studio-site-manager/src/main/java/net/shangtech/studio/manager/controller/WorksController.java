package net.shangtech.studio.manager.controller;

import java.util.List;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.studio.entity.PhotoWorks;
import net.shangtech.studio.entity.Photographer;
import net.shangtech.studio.service.IPhotoWorksService;
import net.shangtech.studio.service.IPhotographerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/works")
public class WorksController {
	
	@Autowired private IPhotoWorksService service;
	@Autowired private IPhotographerService photographerService;
	
	@ModelAttribute
	public void menu(Model model){
		model.addAttribute("menu", "works");
	}
	
	
	@RequestMapping({"", "/list"})
	public String list(Pagination<PhotoWorks> pagination, Model model){
		return list(null, pagination, model);
	}
	
	@RequestMapping({"/{author}", "/{author}/list"})
	public String list(@PathVariable Long author, Pagination<PhotoWorks> pagination, Model model){
		List<Photographer> photographers = photographerService.findAll();
		model.addAttribute("photographers", photographers);
		model.addAttribute("author", author);
		service.findByPhotographerByPage(pagination, author);
		model.addAttribute("pagination", pagination);
		if(author == null){
			pagination.getItems().forEach(works -> {
				works.setPhotographer(photographerService.find(works.getAuthor()));
			});
		}
		return "manager.works.list";
	}
	
	@RequestMapping({"/edit", "/create"})
	public String form(@RequestParam(required = false) Long id, Model model){
		return form(null, id, model);
	}
	
	@RequestMapping({"/{author}/edit", "/{author}/create"})
	public String form(@PathVariable Long author, @RequestParam(required = false) Long id, Model model){
		PhotoWorks works = null;
		if(id != null){
			works = service.find(id);
		}
		if(works == null){
			works = new PhotoWorks();
		}
		if(author != null){
			Photographer photographer = photographerService.find(author);
			if(photographer != null){
				works.setPhotographer(photographer);
				model.addAttribute("author", author);
			}
		}
		model.addAttribute("works", works);
		return "manager.works.form";
	}
	
	@RequestMapping("/save")
	public String save(PhotoWorks works, Model model){
		return save(null, works, model);
	}
	
	@RequestMapping("/{author}/save")
	public String save(@PathVariable Long author, PhotoWorks works, Model model){
		Photographer photographer = null;
		if(author != null){
			photographer = photographerService.find(author);
			if(photographer == null && works.getAuthor() != null){
				photographer = photographerService.find(works.getAuthor());
			}
		}
		if(photographer == null){
			model.addAttribute("author", author);
			model.addAttribute("photographers", photographerService.findAll());
			model.addAttribute("works", works);
			return "manager.works.form";
		}
		if(works.getId() == null){
			works.setAuthor(photographer.getId());
			service.save(works);
		}
		else {
			service.update(works);
		}
		return "redirect:/works" + (author==null ? "" : "/"+author);
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
