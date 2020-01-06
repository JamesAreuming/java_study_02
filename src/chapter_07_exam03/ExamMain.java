package chapter_07_exam03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;



public class ExamMain {
 
	public static void main(String[] args) {
		StdMgnForHashMap sm = new StdMgnForHashMap(initMapStd());
		
//		sm.setStdMap(initMapStd());
		
//		for(Student std : initStdList()) {
//			sm.insertStudent(std);
//		}
		
		Scanner sc = new Scanner(System.in);
		int res;
		do {
			System.out.println("1. 학생목록, 2. 학생추가, 3. 학생 수정, 4. 학생 삭제, 5. 학생검색, 6. 종료");
			res = sc.nextInt();
			System.out.println(res);
			switch(res) {
			case 1:
				prnStudents(sm.listStudent());
				break;
			case 2:
				System.out.printf("%s%n", "학생 추가");
				break;
			case 3:
				System.out.printf("%s%n", "학생 수정");
				break;
			case 4:
				System.out.printf("%s%n", "학생 삭제");
				break;
			case 5:
				System.out.printf("%s%n", "학생 검색");
				break;
			
			}
		}while(res < 6);
		System.out.println("학생관리 프로그램을 종료합니다.");
		sc.close();
	}

	private static void prnStudents(ArrayList<Student> listStudent) {
		for(Student std : listStudent) {
			System.out.println(std);
		}
	}
	
	private static HashMap<Integer, Student> initMapStd(){
		HashMap<Integer, Student> temp = new HashMap<Integer, Student>();
		Random rnd = new Random();
		String[] names = {"권수진", "정아름", "장현서", "황태원", 
				"배진우", "현재승", "이동주", "황하나", "유경진", "이상원", "박인선"};
		for(int i=0; i<names.length; i++) {
			Student std = new Student(
					i+1, 
					names[i], 
					rnd.nextInt(60)+41, 
					rnd.nextInt(60)+41, 
					rnd.nextInt(60)+41);
			
			temp.put(std.getStdNo(), std);
		}
		return temp;
	}
	
	private static ArrayList<Student> initStdList() {
		ArrayList<Student> arList = new ArrayList<>();
		Random rnd = new Random();
		String[] names = {"권수진", "정아름", "장현서", "황태원", 
				"배진우", "현재승", "이동주", "황하나", "유경진", "이상원", "박인선"};
		for(int i=0; i<names.length; i++) {
			arList.add(new Student(i+1, names[i], 
					rnd.nextInt(60)+41, 
					rnd.nextInt(60)+41, 
					rnd.nextInt(60)+41));
		}
		
		return arList;
	}

}
