package sec2.ex2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			this.dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public List<MemberVO> listMembers() {
		ArrayList list = new ArrayList();

		try {
			this.con = this.dataFactory.getConnection();
			String query = "select * from t_member";
			System.out.println("prepareStatement: " + query);
			this.pstmt = this.con.prepareStatement(query);
			ResultSet rs = this.pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}

			rs.close();
			this.pstmt.close();
			this.con.close();
		} catch (Exception var10) {
			var10.printStackTrace();
		}

		return list;
	}

	public void addMember(MemberVO memberVO) {
		try {
			this.con = this.dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String query = "insert into t_member";
			query = query + " (id,pwd,name,email)";
			query = query + " values(?,?,?,?)";
			System.out.println("prepareStatememt: " + query);
			this.pstmt = this.con.prepareStatement(query);
			this.pstmt.setString(1, id);
			this.pstmt.setString(2, pwd);
			this.pstmt.setString(3, name);
			this.pstmt.setString(4, email);
			this.pstmt.executeUpdate();
			this.pstmt.close();
		} catch (Exception var7) {
			var7.printStackTrace();
		}

	}

	public void delMember(String id) {
		try {
			this.con = this.dataFactory.getConnection();
			String query = "delete from t_member where id=?";
			System.out.println("prepareStatememt:" + query);
			this.pstmt = this.con.prepareStatement(query);
			this.pstmt.setString(1, id);
			this.pstmt.executeUpdate();
			this.pstmt.close();
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}
}