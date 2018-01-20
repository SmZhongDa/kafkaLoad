package com.fiberhome.kafka.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Utils {
	
	private static final Logger logger = LoggerFactory.getLogger(Utils.class);
	
	
	public static String getDate(long captureTime){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		String date = sdf.format(new Date(captureTime * 1000L));
		return date;
	}
	
	
	public static boolean nullOrEmpty(String string){
		if( null == string  || string.trim().isEmpty())
			return true;
		else 
			return false;
	}

	
	public static  String getNotNullConfValue(Properties properties,String key) throws Exception
	{
		String tmp = properties.getProperty(key);
		if(Utils.nullOrEmpty(tmp)){
			throw new Exception("please config: " + key);
		}
		logger.debug(key + " = " + tmp);

		return tmp;
	}


	public static void sleep(int second){
		try{
			Thread.sleep(second * 1000);
		}
		catch(Exception e){
			logger.error("sleep is wrong." + e.getMessage());	
		}
	}
	
	
	public static void moveFile(String srcFile,String destDir){
		File src = new File(srcFile);
		String dest = destDir + File.separator + src.getName();
		File destFile = new File(dest);
		destFile.delete();
		src.renameTo(destFile);
	}
	
	
	
	public static void createDir(String ... dir){
		for(String _dir : dir){
			File __dir = new File(_dir);
			if(__dir.exists()){
				logger.info("The path [" + _dir + "] has existed.");
				continue;
			}
			if(!_dir.endsWith(File.separator))
				_dir = _dir + File.separator;
			
			if(__dir.mkdirs())
				logger.info("create dir [" + _dir + "] successfully.");
			else{ 
				logger.error("create dir [" + _dir + "] unsuccessfully.");
				System.exit(-1);
			}
				
			
			
			
		}
		
	}

		
}
