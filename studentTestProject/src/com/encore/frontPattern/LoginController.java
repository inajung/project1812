package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EncoreService;
import com.encore.model.StudentVO;

public class LoginController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		String method = (String) data.get("method");
		if (method.equals("get"))
			return;

		String userid = (String) data.get("userid");
		String userpass = (String) data.get("userpass");
		System.out.println(userid+"LC");
		System.out.println(userpass+"LC");
		EncoreService service = new EncoreService();
		StudentVO std = service.loginCheck(userid, userpass);
		System.out.println(std+"std");
		data.put("loginResult", std == null ? "no" : "yes");
		data.put("std", std);
	}
}
