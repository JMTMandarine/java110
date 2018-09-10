package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherAddController {
    
    @RequestMapping("teacher/add")
    public void add(Scanner keyIn) {
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
            
            App.teachers.add(t);
            
            System.out.print("계속하시겠습니까?(Y/n) ");
            String answer=keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
        
    }
    
    {
        Teacher t=new Teacher();
        t.setName("a");
        App.teachers.add(t);
        
        t=new Teacher();
        t.setName("b");
        App.teachers.add(t);
        
        t=new Teacher();
        t.setName("c");
        App.teachers.add(t);
        
        t=new Teacher();
        t.setName("d");
        App.teachers.add(t);
        
        t=new Teacher();
        t.setName("e");
        App.teachers.add(t);
    }
}
