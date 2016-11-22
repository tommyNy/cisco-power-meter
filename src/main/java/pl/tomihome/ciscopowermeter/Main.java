package pl.tomihome.ciscopowermeter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import org.jboss.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		getContextParams();
		dbConnection();
		// GetSnmpWalk snmpWalkGetter = new GetSnmpWalk(getContextParams());
		// try{
		// snmpWalkGetter.doSnmpwalk();
		// } catch (Exception e) {
		// logger.error("Oops exception during execute snmpwalk. " +
		// e.getMessage());
		// }
	}

	public static HashMap<String, String> getContextParams() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("app-ctx.xml");
		MeterConfiguration meterConfig = appContext.getBean("MeterConfiguration", MeterConfiguration.class);

		HashMap<String, String> snmpParams = meterConfig.snmpParams;

		logger.debug("---snmp params---");
		logger.debug("router IP:\t" + snmpParams.get("ipaddr"));
		logger.debug("oid:\t" + snmpParams.get("oid"));
		logger.debug("communityString:\t" + snmpParams.get("communityString"));
		logger.debug("version:\t" + snmpParams.get("version"));

		HashMap<String, String> dbParams = meterConfig.dbParams;

		logger.debug("---db params---");
		logger.debug("db file:\t" + dbParams.get("dbFileName"));
		logger.debug("user:\t" + dbParams.get("user"));
		logger.debug("password:\t" + dbParams.get("password"));

		HashMap<String, Integer> piParams = meterConfig.rpiParams;

		logger.debug("---rpi params---");
		logger.debug("rs:\t\t" + piParams.get("rs"));
		logger.debug("strobe:\t" + piParams.get("strobe"));
		logger.debug("d0:\t\t" + piParams.get("d0"));
		logger.debug("d1:\t\t" + piParams.get("d1"));
		logger.debug("d2:\t\t" + piParams.get("d2"));
		logger.debug("d3:\t\t" + piParams.get("d3"));

		return snmpParams;
	}

	public static void dbConnection() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tniemczak\\power.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				float salary = rs.getFloat("salary");
				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("AGE = " + age);
				System.out.println("ADDRESS = " + address);
				System.out.println("SALARY = " + salary);
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
}
