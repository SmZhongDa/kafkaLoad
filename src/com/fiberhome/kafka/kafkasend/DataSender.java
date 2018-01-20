package com.fiberhome.kafka.kafkasend;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fiberhome.kafka.config.getConfig;
import com.fiberhome.kafka.utils.StrBuffer;
import com.fiberhome.kafka.utils.Utils;



public class DataSender implements Runnable{
	private static final Logger logger = LoggerFactory.getLogger(DataSender.class);
	
	private String _topic;
	private String _group_name;

	private StrBuffer _buffer = null;
	
	public DataSender(String topic,String group_id,StrBuffer buffer){
		this._topic = topic;
		this._group_name = group_id;
		this._buffer = buffer;
		
	}
	

	public void run()
	{
		logger.info("DataSender: [topic:" + this._topic + ", groupname:" + this._group_name + "]");
		int linenum = 0;

		try{
			KafkaProducer<String, String> ppro = getConfig.getInstance().getKafkaProducer();
			while(true)
			{
				String data = this._buffer.pollData();
				if(null == data){
					if(linenum != 0){
						logger.info("DataSender[topic:" + this._topic + ",groupname:" + this._group_name +"] -- send " + linenum + " successfully.");
						linenum = 0;
					}
					logger.info("DataSender[topic:" + this._topic + ",groupname:" + this._group_name +"] -- no data to send.");
					Utils.sleep(1);
				}
				else{
						ppro.send(new ProducerRecord<String, String>(this._topic,data),
								new org.apache.kafka.clients.producer.Callback() {
							@Override
							public void onCompletion(RecordMetadata metadata,
									Exception exception) {
								if (exception != null) {
									exception.printStackTrace();
									System.out.println("send error"+ exception.toString());
								}
							}
						});
					linenum++;
					if(linenum == 1000){
						logger.info("DataSender[topic:" + this._topic + ",groupname:" + this._group_name +"] -- send 1000 successfully.");
						linenum = 0;
						Thread.sleep(30);
					}
						
				}
			}
		}
		catch(Exception e){
			logger.error("DataSender run failed,[topic:" + this._topic + ",groupname:" + this._group_name,e);
		}
	}
}
