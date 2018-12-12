package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EncoreService;
import com.encore.model.MajorVO;

public class MjrEnrollController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		String method = (String)data.get("method");
		EncoreService service = new EncoreService();
		if(method.equals("get")) return;
		else {
		MajorVO major = (MajorVO) data.get("major");
		data.put("message", service.insertMajor(major) > 0 ? "입력성공" : "입력실패");}
	}

}
