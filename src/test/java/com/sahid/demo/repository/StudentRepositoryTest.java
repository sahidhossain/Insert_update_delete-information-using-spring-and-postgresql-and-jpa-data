//package com.sahid.demo.repository;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.sahid.demo.model.Student;
//import com.sahid.demo.repo.StudentRepository;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ComponentScan(basePackages= {"com.sahid.demo.*"})
//@Rollback
//@SpringBootTest
//public class StudentRepositoryTest {
//
//	@Autowired
//	StudentRepository sr;
//	
//	@Test
//	public void testSave()
//	{
//		int year=1994;
//		int month=3;
//		int day=01;
//		Date firstDate1 = new Date( day,  month,  year);
//		Student st=new Student();
//		st.setId(89);
//		st.setEmail("A@gmail.com");
//		st.setPassword("222");
//		st.setGender("male");
//		st.setHobby("cricket");;
//		st.setCountry("Bangladesh");
//		st.setRoll(111111);
//		st.setDate(firstDate1);
//		sr.save(st);
//	}
//	
//	public void testGetAll() {
//		List<Student> students = (List<Student>) sr.findAll();
//		students.stream().forEach(s -> {
//			System.out.println(s.toString());
//		});
//	}
//	
//	@Test
//	public void testFindOne() {
//		Student student = sr.findById(new Long(89)).orElse(null);
//		System.out.println(student.toString());
//	}
//}
