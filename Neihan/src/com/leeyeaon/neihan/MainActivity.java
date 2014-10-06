package com.leeyeaon.neihan;

import java.util.LinkedList;
import java.util.List;

import com.leeyeaon.neihan.fragments.HuodongFragment;
import com.leeyeaon.neihan.fragments.ImageListFragment;
import com.leeyeaon.neihan.fragments.MineFragment;
import com.leeyeaon.neihan.fragments.ReviewFragment;
import com.leeyeaon.neihan.fragments.TextListFragment;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity implements OnCheckedChangeListener {
	
private List<Fragment>fragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		RadioGroup group=(RadioGroup)findViewById(R.id.main_tab_bar);
		group.setOnCheckedChangeListener(this);
		fragments=new LinkedList<Fragment>();
		
		fragments.add(new TextListFragment());
		
		fragments.add(new ImageListFragment());
		
		fragments.add(new ReviewFragment());
		
		fragments.add(new HuodongFragment());
		
		fragments.add(new MineFragment());
		
		Fragment fragment =fragments.get(0);
		
		FragmentManager manager=getSupportFragmentManager();
		FragmentTransaction transaction=manager.beginTransaction();
		transaction.replace(R.id.mainfram, fragment);
		transaction.commit();
	}


	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		int childCount=group.getChildCount();
		int checkedIndex=0;
		RadioButton btn=null;
		for(int i=0;i<childCount;i++)
		{
			btn=(RadioButton)group.getChildAt(i);
			if(btn.isChecked())
			{
				checkedIndex=i;
				break;
			}
		}
		Fragment fragment =fragments.get(checkedIndex);
		FragmentManager manager=getSupportFragmentManager();
		FragmentTransaction transaction=manager.beginTransaction();
		transaction.replace(R.id.mainfram, fragment);
		transaction.commit();
//		switch(checkedIndex)
//		{
//		case 0:
//			
//			break;
//		}
//		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
