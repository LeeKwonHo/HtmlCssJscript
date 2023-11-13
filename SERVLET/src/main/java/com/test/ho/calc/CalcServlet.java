package com.test.ho.calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		String numOne = req.getParameter("numberOne");
		String numTwo = req.getParameter("numberTwo");

		System.out.println(numOne + ", " + numTwo);

		int result = Integer.parseInt(numOne) + Integer.parseInt(numTwo);
		String a = String.valueOf(result);

		PrintWriter pw = res.getWriter();
		pw.write(a);

		System.out.println(result);
		System.out.println("CalcServlet");
	}

}
