package com.gdgl.model;

import com.gdgl.app.ApplicationController;
import com.gdgl.mydata.DataHelper;
import com.gdgl.mydata.DataUtil;
import com.gdgl.mydata.DevParam;
import com.gdgl.mydata.Node;
import com.gdgl.mydata.ResponseParamsEndPoint;
import com.gdgl.util.UiUtils;

import android.content.ContentValues;
import android.provider.BaseColumns;

interface DevicesBaseColumns extends BaseColumns {

	public static final String ALL_COUNT = "allcount";
	public static final String CURCOUNT = "curcount";
	public static final String DEVICE_ID = "device_id";
	public static final String R_ID = "rid";
	public static final String PIC_NAME = "picname";
	public static final String PROFILE_ID = "profileid";
	public static final String POWER_RESOURCE = "powersource";
	public static final String CUR_POWER_RESOURCE = "curpowersource";
	public static final String CURPOWERSOURCELEVEL = "curpowersourcelevel";
	public static final String IEEE = "ieee";
	public static final String NWK_ADDR = "nwk_addr";
	public static final String NODE_EN_NAME = "node_en_name";
	public static final String CLUSTER_ID = "cluster_id";
	public static final String BIND_TO = "bind_to";
	
	public static final String MANUFACTORY = "manufactory";
	public static final String ZCL_VERSTION = "zcl_version";
	public static final String STACK_VERSTION = "stack_version";
	public static final String APP_VERSTION = "app_version";
	public static final String HW_VERSTION = "hw_version";
	public static final String DATE_CODE = "date_code";

	public static final String MODEL_ID = "model_id";
	public static final String NODE_TYPE = "node_type";
	public static final String EP = "ep";
	public static final String NAME = "name";
	public static final String CURRENT = "current";
	public static final String ENERGY = "energy";
	public static final String POWER = "power";
	public static final String VOLTAGE = "voltage";
	public static final String ON_OFF_STATUS = "on_off_status";
	public static final String EP_MODEL_ID = "ep_model_id";
	public static final String CURRENT_MIN = "current_min";
	public static final String CURRENT_MAX = "current_max";
	public static final String VOLTAGE_MIN = "voltage_min";
	public static final String VOLTAGE_MAX = "voltage_max";
	public static final String ENERGY_MIN = "energy_min";
	public static final String ENERGY_MAX = "energy_max";

	// 自定义
	public static final String DEVICE_REGION = "device_region";
	public static final String LAST_UPDATE_TIME = "last_update_time";
	public static final String ON_OFF_LINE = "on_off_line";
	public static final String USER_DEFINE_NAME = "user_define_name";
	public static final String DEVICE_SORT = "device_sort";
}

public class DevicesModel implements DevicesBaseColumns {

	public static final int DEVICE_ON_LINE = 1;
	public static final int DEVICE_OFF_LINE = 0;

	private int ID;
	private String mAllCount = "";
	private String mCurCount = "";
	private String mDeviceId = "";
	private String mRid = "-1";
	private String mPicName = "";
	private String mProfileId = "0104";
	private String mPowerResource = "";
	private String mCurPowerResource = "";
	private String curpowersourcelevel = "";
	private String mIeee = "";
	private String mNWKAddr = "";
	private String mNodeENNAme = "";
	private String mClusterID="";
	private String mBindTo="";

	private String mManufactory = "";
	private String mZCLVersion = "";
	private String mStackVerstion = "stack_version";
	private String mAppVersion = "";
	private String mHwVersion = "";
	private String mDateCode = "";

	private String mModelId = "";
	private String mNodeType = "";
	private String mEP = "";
	private String mName = "";
	private String mCurrent = "";
	private String mEnergy = "";
	private String mPower = "";
	private String mVoltage = "";
	private String mOnOffStatus = "";
	private String mEPModelId = "";
	private String mCurrentMin = "";
	private String mCurrentMax = "";
	private String mVoltageMin = "";
	private String mVoltageMax = "";
	private String mEnergyMin = "";
	private String mEnergyMax = "";

	// 自定义
	private String mDeviceRegion = "";
	private long mLastDateTime;
	private int mOnOffLine = DEVICE_ON_LINE;
	private String mUserDefineName = "";
	
	private int mValue1 = 0;
	private int mValue2 = 0;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getmAllCount() {
		return mAllCount;
	}

	public void setmAllCount(String mAllCount) {
		this.mAllCount = mAllCount;
	}

	public String getmCurCount() {
		return mCurCount;
	}

