package chapter_07_exam;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ExamMain {

	public static void main(String[] args) {
		/*
		 * 1.학생정보를 관리하는 프로그램을 작성하세요.
		 * 2. 학생 클래스를 정의(번호, 성명, 국어, 영어, 수학)
		 * 3. 10개의 학생정보를 담을 수 있는 배열
		 * 4. 메뉴작성(1. 학생목록(배열), 2. 학생추가, 3.학생수정 4.학생삭제 5.학생검색 5.종료)
		 */

		//test();

		Student[] stdArr= new Student[15];
		initArr(stdArr);
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("===============aaaaa   학생 정보 관리 프로그램     aaaaa================");
		System.out.println();
		int res;
		do {
			System.out.print("1.학생목록  2.학생추가  3.학생 수정  4.학생 삭제  5.학생검색  6.종료    (번호를 입력하세요) >>> ");
			res = sc.nextInt();
			System.out.print("");
			switch(res) {
			case 1:
				prnStudentInfo(stdArr);
				break;
			case 2:
				addStudent(stdArr, sc);	

				break;
			case 3:
				updateStudent(stdArr, sc);
				break;
			case 4:
				delStudent(stdArr, sc);
				break;
			case 5:
				searchStudent(stdArr, sc);
				break;
			}
		}while(res<6);
		System.out.println("=============aaaaa   학생관리 프로그램을 종료합니다     aaaaa==============");
		sc.close();
	}

	private static void initArr(Student[] arr) {
		Random rnd = new Random();
		String[] names = {"권수진","정아름","장현서","황태원","배진우","현재승","이동주","황하나","유경진","이상원","박인선",null,null,null,null};
		for(int i=0;i<arr.length;i++) {
			if(names[i]==null) {
				continue;
			}
			arr[i] = new Student(i+1, names[i], rnd.nextInt(60)+41, rnd.nextInt(60)+41, rnd.nextInt(60)+41);
		}

	}
	
	public static int 함수(Student[] stdArr, Scanner sc) {
		while(true) {
			try {
				System.out.print("학생의 번호를 입력하세요 >>> ");
				int searchNum = sc.nextInt();

				Student findStd = new Student();

				findStd.setStdNo(searchNum);
				int idx = indexOf(stdArr,findStd);
				//System.out.println(indexOf(stdArr,findStd)); -- 반환값 찍어보기
				//System.out.println(stdArr[idx]); // 

				if(idx == -1) {
					System.out.println("※ <확>  해당학생이 존재하지 않습니다.  <인> ※");
				}else if(idx != -1) {
					System.out.println(stdArr[idx]); //stdArr[i] 학생 정보 찍어주기
					return searchNum;
				}	
			}catch(InputMismatchException e) {
				System.out.println("※ <경>  정확히 학생의 번호를 입력하세요!  <고> ※");
				sc.nextLine();
			}
		}
	}
	
	private static int indexOf(Student[] stdArr, Student findStd) { // 인덱스
		for(int i=0;i<stdArr.length && stdArr[i]!=null ;i++) {
			if(stdArr[i].getStdNo() == findStd.getStdNo()) { //stdArr[1].stdNo : 2번 == 찾는 번호:2
				return i;
			}
		}
		return -1;
	}

	private static void searchStudent(Student[] stdArr, Scanner sc) {
		System.out.println("==================55555  학생 정보 검색  55555===================");
		함수(stdArr, sc);

		//		try {
		//			for(int i=0;i<stdArr.length;i++) {
		//				if(stdArr[i] == null) {
		//					System.out.println("해당학생이 존재하지 않습니다.");
		//				}
		//				if(stdArr[i].stdNo == searchNum) {
		//					System.out.println(stdArr[i]);
		//				}
		//			}
		//
		//		}catch(NullPointerException e) {
		//
		//		}
	}

	private static void delStudent(Student[] stdArr, Scanner sc) { //삭제
		System.out.println("==================44444  학생 정보 삭제  44444===================");
		//null로 만들지 말고 덮어쓰기
//		System.out.print("삭제할 학생의 번호를 입력하세요 >>> ");
//		int delNum = sc.nextInt(); //1번삭제    int delNum = sc.nextInt()-1;
//
//		Student findStd = new Student();
//
//		findStd.setStdNo(delNum);
//		int idx = indexOf(stdArr,findStd);
//
//		if(idx == -1) {
//			System.out.println("※ <확>  해당학생이 존재하지 않습니다.  <인> ※");
//		}else if(idx != -1) {
//			System.out.println(stdArr[idx]);
//		}
		int delNum = 함수(stdArr, sc);
		System.out.print("정말 삭제하시겠습니까? 1.삭제  2.취소  >>> ");
		int choose = sc.nextInt();
		
		switch(choose) {
		case 1:
			stdArr[delNum-1] = null; //0
			for (int i = delNum-1; i < stdArr.length - 1; i++) { // 0,1<2
				try {
					stdArr[i] = stdArr[i + 1]; // [0]=[1], [1] =[2]
					stdArr[i].setStdNo(i + 1); //[0].(1), [1],(2)
					if(stdArr[i]==stdArr[i+1]) {
						stdArr[i+1] = null;
					}
				} catch (NullPointerException e) {
					//System.out.println("null ");
				}
			}
			prnStudentInfo(stdArr);
			break;
		case 2:
			break;
		}
	}

	//		for(Student std : stdArr) {
	//			try {
	//				if(std.stdNo == delNum) { //1번 =1번
	//					stdArr[delNum-1] = stdArr[delNum]; //[0] = [1]로 덮기
	//					stdArr[delNum] =stdArr[delNum+1]; // [1] = [2]
	//					stdArr[delNum+1] = null;          //[2] = null
	//					System.out.println("▶ "+delNum+"번 학생이 삭제되었습니다");
	//				}
	//			}catch(NullPointerException e) {
	//				//System.out.print("null");
	//			} 
	//		}


	private static void updateStudent(Student[] stdArr, Scanner sc) { //수정
		System.out.println("==================33333  학생 정보 수정  33333===================");

		int searchNum = 함수(stdArr, sc);

		for(Student std : stdArr) {
			try {
				if(std.getStdNo() == searchNum) { 
					System.out.print("[수정항목을 선택하세요] 1.이름   2.국어   3.수학  4.영어  >>> ");

					int num = sc.nextInt();
					switch(num) {
					case 1:
						System.out.print("변경할 이름을 입력하세요  >>> ");
						std.setStdName(sc.next());
						System.out.println("▶ 이름이 "+std.getStdName()+" (으)로 변경되었습니다.");
						break;
					case 2:
						System.out.print("변경할 국어점수를 입력하세요  >>> ");
						std.setKor(sc.nextInt());
						System.out.println("▶ 국어점수가 "+std.getKor()+"점으로 변경되었습니다.");
						break;
					case 3:
						System.out.print("변경할 수학점수를 입력하세요  >>> ");
						std.setMath(sc.nextInt());
						System.out.println("▶ 수학점수가 "+std.getMath()+"점으로 변경되었습니다.");
						break;
					case 4:
						System.out.print("변경할 영어점수를 입력하세요  >>> ");
						std.setEng(sc.nextInt());
						System.out.println("▶ 영어점수가 "+std.getEng()+"점으로 변경되었습니다.");
						break;					
					}
					System.out.println(stdArr[searchNum-1]);//변경된 학생 정보 목록 확인
				}
			}catch(NullPointerException e) {
				//System.out.print("null");
			}
		}//for

	}

	private static void addStudent(Student[] stdArr, Scanner sc) { //추가
		System.out.println("==================22222  학생 정보 추가  22222===================");
		while(true) {//반복
			try {
				System.out.print("추가할 학생의 정보를 입력해 주세요 (이름/국어 점수/수학 점수/영어 점수) >>>");
				String stdName = sc.next();
				int kor = sc.nextInt();
				int math = sc.nextInt();
				int eng = sc.nextInt();

				for(int i=0;i<stdArr.length;i++) {
					if(stdArr[i] == null) {
						int stdNo;//자동번호 부여
						stdArr[i] = new Student(i+1,stdName,kor,math,eng);
						prnStudentInfo(stdArr);
						break;
					}
				}
				break;//브레이크
			}catch (InputMismatchException e) {
				System.out.println("※ <경>  정확히 (이름/국어 점수/수학 점수/영어 점수) 순서대로 입력해 주세요!  <고> ※");
				sc.nextLine();
			}
		}//while

	}

	private static void prnStudentInfo(Student[] stdArr) { //목록구현
		System.out.println("=====================11111  학생 정보 목록  11111======================");
		System.out.println("==================================================================");
		System.out.println("번   호                이  름                국 어                수학                영어                총점              평      균");
		System.out.println("==================================================================");

		for(int i=0;i<stdArr.length;i++) {
			if(stdArr[i]==null) { // null없애기
				continue;
			}
			System.out.println(stdArr[i]);
		}
	}

	//	public static void test() {
	//		Student std01 = new Student(1,"배진우",80,90,80);
	//		System.out.println(std01);
	//
	//		Student std02 = new Student(2,"이동주",60,90,90);
	//		System.out.println(std02);
	//
	//		System.out.println();
	//		Student[] stdArr = {std01,std02};
	//		for(Student std : stdArr) {
	//			System.out.println(std);
	//		}
	//	}

}
