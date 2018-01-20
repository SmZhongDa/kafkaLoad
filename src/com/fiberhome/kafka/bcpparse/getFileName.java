package com.fiberhome.kafka.bcpparse;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fiberhome.kafka.config.getConfig;
import com.fiberhome.kafka.utils.StrBuffer;
import com.fiberhome.kafka.utils.Utils;



public class getFileName implements Runnable{
	
	private static final Logger logger = LoggerFactory.getLogger(getFileName.class);
	
	
	public String _bad_file = getConfig.get_instance().getbad_dir();
	public StrBuffer _fileNameBuffer;
	public String _file_path;
	private String _file_rule = getConfig.get_instance().getFILENAME_RULE();
	
	public getFileName(StrBuffer buffer){
		this._fileNameBuffer = buffer; 
		this._file_path = getConfig.getInstance().get_file_path();
	}
	
	
	@Override
	public void run(){
		if(this._fileNameBuffer.getDataSize()==0)
			check();
	}
	
	public void check(){
		logger.info("start check path [" + this._file_path + "]");
		try{
			File dir = new File(this._file_path);
			if(dir.exists() && dir.isDirectory())
			{
				logger.debug(String.valueOf(dir.list().length));
				if(dir.list().length == 0){
					logger.info(this._file_path + " no file.");
					return;
				}
				
				for(String filename : dir.list()){
					if(filename.matches(this._file_rule)){
						logger.info("get a file: [" + filename + "]");
						this._fileNameBuffer.putData(this._file_path + File.separator + filename);
						
					}else{
						logger.info("file type is not right.[" + filename + "]");
						String srcFile = dir +  File.separator + filename;
//						Utils.moveFile(srcFile, this._bad_file);
						File src = new File(srcFile);
						String dest = _bad_file + File.separator + src.getName();
						Files.move(Paths.get(srcFile), Paths.get(dest),StandardCopyOption.REPLACE_EXISTING);
					}
						
				}
			}else
			{
				logger.info("dir: [" + this._file_path + "] does not exist or is not directory,sleep 10s.");
				Utils.sleep(10);
			}
		}
		catch(Exception e){
			logger.error("DirCheck run failed.sleep 10s" + e);
			Utils.sleep(10);
		}
	}
	


}
