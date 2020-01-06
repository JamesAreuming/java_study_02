package chapter_07_exam02;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class StudentManagement implements StdManagerInterface {
   private ArrayList<Student> stdList;
  
   protected StudentManagement() { 
      this.stdList = new ArrayList<Student>();
   }
   
   @Override
   public ArrayList<Student> listStudent() { //학생목록
     System.out.println();
      System.out.println("================&&&&&&&&&&  학생 정보 LIST   &&&&&&&&&&=================");
      System.out.println("==================================================================");
      System.out.println("번   호                이  름                국 어                수학                영어                총점              평      균");
      System.out.println("==================================================================");
      return stdList;
   }
   
   @Override
   public ArrayList<Student> compareList() { //학생목록
     System.out.println();
      System.out.println("================&&&&&&&&&&  1등 & 꼴찌   &&&&&&&&&&=================");
      return stdList;
   }


   @Override
   public boolean insertStudent(Student student) { //학생추가
      return stdList.add(student);
   }

   
   @Override
   public void searchStudent(int searchNum) { // 학생검색
      try {
         int idxNo = searchNum - 1; // 인덱스번호 (학생번호-1)
         if (searchNum == stdList.get(idxNo).getStdNo()) {
            JOptionPane.showMessageDialog(null, stdList.get(idxNo), "학생 정보", JOptionPane.INFORMATION_MESSAGE);
         }
      } catch (IndexOutOfBoundsException e) {
         JOptionPane.showMessageDialog(null, "해당학생이 없습니다!", "※ 경 고 ※", JOptionPane.ERROR_MESSAGE);
      }
   }
   
   
   @Override
   public void updateStudent(int searchNum) { // 학생수정
      searchStudent(searchNum);
           int idxNo = searchNum - 1;
            if (searchNum == stdList.get(idxNo).getStdNo()) {
               String[] update = { "이름", "국어", "수학", "영어" };
               String change = (String) JOptionPane.showInputDialog(null, "수정항목을 선택하세요", "학생 정보 수정", JOptionPane.QUESTION_MESSAGE, null, update, "이름");
               switch (change) {
               case "이름":
                  String name = JOptionPane.showInputDialog("변경할 이름을 입력하세요");
                  stdList.get(idxNo).setStdName(name);
                  break;
               case "국어":
                  String inputKor = JOptionPane.showInputDialog("변경할 국어점수를 입력하세요");
                  int kor = Integer.parseInt(inputKor);
                  stdList.get(idxNo).setKor(kor);
                  break;
               case "수학":
                  String inputMath = JOptionPane.showInputDialog("변경할 수학점수를 입력하세요");
                  int math = Integer.parseInt(inputMath);
                  stdList.get(idxNo).setMath(math);
                  break;
               case "영어":
                  String inputEng = JOptionPane.showInputDialog("변경할 영어점수를 입력하세요");
                  int eng = Integer.parseInt(inputEng);
                  stdList.get(idxNo).setEng(eng);
                  break;
         }
         JOptionPane.showMessageDialog(null, stdList.get(idxNo), "변경 정보", JOptionPane.INFORMATION_MESSAGE);
      }
   }

   
   @Override
   public void deleteStudent(int searchNum) { // 학생삭제
      searchStudent(searchNum);
      int idxNo = searchNum - 1;
      if (searchNum == stdList.get(idxNo).getStdNo()) {
         int result = JOptionPane.showConfirmDialog(null, "정말 삭제 하시겠습니까?", "YES & NO", JOptionPane.YES_NO_OPTION);
         if (result == JOptionPane.YES_OPTION) {
            stdList.remove(idxNo);
         }
         for (int i = idxNo; i < stdList.size(); i++) {
            stdList.get(i).setStdNo(i + 1);
         }
      }
   }
   


   public void setStudentList(ArrayList<Student> initStdList) {
      this.stdList = initStdList;
   }

}