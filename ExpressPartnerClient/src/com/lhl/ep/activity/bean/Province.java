package com.lhl.ep.activity.bean;

public class Province {

	private int provinceId;
	private String provinceName;
	private boolean available;

	public Province() {
		// TODO Auto-generated constructor stub
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Province(int provinceId, String provinceName, boolean available) {
		super();
		this.provinceId = provinceId;
		this.provinceName = provinceName;
		this.available = available;
	}

	@Override
	public String toString() {
		return "Province [provinceId=" + provinceId + ", provinceName="
				+ provinceName + ", available=" + available + "]";
	}

}
