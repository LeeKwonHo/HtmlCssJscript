package com.test.ho;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqRes {

	private static ReqRes reqres;

	private ReqRes() {
	}

	static public ReqRes getInstance() {
		if (reqres == null) {
			reqres = new ReqRes();
		}
		return reqres;
	}

	public void setResEcodingType(HttpServletRequest req, HttpServletResponse res) {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		System.out.println(" \" FUCK Yeah Success \" ");
	}

}
