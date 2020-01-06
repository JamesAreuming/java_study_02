package chapter_07_exam06;

public class Phone {
	private String name;
	private String add;
	private String phoneNum;
	
	public Phone() {
		
	}

	public Phone(String name, String add, String phoneNum) {
		this.name = name;
		this.add = add;
		this.phoneNum = phoneNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s]", name, add, phoneNum);
	}
	
	
	
}
