package com.dao;

import java.util.List;

import com.model.Position;

public interface PositionDao {

	public void addPosition(Position pos);
	
	public Position queryPosition(String eId);
	
	public List<Position> queryPositions(String eId);
	
}
