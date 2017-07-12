package com.Mobitel.MobitelFront.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Mobitel.MobitelBack.dao.UserDAO;



@Controller
public class LoginController {
	@Autowired
	UserDAO userDAO;

/*	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String gotoLogin(@RequestParam("uname") String uname, @RequestParam("passwd") String passwd, Model m) {
		List<User> list = userDAO.getUserDetails(); //
		m.addAttribute("userdetail", list);
		for (User user : list) {
			if (user.getUname().equals(uname) && user.getUpswd().equals(passwd)) {
				if (user.getRole().equals("Role_Admin")) {
					return "Admin";
				} else {
					return "Admin";
				}
			}
		}
		return "Home";
	}*/
	/*
	 * @RequestMapping("/login") public String gotoLogin(@RequestParam("uname")
	 * String uname,@RequestParam("passwd") String passwd,Model m) {
	 * 
	 * List<User> list=userDAO.getUserDetails(); //
	 * m.addAttribute("userdetail",list); for(User user:list)
	 * 
	 * if(user.getUname().equals(uname) && user.getUpswd().equals(passwd)) {
	 * return "Success";
	 * 
	 * } else { return"Failure"; } return "Home";
	 * 
	 * }
	 */
	
	
}
