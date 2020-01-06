package chapter_07_exam03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;



public class StdMgnForHashMap implements StdManagerInterface {
	private HashMap<Integer, Student> stdMap;
	
	
	public StdMgnForHashMap() {
		this.stdMap = new HashMap<Integer, Student>();
	}

	
	public StdMgnForHashMap(HashMap<Integer, Student> stdMap) {
		this.stdMap = stdMap;
	}


	public void setStdMap(HashMap<Integer, Student> stdMap) {
		this.stdMap = stdMap;
	}


	/**
	 *  put 중복일 경우 value값 리턴 추가된경우 null리턴
	 */
	@Override
	public boolean insertStudent(Student student) {
		Student res = stdMap.put(student.getStdNo(), student);
		return res==null;
	}

	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student searchStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

}
