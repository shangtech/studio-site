package net.shangtech.studio.manager.controller;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.studio.entity.PhotoWorks;
import net.shangtech.studio.service.IPhotoWorksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/works")
public class WorksController {
	
	@Autowired private IPhotoWorksService service;
	
	@RequestMapping({"/", "/list", "/{author}", "/{author}/list"})
	public String list(@PathVariable Long author, Pagination<PhotoWorks> pagination, Model model){
		return "manager.works.list";
	}
	
	@RequestMapping({"/edit", "create", "/{author}/edit", "/{author}/create"})
	public String form(@PathVariable Long author, @RequestParam(required = false) Long id){
		return "manager.works.form";
	}
	
	@RequestMapping({"/save", "/{author}/save"})
	public String save(@PathVariable Long author, PhotoWorks works){
		return "redirect:/works" + (author==null ? "" : "/"+author);
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public AjaxResponse remove(@RequestParam Long id){
		return null;
	}
	
}
