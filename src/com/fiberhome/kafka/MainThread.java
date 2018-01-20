package com.fiberhome.kafka;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.fiberhome.kafka.bcpparse.getFileName;
import com.fiberhome.kafka.bcpparse.parseFile;
import com.fiberhome.kafka.config.MapLoder;
import com.fiberhome.kafka.config.getConfig;
import com.fiberhome.kafka.kafkasend.DataSender;
import com.fiberhome.kafka.utils.StrBuffer;



public class MainThread {
	private static final Logger logger = LoggerFactory.getLogger(MainThread.class);
	private static String LOG_CONF_PATH = "conf/log4j.properties";
	private static String MAIN_CONF_PATH = "conf/main.properties";
	private static String KAFKA_CONF_PATH = "conf/kafka.properties";
	private static String DATABASE_CONF_PATH = "conf/database.properties";

	public static void main(String[] args) {
		PropertyConfigurator.configure(LOG_CONF_PATH);
		getConfig config = getConfig.getInstance();
		config.load(MAIN_CONF_PATH, KAFKA_CONF_PATH, DATABASE_CONF_PATH);
		MapLoder mapload = new MapLoder();
		mapload.load();
		StrBuffer fileNameBuffer = new StrBuffer(2000000);
		StrBuffer jsonBuffer = new StrBuffer(2000000);
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(getConfig.get_instance().get_num() + 3);
		service.scheduleWithFixedDelay(new getFileName(fileNameBuffer), 3, 5, TimeUnit.SECONDS);
		service.execute(new parseFile(fileNameBuffer,jsonBuffer));
		service.execute(new parseFile(fileNameBuffer,jsonBuffer));
		
		for(int i = 0; i < getConfig.get_instance().get_num();i++){
			DataSender sender = new DataSender(config.getkafka_topic(),"ydb" + i,jsonBuffer);
			service.execute(sender);
		}

//		service.shutdown();
	}
}
