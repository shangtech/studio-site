package net.shangtech.studio.manager.controller;

import java.io.Serializable;
import java.util.List;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.studio.entity.SiteProperty;
import net.shangtech.studio.service.ISitePropertyService;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/properties")
public class PropertyController {
	
	@Autowired private ISitePropertyService service;
	
	@ModelAttribute
	public void menu(Model model){
		model.addAttribute("menu", "properties");
	}
	
	@RequestMapping("")
	public String properties(Model model){
		model.addAttribute("properties", service.findAll());
		return "manager.properties";
	}
	
	@RequestMapping("/save")
	public String save(PropertyForm form, Model model){
		service.save(form.getList());
		return "redirect:/properties";
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public AjaxResponse remove(@RequestParam Long id){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		SiteProperty property = service.find(id);
		if(property != null && !BooleanUtils.isTrue(property.getIsDefault())){
			service.delete(property.getId());
		}
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
}
class PropertyForm implements Serializable{
	
    private static final long serialVersionUID = -3457300175997388418L;
    
	private List<SiteProperty> list;

	public List<SiteProperty> getList() {
		return list;
	}

	public void setList(List<SiteProperty> list) {
		this.list = list;
	}
	
}
