package net.shangtech.studio.mobile.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.studio.entity.Appointment;
import net.shangtech.studio.entity.Appointment.AppointmentType;
import net.shangtech.studio.entity.PhotoWorks;
import net.shangtech.studio.entity.Photographer;
import net.shangtech.studio.entity.SpecialPage;
import net.shangtech.studio.entity.Style;
import net.shangtech.studio.entity.WorksToStyle;
import net.shangtech.studio.mobile.controller.vo.PhotoWorksVo;
import net.shangtech.studio.mobile.controller.vo.PhotographerVo;
import net.shangtech.studio.service.IAppointmentService;
import net.shangtech.studio.service.IPhotoWorksService;
import net.shangtech.studio.service.IPhotographerService;
import net.shangtech.studio.service.ISpecialPageService;
import net.shangtech.studio.service.IStyleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MobileController {
	
	@Autowired private IPhotographerService photographerService;
	@Autowired private IPhotoWorksService worksService;
	@Autowired private IStyleService styleService;
	@Autowired private IAppointmentService appointmentService;
	@Autowired private ISpecialPageService pageService;

	@RequestMapping({ "/", "/main", "/index" })
	public String index(Model model) {
		List<SpecialPage> pages = pageService.findAll();
		List<SpecialPage> result = new ArrayList<SpecialPage>();
		if (pages != null) {
			for (SpecialPage item : pages) {
				if (item.getShowIndex() != null && item.getShowIndex()) {
					result.add(item);
				}
				if (result.size() >= 3) {
					break;
				}
			}
		}
		model.addAttribute("recommend", result);
		return "mobile.index";
	}
	
	/**
	 * 摄影师列表请求(get)
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/photographer", method = RequestMethod.GET)
	public String photographerHome(Model model){
		Pagination<Photographer> pagination = new Pagination<Photographer>(8);
		photographerService.findAllByPage(pagination);
		model.addAttribute("pagination", pagination);
		return "mobile.photographer";
	}
	
	/**
	 * 摄影师列表请求(post),针对Ajax异步请求
	 * 
	 * @param pagination
	 * @return
	 */
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
	
	/**
	 * 摄影师详情界面
	 * 
	 * @param url
	 * @param model
	 * @return
	 */
	@RequestMapping("/photographer/{url}")
	public String photographerDetail(@PathVariable String url, Model model){
		Photographer photographer = photographerService.findByUrl(url);
		if(photographer == null){
			throw new RuntimeException();
		}
		model.addAttribute("photographer", photographer);
		List<PhotoWorks> works = worksService.findByPhotographer(photographer.getId());
		model.addAttribute("works", works);
		// 增加推荐信息
		SpecialPage recommend = pageService.findByUrl("recommend");
		model.addAttribute("recommend", recommend);
		return "mobile.photographer.detail";
	}
	
	
	/**
	 * 作品展
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/works", method = RequestMethod.GET)
	public String works(@RequestParam(required = false) Long styleId, Model model){
		List<PhotoWorksVo> works = worksListByStyle(styleId, new Pagination<PhotoWorks>(8));
		Pagination<PhotoWorksVo> pagination = new Pagination<PhotoWorksVo>(8);
		pagination.setItems(works);
		model.addAttribute("pagination", pagination);
		List<Style> styles = styleService.findAll();
		model.addAttribute("style", styles);
		model.addAttribute("styleId", styleId);
		return "mobile.works";
	}
	
	/**
	 * 某个风格的作品
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/works", method = RequestMethod.POST)
	public List<PhotoWorksVo> worksListByStyle(@RequestParam(required = false) Long styleId, 
			Pagination<PhotoWorks> pagination) {
		List<PhotoWorksVo> list = new ArrayList<>();
		if(styleId == null){ // 没有styleId的情况
			worksService.findAllByPage(pagination);
			if(!CollectionUtils.isEmpty(pagination.getItems())){
				pagination.getItems().forEach(work -> {
					PhotoWorksVo vo = new PhotoWorksVo();
					vo.setImage(work.getImage());
					vo.setUrl(work.getUrl());
					vo.setName(work.getName());
					vo.setAddress(work.getAddress());
					vo.setHearts(work.getHearts());
					vo.setAuthor(photographerService.find(work.getAuthor()).getName());
					list.add(vo);
				});
			}
		}else{ // 有StyleId的情况
			Pagination<WorksToStyle> pages = new Pagination<WorksToStyle>();
			pages.setPageNo(pagination.getPageNo());
			pages.setLimit(pagination.getLimit());
			worksService.findByStyleByPage(pages, styleId);
			if(!CollectionUtils.isEmpty(pages.getItems())){
				pages.getItems().forEach(workToStyle -> {
					PhotoWorksVo item = new PhotoWorksVo();
					item.setImage(workToStyle.getPhotoWorks().getImage());
					item.setUrl(workToStyle.getPhotoWorks().getUrl());
					item.setName(workToStyle.getPhotoWorks().getName());
					item.setAddress(workToStyle.getPhotoWorks().getAddress());
					item.setHearts(workToStyle.getPhotoWorks().getHearts());
					item.setAuthor(photographerService.find(workToStyle.getPhotoWorks().getAuthor()).getName());
					list.add(item);
				});
			}
		}
		return list;
	}
	
	/**
	 * 作品详情
	 * @param model
	 * @return
	 */
	@RequestMapping("/works/{url}")
	public String worksDetail(@PathVariable String url, Model model) {
		PhotoWorks work = worksService.findByUrl(url);
		if (work == null) {
			throw new RuntimeException();
		}
		model.addAttribute("work", work);
		Photographer author = photographerService.find(work.getAuthor());
		model.addAttribute("author", author);
		return "mobile.works.detail";
	}
	
	/**
	 * 预约界面
	 * 
	 * @param url
	 * @param model
	 * @return
	 */
	@RequestMapping("/appointment")
	public String toAppointment(@RequestParam(required = true) String url, Model model){
		// 摄影师预约
		Photographer photographer = photographerService.findByUrl(url);
		if (photographer != null) {
			model.addAttribute("requsetInfo", photographer);
			model.addAttribute("fromPage", Appointment.AppointmentType.PHOTOGRAPHER.toString());
			return "mobile.appointment";
		}
		// 活动预约
		SpecialPage page = pageService.findByUrl(url);
		model.addAttribute("requsetInfo", page);
		model.addAttribute("fromPage", Appointment.AppointmentType.ACTIVITY.toString());
		return "mobile.appointment";
	
	}
	
	/**
	 * 保存预约
	 * 
	 * @param appoint
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/appointment/save", method = RequestMethod.POST)
	public Appointment saveAppointment(Appointment appoint, Model model){
		if (appoint == null) {
			appoint = new Appointment();
			appoint.setId(Long.valueOf(1));
			return appoint;
		}
		// 摄影师预约
		if (AppointmentType.PHOTOGRAPHER.toString().equals(appoint.getAppointmentType())) {
			if(appoint.getPurpose() != null){
			   Photographer author =  photographerService.find(appoint.getPurpose());
			   appoint.setTarget(author);
			}
		}
		// 活动预约
		else if (AppointmentType.ACTIVITY.toString().equals(appoint.getAppointmentType())) {
			if (appoint.getPurpose() != null) {
				SpecialPage page = pageService.find(appoint.getPurpose());
				appoint.setTarget(page);
			}
		}
		
		// 设置创建时间
		appoint.setCreateTime(new Date());
		try {
			appointmentService.save(appoint);
			appoint.setId(Long.valueOf(0));
		} catch (Exception e) {
			e.printStackTrace();
			appoint.setId(Long.valueOf(1));
		}
		return appoint;
	}
	
	/**
	 * 预约结果界面
	 * 
	 * @param url
	 * @param model
	 * @return
	 */
	@RequestMapping("/appointment/result")
	public String appointmentResult(Model model){
		return "mobile.appointment.result";
	}
	
	/**
	 * 联系我们界面
	 *  
	 * @param model
	 * @return
	 */
	@RequestMapping("/contactus")
	public String contactUs(Model model) {
		SpecialPage page = pageService.findByUrl("contactus");
		model.addAttribute("page", page);
		return "mobile.contactus";
	}
	
	/**
	 * 活动界面
	 *  
	 * @param model
	 * @return
	 */
	@RequestMapping("/activity/{url}")
	public String activity(@PathVariable String url, Model model) {
		SpecialPage page = pageService.findByUrl(url);
		model.addAttribute("page", page);
		return "mobile.activity";
	}
	
}
