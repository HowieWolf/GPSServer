package com.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.service.PositionService;
import com.dao.PositionDao;
import com.model.Position;

@Service("positionService")
public class PositionServiceImpl implements PositionService{

	@Resource
	PositionDao positionDao;
	
	@Override
	public Position getCurPosition(String eId) {
		// TODO Auto-generated method stub
		return positionDao.queryPosition(eId);
	}

	@Override
	public List<Position> getPrePositions(String eId) {
		// TODO Auto-generated method stub
		return positionDao.queryPositions(eId);
	}

}
