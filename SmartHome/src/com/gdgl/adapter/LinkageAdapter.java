package com.gdgl.adapter;

import java.util.ArrayList;
import java.util.List;

import com.gdgl.app.ApplicationController;
import com.gdgl.manager.SceneLinkageManager;
import com.gdgl.model.DevicesModel;
import com.gdgl.mydata.DataHelper;
import com.gdgl.mydata.DataUtil;
import com.gdgl.mydata.Linkage;
import com.gdgl.mydata.LinkageAct;
import com.gdgl.mydata.LinkageCnd;
import com.gdgl.mydata.video.VideoNode;
import com.gdgl.smarthome.R;
import com.gdgl.util.UiUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class LinkageAdapter extends BaseAdapter {
	List<Linkage> linkageList;
	List<VideoNode> videoList;
	Context mContext;

	public LinkageAdapter(Context c) {
		mContext = c;
	}
	
	private String getVideoName(String videoId){
		String videoName = "未知摄像头";
		for(VideoNode mVideo : videoList){
			if(mVideo.getId().equals(videoId)){
				videoName = mVideo.getName();
			}
		}
		return videoName;	
	}
	
	public void setList(List<Linkage> linkageList){
		this.linkageList = linkageList;
	}
	
	public void setVideoList(List<VideoNode> videoList){
		this.videoList = videoList;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (null != linkageList) {
			return linkageList.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		if (null != linkageList) {
			return linkageList.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Linkage linkage = linkageList.get(position);
		DataHelper	dh = new DataHelper(ApplicationController.getInstance());
		SQLiteDatabase db = dh.getSQLiteDatabase();
		DevicesModel device = DataUtil.getDeviceModelByIeee(linkage.getTrgieee(), dh, db);
		LinkageAct linkageAct = new LinkageAct(linkage.getLnkact());
		LinkageCnd linkageCnd = new LinkageCnd(linkage.getTrgcnd());
		DevicesModel act = DataUtil.getDeviceModelByIeee(linkageAct.getIeee(), dh, db);
		ViewHolder mViewHolder;
		if (null == convertView) {
			mViewHolder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.linkage_list_item, null);
			mViewHolder.devices_name = (TextView) convertView
					.findViewById(R.id.devices_name);
			mViewHolder.devices_state = (TextView) convertView
					.findViewById(R.id.devices_state);
			mViewHolder.act_name = (TextView) convertView
					.findViewById(R.id.act_name);
			mViewHolder.act_state = (TextView) convertView
					.findViewById(R.id.act_state);
			mViewHolder.switch_btn = (Switch) convertView
					.findViewById(R.id.switch_btn);
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}
		mViewHolder.devices_name.setText(device.getmDefaultDeviceName());
		mViewHolder.devices_state.setText(linkageCnd.getCndString());
		if(linkageAct.getType().equals("4")){
			mViewHolder.act_name.setText(getVideoName(linkageAct.getIeee()));
		}else{
			mViewHolder.act_name.setText(act.getmDefaultDeviceName());
		}
		mViewHolder.act_state.setText(linkageAct.getActString());
		if(linkage.getEnable() > 0){
			mViewHolder.switch_btn.setChecked(true);
		}else{
			mViewHolder.switch_btn.setChecked(false);
		}
		mViewHolder.switch_btn.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					SceneLinkageManager.getInstance().EnableLinkage(1, linkage.getLid());
				}else{
					SceneLinkageManager.getInstance().EnableLinkage(0, linkage.getLid());
				}
				
			}
		});
		
		return convertView;
	}

	class ViewHolder {
		TextView devices_name;
		TextView devices_state;
		TextView act_name;
		TextView act_state;
		Switch switch_btn;
	}
}
