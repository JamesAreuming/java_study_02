package chapter_07_exam03;

import java.util.ArrayList;

public class StudentManagement implements StdManagerInterface {
	private ArrayList<Student> stdList;
	
	
	
	public StudentManagement() {
		this.stdList = new ArrayList<Student>();
	}

	@Override
	public boolean insertStudent(Student student) {
		return stdList.add(student);
	}

	@Override
	public boolean deleteStudent(Student student) {
		if (stdList.contains(student)) {
			return stdList.remove(student);
		}
		return false;
	}

	@Override
	public ArrayList<Student> listStudent() {
		return this.stdList ;
	}

	@Override
	public boolean updateStudent(Student student) {
		Student std = stdList.set(stdList.indexOf(student), student);
		return std!=null;
	}

	@Override
	public Student searchStudent(Student student) {
		if (!stdList.contains(student)) {
			return null;
		}
		return stdList.get(stdList.indexOf(student));
	}

	public void setStudentList(ArrayList<Student> initStdList) {
		this.stdList = initStdList;
	}

}
