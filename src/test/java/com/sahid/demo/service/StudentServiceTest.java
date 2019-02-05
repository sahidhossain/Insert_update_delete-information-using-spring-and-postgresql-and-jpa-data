package com.sahid.demo.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sahid.demo.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages= {"com.sahid.demo.*"})
@Rollback(false)
@SpringBootTest
public class StudentServiceTest {
	
@Autowired
StudentService service;

@Test
public void testSave()
{
	int year=1994;
	int month=3;
	int day=01;
	Date firstDate1 = new Date( day,  month,  year);
	Student st=new Student();
	st.setId(89);
	st.setEmail("A@gmail.com");
	st.setPassword("222");
	st.setGender("male");
	st.setHobby("cricket");;
	st.setCountry("Bangladesh");
	st.setRoll(111111);
	st.setDate(firstDate1);
	service.saveStudentData(st);
}

@Test
public void testGetAll()
{
	List<Student> st=service.getAllStudentData();
	st.stream().forEach(s->
	{System.out.println(st.toString());});
		
}

@Test
public void testFindOne()
{
	@SuppressWarnings("deprecation")
	Student st=service.findOne(new Long(89));
	System.out.println(st.toString());
}

@Test
public void testUpdate()
{
	int year=1994;
	int month=3;
	int day=01;
	Date firstDate1 = new Date( day,  month,  year);
	Student st=new Student();
	st.setId(89);
	st.setEmail("A@gmail.com");
	st.setPassword("111");
	st.setGender("male");
	st.setHobby("cricket");;
	st.setCountry("Bangladesh");
	st.setRoll(111111);
	st.setDate(firstDate1);
	service.update(st);
}

@Test
public void testDelete()
{
	long id=89;
	service.deleteOne(id);
}
}
