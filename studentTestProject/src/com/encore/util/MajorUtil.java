package com.encore.util;

import javax.servlet.http.HttpServletRequest;
import com.encore.model.MajorVO;

public class MajorUtil {
	public static MajorVO makeMajor(HttpServletRequest request) {
		String mmajor_id = request.getParameter("major_id");
		int major_id = Integer.parseInt(mmajor_id);
		String major_title = request.getParameter("major_title");

		MajorVO major = new MajorVO(major_id, major_title);
		return major;

	}
}
