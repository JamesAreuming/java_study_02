package chapter_07_exam04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import chapter_07_exam04.StdManagerInterface;
import chapter_07_exam04.Student;

public class StdMgnForHashMap implements StdManagerInterface {
	private HashMap<Integer, Student> stdMap;
	
	
	@Override
	public String toString() {
		return String.format("(%s)", stdMap);
	}


	public StdMgnForHashMap() {
		this.stdMap = new HashMap<Integer, Student>();
	}

	
	@Override
	public ArrayList<Student> listStudent() {
		ArrayList<Student> stdlist = new ArrayList<Student>();
		Set<Integer> keys = stdMap.keySet();
		for(Integer stdNo : keys) {
			stdlist.add(stdMap.get(stdNo));
		}
		return stdlist;
	}
	
	
	@Override
	public boolean insertStudent(Student student) {
		if (!stdMap.containsKey(student.getStdNo())) {
			stdMap.put(student.getStdNo(), student);
			return true;
		}
		return false;
	}

	@Override
	public Student searchStudent(Student student) { //stdNo
		if (!stdMap.containsKey(student.getStdNo())) {
			return null;
		}
		return stdMap.put(student.getStdNo(), student);
	}
	
	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean updateStudent(Student student) {
		return false;
	}



}
