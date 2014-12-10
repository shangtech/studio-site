package net.shangtech.studio.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.studio.entity.PhotoWorks;
import net.shangtech.studio.entity.Style;
import net.shangtech.studio.entity.WorksToStyle;
import net.shangtech.studio.service.IPhotoWorksService;
import net.shangtech.studio.service.IPhotographerService;
import net.shangtech.studio.service.IStyleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/style")
public class StyleController {
	
	@Autowired private IStyleService service;
	@Autowired private IPhotoWorksService worksService;
	@Autowired private IPhotographerService photographerService;
	
	@ModelAttribute
	public void menu(Model model){
		model.addAttribute("menu", "style");
	}
	
	@RequestMapping({"", "/"})
	public String index(Pagination<WorksToStyle> pagination, Model model){
		return index(null, pagination, model);
	}
	
	@RequestMapping("/{id}")
	public String index(@PathVariable Long id, Pagination<WorksToStyle> pagination, Model model){
		pagination.setLimit(6);
		if(id != null){
			worksService.findByStyleByPage(pagination, id);
			model.addAttribute("style", service.find(id));
		}
		model.addAttribute("pagination", pagination);
		model.addAttribute("id", id);
		model.addAttribute("list", service.findAll());
		return "manager.style";
	}
	
	@RequestMapping("/save")
	public String save(Style style){
		if(style.getId() == null){
			service.save(style);
		}
		else{
			service.update(style);
		}
		return "redirect:/style/" + style.getId();
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public AjaxResponse remove(@RequestParam Long id){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		service.delete(id);
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping("/{style}/add")
	public AjaxResponse add(@PathVariable Long style, @RequestParam Long works){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		service.addWorksToStyle(works, style);
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping("/{style}/remove")
	public AjaxResponse remove(@PathVariable Long style, @RequestParam Long works){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		service.removeWorksToStyle(works, style);
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
	
	@RequestMapping("/pick")
	public String pick(@RequestParam Long style, Pagination<PhotoWorks> pagination, Model model){
		pagination.setLimit(6);
		worksService.findAllByPage(pagination);
		List<WorksToStyle> list = worksService.findByStyle(style);
		Map<Long, WorksToStyle> map = new HashMap<>();
		list.forEach(wts -> {
			map.put(wts.getPhotoWorks().getId(), wts);
		});
		pagination.getItems().forEach(works -> {
			works.setSelected(false);
			if(map.get(works.getId()) != null){
				works.setSelected(true);
			}
			works.setPhotographer(photographerService.find(works.getAuthor()));
		});
		model.addAttribute("pagination", pagination);
		model.addAttribute("style", service.find(style));
		return "manager.style.pick";
	}
}
