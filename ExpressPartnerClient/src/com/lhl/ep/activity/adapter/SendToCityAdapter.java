package com.lhl.ep.activity.adapter;

import java.util.ArrayList;

import com.lhl.ep.activity.bean.City;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 出发地城市适配器
 * 
 * @author luhailong
 * 
 */
public class SendToCityAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<City> sendToCities;

	public SendToCityAdapter(Context context, ArrayList<City> sendToCities) {
		this.context = context;
		this.sendToCities = sendToCities;
	}

	@Override
	public int getCount() {
		if (sendToCities.isEmpty()) {
			return 0;
		}
		return sendToCities.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return sendToCities.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(
					android.R.layout.simple_spinner_item, parent, false);
		}
		TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
		tv.setText(sendToCities.get(position).getCityName());
		tv.setPadding(15, 5, 15, 5);
		tv.setTextSize(20);
		return convertView;
	}

	public void setCities(ArrayList<City> sendToCities) {
		this.sendToCities = sendToCities;
	}

}
