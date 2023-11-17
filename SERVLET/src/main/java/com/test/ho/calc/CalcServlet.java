package com.test.ho.calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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

		String opResult = null;

		System.out.println(op);
		if ("PLUS".equals(op)) {
			opResult = Calcurator.getInstance().add(numOne, numTwo);
		}
		if ("MINUS".equals(op)) {
			opResult = Calcurator.getInstance().minus(numOne, numTwo);
		}
		if ("MULTIPLY".equals(op)) {
			opResult = Calcurator.getInstance().multiply(numOne, numTwo);
		}
		if ("DIVIDE".equals(op)) {
			opResult = Calcurator.getInstance().divide(numOne, numTwo);
		}
		if ("REMAIN".equals(op)) {
			opResult = Calcurator.getInstance().remain(numOne, numTwo);
		}

		req.setAttribute("opResult", opResult);
		req.setAttribute("numOne", numOne);
		req.setAttribute("numTwo", numTwo);
		req.setAttribute("op", op);

		RequestDispatcher dis = req.getRequestDispatcher("/jsp/calc/calc_compute_result.jsp");
		dis.forward(req, res);

	}

}
