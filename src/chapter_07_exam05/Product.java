package chapter_07_exam05;

public class Product {
	private String code;
	private String name;
	
	public Product() {
		
	}
	
	public Product(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return String.format("Product [code=%s, name=%s]", code, name);
	}
	
}
