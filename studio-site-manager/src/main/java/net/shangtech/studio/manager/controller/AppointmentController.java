package net.shangtech.studio.manager.controller;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.studio.entity.Appointment;
import net.shangtech.studio.service.IAppointmentService;

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
	
	@RequestMapping({"/", "/list", "/special/{special}/list", "/photographer/{photographer}/list"})
	public String list(@PathVariable Long special, @PathVariable Long photograhpher, Pagination<Appointment> appointment, Model model){
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
