package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EncoreService;
import com.encore.model.StudentVO;

public class StdEnrollController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		String method = (String)data.get("method");
		EncoreService service = new EncoreService();
		if(method.equals("get")) {
			data.put("majorlist", service.selectAllMajor());
		}
		else {
		StudentVO student = (StudentVO) data.get("student");
		data.put("message", service.insertStudent(student) > 0 ? "입력성공" : "입력실패");}
	}

	}

