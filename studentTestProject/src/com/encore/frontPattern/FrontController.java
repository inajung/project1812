package com.encore.frontPattern;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.encore.frontPattern.CommonController;
import com.encore.frontPattern.LoginController;
import com.encore.model.MajorVO;
import com.encore.model.StudentVO;
import com.encore.util.MajorUtil;
import com.encore.util.StdUtil;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.go")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path2=
				request.getServletContext().getRealPath("csvfile");
		request.setCharacterEncoding("utf-8");
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		String requestURI = uri.substring(path.length(), uri.length() - 3);

		RequestDispatcher rd = null;
		response.setCharacterEncoding("utf-8");
		CommonController controller = null;
		Map<String, Object> data = new HashMap<>();
		String page = null;
		String method = request.getMethod().toLowerCase();
		data.put("method", method);

		HttpSession session = request.getSession();

		if (requestURI.equals("/login/signOut")) {
			session.invalidate();
			response.sendRedirect("../index.jsp");
			return;
		}

		Object sessionObj = session.getAttribute("std");
		if (!requestURI.equals("/login/sign") && sessionObj == null) {
			response.sendRedirect(path + "/login/sign.go");
			return;
		}
		switch (requestURI) {
		case "/login/sign":
			controller = new LoginController();
			if (method.equals("get")) {
				page = "sign.jsp";
			} else {
				String userid = request.getParameter("userid");// name
				String userpass = request.getParameter("userpass");// student_id
				data.put("userid", userid);
				data.put("userpass", userpass);
				data.get("result"); // yes, no

			}
			break;

		case "/admin/DbUpload":
			controller = new DbUpController();
			String m_file= path2 + "/major.csv"; 
			String s_file= path2 + "/student.csv";
			data.put("m_file", m_file);
			data.put("s_file", s_file);
			page="DbUpload.jsp";
		break;
	
		case "/admin/mjrManage":
			controller = new MjrManageController();
			page="mjrManage.jsp";
			break;
		case "/admin/mjrEnroll":
			controller = new MjrEnrollController();
			if(method.equals("get")) {
				page="mjrEnroll.jsp";
			}else {
				
				data.put("major", MajorUtil.makeMajor(request));
				page = "result.jsp";
			}
			break;
		case "/admin/stdManage":
			controller = new StdManageController();
			page="stdManage.jsp";
			break;
		case "/admin/stdEnroll":
			controller = new StdEnrollController();
			if(method.equals("get")) {
				page="stdEnroll.jsp";
			}else {
				data.put("student", StdUtil.makeStudent(request));
				page = "result.jsp";
			}
			break;
		case "/admin/majorDelete":
			controller = new MajorDeleteController();
				String sid = request.getParameter("major_id");
				int major_id = Integer.parseInt(sid);
				data.put("major_id", major_id);
				page = "result.jsp";
			break; 
			
		case "/admin/majorUpdate": 
			controller = new MajorUpdateController();
			if(method.equals("get")) {
				String sid2 = request.getParameter("major_id");
				int major_id2 = Integer.parseInt(sid2);
				data.put("major_id", major_id2);
				page = "majorUpdate.jsp";
			}else {
				String smajor_id = request.getParameter("major_id");
				int major_id2 = Integer.parseInt(smajor_id);
				String major_title = request.getParameter("major_title");
				MajorVO major = new MajorVO(major_id2, major_title);
				data.put("major", major);
				page="result.jsp";
			}
			break; 
		case "/admin/studentDelete":
			controller = new StudentDeleteController();
				String sstudentid = request.getParameter("studentID");
				System.out.println("ss : " + sstudentid);
				int studentID2 = Integer.parseInt(sstudentid);
				System.out.println(studentID2);
				data.put("studentID", studentID2);
				page = "result2.jsp";
			break; 
			
		case "/admin/studentUpdate": 
			controller = new StudentUpdateController();
			if(method.equals("get")) {
				String sid3 = request.getParameter("studentID");
				int studentID = Integer.parseInt(sid3);
				data.put("studentID", studentID);
				page = "studentUpdate.jsp";
			}else {
				StudentVO student = StdUtil.makeStudent(request); 
				data.put("student", student);
				page="result2.jsp";
			}
			break; 	
			
		case "/student/InfoView":
			controller = new InfoViewController(); 
			page="infolist.jsp";
			break; 	
		
		case "/student/infolist2":
			controller = new InfoViewController2(); 
			data.put("studentID", request.getParameter("studentID"));
			data.put("majorid", request.getParameter("majorid"));
			page="infolist2.jsp";
			break; 	
			
		case "/student/myInfoUpdate":
			controller = new MyInfoUpdateController();
			if(method.equals("get")) {
				StudentVO student  =(StudentVO)session.getAttribute("std");
				String studentID = student.getStudentID()+"";
				System.out.println(studentID);
				data.put("studentID", studentID);
				page = "studentUpdate.jsp";
			}else {
				StudentVO student = StdUtil.makeStudent(request); 
				System.out.println(student);
				data.put("student", student);
				System.out.println(student);
				page="../admin/result2.jsp";
			}
			break; 	
		default:
			break;

		}
		System.out.println(data);
		controller.execute(data);
		
		Object result = data.get("loginResult");// 로그인 다녀왔을 수도 있지만. 다른 서비스를 다녀왔을 수도 있음

		if (result != null) {
			String yesNo = (String) result;
System.out.println(yesNo);
			if (yesNo.equals("yes")) {
				// 인증되면 index.jsp
				StudentVO std = (StudentVO) data.get("std");
				session.setAttribute("std", std);
				session.setAttribute("signMessage", "");
				if (!std.getName().equals("admin")) {         /////////////어떻게 될지 확인 
				response.sendRedirect("../index.jsp");
				}else {
					response.sendRedirect("../index2.jsp");	
				}
				return;
			} else {
				// 인증안되면 sign.jsp
				session.setAttribute("signMessage", "인증실패");
				response.sendRedirect("sign.go");
				return;
			}
		}
		for (String key : data.keySet()) {
			request.setAttribute(key, data.get(key));
		}
		rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
