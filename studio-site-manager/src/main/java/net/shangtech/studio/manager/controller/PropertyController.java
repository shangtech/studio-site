package net.shangtech.studio.manager.controller;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.studio.entity.SiteProperty;
import net.shangtech.studio.remote.ISitePropertyRemoteService;
import net.shangtech.studio.service.ISitePropertyService;
import net.shangtech.studio.util.SitePropertyUtils;

import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(PropertyController.class);
	
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
	public String save(PropertyForm form, Model model, HttpServletRequest request){
		service.save(form.getList());
		SitePropertyUtils.refreshProperties(request.getServletContext());
		// 加个远程调用刷新mobile端的properties
		refreshRemoteProperties();
		return "redirect:/properties";
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public AjaxResponse remove(@RequestParam Long id, HttpServletRequest request){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		SiteProperty property = service.find(id);
		if(property != null && !BooleanUtils.isTrue(property.getIsDefault())){
			service.delete(property.getId());
		}
		SitePropertyUtils.refreshProperties(request.getServletContext());
		// 加个远程调用刷新mobile端的properties
		refreshRemoteProperties();
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
	
	private void refreshRemoteProperties(){
		try {
	        ISitePropertyRemoteService remoteService = (ISitePropertyRemoteService) Naming.lookup("rmi://127.0.0.1:8888/property-service");
	        remoteService.refreshSiteProperties();
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
	        logger.error("调用远程接口刷新站点属性异常", e);
        }
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
