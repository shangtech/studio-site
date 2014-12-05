package net.shangtech.studio.manager.controller;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.studio.entity.Appointment;
import net.shangtech.studio.service.IAppointmentService;
import net.shangtech.studio.service.IPhotographerService;
import net.shangtech.studio.service.ISpecialPageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired private IAppointmentService service;
	@Autowired private IPhotographerService photographerService;
	@Autowired private ISpecialPageService specialService;
	
	@RequestMapping("/special")
	public String listSpecial(Pagination<Appointment> pagination, Model model){
		return listSpecial(null, pagination, model);
	}
	
	@RequestMapping({"/special/{special}"})
	public String listSpecial(@PathVariable Long special, Pagination<Appointment> pagination, Model model){
		service.findBySpecial(special, pagination);
		pagination.getItems().forEach(appointment -> {
			appointment.setTarget(specialService.find(appointment.getPurpose()));
		});
		model.addAttribute("pagination", pagination);
		model.addAttribute("list", specialService.findAll());
		model.addAttribute("type", "special");
		model.addAttribute("menu", "appointment-special");
		model.addAttribute("id", special);
		return "manager.appointment.list";
	}
	
	@RequestMapping("/photographer")
	public String listPhotographer(Pagination<Appointment> pagination, Model model){
		return listPhotographer(null, pagination, model);
	}
	
	@RequestMapping({"/photographer/{photographer}"})
	public String listPhotographer(@PathVariable Long photographer, Pagination<Appointment> pagination, Model model){
		service.findByPhotographer(photographer, pagination);
		pagination.getItems().forEach(appointment -> {
			appointment.setTarget(photographerService.find(appointment.getPurpose()));
		});
		model.addAttribute("pagination", pagination);
		model.addAttribute("list", photographerService.findAll());
		model.addAttribute("type", "photographer");
		model.addAttribute("menu", "appointment-photographer");
		model.addAttribute("id", photographer);
		return "manager.appointment.list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/memo", method = RequestMethod.POST)
	public AjaxResponse memo(Appointment appointment){
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public AjaxResponse remove(@RequestParam Long id){
		
		return null;
	}
	
}
