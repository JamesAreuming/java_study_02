package chapter_08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStreamEx {

	public static void main(String[] args) {
//		exam01();
		
		img_copy("grampa06.jpg","grampa06_copy.jpg");
		
		img_copy2("민수옹.jpg","민수옹_copy.jpg");
	}

	private static void img_copy2(String src, String desc) {
		String filePath = System.getProperty("user.dir") + "\\textfile\\";
		
		try(FileInputStream fi = new FileInputStream(filePath+src);
				FileOutputStream fo = new FileOutputStream(filePath+desc)){
			byte [] buf = new byte[2048];
			while((fi.read(buf))!=-1) {
				fo.write(buf);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void img_copy(String src, String desc) {
		String filePath = System.getProperty("user.dir")+"\\textfile\\";
		
		try(FileInputStream fi = new FileInputStream(filePath+src);
				FileOutputStream fo = new FileOutputStream(filePath+desc)){
			int c;
			while((c=fi.read())!=-1) {
				fo.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void exam01() {
		String filePath = System.getProperty("user.dir")+ "\\textfile\\";
		
		try(FileOutputStream fout = new FileOutputStream(filePath + "test.out");){ //out : 바이너리 데이터
			byte [] b = {7,51,3,4,-1,24};
				for(int i=0;i<b.length;i++) {
					fout.write(b[i]);
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(FileInputStream fis = new FileInputStream(filePath + "test.out")){
			int c;
			while((c=fis.read())!=-1) {
				System.out.print((byte)c+" ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
