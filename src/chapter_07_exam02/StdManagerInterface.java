package chapter_07_exam02;

import java.util.ArrayList;

public interface StdManagerInterface {
	
   public ArrayList<Student> listStudent();
   
   public ArrayList<Student> compareList();
   
   public boolean insertStudent(Student student);
   
   public void searchStudent(int searchNum);
   
   public void updateStudent(int searchNum);
   
   public void deleteStudent(int searchNum);   
}