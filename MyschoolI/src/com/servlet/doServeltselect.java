package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.IStudentDao;
import com.dao.impl.StudentDao;
import com.entity.student;

public class doServeltselect extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int ss=0;
		System.out.println(request.getParameter("id"));
		if(session.getAttribute("bb")!=null){
			ss=(Integer) session.getAttribute("bb");
		}
		if(request.getParameter("id")!=null){ 
			if(Integer.parseInt(request.getParameter("id"))==1){
				ss--;
			}
			if(Integer.parseInt(request.getParameter("id"))==2){
				ss++;
			}}
		session.setAttribute("bb", ss);
		
		IStudentDao dao = new StudentDao();
		List<student> list = dao.selectpx(ss);
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(student item:list){
			sb.append("{");
			sb.append("\"studentname\":\""+item.getStudentname()+"\"");
			sb.append("},");			
		}
		sb.replace(sb.length()-1, sb.length(), "");
		sb.append("]");
		String data= sb.toString().replaceAll("\"", "&quot;");
		out.print(sb);
		out.flush();
		out.close();
		
	}

}
