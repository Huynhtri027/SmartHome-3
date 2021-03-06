package com.gdgl.util;

import java.util.List;

import android.content.Context;

import com.gdgl.activity.OutLetControlFragment;
import com.gdgl.activity.SceneDevicesActivity;
import com.gdgl.activity.SeekLightsControlFragment;
import com.gdgl.activity.CurtainControlFragment;
import com.gdgl.manager.CGIManager;
import com.gdgl.model.SimpleDevicesModel;
import com.gdgl.mydata.DataHelper;

public class DispatchOperator {

	private CGIManager mLightManager;
	private List<SceneDevicesActivity.OperatorDevices> mList;
	
	public DispatchOperator(Context c,List<SceneDevicesActivity.OperatorDevices> list){
		mLightManager=new CGIManager();
		mList=list;
	}
	
	public void operator(){
		for (SceneDevicesActivity.OperatorDevices so : mList) {
			Do(so);
		}
	}
	
	private void Do(SceneDevicesActivity.OperatorDevices s){
		
		SimpleDevicesModel sd=s.sModel;
		int devid=sd.getmDeviceId();
		
		switch(devid){
		case DataHelper.ON_OFF_SWITCH_DEVICETYPE:
			mLightManager.OnOffOutputOperation(sd, getChangeValue(s.state));
			break;
		case DataHelper.TEMPTURE_SENSOR_DEVICETYPE:
			CGIManager.getInstance().temperatureSensorOperation(sd, 0);
			CGIManager.getInstance().temperatureSensorOperation(sd, 1);

			break;
		case DataHelper.LIGHT_SENSOR_DEVICETYPE:
			CGIManager.getInstance().lightSensorOperation(sd, 0);
			break;
		case DataHelper.ON_OFF_OUTPUT_DEVICETYPE:
		case DataHelper.IAS_WARNNING_DEVICE_DEVICETYPE:
			mLightManager.IASWarningDeviceOperationCommon(sd,0);
			break;
		case DataHelper.MAINS_POWER_OUTLET_DEVICETYPE:
			sd.setmOnOffStatus(s.state?"1":"0");
			mLightManager.MainsOutLetOperation(sd,OutLetControlFragment.operatortype.ChangeOnOffSwitchActions,1);
			break;
		case DataHelper.IAS_ZONE_DEVICETYPE:
			if (s.state) {
				mLightManager.LocalIASCIEByPassZone(sd);
			}else {
				mLightManager.LocalIASCIEUnByPassZone(sd);
			}
			break;
		case DataHelper.DIMEN_SWITCH_DEVICETYPE:
			
		case DataHelper.DIMEN_LIGHTS_DEVICETYPE:
			mLightManager.dimmableLightOperation(sd,SeekLightsControlFragment.operatortype.MoveToLevel,s.value*255/100);
			break;
		case DataHelper.SHADE_DEVICETYPE:
			CGIManager.getInstance().shadeOperation(sd, CurtainControlFragment.operatortype.TurnOn);
			break;
	
		default:
			break;
		}
	}
	
	private int getChangeValue(boolean s) {
		if (s) {
			return 0x01;
		}else {
			return 0x00;
		}
	}
}
