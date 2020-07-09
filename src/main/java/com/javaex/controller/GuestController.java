package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guestbook")
public class GuestController {

	@RequestMapping("/addList")
	public String addList() {
		System.out.println("/guestbook/addList");
		
		return "guestbook/addList";
		
	}
	
	@RequestMapping("/deleteForm")
	public String deleteForm() {
		System.out.println("/guestbook/deleteForm");
		
		return "guestbook/deleteForm";
	}
		
}
