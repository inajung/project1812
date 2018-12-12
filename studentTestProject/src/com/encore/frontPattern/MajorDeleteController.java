package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EncoreService;

public class MajorDeleteController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		  EncoreService service = new EncoreService();
	      int major_id = (Integer)data.get("major_id");
	        data.put("message",service.deleteMajor(major_id)>0?"삭제성공":"삭제실패");

	}

}
