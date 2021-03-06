package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;


	@RequestMapping("/joinForm") // 하나만 쓸 경우 (value= "") 생략가능
	public String joinForm() {
		System.out.println("/user/joinForm");

		return "user/joinForm";
	}

	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController:join");
		System.out.println(userVo.toString());

		userService.join(userVo);
		return "user/joinOk";
	}

	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("/userController:loginForm");

		return "user/loginForm";
	}

	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("/userController:login");

		UserVo authUser = userService.login(userVo);

		if (authUser != null) { // 로그인 성공일 때
			System.out.println("로그인 성공");
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
		} else { // 로그인 실패일 때
			System.out.println("로그인 실패");
			return "redirect:/user/loginForm?result=fail";
		}
	}

	@RequestMapping("/logout")
	public String logout(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("로그아웃");
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/main";
	}

	@RequestMapping("/modifyForm")
	public String modifyForm(Model model, HttpSession session) {
		System.out.println("/user/modifyForm");

		int no = ((UserVo)session.getAttribute("authUser")).getNo();
		
		UserVo vo = userService.selectId(no);

		model.addAttribute("vo", vo);

		return "user/modifyForm";
	}

	@RequestMapping("/modify")
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("/user/modify" + userVo.toString());

		userService.modify(userVo);
		
		UserVo vo = (UserVo) session.getAttribute("authUser");
		
		vo.setName(userVo.getName());
		vo.setPassword(userVo.getPassword());
		vo.setGender(userVo.getGender());
		
		return "redirect:/main";

	}
}
