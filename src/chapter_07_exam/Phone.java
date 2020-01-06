package chapter_07_exam;

public class Phone {
	private String name;
	private String tel;

	public Phone() {
		// TODO Auto-generated constructor stub
	}

	public Phone(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return String.format("Phone [name=%s, tel=%s]", name, tel);
	}
}
