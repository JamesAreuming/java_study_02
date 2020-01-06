package chapter_07_exam;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
	private int size;
//	private Phone[] phones;
	private ArrayList<Phone> phones; // arrayList
	private Scanner sc;

	public PhoneBook() {
		this.sc = new Scanner(System.in);
		phones = new ArrayList<Phone>();
	}
	
	private void init() {
		System.out.print("인원수>>");
		this.size = sc.nextInt();
		//this.phones = new Phone[size];		
	}
	
	private void input() {
		String name;
		String tel;
		for (int i=0; i<size; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈칸없이 입력)>>");
			name = sc.next();
			tel = sc.next();
			//phones[i] = new Phone(name, tel);
			phones.add(new Phone(name, tel));
		}
		System.out.println("저장 되었습니다.");
	}

	public void run() {
		init();
		input();
		String findName;
		String findTel;
		do {
			System.out.print("검색할 이름>>");
			findName = sc.next();
			findTel = searchPhone(findName);
			if (findTel == null) {
				System.out.println(findName + "이 없습니다.");
			}else {
				System.out.printf("%s 의 번호는 %s입니다.%n", findName, findTel);
			}
		}while(!findName.equals("그만"));
		sc.close();
	}

	private String searchPhone(String findName) {
		for(Phone p : phones) {
			if (p.getName().equals(findName)) {
				return p.getTel();
			}
		}
		return null;
	}
}
