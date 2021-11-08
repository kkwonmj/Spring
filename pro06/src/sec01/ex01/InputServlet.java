package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		String[] subject = request.getParameterValues("subject"); // 여러 개 있어서 배열로 넣음
			for(String str : subject) {
				System.out.println("선택한 과목 : " + str);
		
		System.out.println("아이디 : " + user_id);
		System.out.println("비밀번호 : " + user_pw);
			}
	}	
}
