package pl.tomihome.ciscopowermeter;

import java.util.HashMap;

import org.jboss.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {

	}
	
	public static void getContextParams(){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("app-ctx.xml");
		MeterConfiguration meterConfig = appContext.getBean("MeterConfiguration", MeterConfiguration.class);
		
		HashMap<String, String> inSnmpParams = meterConfig.snmpInParams;
		
		logger.debug("---snmp params---");
		logger.debug("router IP: " + inSnmpParams.get("ipaddr"));
		logger.debug("oid: " + inSnmpParams.get("oid"));
		logger.debug("communityString: " + inSnmpParams.get("communityString"));
		logger.debug("version: " + inSnmpParams.get("version"));
	}
}
