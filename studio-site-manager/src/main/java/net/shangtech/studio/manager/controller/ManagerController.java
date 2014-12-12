package net.shangtech.studio.manager.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import net.shangtech.framework.controller.AjaxResponse;
import net.shangtech.framework.file.FileSaver;
import net.shangtech.framework.file.GenericFile;
import net.shangtech.framework.util.EncoderUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ManagerController {
	
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	private static final Properties props = new Properties();
	
	private static final String USERNAME_KEY = "username";
	private static final String PASSWORD_KEY = "password";
	public static final String SESSION_USER_KEY = "user_in_session";
	private static final String AUTH_FILE = "config/auth.properties";
	
	static{
		try {
			props.load(ManagerController.class.getClassLoader().getResourceAsStream(AUTH_FILE));
		} catch (IOException e) {
			logger.error("加载管理员账户文件异常", e);
		}
	}
	
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
			genericFile.setLength(file.getSize());
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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "manager.login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute(SESSION_USER_KEY);
		return "manager.login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session){
		if(username.equals(props.getProperty(USERNAME_KEY))
				&& EncoderUtils.MD5(username + "@" + password).equals(props.getProperty(PASSWORD_KEY))){
			Map<String, String> user = new HashMap<>();
			user.put(USERNAME_KEY, username);
			session.setAttribute(SESSION_USER_KEY, user);
			return "manager.index";
		}
		else{
			model.addAttribute("msg", "账号或密码错误");
			return "manager.login";
		}
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String reset(){
		return "manager.reset";
	}
	
	@ResponseBody
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public AjaxResponse reset(@RequestParam String oldUsername, @RequestParam String username, @RequestParam String oldPassword, @RequestParam String password){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		if(oldUsername.equals(props.getProperty(USERNAME_KEY))
				&& EncoderUtils.MD5(oldUsername + "@" + oldPassword).equals(props.getProperty(PASSWORD_KEY))){
			props.setProperty(USERNAME_KEY, username);
			props.setProperty(PASSWORD_KEY, EncoderUtils.MD5(username + "@" + password));
			OutputStream os = null;
			try {
				os  = new FileOutputStream(AUTH_FILE);
	            props.store(os, "");
	            ajaxResponse.setSuccess(true);
            } catch (IOException e) {
	            logger.error("更新账号文件失败", e);
            }
			finally {
				if(os != null){
					try {
	                    os.close();
                    } catch (IOException e) {
	                    logger.error("更新账号文件关闭输出流异常", e);
                    }
				}
			}
		}
		return ajaxResponse;
	}
	
}
