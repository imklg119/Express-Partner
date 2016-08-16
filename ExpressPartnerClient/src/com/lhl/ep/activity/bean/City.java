package com.lhl.ep.activity.bean;

public class City {

	private int cityId;
	private String cityName;
	private int provinceId;

	public City() {
		// TODO Auto-generated constructor stub
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public City(int cityId, String cityName, int provinceId) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.provinceId = provinceId;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName
				+ ", provinceId=" + provinceId + "]";
	}

}
