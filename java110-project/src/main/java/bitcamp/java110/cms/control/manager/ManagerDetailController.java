package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerDetailController {

    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 번호? ");
        int no=Integer.parseInt(keyIn.nextLine());
        
        //삭제s
        if(no < 0||no>=App.managers.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        Manager manager=App.managers.get(no);
        
        System.out.printf("이름 : %s\n",manager.getName());
        System.out.printf("이메일 : %s\n",manager.getEmail());
        System.out.printf("암호 : %s\n",manager.getPassword());
        System.out.printf("최종학력 : %s\n",manager.getPosition());
        System.out.printf("전화 : %s\n",manager.getTel());
    }
    
    
}
