package chapter_07_exam06;

public class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getBan() {
		return ban;
	}



	public void setBan(int ban) {
		this.ban = ban;
	}



	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public int getKor() {
		return kor;
	}



	public void setKor(int kor) {
		this.kor = kor;
	}



	public int getEng() {
		return eng;
	}



	public void setEng(int eng) {
		this.eng = eng;
	}



	public int getMath() {
		return math;
	}



	public void setMath(int math) {
		this.math = math;
	}



	int getTotal() {
		return kor + eng + math;
	}
	
	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, ban=%s, no=%s, kor=%s, eng=%s, math=%s]", name, ban, no, kor, eng,
				math);
	}

//	@Override
//	public int hashCode() { //해쉬코드 - no
//		return no;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		Student other = (Student) obj;
//		return no == other.no;
//	}
//
//	public int compareTo(Student o) {
//		return this.no - o.no;
//	}


	
	
	
	
}
