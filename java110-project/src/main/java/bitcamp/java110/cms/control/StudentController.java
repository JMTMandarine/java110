package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Student;
import util.ArrayList;

public class StudentController {
    
    private  ArrayList students=new ArrayList();
    public  Scanner keyIn;
    public StudentController(Scanner keyIn) {
        this.keyIn = keyIn;
    }
    
    public void serviceStudentMenu() {
        while(true) {
            System.out.println("학생관리>");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printStudent();
            }else if(command.equals("add")) {
                inputStudents();
            }else if(command.equals("delete")) {
                deleteStudent();
            }else if(command.equals("detail")) {
                detailStudent();
            }else if(command.equals("quit")) {
                break;
            }else {
                System.out.println("유효하지 않은 명령입니다.");
            }
        }
    }
    
    private void inputStudents() {
        while(true) {
            Student s=new Student();
            
            System.out.print("이름? ");
            s.setName(keyIn.nextLine());
            /*members[index].setName(keyIn.nextLine());*/
            
            System.out.print("이메일? ");
            s.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            s.setPassword(keyIn.nextLine());
            
            System.out.print("최종학력? ");
            s.setSchool(keyIn.nextLine());
            
            System.out.print("재직여부?(true/false) ");
            s.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.print("전화번호? ");
            s.setTel(keyIn.nextLine());
            
            students.add(s);
            
            System.out.print("계속하시겠습니까?(Y/n) ");
            String answer=keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
        
    }
    
    private void printStudent() {
        int count = 0;
        for(int i=0;i<students.size();i++) {
            Student s=(Student)students.get(i);
            System.out.printf("%d: %s, %s, ,%s, %s, %b, %s\n"
                                , count  ++
                                , s.getName()
                                , s.getEmail()
                                , s.getPassword()
                                , s.getSchool()
                                , s.isWorking()
                                , s.getTel());
        }
    }
    
    private void deleteStudent() {
        System.out.print("삭제할 번호? ");
        int no=Integer.parseInt(keyIn.nextLine());
        
        if(no < 0||no>=students.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        
        students.remove(no);
        System.out.println("삭제 하였습니다.");
        
    }
    
    private void detailStudent() {
        System.out.print("조회할 번호? ");
        int no=Integer.parseInt(keyIn.nextLine());
        
        if(no < 0||no>=students.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        Student student=(Student)students.get(no);
        
        System.out.printf("이름 : %s\n",student.getName());
        System.out.printf("이메일 : %s\n",student.getEmail());
        System.out.printf("암호 : %s\n",student.getPassword());
        System.out.printf("최종학력 : %s\n",student.getSchool());
        System.out.printf("전화 : %s\n",student.getTel());
        System.out.printf("제직여부 : %b\n",student.isWorking());
    }
    
     { //인스턴스 블록
        Student s=new Student();
        s.setName("a");
        students.add(s);
        
        s=new Student();
        s.setName("b");
        students.add(s);
        
        s=new Student();
        s.setName("c");
        students.add(s);
        
        s=new Student();
        s.setName("d");
        students.add(s);
        
        s=new Student();
        s.setName("e");
        students.add(s);
    }
}


