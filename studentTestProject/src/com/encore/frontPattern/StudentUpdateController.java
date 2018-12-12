package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EncoreService;
import com.encore.model.StudentVO;



public class StudentUpdateController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		EncoreService service = new EncoreService();
        String method = (String)data.get("method");
        if(method.equals("get")) {
            int studentID = (Integer)data.get("studentID");
            System.out.println(studentID+"검색한 학생ID");
            StudentVO student = service.selectByStudent(studentID);
            System.out.println(student+"검색한 학생정보");
            data.put("student", student);
      
        }else {
        	StudentVO student = (StudentVO)data.get("student");
            data.put("message", service.studentUpdate(student)>0?"수정성공":"수정실패");
        }

	}

}
