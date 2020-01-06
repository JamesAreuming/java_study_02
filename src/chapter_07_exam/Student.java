package chapter_07_exam;

public class Student {
	 private int stdNo; // 필드는  무조건 private 접근지정만 할 수 있다// 참조할때는 getter 메소드 / 넣을때는 setter 메소드 이용
	 private String stdName;
	 private int kor;
	 private int math;
	 private int eng;
	//public String setStdName;
	
	public Student() {
		
	}
	public Student(int stdNo, String stdName, int kor, int math, int eng) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getStdNo() {
		return stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public int getKor() {
		return kor;
	}
	public int getMath() {
		return math;
	}
	public int getEng() {
		return eng;
	}
	public int total() {
		return kor+math+eng;
	}
	
	public double avg() {
		return total()/3.0;
	}
	@Override
	public String toString() {
		return String.format(" %d         %s               %d       %d       %d       %d     %.2f",
				stdNo, stdName, kor, math, eng, total(), avg());
	}
	
	
}
