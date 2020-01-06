package chapter_06;

import java.util.Arrays;

class Product {
	private String code;
	private String name;

	protected Product(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("(%s, %s)", code, name);
	}
	
	

}

class Sale {
	private int no;
	private String code;
	private int price;
	private int saleCnt;
	private int marginRate;

	protected Sale(int no, String code, int price, int saleCnt, int marginRate) {
		this.no = no;
		this.code = code;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}

	public Sale() {
		// TODO Auto-generated constructor stub
	}

	public Sale(String string, String code2, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleCnt() {
		return saleCnt;
	}

	public void setSaleCnt(int saleCnt) {
		this.saleCnt = saleCnt;
	}

	public int getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}

	@Override
	public String toString() {
		return String.format("(%s, %s, %s, %s, %s)", no, code, price, saleCnt,
				marginRate);
	}
	
	

}

public class Exam {


	public static void main(String[] args) {
/*		String std01 = "1,이상원,90,90,90";
		String[] std01Arr = std01.split(",");
		
		Student std = new Student(
				Integer.parseInt(std01Arr[0]), 
				std01Arr[1], 
				Integer.parseInt(std01Arr[2]), 
				Integer.parseInt(std01Arr[3]), 
				Integer.parseInt(std01Arr[4]));
		
		System.out.println(std);		
//		StringTokenizer st = new StringTokenizer(std01, ",");*/
		
	
//		exam01();
		String[] productArr = {
				"A001,아메리카노", //code, name Product p = new Product(code, name)
				"A002,카푸치노", 
				"A003,헤이즐넛",
				"A004,에스프레소",
				"B001,딸기쉐이크",
				"B002,후르츠와인",
				"B003,팥빙수", 
				"B004,아이스초코"};
		
		Product p = new Product();		
		
		String[] saleArr = {
				"1,A001,4500,150,10", //no, code, price, saleCnt, marginRate
				"2,A002,3800,140,15", 
				"3,B001,5200,250,12", 
				"4,B001,4300,110,11",
				};
		
		Sale s = new Sale();	
		
		//위의 문장을 이용하여 Product클래스와 Sale클래스를 정의하고 
		//Product[] pdtArrs 와  Sale[] saleArrs로 변경하시오.
		Product[] pdtArrs = convert_to_Product(productArr);
		
//		System.out.println(Arrays.toString(pdtArrs));
		
		Sale[] saleArrs = convert_to_Sale(saleArr);
		
//		System.out.println(Arrays.toString(saleArrs));


		
	}

	private static Sale[] convert_to_Sale(String[] saleArr) {
		Sale[] pdt = new Sale[saleArr.length];
		for(int i=0;i<saleArr.length;i++) {
			pdt[i] = getSale(saleArr[i]);
			
			System.out.println(pdt[i]);
		}
		return pdt;
	}

	private static Sale getSale(String str_sal) {
		//
		String[] strArr = str_sal.split(",");
		return new Sale(Integer.parseInt(strArr[0].trim()),
				         strArr[1].trim(),
				         Integer.parseInt(strArr[2].trim()),
				         Integer.parseInt(strArr[3].trim()),
				         Integer.parseInt(strArr[4].trim()));
	}

	private static Product[] convert_to_Product(String[] productArr) {
		Product[] sal = new Product[productArr.length];
		for(int i=0; i<productArr.length; i++) {
			sal[i] = getProduct(productArr[i]); // 함수로 쪼개주는게 좋다
			
			System.out.println(sal[i]);
		}
		return sal;
	}

	private static Product getProduct(String str_pro) {
		// str "A001,아메리카노"
		String[] strArr = str_pro.split(",");
		return new Product(strArr[0].trim(), strArr[1].trim());
	}

/*	private static void exam01() {
		String[] productArr = {
				"A001,아메리카노", //code, name Product p = new Product(code, name)
				"A002,카푸치노", 
				
				"A003,헤이즐넛",
				"A004,에스프레소",
				"B001,딸기쉐이크",
				"B002,후르츠와인",
				"B003,팥빙수", 
				"B004,아이스초코"};
		
		
		
		String[] saleArr = {
				"1,A001,4500,150,10", //no, code, price, saleCnt, marginRate
				"2,A002,3800,140,15", 
				"3,B001,5200,250,12", 
				"4,B001,4300,110,11",
				};
		
		
		
		//위의 문장을 이용하여 Product클래스와 Sale클래스를 정의하고 
		//Product[] pdtArrs 와  Sale[] saleArrs로 변경하시오.
		Product[] pdtArrs = convert_to_Product(productArr);
		
		System.out.println(Arrays.toString(pdtArrs));
		
		Sale[] saleArrs = convert_to_Sale(saleArr);
		
		System.out.println(Arrays.toString(saleArrs));
	}

	private static Sale[] convert_to_Sale(String[] saleArr) {
		Sale[] sal = new Sale[saleArr.length];

		return sal;
	}

	private static Product[] convert_to_Product(String[] productArr) {
		Product[] pdt = new Product[productArr.length];

		return pdt;
	}*/

}
