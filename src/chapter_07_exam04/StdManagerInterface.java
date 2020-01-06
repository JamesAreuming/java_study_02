package chapter_07_exam04;

import java.util.ArrayList;

public interface StdManagerInterface {
	
	public boolean insertStudent(Student student);
	
	public boolean deleteStudent(Student student);
	
	public ArrayList<Student> listStudent();
	
	public boolean updateStudent(Student student);
	
	public Student searchStudent(Student student);
	
}
