package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EncoreService;
import com.encore.model.StudentVO;

public class MyInfoUpdateController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		EncoreService service = new EncoreService();
        String method = (String)data.get("method");
        if(method.equals("get")) {
            String sstudentID = (String)data.get("studentID");
            int studentID = Integer.parseInt(sstudentID);
            StudentVO student = service.selectByStudent(studentID);      
            System.out.println(student);
            data.put("student", student);
      
        }else {
        	StudentVO student = (StudentVO)data.get("student");
            data.put("message", service.studentUpdate(student)>0?"수정성공":"수정실패");
        }

	}

}
