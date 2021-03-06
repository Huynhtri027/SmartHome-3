package com.gdgl.util;

import java.util.HashMap;
import java.util.Map;

import android.app.Fragment;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.gdgl.activity.LockFragment;
import com.gdgl.activity.CurtainControlFragment;
import com.gdgl.activity.OutLetControlFragment;
import com.gdgl.activity.SeekLightsControlFragment;
import com.gdgl.activity.SwitchControlFragment;
import com.gdgl.activity.WarnningControlFragment;
import com.gdgl.adapter.SceneDevicesAdapter;
import com.gdgl.mydata.DataHelper;
import com.gdgl.smarthome.R;

public class UiUtils {

	public static final String SharedPreferences_SETTING_INFOS = "SmartHome";

	public static final String PWD = "Password";
	public static final String NAME = "Name";
	public static final String UID = "UserID";
	public static final String IS_REMERBER_PWD = "RemerberPwd";
	public static final String IS_AUTO_LOGIN = "AutoLogin";
	
	public static final String REMOTE_CONTROL = "RemoteControl";
	
	public static final String KONGTIAO="kongtiao";
	public static final String TV="tv";

	public static final String REGION = "RegionName";
	public static final String SCENE = "SceneId";
	public static final String COMMONUSED = "common_used";
	public static final String REGION_FLAG = "REGION";
	public static final String SCENE_FLAG = "SCENE";
	public static final String DEVICES_FLAG = "DEVICE";

	public static final String JOINNETTIME="Joinnettime";
	
	public static final String EMPTY_STR = "";

	public static final String REM_PWD_ACT = "remeber_pwd";
	public static final String N_REM_PWD_ACT = "not_remeber_pwd";

	public static final String AUTO_LOGIN_ACT = "AutoLogin";

	public static int ILLEGAI_UID = -1;

	public static final int PARLOR = 0; // 客厅
	public static final int MASTER_BEDROOM = 1; // 主卧
	public static final int STUDY = 2; // 书房
	public static final int KITCHEN = 3;
	public static final int CORRIDOR = 4; // 走廊
	public static final int BATHROOM = 5; // 洗手间

	// devices
	public static final int LIGHTS = 0; // 普通灯
	public static final int DIMEN_LIGHTS = 1; // 调光灯
	public static final int SWITCH = 2; // 开关
	public static final int CURTAINS = 3; // 窗帘

	public static final int LIGHTS_MANAGER = 0;
	public static final int ELECTRICAL_MANAGER = 1;
	public static final int SECURITY_CONTROL = 2;
	public static final int ENVIRONMENTAL_CONTROL = 3;
	public static final int ENERGY_CONSERVATION = 4;
	public static final int OTHER = 5;
	public static final int SWITCH_DEVICE = 6;

	
	public static Map<String,String> clusterMap;
	static{
		clusterMap=new HashMap<String, String>();
		clusterMap.put("ZB02A", "0006OUT"); //墙面开关（单键）
		clusterMap.put("ZB02B", "0006OUT"); //墙面开关（双键）
		clusterMap.put("ZB02C", "0006OUT"); //墙面开关（三键）
		clusterMap.put("Z311J", "0006OUT"); //门窗感应开关
		clusterMap.put("Z302J", "0006OUT"); //门窗感应开关
		clusterMap.put("ZB02F", "0008OUT"); //调光开关
		clusterMap.put("Z312", "0502OUT"); //门铃按键
		
		clusterMap.put("ZA10", "0006IN"); //无线智能阀门开关
		clusterMap.put("Z805B", "0006IN"); //开关模块（单路）
		clusterMap.put("Z806", "0006IN"); //开关模块（双路）
		clusterMap.put("Z809A", "0006IN"); //电能检测插座
		clusterMap.put("Z811", "0006IN"); //开关模块（四路）
		clusterMap.put("Z816H", "0006IN"); //中规电能检测墙面插座
		clusterMap.put("Z817B", "0008IN"); //吸顶电能检测调光模块
		clusterMap.put("Z815N", "0008IN"); //幕帘控制开关
		clusterMap.put("Z602A", "0502IN"); //警报器
	}
	
