package net.shangtech.studio.mobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MobileController {

	@RequestMapping({ "/", "/main", "/index" })
	public String index(Model model) {
		return "mobile.index";
	}
}
