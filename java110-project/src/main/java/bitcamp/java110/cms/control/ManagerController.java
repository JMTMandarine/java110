package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Manager;
import util.List;



public class ManagerController {
    
    private List<Manager> managers;
    public Scanner keyIn;
    public ManagerController(Scanner keyIn, List<Manager> managers) {
        this.keyIn = keyIn;
        this.managers = managers;
        init();
    }
    
    public void serviceManagerMenu() {
        while(true) {
            System.out.println("매니저관리>");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printManagers();
            }else if(command.equals("add")) {
                inputManagers();
            }else if(command.equals("delete")) {
                deleteManager();
            }else if(command.equals("detail")) {
                detailManager();
            }else if(command.equals("quit")) {
                break;
            }else {
                System.out.println("유효하지 않은 명령입니다.");
            }
        }
    }
    
    private void inputManagers() {
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
            
            managers.add(m);
            
            System.out.print("계속하시겠습니까?(Y/n) ");
            String answer=keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
        
    }
    
    private void printManagers() {
        int count = 0;
        for(int i=0;i<managers.size();i++) {
            Manager m=managers.get(i);
            System.out.printf("%d, %s, %s, ,%s, %s, %s\n"
                                , count ++  
                                , m.getName()
                                , m.getEmail()
                                , m.getPassword()
                                , m.getTel()
                                , m.getPosition());            
        }
    }
    
    private void deleteManager() {
        System.out.print("삭제할 번호? ");
        int no=Integer.parseInt(keyIn.nextLine());
        
        if(no < 0|| no >= managers.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        
        managers.remove(no);
        System.out.println("삭제하였습니다");
    }
    
    private void detailManager() {
        System.out.print("조회할 번호? ");
        int no=Integer.parseInt(keyIn.nextLine());
        
        //삭제s
        if(no < 0||no>=managers.size()) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        Manager manager=managers.get(no);
        
        System.out.printf("이름 : %s\n",manager.getName());
        System.out.printf("이메일 : %s\n",manager.getEmail());
        System.out.printf("암호 : %s\n",manager.getPassword());
        System.out.printf("최종학력 : %s\n",manager.getPosition());
        System.out.printf("전화 : %s\n",manager.getTel());

    }
    
    private void init(){
        Manager m=new Manager();
        m.setName("a");
        managers.add(m);
        
        m=new Manager();
        m.setName("b");
        managers.add(m);
        
        m=new Manager();
        m.setName("c");
        managers.add(m);
        
        m=new Manager();
        m.setName("d");
        managers.add(m);
        
        m=new Manager();
        m.setName("e");
        managers.add(m);
    }
}
