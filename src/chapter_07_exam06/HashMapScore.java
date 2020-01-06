package chapter_07_exam06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashMapScore {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("미래장학금관리시스템입니다.");
		
		HashMap<String, Double> student = new HashMap<String, Double>();
		
		for(int i=0;i<5;i++) {
			System.out.print("이름과 학점 >> ");
			
			String name = sc.next();
			Double score = sc.nextDouble();
			
			student.put(name,score);
		}
		
		//System.out.println(student.toString()); //해쉬맵에 저장된 정보 확인
		
		System.out.print("장학생 선발 학점 기준 >> ");
		Double mainScore = sc.nextDouble();
		
		//전체검색, 키값으로 값을 알아내자
		Set<String> keys = student.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) { // 모든점수 출력
			String stdName = it.next(); // 키 : 이름
			double stdScore = student.get(stdName); //값 :점수
				if(stdScore>mainScore) {
				System.out.println("장학생 명단 : " + stdName);
				}		
			//System.out.println(key+value);
		}
		
		sc.close();

		
		//A : 4.5~4.0 B:3.9~3.0 C:2.9~2.0 D:1.9~1.0 F:0.9~
		
//		if(mainScore<4.5 && mainScore>3.9) { // 4.5 ~ 4.0 => 장학생
//			
//			if(containValue(score) == mainScore)
//			System.out.println("장학생 명단 : A");
//		}
		
		
		

		
	}
}
