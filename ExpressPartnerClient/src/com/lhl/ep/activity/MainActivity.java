package com.lhl.ep.activity;

import java.util.ArrayList;

import com.lhl.ep.BaseActivity;
import com.lhl.ep.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {

	private ViewPager mViewPager;
	private ImageView mPage0;
	private ImageView mPage1;
	private ImageView mPage2;
	private ImageView mPage3;
	private ImageView mPage4;
	private ArrayList<View> views;
	// 模拟获取到的图片列表
	private int[] pic = { R.drawable.main_top_image_01,
			R.drawable.main_top_image_02, R.drawable.main_top_image_03,
			R.drawable.main_top_image_04, R.drawable.main_top_image_05 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		initData();
		initEvent();
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.maintop_viewpager);

		mPage0 = (ImageView) findViewById(R.id.main_pager01);
		mPage1 = (ImageView) findViewById(R.id.main_pager02);
		mPage2 = (ImageView) findViewById(R.id.main_pager03);
		mPage3 = (ImageView) findViewById(R.id.main_pager04);
		mPage4 = (ImageView) findViewById(R.id.main_pager05);
	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		views = new ArrayList<View>();

		for (int i = 0; i < pic.length; i++) {
			ImageView image = new ImageView(this);
			image.setBackgroundResource(pic[i]);
			views.add(image);
		}

		// 填充ViewPager的数据适配器
		PagerAdapter mPagerAdapter = new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return views.size();
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				((ViewPager) container).removeView(views.get(position));
			}

			@Override
			public Object instantiateItem(View container, int position) {
				((ViewPager) container).addView(views.get(position));
				return views.get(position);
			}
		};
		mViewPager.setAdapter(mPagerAdapter);
	}

	/**
	 * 初始化事件
	 */
	private void initEvent() {
		mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	/**
	 * 寄快递
	 */
	public void sendExpress(View v) {
		// startActivity(new Intent(this, ExpressAddrActivity.class));
	}

	/**
	 * 我的订单
	 */
	public void order(View v) {
		// Intent intent = new Intent();
		// if (MyApplication.getInstance().isLogin()) {
		// intent.setClass(this, MyOrderActivity.class);
		// startActivity(intent);
		// } else {
		// intent.setClass(this, LoginActivity.class);
		// intent.putExtras(new Bundle());
		// intent.putExtra("nextActivity",
		// "com.lhl.expresspartner.activity.MyOrderActivity");
		// startActivity(intent);
		// }
	}

	/**
	 * 特约加盟
	 */
	public void franchisees(View v) {
		// startActivity(new Intent(this, FranchiseesExpressActivity.class));
	}

	/**
	 * 广告加盟
	 */
	public void advertisement(View v) {
		// startActivity(new Intent(this, AdvertisementActivity.class));
	}

	/**
	 * 实用平台
	 */
	public void platformSoftware(View v) {
		// startActivity(new Intent(this, PlatformSoftwareActivity.class));
	}

	/**
	 * 平台动态
	 */
	public void platformNews(View v) {
		// startActivity(new Intent(this, PlatformNewsActivity.class));
	}

	/**
	 * 页面改变监听器
	 * */
	public class MyOnPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageSelected(int arg0) {
			switch (arg0) {
			case 0:
				mPage0.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page_now));
				mPage1.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page));
				break;
			case 1:
				mPage1.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page_now));
				mPage0.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page));
				mPage2.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page));
				break;
			case 2:
				mPage2.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page_now));
				mPage1.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page));
				mPage3.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page));
				break;
			case 3:
				mPage3.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page_now));
				mPage4.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page));
				mPage2.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page));
				break;
			case 4:
				mPage4.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page_now));
				mPage3.setImageDrawable(getResources().getDrawable(
						R.drawable.main_image_page));
				break;
			}
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}

}
