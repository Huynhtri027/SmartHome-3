package com.gdgl.mydata;
/***
 * 1234 ({ "request_id":	1234,
 *  "response_params":	
 * { "ieee":	"00137A00000121EF", "ep":	"01", 
 * "status":	{ 
 * "alarm1":	false, 
 * "alarm2":	false, 
 * "tamper":	false, 
 * "batterly_low":	false, 
 * "supervision_reports": true,
 *  "restore_reports":	
 *  true, "trouble":	
 *  false, "ac_trouble":	
 *  false, "battery_level":	95 } } } )
 * @author justek
 *
 */
public class ParamsForStatus {
	private String ieee;
	private String ep;
	private Status status;
	public String getIeee() {
		return ieee;
	}
	public void setIeee(String ieee) {
		this.ieee = ieee;
	}
	public String getEp() {
		return ep;
	}
	public void setEp(String ep) {
		this.ep = ep;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
