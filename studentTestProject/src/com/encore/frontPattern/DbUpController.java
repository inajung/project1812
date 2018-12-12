package com.encore.frontPattern;

import java.util.Map;
import com.encore.model.EncoreService;

public class DbUpController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		
		EncoreService service = new EncoreService();
		String result = service.initData((String)data.get("m_file"),(String)data.get("s_file"));
		data.put("message", result);	
	}

}
