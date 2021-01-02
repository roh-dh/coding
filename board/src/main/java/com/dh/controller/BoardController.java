package com.dh.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dh.entity.BoardDto;
import com.dh.service.BoardService;


@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	// 게시판 글 작성 화면
	@GetMapping("/writeView")
	public void writeView() throws Exception{
		logger.info("writeView");
		
	}
	
	// 게시판 글 작성
	@PostMapping("/write")
	public String write(BoardDto boardDto) throws Exception{
		logger.info("write");
		
		service.write(boardDto);
		
		return "redirect:/";
	}
	
}