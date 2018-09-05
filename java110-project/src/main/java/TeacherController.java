import java.util.Scanner;

public class TeacherController {
    
    static Teacher[] teachers=new Teacher[100];
    static int teacherIndex = 0;
    static Scanner keyIn;
    
    static class Teacher extends Member{
        protected String tel;
        protected int pay;
        protected String subjects;
        
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public int getPay() {
            return pay;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public String getSubjects() {
            return subjects;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
        
    }
    
    static void serviceTeacherMenu() {
        while(true) {
            System.out.println("강사관리>");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printTeachers();
            }else if(command.equals("add")) {
                inputTeachers();
            }else if(command.equals("quit")) {
                break;
            }else {
                System.out.println("유효하지 않은 명령입니다.");
            }
        }
    }
    
    static void printTeachers() {
        int count = 0;
        for(Teacher t : teachers) {
            if(count++ ==teacherIndex)
                break;
            System.out.printf("%s, %s, ,%s, %s, %d, [%s]\n"
                                , t.getName()
                                , t.getEmail()
                                , t.getPassword()
                                , t.getTel()
                                , t.getPay()
                                , t.getSubjects()
                                
                    );            
        }
    }
    
    
    
    static void inputTeachers() {
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
            
            teachers[teacherIndex++] = t;
            
            System.out.print("계속하시겠습니까?(Y/n) ");
            String answer=keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))
                break;
        }
        
    }
}
