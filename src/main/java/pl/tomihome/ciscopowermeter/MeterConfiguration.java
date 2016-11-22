package pl.tomihome.ciscopowermeter;

import java.util.HashMap;

public class MeterConfiguration {
	
	public HashMap<String, String> snmpParams, dbParams; 
	public HashMap<String, Integer> rpiParams;

	public void setSnmpParams(HashMap<String, String> snmpParams) {
		this.snmpParams = snmpParams;
	}

	public void setDbParams(HashMap<String, String> dbParams) {
		this.dbParams = dbParams;
	}

	public void setRpiParams(HashMap<String, Integer> rpiParams) {
		this.rpiParams = rpiParams;
	}
}
