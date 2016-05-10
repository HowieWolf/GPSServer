package com.dao;

import java.util.List;

import com.model.Position;

public interface PositionDao {

	public void addPosition(Position pos);
	
	public List<Position> queryPosition();
	
}
