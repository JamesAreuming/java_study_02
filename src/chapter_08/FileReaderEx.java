package chapter_08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderEx {

	public static void main(String[] args) throws FileNotFoundException, IOException /* throws IOException */ { //JVM에게 처리해달라고 전달(throw) // 예외에서도 계층구조(상속)가 있다. (Exception(이걸로 다 퉁칠수 있으나, 그러면어디에서 오류가 발생한지 모른다.) <- IOException <- FileNotFoundException)
//		readex01();		
//      readex02();
		
		System.out.println(System.getProperty("user.dir")); // 현재 작성한 경로가 나타남
		
		String filePath = System.getProperty("user.dir")  + "\\textfile\\department.txt";
		System.out.println(filePath);
		
		readFile("department.txt");
		readFile("employee.txt");
		
		readFileInputStream("department.txt");
		
		
	}

	private static void readFileInputStream(String fileName) {
		String filePath = System.getProperty("user.dir") + "\\textfile\\" + fileName;
		File file = new File(filePath);
		
		try(FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis,"MS949")){ //MS949 : euckr과 동일 / UTF8로 넣으면 제대로 나옴 / 오토?구현한 인터페이스만 들어올수 있다.
			int c;
			while((c = isr.read())!=-1) {
				System.out.print((char)c);	//인코딩이 틀려서 글자가 깨져서 나옴
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readFile(String fileName) {
		String filePath = System.getProperty("user.dir") + "\\textfile\\" + fileName;
		File file = new File(filePath);

		//try-catch-resource문 : 자동으로 close 호출됨, closable interface를 구현한 클래스만 가능
		try (FileReader fr = new FileReader(file);) {
			int c;
			while ((c = fr.read()) != -1) { //The character read, or -1 if the end of the stream has beenreached
				System.out.print((char)c);
			}
			System.out.println("Encoding :"+fr.getEncoding());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//System.out.println("해당 파일이 존재하지 않음");
		} catch (IOException e) {
			e.printStackTrace();
			//System.out.println("파일 읽는 도중에 문제 발생");
		}

	}

	public static void readex02() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("C:\\Windows\\system.ini");
		int c;
		while ((c = fr.read()) != -1) {
			System.out.print((char)c);
		}
	
	}

	public static void readex01() {
		try {
			readex02();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("해당 파일이 존재하지 않음");
		}

		catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일 읽는 도중에 문제 발생");
		}
	}

}
