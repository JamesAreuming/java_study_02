package chapter_06;

public class Student implements Comparable<Student>{
	private int stdNo;
	private String name;
	private int kor;
	private int eng;
	private int math;

	protected Student() {
	}

	protected Student(int stdNo) {
		this.stdNo = stdNo;
	}

	protected Student(int stdNo, String name, int kor, int eng, int math) {
		this.stdNo = stdNo;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return String.format("[%s, %s, %s, %s, %s]", stdNo, name, kor, eng, math);
	}

/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eng;
		result = prime * result + kor;
		result = prime * result + math;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + stdNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // Student std03 = std01
			return true;
		if (obj == null) // std01.equals(null)
			return false;
		if (getClass() != obj.getClass()) // 서로 다른 클래스라면
			return false;
		Student other = (Student) obj; // obj를 Studeunt로 형변환
		if (eng != other.eng)
			return false;
		if (kor != other.kor)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stdNo != other.stdNo)
			return false;
		return true;
	} */
	
	@Override
	public int hashCode() { // 해쉬코드를 우리가 학번으로 변경
		return stdNo;
	}
	
	@Override
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		return stdNo == other.stdNo;
	}

	@Override
	public int compareTo(Student o) {
		return this.stdNo - o.stdNo; // 학번정렬
	}

}
