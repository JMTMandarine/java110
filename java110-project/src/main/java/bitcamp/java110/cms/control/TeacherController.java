package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.dao.StudentList;
import bitcamp.java110.cms.dao.TeacherList;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.domain.Teacher;

public class TeacherController {
   
    public static Scanner keyIn;
    
    public static void serviceTeacherMenu() {
        while(true) {
            System.out.println("강사관리>");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printTeachers();
            }else if(command.equals("add")) {
                inputTeachers();
            }else if(command.equals("delete")) {
                deleteTeacher();
            }else if(command.equals("detail")) {
                detailTeacher();
            }else if(command.equals("quit")) {
                break;
            }else {
                System.out.println("유효하지 않은 명령입니다.");
            }
        }
    }
    
    private static void inputTeachers() {
        while(true) {
            Teacher t=new Teacher();
            
            System.out.print("이름? ");
            t.setName(keyIn.nextLine());
            /*members[index].setName(keyIn.nextLine());*/
            
            System.out.print("이메일? ");
            t.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            t.setPassword(keyIn.nextLine());
            
            System.out.print("전화번호? ");
            t.setTel(keyIn.nextLine());
            
            System.out.print("급여 ");
            t.setPay(Integer.parseInt(keyIn.nextLine()));
            
            System.out.print("강의과목?(예: 자바,C,C++) ");
            t.setSubjects(keyIn.nextLine());
            
            System.out.print("계속하시겠습니까?(Y/n) ");
            String answer=keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
        
    }
    
    private static void printTeachers() {
        int count = 0;
        for(int i=0; i<TeacherList.size();i++) {
            Teacher t=TeacherList.get(i);
            System.out.printf("%d, %s, %s, ,%s, %s, %d, [%s]\n"
                                , count ++  
                                , t.getName()
                                , t.getEmail()
                                , t.getPassword()
                                , t.getTel()
                                , t.getPay()
                                , t.getSubjects());
        }
    }
    
    private static void deleteTeacher() {
        System.out.print("삭제할 번호? ");
        int no=Integer.parseInt(keyIn.nextLine());
        
        if(no<0||no>TeacherList.size()) {
            System.out.println("해당 번호가 없습니다.");
            return;
        }
        TeacherList.remove(no);
        System.out.println("삭제 하였습니다.");
    }
    
    private static void detailTeacher() {
        System.out.print("조회할 번호? ");
        int no=Integer.parseInt(keyIn.nextLine());
        
        if(no < 0||no>=TeacherList.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        Teacher teacher=TeacherList.get(no);
        
        System.out.printf("이름 : %s\n",teacher.getName());
        System.out.printf("이메일 : %s\n",teacher.getEmail());
        System.out.printf("암호 : %s\n",teacher.getPassword());
        System.out.printf("급여 : %d\n",teacher.getPay());
        System.out.printf("전화 : %s\n",teacher.getTel());
        System.out.printf("과목 : %s\n",teacher.getSubjects());

    }
    
    static {
        Teacher t=new Teacher();
        t.setName("a");
        TeacherList.add(t);
        
        t=new Teacher();
        t.setName("b");
        TeacherList.add(t);
        
        t=new Teacher();
        t.setName("c");
        TeacherList.add(t);
        
        t=new Teacher();
        t.setName("d");
        TeacherList.add(t);
        
        t=new Teacher();
        t.setName("e");
        TeacherList.add(t);
    } 
}
