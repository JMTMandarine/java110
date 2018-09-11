package bitcamp.java110.cms.context;

import java.lang.reflect.Method;
import java.util.Collection;

import bitcamp.java110.cms.annotaion.Autowired;

public class AutowiredAnnotationBeanPostProcessor {
    
    ApplicationContext beanContainer;
    
    
    
    public void postProcess(ApplicationContext beanContainer) {
        
     // objPool에 보관된 객체 목록을 꺼낸다.
        Collection<Object> objList = beanContainer.objPool.values();
        
        for(Object obj : objList) {
          
            Method[] methods = obj.getClass().getDeclaredMethods();
            for(Method m:methods) {
                if(!m.isAnnotationPresent(Autowired.class)) continue;
                
                //setter 메서드를 호출하기 위해 파라미터 값을 준비한다.
                Class<?> paramType=m.getParameterTypes()[0];
                
                //그 파라미터 타입과 일치하는 객체가 objPool에 있는지 꺼낸다.
                Object dependency=beanContainer.getBean(paramType);
                if(dependency == null) continue;
                
                try {
                    m.invoke(obj, dependency);
                    System.out.printf("%s() 호출됨\n",m.getName());
                } catch (Exception e) {}
            }
            
            
        } 
        
    }
}