	public void setmCurCount(String mCurCount) {
		this.mCurCount = mCurCount;
	}

	public String getmDeviceId() {
		return mDeviceId;
	}

	public void setmDeviceId(String mDeviceId) {
		this.mDeviceId = mDeviceId;
	}

	public String getmRid() {
		return mRid;
	}

	public void setmRid(String mRid) {
		this.mRid = mRid;
	}

	public String getmPicName() {
		return mPicName;
	}

	public void setmPicName(String mPicName) {
		this.mPicName = mPicName;
	}

	public String getmProfileId() {
		return mProfileId;
	}

	public void setmProfileId(String mProfileId) {
		this.mProfileId = mProfileId;
	}

	public String getmPowerResource() {
		return mPowerResource;
	}

	public void setmPowerResource(String mPowerResource) {
		this.mPowerResource = mPowerResource;
	}

	public String getmCurPowerResource() {
		return mCurPowerResource;
	}

	public void setmCurPowerResource(String mCurPowerResource) {
		this.mCurPowerResource = mCurPowerResource;
	}

	public String getmIeee() {
		return mIeee;
	}

	public void setmIeee(String mIeee) {
		this.mIeee = mIeee;
	}

	public String getmNWKAddr() {
		return mNWKAddr;
	}

	public void setmNWKAddr(String mNWKAddr) {
		this.mNWKAddr = mNWKAddr;
	}

	public String getmNodeENNAme() {
		return mNodeENNAme;
	}

	public void setmNodeENNAme(String mNodeENNAme) {
		this.mNodeENNAme = mNodeENNAme;
	}

	public String getmManufactory() {
		return mManufactory;
	}

	public void setmManufactory(String mManufactory) {
		this.mManufactory = mManufactory;
	}

	public String getmZCLVersion() {
		return mZCLVersion;
	}

	public void setmZCLVersion(String mZCLVersion) {
		this.mZCLVersion = mZCLVersion;
	}

	public String getmStackVerstion() {
		return mStackVerstion;
	}

	public void setmStackVerstion(String mStackVerstion) {
		this.mStackVerstion = mStackVerstion;
	}

	public String getmAppVersion() {
		return mAppVersion;
	}

	public void setmAppVersion(String mAppVersion) {
		this.mAppVersion = mAppVersion;
	}

	public String getmHwVersion() {
		return mHwVersion;
	}

	public void setmHwVersion(String mHwVersion) {
		this.mHwVersion = mHwVersion;
	}

	public String getmDateCode() {
		return mDateCode;
	}

	public void setmDateCode(String mDateCode) {
		this.mDateCode = mDateCode;
	}

	public String getmModelId() {
		return mModelId;
	}

	public void setmModelId(String mModelId) {
		this.mModelId = mModelId;
	}

	public String getmNodeType() {
		return mNodeType;
	}

	public void setmNodeType(String mNodeType) {
		this.mNodeType = mNodeType;
	}

	public String getmEP() {
		return mEP;
	}

