package com.dao;

import com.model.VersionInfo;

public interface VersionDao {
	
	public VersionInfo queryVersion();
	
	public void addVersion(VersionInfo info);

}
