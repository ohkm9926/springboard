package com.kyugmin.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyungmin.domain.boardVO;
import com.kyungmin.service.boardService;

@Controller
@RequestMapping("/board/")
public class boardController {
	
	private static final Logger logger = LoggerFactory.getLogger(boardController.class);
	
	@Inject
	private boardService service;
	
	//글작성 get
	 @RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite() throws Exception {
		logger.info("get write");
			
	}
	//글작성 post
	 @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String postWrite(boardVO vo)	throws Exception{
    	logger.info("post write");
    	
    	service.write(vo);
    	
    	return "redirect:/";
    }
    
	 // 글 목록
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	 public void list(Model model) throws Exception {
	  logger.info("get list");
	  
	  List<boardVO> list = service.list();
	  
	  model.addAttribute("list", list);
	 }

	// 글 조회
	 @RequestMapping(value = "/read", method = RequestMethod.GET)
	 public void getRead(@RequestParam("bno") int bno, Model model) throws Exception {
	  logger.info("get read");
	  
	  boardVO vo = service.read(bno);
	  
	  model.addAttribute("read", vo);
	  
	 }
	 
	 // 글 수 정
	 @RequestMapping(value = "/modify", method = RequestMethod.GET)
	 public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
	  logger.info("get modify");
	  
	 boardVO vo = service.read(bno);
	  
	  model.addAttribute("modify", vo);
	  
	 } 
	 
	 // 글 수정  POST 
	 @RequestMapping(value = "/modify", method = RequestMethod.POST)
	 public String postModify(boardVO vo) throws Exception {
	  logger.info("post modify");
	  
	  service.update(vo);
	  
	  return "redirect:/board/list";
	  
	 }
	 
	 // 글 삭제
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	 public void getDelete(@RequestParam("bno") int bno, Model model) throws Exception {
	  logger.info("get delete");
	    
	  model.addAttribute("delete", bno);
	  
	 }
	 
	 // 글 삭제  POST
	 @RequestMapping(value = "/delete", method = RequestMethod.POST)
	 public String postDelete(@RequestParam("bno") int bno) throws Exception {
	  logger.info("post delete");
	    
	  service.delete(bno);
	  
	  return "redirect:/board/list";
	 }
}
