package com.model;

/**
 * 围栏，记录中心点和半径
 */
public class Rail {

	private int id;
	private String eId;
	private double lat;
	private double lng;
	private double radius;

	public Rail() {
	}

	public Rail(String eId, double lat, double lng, double radius) {
		this.eId = eId;
		this.lat = lat;
		this.lng = lng;
		this.radius = radius;
	}

	/**
	 * 该方法判断一个点是否在这个范围内
	 * 
	 * @param lat
	 * @param lng
	 * @return
	 */
	public boolean isAwayRail(double lat, double lng) {
		// 这里应该进行经纬度与米之间的换算

		if (Math.pow(Math.pow(lat - this.lat, 2) + Math.pow(lng - this.lng, 2), 0.5) < radius) {
			return false;
		}

		/*
		 * CoordinateConverter converter = new CoordinateConverter();
		 * converter.from(CoordType.GPS); // sourceLatLng待转换坐标
		 * converter.coord(new LatLng(this.lat, this.lng)); LatLng p1 =
		 * converter.convert(); converter.coord(new LatLng(lat, lng)); LatLng p2
		 * = converter.convert();
		 * 
		 * if (DistanceUtil.getDistance(new LatLng(this.lat, this.lng), new
		 * LatLng(lat, lng)) < radius) { return false; }
		 */
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}
