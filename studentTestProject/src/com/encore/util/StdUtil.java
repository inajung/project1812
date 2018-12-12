package com.encore.util;

import javax.servlet.http.HttpServletRequest;
import com.encore.model.StudentVO;

public class StdUtil {
	public static StudentVO makeStudent(HttpServletRequest request) {
		String sstudent_id = request.getParameter("student_id");
		int student_id = Integer.parseInt(sstudent_id);
		String name = request.getParameter("name");
		String mmajor_id = request.getParameter("major_id");
		int major_id = Integer.parseInt(mmajor_id);
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		String skill  = request.getParameter("skill");
		
		StudentVO std =new StudentVO(student_id, name, major_id, phone, address, hobby, skill);
		return std; 
	
	}
}
