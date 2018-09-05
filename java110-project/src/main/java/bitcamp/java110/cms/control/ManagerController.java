package bitcamp.java110.cms.control;
import java.util.Scanner;


import bitcamp.java110.cms.domain.Member;


public class ManagerController {
    static Manager[] managers=new Manager[100];
    static int managerIndex = 0;
    public static Scanner keyIn;
    
    private static class Manager extends Member{
        protected String tel;
        protected String position;
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }
    }
    
    public static void serviceManagerMenu() {
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
    
    private static void printManagers() {
        int count = 0;
        for(Manager m : managers) {
            if(count++ ==managerIndex)
                break;
            System.out.printf("%s, %s, ,%s, %s, %s\n"
                                , m.getName()
                                , m.getEmail()
                                , m.getPassword()
                                , m.getTel()
                                , m.getPosition()
                                
                    );            
        }
    }
    
    
    
    private static void inputManagers() {
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
            
            if(managerIndex == managers.length) {
                increaseStorage();
            }
            
           
            
            managers[managerIndex++] = m;
            
            System.out.print("계속하시겠습니까?(Y/n) ");
            String answer=keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
        
    }
    
    private static void increaseStorage() {
        Manager[] newList = new Manager[managers.length+3];
        for(int i=0; i<managers.length; i++) {
            newList[i]=managers[i];
        }
        managers = newList;
    }
    
    
    private static void deleteManager() {
        System.out.print("삭제할 번호? ");
        int no=Integer.parseInt(keyIn.nextLine());
        
        //삭제s
        if(no < 0||no>=managerIndex) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        
        for(int i=no; i<managerIndex-1; i++){
            managers[i] = managers[i+1];
        }
        managerIndex--;
        
    }
    
    private static void detailManager() {
        System.out.print("조회할 번호? ");
        int no=Integer.parseInt(keyIn.nextLine());
        
        //삭제s
        if(no < 0||no>=managerIndex) {
            System.out.println("잘못된 번호입니다.");
            return;
        }
        System.out.printf("이름 : %s\n",managers[no].getName());
        System.out.printf("이메일 : %s\n",managers[no].getEmail());
        System.out.printf("암호 : %s\n",managers[no].getPassword());
        System.out.printf("최종학력 : %s\n",managers[no].getPosition());
        System.out.printf("전화 : %s\n",managers[no].getTel());

    }
    
}
