package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.EncoreService;
import com.encore.model.MajorVO;

public class MajorUpdateController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		EncoreService service = new EncoreService();
        String method = (String)data.get("method");
        if(method.equals("get")) {
            int major_id = (Integer)data.get("major_id");
            MajorVO major = service.selectByMajor(major_id);
            data.put("major", major);
        }else {
        	MajorVO major = (MajorVO)data.get("major");
            data.put("message", service.majorUpdate(major)>0?"수정성공":"수정실패");
        }

	}

}
