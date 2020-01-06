
package chapter_08;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BufferedIOEx {

	public static void main(String[] args) {
		int c;
		try (FileReader fin = new FileReader("D:\\workspace_java\\java_study_02\\textfile\\department.txt")) {

			// BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out), 5);

			while ((c = fin.read()) != -1) {
				out.write((char) c);
			}

			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