	public static int getDevicesSmallIcon(int type) {
		int result = 0;
		switch (type) {
		case DataHelper.DIMEN_LIGHTS_DEVICETYPE:
			result = R.drawable.seek_light;
			break;
		case DataHelper.ON_OFF_SWITCH_DEVICETYPE:
			result = R.drawable.switch_small;
			break;
		case DataHelper.DIMEN_SWITCH_DEVICETYPE:
			result = R.drawable.dimmable_switch;
			break;
		case DataHelper.LIGHT_SENSOR_DEVICETYPE:
			result = R.drawable.light_sensor;
			break;
		case DataHelper.SHADE_DEVICETYPE:
			result = R.drawable.curtain;
			break;
		case DataHelper.MAINS_POWER_OUTLET_DEVICETYPE:
			result = R.drawable.wall_socket;
			break;
		case DataHelper.IAS_WARNNING_DEVICE_DEVICETYPE:
			result = R.drawable.alarm_small;
			break;
		case DataHelper.REMOTE_CONTROL_DEVICETYPE:
			result = R.drawable.remote_control;
			break;
		case DataHelper.IAS_ACE_DEVICETYPE:
			result = R.drawable.tv_control;
			break;
		case DataHelper.RANGE_EXTENDER_DEVICETYPE:
			result = R.drawable.range_extender;
			break;
		case DataHelper.ON_OFF_OUTPUT_DEVICETYPE:
			result = R.drawable.on_off_output;
			break;
		case DataHelper.COMBINED_INTERFACE_DEVICETYPE:
			result = R.drawable.the_adapter;
			break;
		default:
			result = R.drawable.tempture;
			break;
		}
		return result;
	}

	public static String[] getTagsByType(int type) {
		String[] tags = null;
		switch (type) {
		case LIGHTS_MANAGER:
			tags = new String[] { "电器控制", "安全防护", "照明管理", "环境监测", "节能", "其它" };
			break;
		case ELECTRICAL_MANAGER:
			tags = new String[] { "照明管理", "安全防护", "电器控制", "环境监测", "节能", "其它" };
			break;
		case SECURITY_CONTROL:
			tags = new String[] { "照明管理", "电器控制", "安全防护", "环境监测", "节能", "其它" };
			break;
		case ENVIRONMENTAL_CONTROL:
			tags = new String[] { "照明管理", "电器控制", "环境监测", "安全防护", "节能", "其它" };
			break;
		case ENERGY_CONSERVATION:
			tags = new String[] { "照明管理", "电器控制", "节能", "安全防护", "环境监测", "其它" };
			break;
		case OTHER:
			tags = new String[] { "照明管理", "电器控制", "其它", "节能", "安全防护", "环境监测" };
			break;
		}
		return tags;
	}
	
	public static String getClusterIdByDeviceid_Modelid(String model_id,String Ep){
		if(model_id.indexOf("ZB02A")==0){
			return clusterMap.get("ZB02A");
		} else if (model_id.indexOf("ZB02B")==0) {
			return clusterMap.get("ZB02B");
		} else if (model_id.indexOf("ZB02C")==0) {
			return clusterMap.get("ZB02C");
		} else if (model_id.indexOf("Z311J")==0 && Ep.equals("01")) {
			return clusterMap.get("Z311J");
		} else if (model_id.indexOf("Z302J")==0 && Ep.equals("01")) {
			return clusterMap.get("Z302J");
		} else if (model_id.indexOf("ZB02F")==0) {
			return clusterMap.get("ZB02F");
		} else if (model_id.indexOf("Z312")==0) {
			return clusterMap.get("Z312");
			
		} else if (model_id.indexOf("ZA10")==0) {
			return clusterMap.get("ZA10");
		} else if (model_id.indexOf("Z805B")==0) {
			return clusterMap.get("Z805B");
		} else if (model_id.indexOf("Z806")==0) {
			return clusterMap.get("Z806");
		} else if (model_id.indexOf("Z809A")==0) {
			return clusterMap.get("Z809A");
		} else if (model_id.indexOf("Z811")==0) {
			return clusterMap.get("Z811");
		} else if (model_id.indexOf("Z816H")==0) {
			return clusterMap.get("Z816H");
		} else if (model_id.indexOf("Z817B")==0) {
			return clusterMap.get("Z817B");
		} else if (model_id.indexOf("Z815N")==0) {
			return clusterMap.get("Z815N");
		} else if (model_id.indexOf("Z602A")==0) {
			return clusterMap.get("Z602A");
		} else {
			return "";
		}
	}
	
