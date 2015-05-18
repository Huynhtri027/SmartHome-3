package com.gdgl.activity;

import java.util.List;

import com.gc.materialdesign.views.ButtonFloat;
import com.gdgl.model.DevicesModel;
import com.gdgl.mydata.DataHelper;
import com.gdgl.mydata.scene.SceneDevice;
import com.gdgl.smarthome.R;

import android.support.v4.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class SceneDevicesFragment extends Fragment {

	private View mView;
//	PullToRefreshListView devices_list_view;
	ListView devices_list_view;
	ButtonFloat mButtonFloat;

	public List<SceneDevice> mSceneDevicesList;

	int refreshTag = 0;

	BaseAdapter mBaseAdapter;

	DataHelper mDataHelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mDataHelper = new DataHelper(getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mView = inflater.inflate(R.layout.scene_devices_fragment, null);
		initView();
		return mView;
	}

	private void initView() {
		// TODO Auto-generated method stub

		devices_list_view = (ListView) mView
				.findViewById(R.id.devices_list);
		mButtonFloat = (ButtonFloat) mView.findViewById(R.id.buttonFloat);
		mButtonFloat.setVisibility(View.VISIBLE);
		devices_list_view.setAdapter(mBaseAdapter);

		mButtonFloat.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ChangeFragment changeFragment = (ChangeFragment) getActivity();
				changeFragment.setFragment(new SceneDevicesAddFragment());
			}
		});
		registerForContextMenu(devices_list_view);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		menu.setHeaderTitle("删除设备");
		menu.add(0, 1, 0, "删除");
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
				.getMenuInfo();
		int position = info.position;
		int menuIndex = item.getItemId();
		if (1 == menuIndex) {
			mSceneDevicesList.remove(position);
			mBaseAdapter.notifyDataSetChanged();
		}
		return super.onContextItemSelected(item);
	}
	
	public class SceneDevicesListAdapter extends BaseAdapter {

		public SceneDevicesListAdapter(List<SceneDevice> list) {
			mSceneDevicesList = list;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			if (null != mSceneDevicesList) {
				return mSceneDevicesList.size();
			}
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			if (null != mSceneDevicesList) {
				return mSceneDevicesList.get(position);
			}
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			if (null != mSceneDevicesList) {
				return (long) mSceneDevicesList.get(position).getSid();
			}
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			if (null == mSceneDevicesList) {
				return convertView;
			}
			View mView = convertView;
			final ViewHolder mHolder;
			final SceneDevice mDevices = mSceneDevicesList.get(position);

			if (null == mView) {
				mHolder = new ViewHolder();
				mView = LayoutInflater.from(getActivity()).inflate(
						R.layout.scene_device_item, null);
				mHolder.devices_img = (ImageView) mView
						.findViewById(R.id.devices_img);
				mHolder.devices_name = (TextView) mView
						.findViewById(R.id.devices_name);
				mHolder.devices_state = (TextView) mView
						.findViewById(R.id.devices_state);
				mHolder.devices_switch = (Switch) mView
						.findViewById(R.id.switch_btn);
				mView.setTag(mHolder);
			} else {
				mHolder = (ViewHolder) mView.getTag();
			}

			SQLiteDatabase db = mDataHelper.getSQLiteDatabase();
			String[] columns = { DevicesModel.PIC_NAME,
					DevicesModel.DEFAULT_DEVICE_NAME };
			String where = " ieee=? and ep=? ";
			String[] args = { mDevices.getIeee(), mDevices.getEp() };

			Cursor cursor = mDataHelper.query(db, DataHelper.DEVICES_TABLE,
					columns, where, args, null, null, null, null);
			String picSource = Integer
					.toString(R.drawable.ui_securitycontrol_alarm);
			String deviceName = "";
			while (cursor.moveToNext()) {
				deviceName = cursor.getString(cursor
						.getColumnIndex(DevicesModel.DEFAULT_DEVICE_NAME));
				picSource = cursor.getString(cursor
						.getColumnIndex(DevicesModel.PIC_NAME));
			}
			cursor.close();
			db.close();
			
			mHolder.devices_name.setText(deviceName);
			mHolder.devices_img.setImageResource(Integer.parseInt(picSource));
			if (mDevices.getDevicesStatus() == 0) {
				mHolder.devices_switch.setChecked(false);
				mHolder.devices_state.setText("关闭");
			}
			if (mDevices.getDevicesStatus() == 1) {
				mHolder.devices_switch.setChecked(true);
				mHolder.devices_state.setText("开启");
			}
			mHolder.devices_switch
					.setOnCheckedChangeListener(new OnCheckedChangeListener() {

						@Override
						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							// TODO Auto-generated method stub
							if (isChecked) {
								mHolder.devices_state.setText("开启");
								mDevices.setDevicesStatus(1);
//								notifyDataSetChanged();
							} else {
								mHolder.devices_state.setText("关闭");
								mDevices.setDevicesStatus(0);
//								notifyDataSetChanged();
							}
						}
					});

			return mView;
		}

		public void setList(List<SceneDevice> list) {
			mSceneDevicesList = null;
			mSceneDevicesList = list;
		}

		public class ViewHolder {
			ImageView devices_img;
			TextView devices_name;
			TextView devices_state;
			Switch devices_switch;
		}
	}

	public void setAdapter(BaseAdapter mAdapter) {
		// TODO Auto-generated method stub
		mBaseAdapter = null;
		mBaseAdapter = mAdapter;
	}

	public interface ChangeFragment {
		public void setFragment(Fragment f);
	}
}
