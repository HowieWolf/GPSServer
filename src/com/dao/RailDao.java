package com.dao;

import java.util.List;

import com.model.Rail;

public interface RailDao {

	public void addRail(Rail rail);

	public Rail queryRail(String id);

	public List<Rail> queryRails(String eId);

}
