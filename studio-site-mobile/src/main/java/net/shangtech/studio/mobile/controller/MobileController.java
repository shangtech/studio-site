package net.shangtech.studio.mobile.controller;

import java.util.ArrayList;
import java.util.List;

import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.studio.entity.PhotoWorks;
import net.shangtech.studio.entity.Photographer;
import net.shangtech.studio.mobile.controller.vo.PhotographerVo;
import net.shangtech.studio.service.IPhotoWorksService;
import net.shangtech.studio.service.IPhotographerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MobileController {
	
	@Autowired private IPhotographerService photographerService;
	@Autowired private IPhotoWorksService worksService;

	@RequestMapping({ "/", "/main", "/index" })
	public String index(Model model) {
		return "mobile.index";
	}
	
	@RequestMapping(value = "/photographer", method = RequestMethod.GET)
	public String photographerHome(Model model){
		Pagination<Photographer> pagination = new Pagination<Photographer>(8);
		photographerService.findAllByPage(pagination);
		model.addAttribute("pagination", pagination);
		return "mobile.photographer";
	}
	
	@ResponseBody
	@RequestMapping(value = "/photographer", method = RequestMethod.POST)
	public List<PhotographerVo> photographerList(Pagination<Photographer> pagination){
		List<PhotographerVo> list = new ArrayList<>();
		photographerService.findAllByPage(pagination);
		if(!CollectionUtils.isEmpty(pagination.getItems())){
			pagination.getItems().forEach(photographer -> {
				PhotographerVo vo = new PhotographerVo();
				vo.setF_url(photographer.getImage());
				vo.setUrl(photographer.getUrl());
				vo.setOrder_count(photographer.getAppointments());
				vo.setShotfeeoneday(photographer.getPrice());
				vo.setUsersdesc(photographer.getDescription());
				vo.setUsersname(photographer.getName());
				vo.setYear(photographer.getExperience());
				list.add(vo);
			});
		}
		return list;
	}
	
	@RequestMapping("/photographer/{url}")
	public String photographerDetail(@PathVariable String url, Model model){
		Photographer photographer = photographerService.findByUrl(url);
		if(photographer == null){
			throw new RuntimeException();
		}
		model.addAttribute("photographer", photographer);
		List<PhotoWorks> works = worksService.findByPhotographer(photographer.getId());
		model.addAttribute("works", works);
		return "mobile.photographer.detail";
	}
}
