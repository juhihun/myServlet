package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.mapper.EmpMapper;
import com.yedam.vo.EmployeeVO;

public class AppTest {

	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true);
		
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		EmployeeVO evo = new EmployeeVO();
//		evo.setEmployeeId(999);
//		evo.setFirstName("길동");
//		evo.setLastName("홍");
//		evo.setEmail("sss@aaa.com");
//		evo.setJobId("IT PROG");
//		int r = mapper.insertEmp(evo);
//		System.out.println(r+"건 처리.");
//		session.commit();
//		
//		int d  = mapper.deleteEmp(999);
//		System.out.println(d + "건 삭제");
//		
		
		System.out.println(mapper.getEmployee(100).toString());
		List<EmployeeVO> list = mapper.selectEmp();
				//session.selectList("com.yedam.mapper.EmpMapper.selectEmp");
		
		for(EmployeeVO emp : list) {
			System.out.println(emp.toString());
		}
	}
}
