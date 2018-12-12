package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EncoreService;

public class StudentDeleteController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		  EncoreService service = new EncoreService();
	      int studentID = (Integer)data.get("studentID");
	      data.put("message",service.deleteStudent(studentID)>0?"삭제성공":"삭제실패");

	}

}