	public static int[] getImgByType(int type) {
		int[] imgs = null;
		switch (type) {
		case LIGHTS_MANAGER:
			imgs = new int[] { R.drawable.electrical_control, R.drawable.safe,
					R.drawable.light_manage, R.drawable.huanjing_jiance,
					R.drawable.jieneng, R.drawable.other };
			break;
		case ELECTRICAL_MANAGER:
			imgs = new int[] { R.drawable.light_manage, R.drawable.safe,
					R.drawable.electrical_control, R.drawable.huanjing_jiance,
					R.drawable.jieneng, R.drawable.other };
			break;
		case SECURITY_CONTROL:
			imgs = new int[] { R.drawable.light_manage,
					R.drawable.electrical_control, R.drawable.safe,
					R.drawable.huanjing_jiance, R.drawable.jieneng,
					R.drawable.other };
			break;
		case ENVIRONMENTAL_CONTROL:
			imgs = new int[] { R.drawable.light_manage,
					R.drawable.electrical_control, R.drawable.huanjing_jiance,
					R.drawable.safe, R.drawable.jieneng, R.drawable.other };
			break;
		case ENERGY_CONSERVATION:
			imgs = new int[] { R.drawable.light_manage,
					R.drawable.electrical_control, R.drawable.jieneng,
					R.drawable.safe, R.drawable.huanjing_jiance,
					R.drawable.other };
			break;
		case OTHER:
			imgs = new int[] { R.drawable.light_manage,
					R.drawable.electrical_control, R.drawable.other,
					R.drawable.jieneng, R.drawable.safe,
					R.drawable.huanjing_jiance };
			break;
		}
		return imgs;
	}
 
	public static boolean isHaveBattery(String modelid){
		
		if(null==modelid || modelid.trim().equals("")){
			return false;
		}
		
		String[] mHasBattery={DataHelper.Motion_Sensor,DataHelper.Magnetic_Window,DataHelper.Emergency_Button,DataHelper.Doors_and_windows_sensor_switch,
				DataHelper.Siren,DataHelper.Wall_switch_touch,DataHelper.Wall_switch_double,DataHelper.Wall_switch_triple,
				DataHelper.Dimmer_Switch,DataHelper.Indoor_temperature_sensor,DataHelper.Light_Sensor,DataHelper.Multi_key_remote_control,
				DataHelper.Doorbell_button}; 
		
		for (int i = 0; i < mHasBattery.length; i++) {
			if(modelid.trim().indexOf(mHasBattery[i])==0){
				return true;
			}
		}
		
		return false;
		
	}
	