	public void setmEP(String mEP) {
		this.mEP = mEP;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmCurrent() {
		return mCurrent;
	}

	public void setmCurrent(String mCurrent) {
		this.mCurrent = mCurrent;
	}

	public String getmEnergy() {
		return mEnergy;
	}

	public void setmEnergy(String mEnergy) {
		this.mEnergy = mEnergy;
	}

	public String getmPower() {
		return mPower;
	}

	public void setmPower(String mPower) {
		this.mPower = mPower;
	}

	public String getmVoltage() {
		return mVoltage;
	}

	public void setmVoltage(String mVoltage) {
		this.mVoltage = mVoltage;
	}

	public String getmOnOffStatus() {
		return mOnOffStatus;
	}

	public void setmOnOffStatus(String mOnOffStatus) {
		this.mOnOffStatus = mOnOffStatus;
	}

	public String getmEPModelId() {
		return mEPModelId;
	}

	public void setmEPModelId(String mEPModelId) {
		this.mEPModelId = mEPModelId;
	}

	public String getmCurrentMin() {
		return mCurrentMin;
	}

	public void setmCurrentMin(String mCurrentMin) {
		this.mCurrentMin = mCurrentMin;
	}

	public String getmCurrentMax() {
		return mCurrentMax;
	}

	public void setmCurrentMax(String mCurrentMax) {
		this.mCurrentMax = mCurrentMax;
	}

	public String getmVoltageMin() {
		return mVoltageMin;
	}

	public void setmVoltageMin(String mVoltageMin) {
		this.mVoltageMin = mVoltageMin;
	}

	public String getmVoltageMax() {
		return mVoltageMax;
	}

	public void setmVoltageMax(String mVoltageMax) {
		this.mVoltageMax = mVoltageMax;
	}

	public String getmEnergyMin() {
		return mEnergyMin;
	}

	public void setmEnergyMin(String mEnergyMin) {
		this.mEnergyMin = mEnergyMin;
	}

	public String getmEnergyMax() {
		return mEnergyMax;
	}

	public void setmEnergyMax(String mEnergyMax) {
		this.mEnergyMax = mEnergyMax;
	}

	public String getmDeviceRegion() {
		return mDeviceRegion;
	}

	public void setmDeviceRegion(String mDeviceRegion) {
		this.mDeviceRegion = mDeviceRegion;
	}

	public long getmLastDateTime() {
		return mLastDateTime;
	}

	public void setmLastDateTime(long mLastDateTime) {
		this.mLastDateTime = mLastDateTime;
	}

	public int getmOnOffLine() {
		return mOnOffLine;
	}

	public void setmOnOffLine(int mOnOffLine) {
		this.mOnOffLine = mOnOffLine;
	}
	
	public String getmUserDefineName() {
		return mUserDefineName;
	}

	public void setmUserDefineName(String mUserDefineName) {
		this.mUserDefineName = mUserDefineName;
	}

	public ContentValues convertContentValues() {
		ContentValues mContentValues = new ContentValues();

		mContentValues.put(DevicesBaseColumns.ALL_COUNT, getmAllCount());
		mContentValues.put(DevicesBaseColumns.APP_VERSTION, getmAppVersion());
		mContentValues.put(DevicesBaseColumns.CUR_POWER_RESOURCE,
				getmCurPowerResource());
		mContentValues.put(DevicesBaseColumns.CURPOWERSOURCELEVEL,
				getCurpowersourcelevel());
		mContentValues.put(DevicesBaseColumns.CURCOUNT, getmCurCount());
		mContentValues.put(DevicesBaseColumns.CURRENT, getmCurrent());
		mContentValues.put(DevicesBaseColumns.CURRENT_MAX, getmCurrentMax());
		mContentValues.put(DevicesBaseColumns.CURRENT_MIN, getmCurrentMin());
		mContentValues.put(DevicesBaseColumns.DATE_CODE, getmDateCode());
		mContentValues.put(DevicesBaseColumns.DEVICE_ID, getmDeviceId());
		mContentValues
				.put(DevicesBaseColumns.DEVICE_REGION, getmDeviceRegion());
		mContentValues.put(DevicesBaseColumns.ENERGY, getmEnergy());
		mContentValues.put(DevicesBaseColumns.ENERGY_MAX, getmEnergyMax());
		mContentValues.put(DevicesBaseColumns.ENERGY_MIN, getmEnergyMin());
		mContentValues.put(DevicesBaseColumns.EP, getmEP());
		mContentValues.put(DevicesBaseColumns.EP_MODEL_ID, getmEPModelId());
		mContentValues.put(DevicesBaseColumns.HW_VERSTION, getmHwVersion());
		mContentValues.put(DevicesBaseColumns.IEEE, getmIeee());
		mContentValues.put(DevicesBaseColumns.LAST_UPDATE_TIME,
				getmLastDateTime());
		mContentValues.put(DevicesBaseColumns.MANUFACTORY, getmManufactory());
		mContentValues.put(DevicesBaseColumns.MODEL_ID, getmModelId());
		mContentValues.put(DevicesBaseColumns.NAME, getmName());
		mContentValues.put(DevicesBaseColumns.NODE_EN_NAME, getmNodeENNAme());
		mContentValues.put(DevicesBaseColumns.NODE_TYPE, getmNodeType());
		mContentValues.put(DevicesBaseColumns.NWK_ADDR, getmNWKAddr());
		mContentValues.put(DevicesBaseColumns.ON_OFF_LINE, getmOnOffLine());
		if(null==getmOnOffStatus() || getmOnOffStatus().trim().equals("0")){
			mContentValues.put(DevicesBaseColumns.ON_OFF_STATUS, "0");
		}else{
			mContentValues.put(DevicesBaseColumns.ON_OFF_STATUS, "1");
		}
		mContentValues.put(DevicesBaseColumns.PIC_NAME, getmPicName());
		mContentValues.put(DevicesBaseColumns.POWER, getmPower());
		mContentValues.put(DevicesBaseColumns.POWER_RESOURCE,
				getmPowerResource());
		mContentValues.put(DevicesBaseColumns.PROFILE_ID, getmProfileId());
		mContentValues.put(DevicesBaseColumns.R_ID, getmRid());
		mContentValues.put(DevicesBaseColumns.STACK_VERSTION,
				getmStackVerstion());
		mContentValues.put(DevicesBaseColumns.VOLTAGE, getmVoltage());
		mContentValues.put(DevicesBaseColumns.VOLTAGE_MAX, getmVoltageMax());
		mContentValues.put(DevicesBaseColumns.VOLTAGE_MIN, getmVoltageMin());
		mContentValues.put(DevicesBaseColumns.ZCL_VERSTION, getmZCLVersion());
		mContentValues.put(DevicesBaseColumns.CLUSTER_ID, getmClusterID());
		mContentValues.put(DevicesBaseColumns.BIND_TO, getmBindTo());
		
		//设置设备名称
		if (getmUserDefineName() == null || getmUserDefineName().trim().equals("")) {
			setmUserDefineName(DataUtil.getDefaultUserDefinname(
					ApplicationController.getInstance(), getmModelId()));
		}
		mContentValues.put(DevicesBaseColumns.USER_DEFINE_NAME, getmUserDefineName());
		
		//设备分类
		if(Integer.valueOf(getmDeviceId())==DataHelper.ON_OFF_SWITCH_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.SWITCH_DEVICE);
		} else if(Integer.valueOf(getmDeviceId())==DataHelper.ON_OFF_OUTPUT_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.SECURITY_CONTROL);
		} else if(Integer.valueOf(getmDeviceId())==DataHelper.REMOTE_CONTROL_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.SWITCH_DEVICE);
		} else if (Integer.valueOf(getmDeviceId())==DataHelper.COMBINED_INTERFACE_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.SECURITY_CONTROL);
		} else if (Integer.valueOf(getmDeviceId())==DataHelper.RANGE_EXTENDER_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.ELECTRICAL_MANAGER);
		} else if (Integer.valueOf(getmDeviceId())==DataHelper.MAINS_POWER_OUTLET_DEVICETYPE) {
			if(getmModelId().indexOf(DataHelper.Switch_Module_Single)==0) {
				mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.LIGHTS_MANAGER);
			} else {
				mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.ELECTRICAL_MANAGER);
			}
		} else if (Integer.valueOf(getmDeviceId())==DataHelper.DIMEN_LIGHTS_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.LIGHTS_MANAGER);
		} else if (Integer.valueOf(getmDeviceId())==DataHelper.DIMEN_SWITCH_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.SWITCH_DEVICE);
		} else if (Integer.valueOf(getmDeviceId())==DataHelper.LIGHT_SENSOR_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.ENVIRONMENTAL_CONTROL);
		} else if (Integer.valueOf(getmDeviceId())==DataHelper.SHADE_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.ELECTRICAL_MANAGER);
		} else if (Integer.valueOf(getmDeviceId())==DataHelper.TEMPTURE_SENSOR_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.ENVIRONMENTAL_CONTROL);
		} else if (Integer.valueOf(getmDeviceId())==DataHelper.IAS_ACE_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.SWITCH_DEVICE);
		} else if (Integer.valueOf(getmDeviceId())==DataHelper.IAS_ZONE_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.SECURITY_CONTROL);
		} else if (Integer.valueOf(getmDeviceId())==DataHelper.IAS_WARNNING_DEVICE_DEVICETYPE) {
			mContentValues.put(DevicesBaseColumns.DEVICE_SORT, UiUtils.SECURITY_CONTROL);
		}

		return mContentValues;
	}

	public DevicesModel() {
	}

	// ResponseParamsEndPoint
	public DevicesModel(ResponseParamsEndPoint r) {

		DevParam d = r.getDevparam();
		Node n = d.getNode();

		setmAllCount(r.getAllcount());
		setmAppVersion(n.getApp_version());
		setmCurCount(r.getCurcount());
		setmCurPowerResource(r.getCurpowersource());
		setCurpowersourcelevel(r.getCurpowersourcelevel());
		setmCurrent(d.getCurrent());
		setmCurrentMax(d.getCurrentmax());
		setmCurrentMin(d.getCurrentmin());
		setmDateCode(n.getDate_code());
		setmDeviceId(r.getDevice_id()==null?"":r.getDevice_id());
		setmEnergy(d.getEnergy());
		setmEnergyMax(d.getEnergymax());
		setmEnergyMin(d.getEnergymin());
		setmEP(d.getEp()==null?"":d.getEp());
		setmEPModelId(d.getEp_model_id()==null?"":d.getEp_model_id());
		setmHwVersion(n.getHw_version());
		setmIeee(n.getIeee()==null?"":n.getIeee());
		setmManufactory(n.getManufactory());
		setmModelId(n.getModel_id()==null?"":n.getModel_id());
		setmName(d.getName()==null?"":d.getName());
		setmNodeENNAme(n.getName()==null?"":n.getName());
		setmNodeType(n.getNode_type()==null?"":n.getNode_type());
		setmNWKAddr(n.getNwk_addr()==null?"":n.getNwk_addr());
		setmOnOffStatus(d.getOn_off_status()==null?"0":d.getOn_off_status());
		setmPicName(r.getPicname());
		setmPower(d.getPower()==null?"":d.getPower());
		setmPowerResource(r.getPowersource());
		setmProfileId(r.getProfileid());
		setmRid(r.getRid());
		setmStackVerstion(n.getStack_version());
		setmVoltage(d.getVoltage());
		setmVoltageMax(d.getVoltagemax());
		setmVoltageMin(d.getVoltagemin());
		setmZCLVersion(n.getZcl_version());
		setmDeviceRegion("");
		setmLastDateTime(System.currentTimeMillis());
		setmClusterID(UiUtils.getClusterIdByDeviceid_Modelid(n.getModel_id(),d.getEp()));
		setmBindTo("");
		setmOnOffLine(DEVICE_ON_LINE);
	}

	public int getmValue1() {
		return mValue1;
	}

	public void setmValue1(int mValue1) {
		this.mValue1 = mValue1;
	}

	public int getmValue2() {
		return mValue2;
	}

	public void setmValue2(int mValue2) {
		this.mValue2 = mValue2;
	}

	public String getmClusterID() {
		return mClusterID;
	}

	public void setmClusterID(String mClusterID) {
		this.mClusterID = mClusterID;
	}

	public String getmBindTo() {
		return mBindTo;
	}

	public void setmBindTo(String mBindTo) {
		this.mBindTo = mBindTo;
	}

	@Override
	public String toString() {
		return "DevicesModel [ID=" + ID + ", mAllCount=" + mAllCount
				+ ", mCurCount=" + mCurCount + ", mDeviceId=" + mDeviceId
				+ ", mRid=" + mRid + ", mPicName=" + mPicName + ", mProfileId="
				+ mProfileId + ", mPowerResource=" + mPowerResource
				+ ", mCurPowerResource=" + mCurPowerResource + ", mIeee="
				+ mIeee + ", mNWKAddr=" + mNWKAddr + ", mNodeENNAme="
				+ mNodeENNAme + ", mClusterID=" + mClusterID + ", mBindTo="
				+ mBindTo + ", mManufactory=" + mManufactory + ", mZCLVersion="
				+ mZCLVersion + ", mStackVerstion=" + mStackVerstion
				+ ", mAppVersion=" + mAppVersion + ", mHwVersion=" + mHwVersion
				+ ", mDateCode=" + mDateCode + ", mModelId=" + mModelId
				+ ", mNodeType=" + mNodeType + ", mEP=" + mEP + ", mName="
				+ mName + ", mCurrent=" + mCurrent + ", mEnergy=" + mEnergy
				+ ", mPower=" + mPower + ", mVoltage=" + mVoltage
				+ ", mOnOffStatus=" + mOnOffStatus + ", mEPModelId="
				+ mEPModelId + ", mCurrentMin=" + mCurrentMin
				+ ", mCurrentMax=" + mCurrentMax + ", mVoltageMin="
				+ mVoltageMin + ", mVoltageMax=" + mVoltageMax
				+ ", mEnergyMin=" + mEnergyMin + ", mEnergyMax=" + mEnergyMax
				+ ", mDeviceRegion=" + mDeviceRegion + ", mLastDateTime="
				+ mLastDateTime + ", mOnOffLine=" + mOnOffLine
				+ ", mUserDefineName=" + mUserDefineName + ", mValue1="
				+ mValue1 + ", mValue2=" + mValue2 + "]";
	}

	public String getCurpowersourcelevel() {
		return curpowersourcelevel;
	}

	public void setCurpowersourcelevel(String curpowersourcelevel) {
		this.curpowersourcelevel = curpowersourcelevel;
	}
	
	
}
