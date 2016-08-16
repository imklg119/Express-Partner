package com.lhl.ep.activity.adapter;

import java.util.ArrayList;

import com.lhl.ep.activity.bean.Province;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 出发地省份适配器
 * 
 * @author luhailong
 * 
 */
public class SendToProvinceAdapter extends BaseAdapter {

	private ArrayList<Province> Provinces;
	private Context context;

	public SendToProvinceAdapter(Context context,
			ArrayList<Province> Provinces) {
		this.context = context;
		this.Provinces = Provinces;
	}

	@Override
	public int getCount() {
		if (Provinces.isEmpty()) {
			return 0;
		}
		return Provinces.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return Provinces.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(
					android.R.layout.simple_spinner_item, parent, false);
		}
		TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
		tv.setText(Provinces.get(position).getProvinceName());
		tv.setPadding(15, 5, 15, 5);
		tv.setTextSize(20);
		return convertView;
	}
}