	public static int[] getType(int type) {
		int[] imgs = null;
		switch (type) {
		case LIGHTS_MANAGER:
			imgs = new int[] { ELECTRICAL_MANAGER, SECURITY_CONTROL,
					LIGHTS_MANAGER, ENVIRONMENTAL_CONTROL, ENERGY_CONSERVATION,
					OTHER };
			break;
		case ELECTRICAL_MANAGER:
			imgs = new int[] { LIGHTS_MANAGER, SECURITY_CONTROL,
					ELECTRICAL_MANAGER, ENVIRONMENTAL_CONTROL,
					ENERGY_CONSERVATION, OTHER };
			break;
		case SECURITY_CONTROL:
			imgs = new int[] { LIGHTS_MANAGER, ELECTRICAL_MANAGER,
					SECURITY_CONTROL, ENVIRONMENTAL_CONTROL,
					ENERGY_CONSERVATION, OTHER };
			break;
		case ENVIRONMENTAL_CONTROL:
			imgs = new int[] { LIGHTS_MANAGER, ELECTRICAL_MANAGER,
					ENVIRONMENTAL_CONTROL, SECURITY_CONTROL,
					ENERGY_CONSERVATION, OTHER };
			break;
		case ENERGY_CONSERVATION:
			imgs = new int[] { LIGHTS_MANAGER, ELECTRICAL_MANAGER,
					ENERGY_CONSERVATION, SECURITY_CONTROL,
					ENVIRONMENTAL_CONTROL, OTHER };
			break;
		case OTHER:
			imgs = new int[] { LIGHTS_MANAGER, ELECTRICAL_MANAGER, OTHER,
					ENERGY_CONSERVATION, SECURITY_CONTROL,
					ENVIRONMENTAL_CONTROL };
			break;
		}
		return imgs;
	}

	public static int getDevicesSmallIconByModelId(String modelId) {

		int imgId = R.drawable.detector;

		if (modelId.indexOf(DataHelper.Motion_Sensor) == 0) { // ZigBee动作感应器
			imgId = R.drawable.motion_sensor;
		}
		if (modelId.indexOf(DataHelper.Magnetic_Window) == 0) { // ZigBee窗磁
			imgId = R.drawable.motion_sensor;
		}
		if (modelId.indexOf(DataHelper.Emergency_Button) == 0) { // ZigBee紧急按钮
			imgId = R.drawable.urgent;
		}
		if (modelId.indexOf(DataHelper.Smoke_Detectors) == 0) { // 烟雾感应器
			imgId = R.drawable.smoke;
		}
		if (modelId.indexOf(DataHelper.Combustible_Gas_Detector_Gas) == 0) { // 可燃气体探测器（煤气)器
			imgId = R.drawable.detector;
		}
		if (modelId.indexOf(DataHelper.Combustible_Gas_Detector_CO) == 0) { // 可燃气体探测器（一氧化碳)
			imgId = R.drawable.detector_ano;
		}
		if (modelId.indexOf(DataHelper.Combustible_Gas_Detector_Natural_gas) == 0) { // 可燃气体探测器（天然气)
			imgId = R.drawable.detector_ano;
		}
		if (modelId.indexOf(DataHelper.Doorbell_button) == 0) { // 可燃气体探测器（天然气)
			imgId = R.drawable.doorbell;
		}
		if (modelId.indexOf(DataHelper.Siren) == 0) { // 可燃气体探测器（天然气)
			imgId = R.drawable.alarm_small;
		}
		return imgId;
	}

	public static int getSceneItemType(int devicesid) {

		int LIGHT = DataHelper.ON_OFF_SWITCH_DEVICETYPE;
		int[] NOOPER = { DataHelper.LIGHT_SENSOR_DEVICETYPE,
				DataHelper.TEMPTURE_SENSOR_DEVICETYPE };
		int[] WITH_VALUE = { DataHelper.DIMEN_SWITCH_DEVICETYPE,
				DataHelper.DIMEN_LIGHTS_DEVICETYPE, DataHelper.SHADE_DEVICETYPE };
		for (int i : WITH_VALUE) {
			if (i == devicesid) {
				return SceneDevicesAdapter.WITH_VALUE;
			}
		}
		if (devicesid == LIGHT) {
			return SceneDevicesAdapter.LIGHT;
		}
		for (int i : NOOPER) {
			if (i == devicesid) {
				return SceneDevicesAdapter.NO_OPERATOR;
			}
		}
		return SceneDevicesAdapter.ON_OFF;
	}

