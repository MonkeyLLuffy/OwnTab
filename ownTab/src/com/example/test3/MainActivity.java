package com.example.test3;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	LinearLayout mPerson;
	LinearLayout mSearch;
	LinearLayout mAccount;
	
	ImageButton mPersonImg;
	ImageButton mSearchImg;
	ImageButton mAccountImg;
	
	List<View> mViews = new ArrayList<View>();
	ViewPager viewPager;
	PagerAdapter pagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		initView();
		initEvent();
	}
	
	public void initEvent() {
		mPerson.setOnClickListener(this);
		mSearch.setOnClickListener(this);
		mAccount.setOnClickListener(this);
		
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener()//»ª¶«
		{

			@Override
			public void onPageSelected(int arg0)
			{
				int currentItem = viewPager.getCurrentItem();
				setImg();
				switch (currentItem)
				{
				case 0:
					mPersonImg.setImageResource(R.drawable.tab01_press);
					break;
				case 1:
					mSearchImg.setImageResource(R.drawable.tab02_press);
					break;
				case 2:
					mAccountImg
							.setImageResource(R.drawable.tab03_press);
					break;
				

				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2)
			{

			}

			@Override
			public void onPageScrollStateChanged(int arg0)
			{

			}
		});
		
		
		
		
		
		
		
		
		
			
		
		
	}
	public void initView() {
		
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		
		mPerson = (LinearLayout) findViewById(R.id.id_tab_person);
		mSearch = (LinearLayout) findViewById(R.id.id_tab_search);
		mAccount = (LinearLayout) findViewById(R.id.id_tab_account);
		
		mPersonImg = (ImageButton) findViewById(R.id.id_tab_person_img);
		mSearchImg = (ImageButton) findViewById(R.id.id_tab_search_img);
		mAccountImg = (ImageButton) findViewById(R.id.id_tab_account_img);
		
		LayoutInflater mInflater = LayoutInflater.from(this);
		View view1 = mInflater.inflate(R.layout.tab01, null);
		View view2 = mInflater.inflate(R.layout.tab02, null);
		View view3 = mInflater.inflate(R.layout.tab03, null);
		
		mViews.add(view1);
		mViews.add(view2);
		mViews.add(view3);
		
		pagerAdapter = new PagerAdapter() {
			
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object)
			{
				container.removeView(mViews.get(position));
			}
			
			@Override
			public Object instantiateItem(ViewGroup container, int position)
			{
				View view = mViews.get(position);
				container.addView(view);
				return view;
			}

			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mViews.size();
			}
		};
		viewPager.setAdapter(pagerAdapter);	
		
	}







	
	@Override
	public void onClick(View v){//TODO Auto-generated method stub
		setImg();
	switch (v.getId()) {
		case R.id.id_tab_person:mPersonImg.setImageResource(R.drawable.tab01_press);break;
		case R.id.id_tab_search:mSearchImg.setImageResource(R.drawable.tab02_press);break;
		case R.id.id_tab_account:mAccountImg.setImageResource(R.drawable.tab03_press);break;	
	default:
		break;
	}
	}







public void setImg() {
	mPersonImg.setImageResource(R.drawable.tab01);
	mSearchImg.setImageResource(R.drawable.tab02);
	mAccountImg.setImageResource(R.drawable.tab03);
}
	
	
}
