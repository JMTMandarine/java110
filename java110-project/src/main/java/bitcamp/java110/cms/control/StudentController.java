package bitcamp.java110.cms.control;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Student;

public class StudentController implements Controller{
    
    private  List<Student> students;
    
    public StudentController(List<Student> students) {
        this.students = students;
        init();
    }
    
    public void service(Scanner keyIn) {
        while(true) {
            System.out.println("학생관리>");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printStudent();
            }else if(command.equals("add")) {
                inputStudents(keyIn);
            }else if(command.equals("delete")) {
                deleteStudent(keyIn);
            }else if(command.equals("detail")) {
                detailStudent(keyIn);
            }else if(command.equals("quit")) {
                break;
            }else {
                System.out.println("유효하지 않은 명령입니다.");
            }
        }
    }
    
    private void inputStudents(Scanner keyIn) {
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
        for(int i=0;i<students.size();i++) {
            Student s=students.get(i);
            System.out.printf("%d: %s, %s, ,%s, %s, %b, %s\n"
                                , i
                                , s.getName()
                                , s.getEmail()
                                , s.getPassword()
                                , s.getSchool()
                                , s.isWorking()
                                , s.getTel());
        }
    }
    
    private void deleteStudent(Scanner keyIn) {
        System.out.print("삭제할 번호? ");
        int no=Integer.parseInt(keyIn.nextLine());
        
        if(no < 0||no>=students.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        
        students.remove(no);
        System.out.println("삭제 하였습니다.");
        
    }
    
    private void detailStudent(Scanner keyIn) {
        System.out.print("조회할 번호? ");
        int no=Integer.parseInt(keyIn.nextLine());
        
        if(no < 0||no>=students.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        Student student=students.get(no);
        
        System.out.printf("이름 : %s\n",student.getName());
        System.out.printf("이메일 : %s\n",student.getEmail());
        System.out.printf("암호 : %s\n",student.getPassword());
        System.out.printf("최종학력 : %s\n",student.getSchool());
        System.out.printf("전화 : %s\n",student.getTel());
        System.out.printf("제직여부 : %b\n",student.isWorking());
    }
    
     private void init() {
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


