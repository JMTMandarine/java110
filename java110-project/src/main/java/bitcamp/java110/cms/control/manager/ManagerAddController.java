package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerAddController {

    @RequestMapping("manager/add")
    public void add(Scanner keyIn) {
        while(true) {
            Manager m=new Manager();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            /*members[index].setName(keyIn.nextLine());*/
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("전화번호? ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("위치? ");
            m.setPosition(keyIn.nextLine());
            
            App.managerDao.insert(m);
            
            System.out.print("계속하시겠습니까?(Y/n) ");
            String answer=keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
        
    }
    
    {
        Manager m=new Manager();
        m.setName("a");
        m.setEmail("aa@naver.com");
        App.managerDao.insert(m);
        
        m=new Manager();
        m.setName("b");
        m.setEmail("bb@naver.com");
        App.managerDao.insert(m);
        
        m=new Manager();
        m.setName("c");
        m.setEmail("cc@naver.com");
        App.managerDao.insert(m);
        
        m=new Manager();
        m.setName("d");
        m.setEmail("dd@naver.com");
        App.managerDao.insert(m);
        
        m=new Manager();
        m.setName("e");
        m.setEmail("ee@naver.com");
        App.managerDao.insert(m);
    }
    
    
}
