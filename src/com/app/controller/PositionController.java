package com.app.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.PositionService;
import com.model.Position;

@Controller
public class PositionController {

	@Resource
	PositionService positionService;
	
	@RequestMapping("/curPos")
	public void currentPosition(String eId , HttpServletRequest req , HttpServletResponse res){
		eId = "867967020452449";
		Position curPos = positionService.getCurPosition(eId);
		req.setAttribute("curPos", curPos);
	}
	
	@RequestMapping("/prePos")
	public void previousPosition(String eId , HttpServletRequest req , HttpServletResponse res){
		eId = "867967020452449";
		List<Position> prePos = positionService.getPrePositions(eId);
		req.setAttribute("prePos", prePos);
	}
	
}
