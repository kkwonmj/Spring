package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;import sec01.ex01.MemberBean;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

		List membersList = new ArrayList();
		String _name = memberVO.getName();
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			if ((_name!=null && _name.length()!=0)) {
				query+=" where name=?"; // 한 칸을 띄워야 함
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, _name);
			} else {
				pstmt = con.prepareStatement(query);
			}
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberBean vo = new MemberBean();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				/* vo.setJoinDate(joinDate); */
				membersList.add(vo);
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return membersList;
	}
	public void addMember(MemberBean memberBean) {
		try {
			
		}
	}
}