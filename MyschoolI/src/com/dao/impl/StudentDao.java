package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.IStudentDao;
import com.entity.student;

public class StudentDao extends BaseDao implements IStudentDao {

	@Override
	public List<student> selectpx(int ys) {
		List<student> list = new ArrayList<student>();
		
		try {
			String sql = "select * from city limit ?,5";
			
			getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ys*5);
			 rs = pstmt.executeQuery();
			 while (rs.next()) {
				 int studentno = rs.getInt("id");
				 String studentname = rs.getString("name");
				 student st = new student(studentno, studentname);
				 list.add(st);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}		
		return list;
	}

}
