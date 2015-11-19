package com.example.test3;

import com.example.test3.R;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class FragmentMainActivity extends FragmentActivity implements OnClickListener{

	LinearLayout mPerson;
	LinearLayout mSearch;
	LinearLayout mAccount;
	
	ImageButton mPersonImg;
	ImageButton mSearchImg;
	ImageButton mAccountImg;
	
	Fragment mtab01;
	Fragment mtab02;
	Fragment mtab03;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragment_main);		
		initView();
		initEvent();
		setSelect(0);
	}
	
	public void initEvent() {
		mPerson.setOnClickListener(this);
		mSearch.setOnClickListener(this);
		mAccount.setOnClickListener(this);
		
	}
	public void initView() {
		
		
		mPerson = (LinearLayout) findViewById(R.id.id_tab_person);
		mSearch = (LinearLayout) findViewById(R.id.id_tab_search);
		mAccount = (LinearLayout) findViewById(R.id.id_tab_account);
		
		mPersonImg = (ImageButton) findViewById(R.id.id_tab_person_img);
		mSearchImg = (ImageButton) findViewById(R.id.id_tab_search_img);
		mAccountImg = (ImageButton) findViewById(R.id.id_tab_account_img);
	
	}
	@Override
	public void onClick(View v){//TODO Auto-generated method stub
		setImg();
		switch (v.getId()) {
			case R.id.id_tab_person:setSelect(0);break;
			case R.id.id_tab_search:setSelect(1);break;
			case R.id.id_tab_account:setSelect(2);break;
		}
	}

	private void setSelect(int i) {
		// TODO Auto-generated method stub
		
		FragmentManager fm = getSupportFragmentManager();
		
		FragmentTransaction transaction = fm.beginTransaction();
		
		hidFragment(transaction);
		switch (i) {
		case 0:
			if (mtab01 == null)
			{
				mtab01 = new PersonFragment();
				transaction.add(R.id.id_content, mtab01);
				Log.i("iiiiii", "--------------------------");
			} else
			{
				transaction.show(mtab01);
			}
			mPersonImg.setImageResource(R.drawable.tab01_press);
			
			break;
		case 1:			
			if (mtab02==null) {
				mtab02 = new SearchFragment();
				transaction.add(R.id.id_content, mtab02);
			}
			else {
				transaction.show(mtab02);
			}
			mSearchImg.setImageResource(R.drawable.tab02_press);
			break;
		case 2:
			if (mtab03==null) {
				mtab03 = new AccountFragment();
				transaction.add(R.id.id_content, mtab03);
			}
			else {
				transaction.show(mtab03);
			}
			mAccountImg.setImageResource(R.drawable.tab03_press);
			break;

		default:
			break;
		}
		transaction.commit();

	}

private void hidFragment(FragmentTransaction transaction) {
		// TODO Auto-generated method stub
		
	if (mtab01 != null)
	{
		transaction.hide(mtab01);
	}
	if (mtab02 != null)
	{
		transaction.hide(mtab02);
	}
	if (mtab03 != null)
	{
		transaction.hide(mtab03);
	}

	}

public void setImg() {
	mPersonImg.setImageResource(R.drawable.tab01);
	mSearchImg.setImageResource(R.drawable.tab02);
	mAccountImg.setImageResource(R.drawable.tab03);
}
}
