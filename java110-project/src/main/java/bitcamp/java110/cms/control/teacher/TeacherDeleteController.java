package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;

@Component
public class TeacherDeleteController {
    
    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 번호? ");
        int no=Integer.parseInt(keyIn.nextLine());
        
        if(no<0||no>App.teachers.size()) {
            System.out.println("해당 번호가 없습니다.");
            return;
        }
        App.teachers.remove(no);
        System.out.println("삭제 하였습니다.");
    }
    
}