	public static int getDevicesSmallIconForRemote(int type) {

		int imgId = R.drawable.detector;

		switch (type) {
		case DataHelper.REMOTE_CONTROL_DEVICETYPE:
			imgId = R.drawable.tv_control;
			break;
		case DataHelper.IAS_ACE_DEVICETYPE:
			imgId = R.drawable.remote_control;
			break;
		}
		return imgId;
	}

	public static int getLightsSmallIcon(boolean state) {
		if (state) {
			return R.drawable.l_on_forreg;
		}
		return R.drawable.l_off_forreg;
	}

	public static int[] DEVICES_MANAGER_IMAGES = { R.drawable.light_manage,
			R.drawable.electrical_control, R.drawable.safe,
			R.drawable.huanjing_jiance, R.drawable.jieneng ,R.drawable.other};
	public static String[] DEVICES_MANAGER_TAGS = { "照明管理", "电器控制", "安全防护",
			"环境监测", "节能","其它" };

	public static int[] getImagResource(int type) {
		int[] mresult = null;
		switch (type) {
		case 0:
		case 1:
			mresult = DEVICES_MANAGER_IMAGES;
			break;
		default:
			break;
		}
		return mresult;
	}

	public static String[] getTagResource(int type) {
		String[] mresult = null;
		switch (type) {
		case 0:
		case 1:
			mresult = DEVICES_MANAGER_TAGS;
			break;
		default:
			break;
		}
		return mresult;
	}

	public static Fragment getFragment(int type) {

		Fragment mFragment = null;
		switch (type) {
		case DataHelper.ON_OFF_SWITCH_DEVICETYPE:
			mFragment = new SwitchControlFragment();
			break;
		case DataHelper.TEMPTURE_SENSOR_DEVICETYPE:
			mFragment = null;
			break;
		case DataHelper.LIGHT_SENSOR_DEVICETYPE:
			mFragment = null;
			break;
		case DataHelper.IAS_WARNNING_DEVICE_DEVICETYPE:
			mFragment = new WarnningControlFragment();
			break;
		case DataHelper.MAINS_POWER_OUTLET_DEVICETYPE:
			mFragment = new OutLetControlFragment();
			break;
		case DataHelper.IAS_ZONE_DEVICETYPE:
			mFragment = new LockFragment();
			break;
		case DataHelper.DIMEN_SWITCH_DEVICETYPE:

		case DataHelper.DIMEN_LIGHTS_DEVICETYPE:
			mFragment = new SeekLightsControlFragment();
			break;
		case DataHelper.SHADE_DEVICETYPE:
			mFragment = new CurtainControlFragment();
			break;

		default:
			break;
		}
		return mFragment;

	}

	public static String formatResponseString(String response) {
		response = response.replaceAll("\n", "");
		response = response.replaceAll("\t", "");
		response = customString(response);
		return response;
	}

	public static String customString(String s) {
//		s = s.substring(s.indexOf("{"), s.length() - 1);
		s = s.substring(s.indexOf("{"), s.lastIndexOf("}")+1);
		return s;
	}

	public static Toast getToast(Context c) {
		LayoutInflater inflater = LayoutInflater.from(c);
		View layout = inflater.inflate(R.layout.custom_toast, null);
		Toast toast = new Toast(c);
		toast.setGravity(Gravity.BOTTOM, 0, 250);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);
		toast.show();
		return toast;
	}

	public static LayoutAnimationController getAnimationController(Context c) {
		int duration = 500;
		AnimationSet set = new AnimationSet(true);

		Animation animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(duration);
		set.addAnimation(animation);

		animation = AnimationUtils.loadAnimation(c, R.anim.slide_bottom_to_top);
		animation.setDuration(duration);
		set.addAnimation(animation);

		LayoutAnimationController controller = new LayoutAnimationController(
				set, 0.5f);
		controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
		return controller;
	}

}
