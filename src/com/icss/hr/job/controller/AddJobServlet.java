package com.icss.hr.job.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;

/**
 *	增加职务的控制器
 */
@WebServlet("/AddJobServlet")
public class AddJobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		获得请求参数
		String jobNname = request.getParameter("jobName");
		String jobMinSal = request.getParameter("jobMinSal");
		String jobMaxSal = request.getParameter("jobMaxSal");
		
//		封装pojo对象
		Job job = new Job(jobNname,Integer.parseInt(jobMinSal),Integer.parseInt(jobMaxSal));
		
//		调用业务对象
		JobService service = new JobService();
		
		
		try {
			service.addJOb(job);
		} catch (Exception e) {		
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);		
	}

}
