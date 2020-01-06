package chapter_06;

public class WrapperEx {

	public static void main(String[] args) {
		Integer i = 31; // autoboxing
		Integer i2 = Integer.valueOf(31);
		Integer i3 = new Integer(31);
		Integer i4 = Integer.valueOf("31");
		
		System.out.printf("%d %d %d %d %n",i,i2,i3,i4);
		
		System.out.println(Integer.bitCount(31)); // 31을 이진수로 변환후 1의 개수 : 11111
		System.out.println(Integer.bitCount(32));
		System.out.println(Integer.bitCount(10));
		
		System.out.println(Integer.toHexString(31)); //1f (1/1111)
		System.out.println(Integer.toBinaryString(31)); // 11111
		System.out.println(Integer.toOctalString(31)); //37
		
		System.out.println("============================");
		System.out.println(i2.floatValue()); //실수형으로 돌려준다
		System.out.println(i2.doubleValue());
		
		String str = i2.toString();
		System.out.println(str); // 문자열화된 31
		
	}

}
