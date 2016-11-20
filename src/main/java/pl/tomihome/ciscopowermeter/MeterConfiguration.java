package pl.tomihome.ciscopowermeter;

import java.util.HashMap;

public class MeterConfiguration {
	
	public HashMap<String, String> snmpInParams;
	public String ipRouter, dbHost;
	

	public void setIpRouter(String ipRouter) {
		this.ipRouter = ipRouter;
	}

	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}

	public void setSnmpInParams(HashMap<String, String> snmpInParams) {
		this.snmpInParams = snmpInParams;
	}
}
