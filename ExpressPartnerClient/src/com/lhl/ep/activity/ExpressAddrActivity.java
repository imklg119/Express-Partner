package com.lhl.ep.activity;

import java.util.ArrayList;

import com.lhl.ep.BaseActivity;
import com.lhl.ep.R;
import com.lhl.ep.activity.adapter.SendFromCityAdapter;
import com.lhl.ep.activity.adapter.SendFromProvinceAdapter;
import com.lhl.ep.activity.adapter.SendToProvinceAdapter;
import com.lhl.ep.activity.bean.City;
import com.lhl.ep.activity.bean.Province;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;

public class ExpressAddrActivity extends BaseActivity {

	private Spinner sendFromProvince; // 出发地省份Spinner
	private Spinner sendFromCity; // 出发地城市Spiner
	private Spinner sendToProvince; // 目的地省份Spiner
	private Button submit; // 提交按钮

	private ArrayList<Province> Provinces;
	private ArrayList<City> Cities;

	private SendFromProvinceAdapter sendFromProvinceAdapter; // 出发地省份适配器
	private SendFromCityAdapter sendFromCityAdapter; // 出发地城市适配器
	private SendToProvinceAdapter sendToProvinceAdapter; // 出发地省份适配器
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_express_addr);

		initView();
		initData();
		initEvent();

	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		this.sendFromProvince = (Spinner) findViewById(R.id.send_from_province);
		this.sendFromCity = (Spinner) findViewById(R.id.send_from_city);
		this.sendToProvince = (Spinner) findViewById(R.id.send_to_province);
		this.submit = (Button) findViewById(R.id.express_addr_submit);
		this.submit.setEnabled(false);
	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		// 出发地省份数据、目的地省份数据（全国所有省份）
		Provinces = new ArrayList<Province>();
		Provinces.add(new Province(1, "北京", true));
		Provinces.add(new Province(2, "天津", true));
		Provinces.add(new Province(3, "上海", true));
		Provinces.add(new Province(4, "重庆", true));
		Provinces.add(new Province(5, "河北", true));
		Provinces.add(new Province(6, "河南", true));
		Provinces.add(new Province(7, "云南", true));
		Cities = new ArrayList<City>();
		Cities.add(new City(1, "北京", 1));
		
		province();
	}

	/**
	 * 填充省份数据到spinner
	 */
	private void province() {
		sendFromProvinceAdapter = new SendFromProvinceAdapter(
				ExpressAddrActivity.this, Provinces);
		sendFromProvince.setAdapter(sendFromProvinceAdapter);

		sendToProvinceAdapter = new SendToProvinceAdapter(
				ExpressAddrActivity.this, Provinces);
		sendToProvince.setAdapter(sendToProvinceAdapter);
	}

	/**
	 * 填充城市数据到spinner
	 */
	private void city() {
		if (sendFromCityAdapter == null) {
			sendFromCityAdapter = new SendFromCityAdapter(
					ExpressAddrActivity.this, Cities);
			sendFromCity.setAdapter(sendFromCityAdapter);
		} else {
			sendFromCityAdapter.setCities(Cities);
			sendFromCityAdapter.notifyDataSetChanged();
		}
	}

	/**
	 * 初始化事件
	 */
	private void initEvent() {
		// 设置出发地spinner选中某项事件
		sendFromProvince
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int position, long arg3) {
						city();
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

	}

	/**
	 * 返回按钮
	 * 
	 * @param v
	 * */
	public void back(View v) {
		finish();
	}

	/**
	 * 提交按钮
	 * 
	 * @param v
	 */
	public void submit(View v) {
//		Intent intent = new Intent(this, ExpressCompanyActivity.class);
//		HashMap<String, String> params = new HashMap<String, String>();
//		params.put("expressFromProvinceId", String.valueOf(sendFromProvinces.get(
//				sendFromProvince.getSelectedItemPosition()).getProvinceId()));
//		params.put(
//				"expressFromCityId",
//				String.valueOf(sendFromCities.get(
//						sendFromCity.getSelectedItemPosition()).getCityId()));
//		params.put("expressToProvinceId", String.valueOf(Provinces.get(
//				sendToProvince.getSelectedItemPosition()).getProvinceId()));
//		
//		intent.putExtra("params", params);
//		startActivity(intent);
	}

}
