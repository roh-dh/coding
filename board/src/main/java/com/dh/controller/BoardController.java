package com.dh.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dh.dao.ReplyService;
import com.dh.entity.BoardDto;
import com.dh.service.BoardService;
import com.dh.vo.CriteriaVo;
import com.dh.vo.PageMaker;
import com.dh.vo.ReplyVo;
import com.dh.vo.SearchCriteria;


@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	@Inject
	ReplyService replyService;
	
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
	public String list(
			Model model,
			@ModelAttribute("scri")	SearchCriteria scri
			)
			throws Exception{
		logger.info("list");
		
		model.addAttribute("list", service.list(scri));
		PageMaker pagemaker = new PageMaker();
		pagemaker.setCri(scri);
		pagemaker.setTotalCount(service.listCount(scri));
	
		model.addAttribute("pageMaker", pagemaker);
		
		return "board/list";
	}
	
	//게시글 조회
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(
			BoardDto boardDto,
			Model model,
			@ModelAttribute("scri") SearchCriteria scri
			) throws Exception{
		logger.info("read");
		
		model.addAttribute("read", service.read(boardDto.getBno()));
		model.addAttribute("scri",scri);

		List<ReplyVo> replyList = replyService.readReply(boardDto.getBno());
		model.addAttribute("replyList", replyList);
		
		
		return "/board/readView";
	}
	//게시글 수정뷰
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(
			BoardDto boardDto,
			@ModelAttribute("scri") SearchCriteria scri,
			Model model
			) throws Exception{
			logger.info("updateView");

			model.addAttribute("update", service.read(boardDto.getBno()));
			model.addAttribute("scri",scri);
			
		return "board/updateView";
	}
	
	//게시글 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(
			BoardDto boardDto,
			@ModelAttribute("scri") SearchCriteria scri,
			RedirectAttributes rttr
			) throws Exception {
		logger.info("update");
		
		service.update(boardDto);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	//게시글 삭제
	@RequestMapping(value ="/delete", method = RequestMethod.POST)
	public String delete(
			int bno,
			@ModelAttribute("scri") SearchCriteria scri,
			RedirectAttributes rttr
			) throws Exception{
		logger.info("delete");
		
		service.delete(bno);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/list";
	}
	
}