package bitcamp.java110.cms.control.people;

import java.util.Scanner;

import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.domain.People;

@Component
public class PeopleAddController {

    public void add(Scanner keyIn) {
        People p=new People();
        
        System.out.println("이름을 입력해주세요.");
        p.setName(keyIn.nextLine());
        
        System.out.println("이메일을 입력해주세요.");
        p.setEmail(keyIn.nextLine());
        
        System.out.println("나이를 입력해주세요.");
        p.setAge(keyIn.nextLine());
        
        System.out.println("주소을 입력해주세요.");
        p.setAddr(keyIn.nextLine());
        
        System.out.println("지역을 입력해주세요");
        p.setArea(keyIn.nextLine());
        
    }
    
}
