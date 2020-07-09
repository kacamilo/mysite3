package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@RequestMapping("/list")
	public String list() {
		System.out.println("/board/list");
		return "board/list";
	}
	@RequestMapping("/modifyForm")
	public String modifyForm () {
		System.out.println("/board/modifyForm");
		return "board/modifyForm";
	}
	@RequestMapping("/read")
	public String read () {
		System.out.println("/board/read");
		return "board/read";
	}
	@RequestMapping("/writeForm")
	public String writeForm () {
		System.out.println("/board/writeForm");
		return "board/writeForm";
	}
}
