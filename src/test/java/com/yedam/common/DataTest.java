package com.yedam.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.mapper.EmpMapper;


public class DataTest {

	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true);
		
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		
		int d  = mapper.deleteEmp(999);
		System.out.println(d + "건 삭제");
	}

}
