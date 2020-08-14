package com.clc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clc.model.UserModel;
import com.clc.service.UserService;

@Controller
public class DriverController {
	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String newUser(Model model) {
		
		return "register";
		
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("users", new UserModel());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "users";
		
	}
	
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") UserModel userModel) {
		if(userModel.getId() == 0) {
			this.userService.addUser(userModel);
		}
		else {
			this.userService.updateUser(userModel);
		}
		return "redirect:/products";
		
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginPage(@ModelAttribute("user") UserModel userModel) {
		
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginUser(HttpServletRequest req) {
		int i=this.userService.loginUser(req.getParameter("username"), req.getParameter("password"));
		System.out.println(i);
		if (i>0) {
			return "redirect:/products";
		}
		else {
			return "users";
		}
	}
	
	@RequestMapping("/user/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {
		this.userService.removeUser(id);
		return "redirect:/users";
	}
	
	@RequestMapping("/user/edit/{id}")
	public String editUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userService.getUserById(id));
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
		
	}
}
