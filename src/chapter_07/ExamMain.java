package chapter_07;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import chapter_07_exam04.Student;

public class ExamMain {
 
	public static void main(String[] args) {
		StdMgnForHashMap sm = new StdMgnForHashMap();
		
		for(Student std : initStdList()) {
			sm.insertStudent(std);
		}
		
		String[] select = {"학생 목록","학생 추가","학생 수정","학생 삭제","학생검색","종료"};
		//System.out.println(sm.toString()); // Key값 : 1~ / Value값 : 1 권수진         76  80  51 207 69.00
		while (true) {
			String option = (String) JOptionPane.showInputDialog(null, "관리할 항목을 선택하세요", "학생관리프로그램",
					JOptionPane.QUESTION_MESSAGE, null, select, select[0]);
			try {
				switch (option) {
				case "학생 목록":
					prnStudents(sm.listStudent());
					break;
				case "학생 추가":
					Student insertStd = getStudent();
					sm.insertStudent(insertStd);
					break;
				case "학생 수정":
					Student updateStd = updateStudent();
					sm.updateStudent(updateStd);
					
					prnStudents(sm.listStudent());
					break;
				case "학생 삭제":
					Student deleteStd = sm.searchStudent(findStudent());
					prnStudents(sm.listStudent());
					break;
				case "학생검색":
					// System.out.printf("%s%n", "학생 검색");
					Student searchStd = sm.searchStudent(findStudent());
					찾기(searchStd);
					break;
				}
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "프로그램이 종료 되었습니다.", "종료 메세지", JOptionPane.INFORMATION_MESSAGE);
				break;
			}

			if (option == "종료") {
				int goodBye = JOptionPane.showConfirmDialog(null, "정말 종료 하시겠습니까?", "YES & NO",
						JOptionPane.YES_NO_OPTION);
				if (goodBye == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "프로그램이 종료 되었습니다.", "종료 메세지", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				if (goodBye == JOptionPane.CLOSED_OPTION || goodBye == JOptionPane.NO_OPTION) {
					continue;
				}
			}
		}
	}


	public static void 찾기(Student searchStd) {
		if (searchStd != null) {
			JOptionPane.showMessageDialog(null, searchStd, "학생 검색", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "해당 학생이 존재하지 않음", "학생 검색", JOptionPane.WARNING_MESSAGE);
		}
	}

	
	private static Student updateStudent() {
		Student searchStd;
		return null;
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
	
	private static void prnStudents(ArrayList<Student> listStudent) {
		JOptionPane.showMessageDialog(null, listStudent.toArray());
	}
	
	
	private static Student getStudent() {
		String res = JOptionPane.showInputDialog("학생정보 입력 : 번호,성명,국어,영어,수학");
		System.out.println(res);
		String[]resArr = res.split(",");
		
		int stdNo = Integer.parseInt(resArr[0].trim());
		String stdName = resArr[1].trim();
		int kor = Integer.parseInt(resArr[2].trim());
		int math = Integer.parseInt(resArr[3].trim());
		int eng = Integer.parseInt(resArr[4].trim());
		return new Student(stdNo, stdName, kor, math, eng);
	}

	private static Student findStudent() {
		String num = JOptionPane.showInputDialog("학생 번호를 입력하세요");
		int stdNo = Integer.parseInt(num.trim());
		return new Student(stdNo);
	}


	


}
