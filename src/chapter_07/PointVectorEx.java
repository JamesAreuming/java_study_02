package chapter_07;

import java.util.Arrays;
import java.util.Vector;

public class PointVectorEx {

	public static void main(String[] args) {
		Vector<Point> v = new Vector<Point>();
		
		v.add(new Point(2, 3));
		v.add(new Point(-5, 20));
		v.add(new Point(30, -8));
		
		v.remove(1); // -5, 20 삭제
		
		for(int i=0;i<v.size();i++) {
			Point p = v.get(i);
			System.out.println(p);
		}
		
		//해결하시오
		//alt + shift +s : hashCode, equals
		System.out.println(v.contains(new Point(30, -8))); // false --> true
		System.out.println(v.indexOf(new Point(30, -8))); // -1  --> 1
		
//		v.clear();
//		System.out.println(v.isEmpty());
		

		
		v.remove(new Point(30, -8));
		System.out.println(v);
	}

}
