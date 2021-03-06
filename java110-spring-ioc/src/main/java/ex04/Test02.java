// 생성자 호출 : <constructor=arg> 사용법
// => 객체를 생성할 때 생성자의 파라미터 값을 지정하지 않으면, 기본 생성자가 호출됨
//
// XML문법
//      <constructor-arg value="값"/>
//      <constructor-arg><value>소나타</value></constructor-arg>
package ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    public static void main(String[] args) {
        
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex04/app-context-2.xml");
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
        
        Car c3 = (Car)iocContainer.getBean("c3");
        System.out.println(c3);
        
        Car c4 = (Car)iocContainer.getBean("c4");
        System.out.println(c4);
        
      
        
    }
}
