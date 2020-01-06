package chapter_07_exam05;

public class MyClass<T> {
	private T val;
	
	
	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}



	public static void main(String[] args) {
		MyClass<String> strClass = new MyClass<String>();
		
		MyClass<String> intClass = new MyClass<String>();
		
		strClass.setVal("test");
		intClass.setVal(5);
		
	}
}
