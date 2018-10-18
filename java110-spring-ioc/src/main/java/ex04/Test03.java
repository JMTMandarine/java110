// 생성자 호출 : p 네임스페스 사용
//
// XML문법
//      <bean id="아이디" class="클래스명"
//          c:파라미터명="값" c:파라미터명="값" c:파라미터명-ref="객체"/>
//  단, 
//

package ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
    public static void main(String[] args) {
        
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex04/app-context-3.xml");
        System.out.println("===========================================");
        // 컨테이너에 들어 있는 객체의 이름 알아내기
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n",count);
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            System.out.printf("=> %s:%s\n",
                                name,
                                iocContainer.getType(name).getName() );
        }
        System.out.println("===========================================");
        
        Car c1 = (Car)iocContainer.getBean("c1");
        System.out.println(c1);
        
        Car c2 = (Car)iocContainer.getBean("c2");
        System.out.println(c2);
      
        /*Car c3 = (Car)iocContainer.getBean("c3");
        System.out.println(c3);*/ // 생성자 귀찮아서 안만들어서 없음;; 실행오류;;
        
        Car c4 = (Car)iocContainer.getBean("c4");
        System.out.println(c4);
        
    }
}
