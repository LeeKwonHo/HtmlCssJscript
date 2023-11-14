package com.test.ho.calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ho.ReqRes;

public class CalcServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ReqRes.getInstance().setResEcodingType(req, res);

		String numOne = req.getParameter("numberOne");
		String numTwo = req.getParameter("numberTwo");
		String op = req.getParameter("operations");

		PrintWriter pw = res.getWriter();

		System.out.println(op);
		String a = Calcurator.getInstance().add(numOne, numTwo);
		String b = Calcurator.getInstance().minus(numOne, numTwo);
		String c = Calcurator.getInstance().multiply(numOne, numTwo);
		String d = Calcurator.getInstance().divide(numOne, numTwo);
		String e = Calcurator.getInstance().remain(numOne, numTwo);

		if ("PLUS".equals(op)) {
			pw.write(numOne + " + " + numTwo + " = " + a + " 입니다.");
		} else if ("MINUS".equals(op)) {
			pw.write(numOne + " - " + numTwo + " = " + b + " 입니다.");
		} else if ("MULTIPLY".equals(op)) {
			pw.write(numOne + " * " + numTwo + " = " + c + " 입니다.");
		} else if ("DIVIDE".equals(op)) {
			pw.write(numOne + " / " + numTwo + " = " + d + " 입니다.");
		} else if ("REMAIN".equals(op)) {
			pw.write(numOne + " % " + numTwo + " = " + e + " 입니다.");
		} else {

		}
		pw.write(" <br> <input type=\"button\" name=\"BackBtn\" id=\"backBTN\" value=\"돌아가기\">");
		pw.println("<script>");
		pw.println("document.getElementById('backBTN').addEventListener('click', function () {");
		pw.println("    location.href = 'http://localhost/calc.html';");
		pw.println("    alert('Go Back!');");
		pw.println("});");
		pw.println("</script>");

	}

}
