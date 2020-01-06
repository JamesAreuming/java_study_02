package chapter_06;

import java.util.Arrays;
import java.util.Comparator;

public class ObjectEqualsMain {
	public static void main(String[] args) {
		//do_equals();

		Student[] stdArr = {
				new Student(5, "장현서",80,80,70),
				new Student(3, "유경진",81,90,70),
				new Student(4, "권수진",82,100,70),
				new Student(1, "정아름",83,89,70),
				new Student(2, "김민수",84,69,70)
		};

		 do_sort(stdArr); // 학번, 국어점수, 영어점수별 정렬

		//do_search(stdArr);
		
		prn_Object(stdArr[0]); // 5, "장현서",80,80,70

	}




	private static void prn_Object(Object obj) {
		System.out.println(obj.getClass().getName());
		System.out.println(obj.getClass().getSimpleName());
		System.out.println(obj.hashCode()); // 우리가 학번으로 정의해놔서 5로 나옴
	}




	public static void do_search(Student[] stdArr) {
		// 검색
		Arrays.sort(stdArr); // comparable compareto()에 의해 정렬 // 1,2,3,4,5
		prnStds(stdArr);

		System.out.println("===================================");

		Student findStd = new Student(6); // 3번 학생을 찾고자 한다 // 6번의 경우 -값이 나옴
		int findIndex = Arrays.binarySearch(stdArr, findStd); // binarySearch:이분검색
		System.out.println("찾는학생 : " + findStd + "의 위치는" + findIndex);
	}

	
	
	
	public static void do_sort(Student[] stdArr) {
		//학번순으로 정렬(기본정렬)
		prnStds(stdArr);
		System.out.println("=====================================================");
		Arrays.sort(stdArr);
		prnStds(stdArr);
		
		
		
		
		//기본정렬외 국어점수로 정렬
		Comparator<Student> korOrder = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				return o2.getKor()-o1.getKor(); //국어점수끼리 비교하겠다
			}
		};
		
		Arrays.sort(stdArr,korOrder);
		System.out.println("국어 점수별 정렬");
		prnStds(stdArr);
		
//		Comparable<Student> engOrder = new Comparable<Student>() {
//			
//			public int compareTo(Student o1, Student o2) {
//				return o2.getEng()-o1.getEng(); //국어점수끼리 비교하겠다
//
//			}
//
//			@Override
//			public int compareTo(Student o) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		};
//		
//		Arrays.sort(stdArr,korOrder);
//		System.out.println("영어 점수별 정렬");
//		prnStds(stdArr);
	}

	private static void prnStds(Student[] stdArr) {
		for(Student s : stdArr) {
			System.out.println(s);
		}
	}

	public static void do_equals() {
		Student std01 = new Student(1, "이상원", 90, 90, 90);
		Student std02 = new Student(1, "이상원", 90, 90, 90);
		Student findStd = new Student(1); // 학번으로 검색

		/*		if (std01.equals(std02)) {
			System.out.println("같은학생");
		} else {
			System.out.println("다른학생");
		}*/

		if (std01.equals(findStd)) {
			System.out.println("같은학생");
		} else {
			System.out.println("다른학생");
		}

		//		System.out.println("std01 : "+std01.hashCode()); // 주소값 : 366712642   // 해쉬코드: 1684640503
		//		System.out.println("std02 : "+std02.hashCode()); // 주소값 : 1829164700  // 해쉬코드 : 1684640503

		// 해쉬코드 : JVM의 heap 영역의 인스턴스에 대한 참조값을 주는 방식이 hash 방식이다.
		// 책의 index가 바로 hash 방식


		System.out.println("std01 : "+std01.hashCode());     // std01 : 1
		System.out.println("findStd : "+findStd.hashCode()); // findStd : 1
	}
}
