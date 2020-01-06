package chapter_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList arr = new ArrayList(); // ArrayList<Objext> = new ArrayList(); // 이렇게 쓰면 않좋다.
		
		
		
		List<Integer> arList = new ArrayList<>(); // java.util.List (Ctrl + shift + O)
		// ArrayList<Integer> arList = new ArrayList<>();
		//addList(arList);
		
		//arList.add("a");//숫자만 넣어
		
		arList.add(5);
		arList.add(3);
		arList.add(4);
		arList.add(1);
		
		for(int i=0;i<arList.size();i++) {
		 //int a = arList.get(i);
		System.out.print(arList.get(i)+" ");

		}
		System.out.println();
//		for(int i=0;i<arList.size();i++) {
//			int a = arList.get(i);
//			System.out.print(a+" ");
//		}
		
		
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("이상원");
		strList.add("황태원");
		strList.add("권수진");
		
		String[] a = new String[strList.size()];
		System.out.println(Arrays.toString(a));
		strList.toArray(a);
		System.out.println(Arrays.toString(a));
		
		
		
		
		System.out.println("==============================================");
		
		
		for(String name : strList) {
			System.out.print(name);
		}
		
		if(strList.contains("황태원")){
			System.out.println("포함");
		}else {
			System.out.println("아늬");
		}
		
		int findIdx = strList.indexOf("권수진");
		System.out.println("권수진 인덱스 : "+findIdx);
		
		int findIdx1 = strList.indexOf("장현서");
		System.out.println("장현서 인덱스 : "+findIdx1);
		
		int findIdx3 = strList.lastIndexOf("이상원");
		System.out.println("이상원 인덱스 : "+findIdx3);
		
		
		System.out.println(strList.isEmpty()); //false
		
		strList.remove(0); // 이상원 삭제
		System.out.println(strList);
		
		strList.remove("권수진"); // 권수진 삭제
		System.out.println(strList);
		
		strList.clear(); // 총삭제
		
		System.out.println(strList.isEmpty()); // clear해서 -> true
		System.out.println(strList); //[] : 비워있는게 보임 
	}

	public static void addList(List<Integer> arList) {
		System.out.println(arList); // []
		System.out.println("arList.size() : "+arList.size()); // 0개
		
		//추가
		arList.add(5); // 5추가
		System.out.println("arList.size() : "+arList.size()); // 1개
		
		for(int i=0;i<10;i++) {
			arList.add(i); // 0,1,2,3,4,5,6,7,8,9
		}
		
		System.out.println("arList.size() : "+arList.size()); // 11개 (5,0,1,2,3,4,5,6,7,8,9)
		System.out.println(arList); // [5, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		
		arList.add(1,10); // 인덱스 1번에 , 10을 삽입
		System.out.println(arList); // [5, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		
		ArrayList<Integer> sublist = new ArrayList<Integer>();
		sublist.add(20); // 20추가
		sublist.add(21);
		sublist.add(22);
		
		arList.addAll(sublist);
		System.out.println(arList); //[5, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 21, 22]
	}

}
