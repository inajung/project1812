package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EncoreService;

public class InfoViewController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		EncoreService service = new EncoreService();
		data.put("studentlist", service.selectAllStudent());
		data.put("majorlist", service.selectAllMajor());
	}

}
