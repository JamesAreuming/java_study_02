package chapter_07_exam02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import javax.swing.JOptionPane;

public class ExamMain {
 
   public static void main(String[] args) {
      /*
      1. 학생정보를 관리하는 프로그램을 작성하세요.
      2. 학생클래스를 정의(번호, 성명, 국어, 영어, 수학) 
      3. 학생관리클래스정의(StudentManagement) StdManagerInterface를 구현한
      4. 메뉴작성(1. 학생목록, 2. 학생추가, 3. 학생 수정, 4. 학생 삭제, 5. 학생 검색,  6. 종료)
      */

      StudentManagement sm = new StudentManagement();

      sm.setStudentList(initStdList());

      String[] select = { "학생 목록", "학생 추가", "학생 수정", "학생 삭제 ", "학생 검색 ", "종료" };

      while (true) {
         String option = (String) JOptionPane.showInputDialog(null, "관리할 항목을 선택하세요", "학생 관리 프로그램",JOptionPane.QUESTION_MESSAGE, null, select, "학생 목록");
         try {
            switch (option) {
            case "학생 목록":
               String[] list = {"번호순 조회","국어점수 정렬","수학점수 정렬","영어점수 정렬","총점수 정렬"};
               String listOpt = (String) JOptionPane.showInputDialog(null, "조회할 항목을 선택하세요", "학생 정보 항목별 LIST", JOptionPane.QUESTION_MESSAGE, null, list, "번호순 조회");
                  switch(listOpt) {
                  case "번호순 조회":
                  prnStudents(sm.listStudent());
                  break;
                  case "국어점수 정렬":
                     korList(sm.compareList());
                     prnStudents(sm.listStudent());
                     break;
                  case "수학점수 정렬":
                     mathList(sm.compareList());
                     prnStudents(sm.listStudent());
                     break;
                  case "영어점수 정렬":
                     engList(sm.compareList());
                     prnStudents(sm.listStudent());
                     break;
                  case "총점수 정렬":
                      totalList(sm.compareList());
                     prnStudents(sm.listStudent());
                     break;
                  };
                  break;
            case "학생 추가":
               Student insertStd = getStudent();
               sm.insertStudent(insertStd);
               prnStudents(sm.listStudent());// 학생목록 활용
               break;
            case "학생 수정":
               int updateStd = findStudent();
               sm.updateStudent(updateStd);
               prnStudents(sm.listStudent());// 학생목록 활용
               break;
            case "학생 삭제 ":
               int deleteStd = findStudent();
               sm.deleteStudent(deleteStd);
               prnStudents(sm.listStudent());// 학생목록 활용
               break;
            case "학생 검색 ":// 5.학생검색 (O)
               int searchStd = findStudent();
               sm.searchStudent(searchStd);
               break;
            }
         } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "프로그램이 종료 되었습니다.", "종료 메세지", JOptionPane.INFORMATION_MESSAGE);
            break;
         }
         
