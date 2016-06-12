package com.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.service.PositionService;
import com.model.Position;

@RequestMapping("/position")
@Controller
public class PositionController {

	@Resource
	PositionService positionService;
	
	@RequestMapping("/current")
	@ResponseBody
	public Position currentPosition(String eId){
		Position curPos = positionService.getCurPosition(eId);
		return curPos;
	}
	
	@RequestMapping("/previous")
	@ResponseBody
	public List<Position> previousPosition(String eId){
		List<Position> prePos = positionService.getPrePositions(eId);
		return prePos;
	}
	
}
