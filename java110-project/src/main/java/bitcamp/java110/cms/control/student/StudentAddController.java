package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentAddController {
    
    @RequestMapping("student/add")
    public void add(Scanner keyIn) {
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
            
            App.students.add(s);
            
            System.out.print("계속하시겠습니까?(Y/n) ");
            String answer=keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
        
    }
    
    {
        Student s=new Student();
        s.setName("a");
        App.students.add(s);
        
        s=new Student();
        s.setName("b");
        App.students.add(s);
        
        s=new Student();
        s.setName("c");
        App.students.add(s);
        
        s=new Student();
        s.setName("d");
        App.students.add(s);
        
        s=new Student();
        s.setName("e");
        App.students.add(s);
    }
}
