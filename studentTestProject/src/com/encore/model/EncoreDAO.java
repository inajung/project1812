package com.encore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.encore.util.MajorUtil;
import com.encore.util.OracleDBUtil;
import com.encore.util.StdUtil;

public class EncoreDAO {

	public StudentVO loginCheck(String userid, String userpass) {
		Connection conn = null;
		PreparedStatement st = null; // select문에 ?가 있게 하려고
		ResultSet rs = null;
		String sql = "select * from student where name=? and STUDENT_ID=?";

		StudentVO std = null;
		System.out.println("a" + userid + "a");
		System.out.println("a" + userpass + "a");
		conn = OracleDBUtil.dbConnect();
		try {

			st = conn.prepareStatement(sql);
			st.setString(1, userid);
			st.setString(2, userpass);
			rs = st.executeQuery();

			if (rs.next()) {
				std = makeStudent(rs);
				System.out.println(std);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return std;
	}

	public boolean initMajorData(List<MajorVO> majorList) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into major values(?,?)";
		int count = 0;
		conn = OracleDBUtil.dbConnect();
		try {

			for (MajorVO major : majorList) {
				st = conn.prepareStatement(sql);
				st.setInt(1, major.getMajor_id());
				st.setString(2, major.getMajor_title());
				count += st.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count > 0 ? true : false;
	}

	public boolean initStudentData(List<StudentVO> studentList) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into student values(?,?,?,?,?,?,?)";
		int count = 0;
		conn = OracleDBUtil.dbConnect();
		try {

			for (StudentVO std : studentList) {
				st = conn.prepareStatement(sql);
				st.setInt(1, std.getStudentID());
				st.setString(2, std.getName());
				st.setInt(3, std.getMajor_id());
				st.setString(4, std.getPhone());
				st.setString(5, std.getAddress());
				st.setString(6, std.getHobby());
				st.setString(7, std.getSkill());

				count += st.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count > 0 ? true : false;
	}

	// public int insertEmp(EmpVO emp) {
	// int result = 0;
	// Connection conn = null;
	// PreparedStatement st = null; //select가 아님으로 resultset은 필요없음
	// String sql = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
	//
	// conn = OracleDBUtil.dbConnect();
	// try {
	// st = conn.prepareStatement(sql);
	// st.setInt(1, emp.getEmployee_id());
	// st.setString(2, emp.getFirst_name());
	// st.setString(3, emp.getLast_name());
	// st.setString(4, emp.getEmail());
	// st.setString(5, emp.getPhone_number());
	// st.setDate(6, emp.getHire_date());
	// st.setString(7, emp.getJob_id());
	// st.setInt(8, emp.getSalary());
	// st.setDouble(9, emp.getCommission_pct());
	// st.setInt(10, emp.getManager_id());
	// st.setInt(11, emp.getDepartment_id());
	// result = st.executeUpdate(); //DML실행
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }finally {
	// OracleDBUtil.dbDisconnect(null, st, conn);
	// }
	// return result;
	// }

	public List<MajorVO> sellectAllMajor() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select* from major order by 1";
		MajorVO major = null;
		List<MajorVO> majorlist = new ArrayList<>();

		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				major = new MajorVO(rs.getInt(1), rs.getString(2));
				majorlist.add(major);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return majorlist;
	}

	public List<StudentVO> sellectAllStudent() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select* from student order by 1";
		StudentVO student = null;
		List<StudentVO> studentlist = new ArrayList<>();

		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				student = new StudentVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				studentlist.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return studentlist;
	}

	public List<StudentVO> retrieve(Map<String, String> job) {
		List<StudentVO> data = new ArrayList<StudentVO>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String original_sql = "select * from student where 1=1 ";
		String modify_sql = "";
		for (String key : job.keySet()) {
			modify_sql += " and " + key + " like '" + job.get(key) + "'";
		}
		String sql = original_sql + modify_sql;
		try {
			conn = OracleDBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				data.add(makeStudent(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}

		return data;
	}

	private StudentVO makeStudent(ResultSet rs) throws SQLException {
		StudentVO std = new StudentVO();
		std.setAddress(rs.getString("address"));
		std.setHobby(rs.getString("hobby"));
		std.setMajor_id(rs.getInt("major_id"));
		std.setName(rs.getString("name"));
		std.setPhone(rs.getString("phone"));
		std.setSkill(rs.getString("skill"));
		std.setStudentID(rs.getInt("student_id"));
		return std;
	}

	public int insertMajor(MajorVO major) {
		int result = 0;
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into major values(?,?)";

		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, major.getMajor_id());
			st.setString(2, major.getMajor_title());
			result = st.executeUpdate(); // DML실행
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result;
	}

	public int insertStudent(StudentVO std) {
		int result = 0;
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into student values(?,?,?,?,?,?,?)";

		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, std.getStudentID());
			st.setString(2, std.getName());
			st.setInt(3, std.getMajor_id());
			st.setString(4, std.getPhone());
			st.setString(5, std.getAddress());
			st.setString(6, std.getHobby());
			st.setString(7, std.getSkill());
			result = st.executeUpdate(); // DML실행
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result;
	}

	public int deleteMajor(int major_id) {
		int result = 0;
		String sql = "delete from major " + "where major_id=?";

		Connection conn = OracleDBUtil.dbConnect();
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, major_id);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result;
	}

	public MajorVO selectByMajor(int major_id) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select*from major where major_id =" + major_id;
		MajorVO major = null;

		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				int gmajor_id = rs.getInt("major_id");
				String gmajor_title = rs.getString("major_title");

				major = new MajorVO(gmajor_id, gmajor_title);
				System.out.println(major);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return major;
	}

	public int majorUpdate(MajorVO major) {
		int result = 0;
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update major" + " set major_title=?" + " where major_id=?";

		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);

			st.setString(1, major.getMajor_title());
			st.setInt(2, major.getMajor_id());

			result = st.executeUpdate(); // DML실행
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result;
	}

	public int deleteStudent(int studentID) {
		int result = 0;
		String sql = "delete from student " + "where student_id =?";

		Connection conn = OracleDBUtil.dbConnect();
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, studentID);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		System.out.println(result + "학생삭제");
		return result;
	}

	public StudentVO selectByStudent(int studentID) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select*from student where student_id =" + studentID;
		StudentVO student = null;

		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {

				int student_id = rs.getInt("student_id");
				String name = rs.getString("name");
				int major_id = rs.getInt("major_id");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String hobby = rs.getString("hobby");
				String skill = rs.getString("skill");

				student = new StudentVO(student_id, name, major_id, phone, address, hobby, skill);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return student;
	}

	public int studentUpdate(StudentVO student) {
		int result = 0;
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update student" + " set name=?, major_id=?, phone=?, address=?, hobby=?, skill=?"
				+ " where student_id=?";

		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);

			st.setString(1, student.getName());
			st.setInt(2, student.getMajor_id());
			st.setString(3, student.getPhone());
			st.setString(4, student.getAddress());
			st.setString(5, student.getHobby());
			st.setString(6, student.getSkill());
			st.setInt(7, student.getStudentID());

			result = st.executeUpdate(); // DML실행
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result;
	}

	public List<StudentVO> selectByIDs(int studentID, int majorid) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select* from student where 1=1 ";
		if (studentID != 0)
			sql += " and student_id=" + studentID;
		if (majorid != 0)
			sql += " and major_id=" + majorid;

		StudentVO student = null;
		List<StudentVO> studentlist = new ArrayList<>();

		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				student = makeStudent(rs);
				studentlist.add(student);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return studentlist;
	}
}
