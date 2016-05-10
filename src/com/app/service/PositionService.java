package com.app.service;

import java.util.List;

import com.model.Position;

public interface PositionService {

	public Position getCurPosition(String eId);
	
	public List<Position> getPrePositions(String eId);
	
}