         if (option == "종료") {
            int goodBye = JOptionPane.showConfirmDialog(null, "정말 종료 하시겠습니까?", "YES & NO",JOptionPane.YES_NO_OPTION);
            if (goodBye == JOptionPane.YES_OPTION) {
               JOptionPane.showMessageDialog(null, "프로그램이 종료 되었습니다.", "종료 메세지", JOptionPane.INFORMATION_MESSAGE);
               break;
            }
            if (goodBye == JOptionPane.CLOSED_OPTION || goodBye == JOptionPane.NO_OPTION) {
               continue;
            }
         }
      }
   }

    //학생목록 =======================================================================================
   private static ArrayList<Student> initStdList() {
      ArrayList<Student> arList = new ArrayList<>();
      Random rnd = new Random();
      String[] names = { "권수진", "정아름", "장현서", "황태원", "배진우", "현재승", "이동주", "황하나", "유경진", "이상원", "박인선" };
      for (int i = 0; i < names.length; i++) {
         arList.add(new Student(i + 1, names[i], rnd.nextInt(60) + 41, rnd.nextInt(60) + 41, rnd.nextInt(60) + 41));
      }
      return arList;
   }

   private static void prnStudents(ArrayList<Student> listStudent) { // 랜덤으로 넣은 학생들 정보 보기
      for (Student std : listStudent) {
         System.out.println(std);
      }
   }
   
   // *정렬
   private static void korList(ArrayList<Student> compareList) { //국어점수별 정렬
      Comparator<Student> korComp = new Comparator<Student>() {

         @Override
         public int compare(Student o1, Student o2) {
            return o2.getKor() - o1.getKor();
         }
      };

      compareList.sort(korComp);
      System.out.printf("▶ [ 1  등 ]   이름 : %s   국어점수 : %d %n",compareList.get(0).getStdName(),compareList.get(0).getKor());
      System.out.printf("▶ [ 꼴 찌 ]   이름 : %s   국어점수 : %d %n",compareList.get(compareList.size() - 1).getStdName(),compareList.get(compareList.size() - 1).getKor());
   }

   private static void mathList(ArrayList<Student> compareList) { //수학점수별 정렬
      Comparator<Student> mathComp = new Comparator<Student>() {

         @Override
         public int compare(Student o1, Student o2) {
            return o2.getMath() - o1.getMath(); // 제일 높은 점수
         }
      };

      compareList.sort(mathComp);
      System.out.printf("▶ [ 1  등 ]   이름 : %s   수학점수 : %d %n",compareList.get(0).getStdName(),compareList.get(0).getMath());
      System.out.printf("▶ [ 꼴 찌 ]   이름 : %s   수학점수 : %d %n",compareList.get(compareList.size() - 1).getStdName(),compareList.get(compareList.size() - 1).getMath());
   }
   
   private static void engList(ArrayList<Student> compareList) { //영어점수별 정렬
      Comparator<Student> engComp = new Comparator<Student>() {

         @Override
         public int compare(Student o1, Student o2) {
            return o2.getEng() - o1.getEng(); // 제일 높은 점수
         }
      };

      compareList.sort(engComp);
      System.out.printf("▶ [ 1  등 ]   이름 : %s   영어점수 : %d %n",compareList.get(0).getStdName(),compareList.get(0).getEng());
      System.out.printf("▶ [ 꼴 찌 ]   이름 : %s   영어점수 : %d %n",compareList.get(compareList.size() - 1).getStdName(),compareList.get(compareList.size() - 1).getEng());
   }
   
   private static void totalList(ArrayList<Student> compareList) { //총점수별 정렬
      Comparator<Student> totalComp = new Comparator<Student>() {

         @Override
         public int compare(Student o1, Student o2) {
            return o2.total() - o1.total(); // 제일 높은 점수
         }
      };

      compareList.sort(totalComp);
      System.out.printf("▶ [ 1  등 ]   이름 : %s   총점수 : %d %n",compareList.get(0).getStdName(),compareList.get(0).total());
      System.out.printf("▶ [ 꼴 찌 ]   이름 : %s   총점수 : %d %n",compareList.get(compareList.size() - 1).getStdName(),compareList.get(compareList.size() - 1).total());
   }
  
    //학생추가 =======================================================================================
   private static Student getStudent() {
      String res = JOptionPane.showInputDialog("추가할 학생 정보를 입력하세요 >>> 번호/성명/국어점수/영어점수/수학점수 ");
      String[] resArr = res.split("/");

      // int stdNo = arrStudent.size()+1; //자동번호부여
      int stdNo = Integer.parseInt(resArr[0].trim());
      String stdName = resArr[1].trim();
      int kor = Integer.parseInt(resArr[2].trim());
      int math = Integer.parseInt(resArr[3].trim());
      int eng = Integer.parseInt(resArr[4].trim());

      return new Student(stdNo, stdName, kor, math, eng);
   }

   //학생검색 : +수정,삭제 이용 ================================================================================
   private static int findStudent() {
      try {
         String num = JOptionPane.showInputDialog("학생 번호를 입력하세요"); // 문자형
         int searchNum = Integer.parseInt(num); // 숫자로 형변환
         return searchNum;
      } catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(null, "번호를 입력하세요!", "※ 경 고 ※", JOptionPane.ERROR_MESSAGE);
         return -1; // *좀더 고민 후 수정해야함
      }
   }
}