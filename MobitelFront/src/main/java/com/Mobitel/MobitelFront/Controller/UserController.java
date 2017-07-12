package com.Mobitel.MobitelFront.Controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Mobitel.MobitelBack.dao.UserDAO;
import com.Mobitel.MobitelBack.model.User;

@Controller
public class UserController {
	@Autowired
	UserDAO userDAO;

	@RequestMapping(value="/Registration")
	public String GotoRegisterPage() {
		return "Registration";
	}

	@RequestMapping("/login_success")
	public String loginsuccess(HttpSession session) {
		System.out.println("loded successfully");

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		session.setAttribute("uname", username);
		

		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		for (GrantedAuthority role : authorities) {
			System.out.println("Role:" + role.getAuthority() + "uname" + username);

			if (role.getAuthority().equals("Role_Admin")) {

				return "Admin";
			} else {
				return "ProductPage";
			}
		}
		return "Home";
	}

	@RequestMapping(value = "/SignUp")
	public String addUser(@RequestParam("uname") String uname, @RequestParam("CustName") String CustName,
			@RequestParam("email") String email, @RequestParam("Upswd") String Upswd, @RequestParam("Addr") String Addr,
			@RequestParam("Mobile") String Mobile, Model m) {
		System.out.println("---Add Category Starting-----");

		User user = new User();
		user.setCustName(CustName);
		user.setAddr(Addr);
		user.setEmail(email);
		user.setMobile(Mobile);
		user.setUname(uname);
		user.setUpswd(Upswd);

		userDAO.insertUpdateUser(user);

		List<User> list = userDAO.getUserDetails();
		m.addAttribute("User", list);

		System.out.println("---User Added----");
		return "Success";
	}
	
	/*@RequestMapping(value="/perform_login")
	public String performLogin(){
		System.out.println("Inside perform login");
		
		return "home";
	}
	
	@RequestMapping(value="/Login")
	public String Login(){
		System.out.println("Inside login");
		
		return "Login";
	}*/
	
}