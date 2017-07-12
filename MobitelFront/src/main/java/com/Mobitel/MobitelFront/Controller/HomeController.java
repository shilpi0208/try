package com.Mobitel.MobitelFront.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String GotoHome() {
		return "Home";
	}

	@RequestMapping("/Home")
	public String gotoHome() {
		return "Home";
	}
	@RequestMapping("/Login")
	public String GotoLoginPage() {
		return "Login";
	}
	

	@RequestMapping("/Success")
	public String GotoLoginSuccessPage() {
		return "Success";
	}

	@RequestMapping("/ContactUs")
	public String GotoContactPage() {
		return "ContactUs";
	}
	@RequestMapping("/AboutUs")
	public String GotoAboutUsPage() {
		return "AboutUs";
	}

	@RequestMapping("/Footer")
	public String GotoFooterPage() {
		return "Footer";
	}
	@RequestMapping("/ProductPage")
	public String GotoProductPage() {
		return "ProductPage";
	}


	
}
