package com.fiberhome.kafka.bcpparse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.LoggerFactory;

import cn.net.ycloud.ydb.json.JSONArray;
import cn.net.ycloud.ydb.json.JSONObject;

import com.fiberhome.kafka.config.MapLoder;
import com.fiberhome.kafka.config.getConfig;
import com.fiberhome.kafka.utils.StrBuffer;
import com.fiberhome.kafka.utils.Utils;


public class parseFile implements Runnable{
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(parseFile.class);
	
	public StrBuffer _fileNameBuffer;
	public StrBuffer _jsonBuffer;
	public String _tmp_dir = getConfig.get_instance().getTMP_DIR();
	private String _bad_file = getConfig.get_instance().getbad_dir();
	
	private BufferedReader br = null;
	
	private lineParse _parser = null;
	 
	public parseFile(StrBuffer fileNameBuffer,StrBuffer jsonBuffer){
		this._fileNameBuffer = fileNameBuffer;
		this._jsonBuffer = jsonBuffer;
		this._parser = new lineParse('\t');
	}
	
	
	
	
	private void parseBcpFile()
	{
		logger.info("[start] process file thread.");
			String fileName;
			JSONArray jsonlist = null;
			JSONObject json = null;
			while (true) {
				try{
				fileName = this._fileNameBuffer.pollData();
				if (null == fileName) {
					logger.info("No file.thread pasrseFile wait 2s.");
					logger.debug(String.valueOf(_jsonBuffer.getDataSize()));
					Utils.sleep(2);
					continue;
				}
				logger.info("[start] process file: [" + fileName + "]");
		
				File srcFile = new File(fileName);
				String[] item_array = srcFile.getName().split("_");
				
				//判断协议是否存在
				String protocol = item_array[3];
				if (!(MapLoder._capture_time.keySet().contains(protocol))) {
					logger.error("protocol: [" + protocol + "] is illegal.");
					String dest = _bad_file + File.separator + srcFile.getName();
					Files.move(Paths.get(fileName), Paths.get(dest),StandardCopyOption.REPLACE_EXISTING);
					continue;
				}

				this.br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile)));
				String line = null;
				jsonlist = new JSONArray();
				String partion = null;
				while ((line = br.readLine()) != null) {
					String[] arry = line.split("\t",-1);
					String capturetime =  arry[MapLoder._capture_time.get(protocol) - 1];
				    partion = Utils.getDate(Long.valueOf(capturetime));	
				    
				    //判断字段对应
					if(arry.length == MapLoder._fieldMap.get(protocol).size()){
						JSONObject data = parseBcpLine(line, protocol);
						jsonlist.put(data);
					    json = new JSONObject();
						json.put(getConfig.getInstance().get_json_key_table(),"NB_TAB_" + protocol);
						json.put(getConfig.getInstance().get_json_key_partion(),partion);
						json.put(getConfig.getInstance().get_json_key_data(),data);
						this._jsonBuffer.putData(json.toString());
					}else{
						logger.error("num is not equal:" + "[" + protocol + ":" + line +"]");
						String dest = _bad_file + File.separator + srcFile.getName();
						Files.move(Paths.get(fileName), Paths.get(dest),StandardCopyOption.REPLACE_EXISTING);
						break;
					}
				}
				br.close();
				logger.info("[complete] file: " + srcFile + " process end,delete it.");
				srcFile.delete();
				}
				catch(Exception e){
					logger.error("parseBcpFile failed.",e);
				}

			}
	}
	
	
	private JSONObject parseBcpLine(String line,String protocol)
	{
		this._parser.parse(line);
		JSONObject data = new JSONObject();
		String field_value;
		int i = 0;
		for (String field : MapLoder._fieldMap.get(protocol)) {
			field_value = "";
			field_value = this._parser.getStringColumn(i);
			
			if(field_value.length() == 0){
				i++;
				continue;
			}
				
			data.put(field, field_value);
			i++;
		}
		return data;
	}
	
	
	public void run(){
	try {
		   parseBcpFile();	
		} catch (Exception e) {
			logger.error("pollData() is wrong. " + e);
		}
	}

}
