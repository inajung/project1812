package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EncoreService;

public class InfoViewController2 implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		EncoreService service = new EncoreService();
		String studentID = (String)data.get("studentID");
		String majorid = (String)data.get("majorid");
		
		data.put("studentlist", 
		    service.selectByIDs(Integer.parseInt(studentID),Integer.parseInt(majorid)));
	}

}
