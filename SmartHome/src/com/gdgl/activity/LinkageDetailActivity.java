package com.gdgl.activity;

import java.util.List;

import com.gdgl.activity.LinkageDevicesAddFragment.LinkageDevicesAddListAdapter;
import com.gdgl.activity.SceneDevicesFragment;
import com.gdgl.activity.SceneDevicesFragment.ChangeFragment;
import com.gdgl.libjingle.LibjingleSendManager;
import com.gdgl.manager.SceneLinkageManager;
import com.gdgl.model.DevicesModel;
import com.gdgl.mydata.Constants;
import com.gdgl.mydata.DataHelper;
import com.gdgl.mydata.Linkage;
import com.gdgl.network.NetworkConnectivity;
import com.gdgl.smarthome.R;
import com.gdgl.util.MyApplicationFragment;
import com.gdgl.util.MyOkCancleDlg;
import com.gdgl.util.MyOkCancleDlg.Dialogcallback;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class LinkageDetailActivity extends MyActionBarActivity implements
		ChangeFragment, Dialogcallback {
	private static final String SPINNER_ONOFF_STRING[] = {"开", "关"};
	private static final String SPINNER_ONOFF_DATA[] = {"1", "0"};
	private static final String SPINNER_SIGN_STRING[] = {"大于", "等于", "小于"};
	private static final String SPINNER_SIGN_DATA[] = {"bt", "eq", "lt"};
	private static final String SPINNER_TRG_STRING[] = {"触发"};
	public static final String TYPE = "type";
	public static final String INDEX = "index";
	public static final int CREATE = 1;
	public static final int EDIT = 2;

	public static final int EDIT_FRAGMENT = 2;
	public static final int ADD_FRAGMENT = 1;

	// 判断是创建情景还是编辑情景
	int linkage_type;
	int fragment_flag;
	int spinner_type;

	private Toolbar mToolbar;
	private ActionBar mActionBar;

	private int linkageId;
	private int linkageIndex;

	private Linkage mLinkage;
	// 点击图片后出现的设备表
	List<DevicesModel> mTrgAddList, mActAddList;
	DevicesModel actDevices, trgDevices;

	DataHelper mDataHelper;
	
	LinkageDetailFragment mLinkageDetailFragment;

	FragmentManager fragmentManager;

	DevicesListFragment mDevicesListFragment;

	SceneDevicesFragment mAllDevicesFragment;

	LinkageDevicesAddListAdapter mLinkageDevicesAddListAdapter;

	ImageView img_act_device, img_trg_device;
	TextView txt_act_device, txt_trg_device;
	Spinner spinner_trg_type, spinner_act_type;
	Switch switch_act_type;
	EditText edit_trg_data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		MyApplicationFragment.getInstance().setActivity(this);

		mDataHelper = new DataHelper(this);

//		img_trg_device = (ImageView)findViewById(R.id.img_trg_device);
//		img_act_device = (ImageView)findViewById(R.id.img_act_device);	
//		txt_trg_device = (TextView)findViewById(R.id.txt_trg_device);
//		txt_act_device = (TextView)findViewById(R.id.txt_act_device);
//		spinner_trg_type = (Spinner)findViewById(R.id.spinner_trg_type);
//		spinner_act_type = (Spinner)findViewById(R.id.spinner_act_type);
//		edit_trg_data = (EditText)findViewById(R.id.edit_trg_data);

		Intent i = getIntent();
		linkage_type = i.getIntExtra(TYPE, 2);
		String titleName;
		if (linkage_type == CREATE) {
			linkageIndex = i.getIntExtra(LinkageDetailActivity.INDEX, 0);
			mLinkage = new Linkage();
			titleName = "添加联动";
		} else {
			mLinkage = (Linkage) i.getSerializableExtra(Constants.PASS_OBJECT);
			titleName = "编辑联动";
		}

		mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
		setSupportActionBar(mToolbar);
		mActionBar = getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		mActionBar.setDisplayShowTitleEnabled(true);
		mActionBar.setTitle(titleName);
	
		mToolbar.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				switch (item.getItemId()) {
				case R.id.menu_ok:
					if(mLinkageDetailFragment.updateLinkage()){
						if (linkage_type == CREATE) {
							if (NetworkConnectivity.networkStatus == NetworkConnectivity.LAN) {
								SceneLinkageManager.getInstance().AddLinkage("", 
										mLinkage.getTrgieee(), 
										mLinkage.getTrgep(), 
										mLinkage.getTrgcnd(), 
										mLinkage.getLnkact(), 
										mLinkage.getEnable());
							} else if (NetworkConnectivity.networkStatus == NetworkConnectivity.INTERNET) {
								LibjingleSendManager.getInstance().AddLinkage("", 
										mLinkage.getTrgieee(), 
										mLinkage.getTrgep(), 
										mLinkage.getTrgcnd(), 
										mLinkage.getLnkact(), 
										mLinkage.getEnable());
							}
							finish();
						}else if(linkage_type == EDIT){
							if (NetworkConnectivity.networkStatus == NetworkConnectivity.LAN) {
								SceneLinkageManager.getInstance().EditLinkage("", 
										mLinkage.getTrgieee(), 
										mLinkage.getTrgep(), 
										mLinkage.getTrgcnd(), 
										mLinkage.getLnkact(), 
										mLinkage.getEnable(), 
										mLinkage.getLid());	
							} else if (NetworkConnectivity.networkStatus == NetworkConnectivity.INTERNET) {
								LibjingleSendManager.getInstance().EditLinkage("", 
										mLinkage.getTrgieee(), 
										mLinkage.getTrgep(), 
										mLinkage.getTrgcnd(), 
										mLinkage.getLnkact(), 
										mLinkage.getEnable(), 
										mLinkage.getLid());	
							}
							finish();
						}
					}
					break;

				default:
					break;
				}
				return false;
			}
		});
		mLinkageDetailFragment = new LinkageDetailFragment();
		mLinkageDetailFragment.setLinkage(mLinkage);
		Bundle bundle1 = new Bundle();
		bundle1.putInt(TYPE, linkage_type);	
		mLinkageDetailFragment.setArguments(bundle1);
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		fragmentTransaction.replace(R.id.container, mLinkageDetailFragment);
		fragmentTransaction.commit();
		MyApplicationFragment.getInstance().addNewTask(mLinkageDetailFragment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_ok, menu);
		return true;
	}
	
	private boolean checkLinkageData(){
		if(trgDevices == null){
			Toast.makeText(LinkageDetailActivity.this,
					"请选择触发设备", Toast.LENGTH_SHORT).show();
			return false;
		}
		if(actDevices == null){
			Toast.makeText(LinkageDetailActivity.this,
					"请选择联动设备", Toast.LENGTH_SHORT).show();
			return false;
		}
		if(spinner_trg_type.getSelectedItemPosition() == 0){
			Toast.makeText(LinkageDetailActivity.this,
					"请选择触发方式", Toast.LENGTH_SHORT).show();
			return false;
		}
		if(spinner_act_type.getSelectedItemPosition() == 0){
			Toast.makeText(LinkageDetailActivity.this,
					"请选择联动方式", Toast.LENGTH_SHORT).show();
			return false;
		}
		if(edit_trg_data.getText().toString().equals("")){
			Toast.makeText(LinkageDetailActivity.this,
					"请选择触发数值", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	@Override
	public void setFragment(Fragment f) {
//		initAddFragmentDevicesList();
//		LinkageDevicesAddFragment mSceneAddFragment = (LinkageDevicesAddFragment) f;
//		mLinkageDevicesAddListAdapter = mSceneAddFragment.new LinkageDevicesAddListAdapter(
//				mAddList, LinkageDetailActivity.this);
//		mSceneAddFragment.setAdapter(mLinkageDevicesAddListAdapter);
//
//		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
//				.beginTransaction();
//		fragmentTransaction.add(R.id.container, f);
//		fragmentTransaction.commit();
//		fragment_flag = ADD_FRAGMENT;
//		MyApplicationFragment.getInstance().addFragment(f);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (MyApplicationFragment.getInstance().getFragmentListSize() > 1) {
			MyApplicationFragment.getInstance().removeLastFragment();
			fragment_flag = EDIT_FRAGMENT;
		} else {
			MyOkCancleDlg mMyOkCancleDlg = new MyOkCancleDlg(this);
			mMyOkCancleDlg
					.setDialogCallback((Dialogcallback) this);
			mMyOkCancleDlg.setContent("确定要放弃本次编辑?");
			mMyOkCancleDlg.show();
		}
	}

	@Override
	public boolean onSupportNavigateUp() {
		// TODO Auto-generated method stub
		if (MyApplicationFragment.getInstance().getFragmentListSize() > 1) {
			MyApplicationFragment.getInstance().removeLastFragment();
			fragment_flag = EDIT_FRAGMENT;
			return super.onSupportNavigateUp();
		}
		MyOkCancleDlg mMyOkCancleDlg = new MyOkCancleDlg(this);
		mMyOkCancleDlg
				.setDialogCallback((Dialogcallback) this);
		mMyOkCancleDlg.setContent("确定要放弃本次编辑?");
		mMyOkCancleDlg.show();
		return super.onSupportNavigateUp();
	}

	@Override
	public void dialogdo() {
		// TODO Auto-generated method stub
		finish();
	}
	
}
