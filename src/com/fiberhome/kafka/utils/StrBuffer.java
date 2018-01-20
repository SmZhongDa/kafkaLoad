package com.fiberhome.kafka.utils;


import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StrBuffer 
{

	private static final Logger logger = LoggerFactory.getLogger(StrBuffer.class);
	
	private LinkedBlockingQueue<String> _data_buffer = null;
	
	public StrBuffer(int size){
		this._data_buffer = new LinkedBlockingQueue<String>(size);
	}
	

	public void putData(String str)
	{
		try{
			this._data_buffer.put(str);
		}
		catch(InterruptedException e){
			logger.error(e.getMessage());
		}
	}
	

	public String peekData() throws InterruptedException
	{
		return this._data_buffer.peek();
	}
	
	public int getDataSize(){
		return this._data_buffer.size();
	}
	
	
	public  void deleteData() throws InterruptedException
	{
		this._data_buffer.poll();
	}
	
	
	public  String pollData() throws InterruptedException
	{
		return this._data_buffer.poll();
	}
	
}
