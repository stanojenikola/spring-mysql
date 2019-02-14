package com.javasampleapproach.mysql.guicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javasampleapproach.mysql.api.AddressAPI;

@Controller
public class HomeController {
	
	@Autowired
	private AddressAPI addressAPI;

	private static final String PAGE_HOME = "/pages/homepage";
	private static final String PAGE_JAVASCRIPT_TEST="/pages/javascripttest";
	
	@RequestMapping( value = "/home", method =  RequestMethod.GET)
	public String getHomePage(Model model) {
		model.addAttribute("address", addressAPI.getAllAddress());

		return PAGE_HOME;
	}
	
	@GetMapping("/javascript")
	public String getJavaScriptTest() {
		
		return PAGE_JAVASCRIPT_TEST;
	}
	

	
}
