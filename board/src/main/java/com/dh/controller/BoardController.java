package com.dh.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dh.entity.BoardDto;
import com.dh.service.BoardService;


@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	// 게시판 글 작성 화면
	@RequestMapping(value = "board/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
		
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "board/write", method = RequestMethod.POST)
	public String write(BoardDto boardDto) throws Exception{
		logger.info("write");
		
		service.write(boardDto);
		
		return "redirect:/board/list";
	}
	// 게시판 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		logger.info("list");
		
		model.addAttribute("list", service.list());
		return "board/list";
	}
	
	//게시글 조회
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(
			BoardDto boardDto,
			Model model
			) throws Exception{
		logger.info("read");
		
		model.addAttribute("read", service.read(boardDto.getBno()));

		return "/board/readView";
	}
	//게시글 수정뷰
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(
			BoardDto boardDto,
			Model model
			) throws Exception{
			logger.info("updateView");

			model.addAttribute("update", service.read(boardDto.getBno()));
			
		return "board/updateView";
	}
	
	//게시글 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardDto boardDto) throws Exception {
		logger.info("update");
		
		service.update(boardDto);
		
		return "redirect:/board/list";
	}
	
	//게시글 삭제
	@RequestMapping(value ="/delete", method = RequestMethod.POST)
	public String delete(int bno) throws Exception{
		logger.info("delete");
		
		service.delete(bno);
		
		return "redirect:/board/list";
	}
	
}