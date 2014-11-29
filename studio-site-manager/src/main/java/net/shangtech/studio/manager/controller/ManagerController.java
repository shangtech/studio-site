package net.shangtech.studio.manager.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.file.FileSaver;
import net.shangtech.framework.file.GenericFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ManagerController {
	
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	@Autowired private FileSaver fileSaver;

	@RequestMapping({"/", "/main", "/index"})
	public String index(Model model){
		return "manager.index";
	}
	
	@ResponseBody
	@RequestMapping("/upload")
	public AjaxResponse upload(MultipartHttpServletRequest request){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		Map<String, String> map = new HashMap<>();
		request.getFileMap().values().forEach(file -> {
			GenericFile genericFile = new GenericFile();
			genericFile.setName(file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")));
			genericFile.setExtend(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			try {
	            genericFile.setIs(file.getInputStream());
	            map.put(file.getName(), fileSaver.save(genericFile));
            } catch (IOException e) {
	            logger.error("文件上传错误", e);
            }
		});
		ajaxResponse.setSuccess(true);
		ajaxResponse.setData(map);
		return ajaxResponse;
	}
	
}
