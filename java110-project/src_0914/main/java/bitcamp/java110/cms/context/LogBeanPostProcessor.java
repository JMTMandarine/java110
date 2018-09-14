package bitcamp.java110.cms.context;

import java.util.Collection;

import bitcamp.java110.cms.annotaion.Component;

@Component //객채를 생성안해도 만들어짐 (찾을때는 인터페이스로 찾음)
public class LogBeanPostProcessor implements BeanPostProcessor{
    
    ApplicationContext beanContainer;
    
    
    
    public void postProcess(ApplicationContext beanContainer) {
        
     // objPool에 보관된 객체 목록을 꺼낸다.
        Collection<Object> objList = beanContainer.objPool.values();
        
        System.out.println("------------------------------------");
        for(Object obj : objList) {
            System.out.println(obj.getClass().getName());
        } 
        System.out.println("------------------------------------");
        
    }
}
