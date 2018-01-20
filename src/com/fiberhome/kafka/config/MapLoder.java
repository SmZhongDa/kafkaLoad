package com.fiberhome.kafka.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MapLoder {

	private static final Logger logger = LoggerFactory.getLogger(getConfig.class);
	public static ConcurrentHashMap<String, ArrayList<String>> _fieldMap = new ConcurrentHashMap<String, ArrayList<String>>();
	public static ConcurrentHashMap<String,Integer> _capture_time = new ConcurrentHashMap<String,Integer>();

	
	private final String url = getConfig.getInstance().get_url();
	private final String user = getConfig.getInstance().get_user();
	private final String passwd = getConfig.get_instance().get_password();


	public void load() {
		logger.info("[start] load metadata.");
		Connection conn = null;
		try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, passwd);
			}
		catch (Exception e)
			{
				logger.error(e.toString());
				System.exit(1);
			}
		
		try{
			for(String name:getConfig.get_instance().get_protocol_list()){
			String sql = "SELECT T2.TEMPLATE_NAME, T1.ENAME, T1.RN FROM (SELECT TEMPLATE_ID, ENAME, ROW_NUMBER() OVER(PARTITION BY TEMPLATE_ID ORDER BY FIELD_ID) RN FROM BASE_FIELD_INFO) T1, BASE_TEMPLATE_INFO T2 WHERE T1.TEMPLATE_ID = T2.TEMPLATE_ID AND T2.DIR_ID = 2 and T2.TEMPLATE_NAME = '"+ name + "'";
			PreparedStatement preStatement = conn.prepareStatement(sql);
			ResultSet rs = preStatement.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			while (rs.next()){
				list.add(rs.getString(2).toUpperCase());
				logger.debug(rs.getString(2));
			}
				
			MapLoder._fieldMap.put(name, list);	
			logger.debug(String.valueOf(MapLoder._fieldMap.get(name).size()));
			preStatement.close();
			
		  }
			
		}
		catch (Exception e)
			{
				logger.error(e.toString());
				System.exit(1);
			}

		
		try{
			String sql = "SELECT T2.TEMPLATE_NAME,T1.RN FROM (SELECT TEMPLATE_ID,ENAME,ROW_NUMBER() OVER(PARTITION BY TEMPLATE_ID ORDER BY FIELD_ID) RN FROM BASE_FIELD_INFO) T1,BASE_TEMPLATE_INFO T2 WHERE T1.TEMPLATE_ID = T2.TEMPLATE_ID AND T2.DIR_ID = 2 AND T1.ENAME = 'CAPTURE_TIME'";
		    PreparedStatement preStatement = conn.prepareStatement(sql);
		    ResultSet rs = preStatement.executeQuery();
		    while(rs.next()){
		    	_capture_time.put(rs.getString(1).toUpperCase(), rs.getInt(2));
		    }
		}catch(Exception e){
			logger.error(e.toString());
			System.exit(1);
		}
		logger.info("[complete] Map load successfully.");
	
	}
}
