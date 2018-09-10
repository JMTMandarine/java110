import java.lang.reflect.Method;
import java.util.Scanner;

import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.context.ApplicationContext;

public class App {
    
    static Scanner keyIn=new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        
        ApplicationContext iocContainer = new ApplicationContext("bitcamp.java110.cms.control");
        
        while(true) {
            String menu=prompt();
            if(menu.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            
            Object controller = iocContainer.getBean(menu);
            if(controller==null) {
                System.out.println("해당 메뉴가 없습니다.");
                continue;
            }
            
            Method method=findRequestMapping(controller.getClass());
            
            if(method==null) {
                System.out.println("해당 메뉴가 없습니다.");
                continue;
            }
            method.invoke(controller, keyIn);
        }
        
        keyIn.close();   
    }

    private static Method findRequestMapping(Class<?> clazz) {
        //=>클래스의 메서드 목록울 꺼낸다.
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m : methods) {
            // 메서드에서  @RequestMapping 정보를 추출
            RequestMapping anno=m.getAnnotation(RequestMapping.class);
            if(anno!=null) //찾을경우 메서드 리턴
                return m;
        }
        return null;
    }

    private static String prompt() {
        System.out.println("[메뉴]");
            return keyIn.nextLine();
        }
        /*if(menu.equals("1")) {
            inputMembers();
            printMembers();       
        }else {
            
        }*/
    
    
    
    
}
