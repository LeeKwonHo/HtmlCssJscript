package com.test.ho;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Test Servlet");

		PrintWriter pw = response.getWriter();
		pw.write("<h1 style=\"color: red;\">" + "Test print" + "</h1>");
	}

}
