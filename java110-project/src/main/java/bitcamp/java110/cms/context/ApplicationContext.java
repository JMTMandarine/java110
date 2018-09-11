package bitcamp.java110.cms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.io.Resources;

import bitcamp.java110.cms.annotaion.Component;

public class ApplicationContext {
    HashMap<String, Object> objPool=new HashMap<>();
    List<Class<?>> classes=new ArrayList<>();
    
    public ApplicationContext(String packageName) throws Exception {
        // 패키지이름을 파일경로로 바꿈
        String path=packageName.replace(".", "/");
        
        // 패키지 경로를 가지고 전체 파일 경로를 알아낸다.
        File file=Resources.getResourceAsFile(path);
        
        //패키지 폴더에 들어있는 클래스를 찾아 인스턴스를 생성하여 objPool에 저장
        
         findClass(file, path); //패키지 폴더에 들어 있는 클래스를 찾아 클래스를 로딩한 후 그 목록에 저장. 
        
        // 1) 인스턴스 생성
        // 로딩된 클래스 목록을 @Component가 붙음
        // 클래스에 대해 인스턴스를 생성한 후에 
         createInstance();
         
         //injectDepenency() 메서드를 외부 클래스로 분리한 다음에
         // 그 객체를 실행한다.
         AutowiredAnnotationBeanPostProcessor processor=new AutowiredAnnotationBeanPostProcessor();
         processor.postProcess(this);
         
    }
    
    
    public Object getBean(String name) {
        // objPool에 보관된 객체를 이름으로 찾아 리턴함.
        return objPool.get(name);
    }
    
    //객채의 타입으로 objPool에 보관된 객체를 찾아 리턴
    public Object getBean(Class<?> type) {
        Collection<Object> objList = objPool.values();
        for(Object obj : objList) {
            if(type.isInstance(obj)) {
                return obj;
            }
        }
        return null;
    }
    
    //키값을 배열에 넣음
    public String[] getBeanDefinintionNames() {
        Set<String> keySet = objPool.keySet();
        String[] names =new String[keySet.size()];
        keySet.toArray(names);
        return names;
    }
    
    private void findClass(File path, String packagePath) throws Exception {
        File[] files = path.listFiles();
        for(File file : files) {
            if(file.isDirectory()) {
                findClass(file, packagePath+"/"+file.getName());
            }else {
                String className=(packagePath+"/"+file.getName()).replace("/", ".").replace(".class","");
                
                try {
                    //1)클래스 이름을 가지고 .class 파일을 찾아 메모리에 로딩한다.
                    Class<?> clazz=Class.forName(className);
                    
                    //로딩한 클래스 정보를 목록에 보관
                    classes.add(clazz);
                    
                } catch (Exception e) {}
            }
            
            
        }
        
    }
    private void createInstance() {
        for(Class<?> clazz: classes) {
            // 인터페이스인 경우 무시
            if(clazz.isInterface()) continue ;
            
            // 클래스에서 
            Component anno= clazz.getAnnotation(Component.class);
            
            // 애노테이션이 붙지않은 클래스는 객체를 생성하지 않음.
            if(anno==null) continue;
            try {
                //2)로딩된 클래스 정보를 가지고 인스턴스를 생성한다.
                //=>먼저 해당 클래스의 생성자 정보를 얻는다.
                Constructor<?> constructor=clazz.getConstructor();
                
                // 생성자를 가지고 인스턴스를 생성한다.
                Object instance = constructor.newInstance();
                

                if(anno.value().length()>0) {
                    objPool.put(anno.value(), instance);
                }else {
                    objPool.put(clazz.getName(), instance);
                }
                
                // => Component 에노테이션 value값으로 인서턴스를 objPool에 저장한다.
                
            }catch(Exception e) {
                e.printStackTrace();
                System.out.printf("%s 클래는 기본 생성자가 없습니다.\n",clazz.getName());
            }
        }
    }
    
   /* private void callBeanPostProcessor() {
        //objPool에 보관된 객체 중에서 BeanPostProcessor 규칙을 준수하는 객체를 찾음
        Collection<Object> objList= objPool.values();
        for(Object obj : objList) {
            if(!BeanPostProcessor.class.isInstance(obj)) continue; //class?
            
            BeanPostProcessor processor= (BeanPostProcessor)obj;
            processor.postProcess(this);
        }
    }*/
}



    
/*  재귀설명  
 *  public static void main(String[] args) {
        int sum =sigma(3);
        System.out.println(sum);
        
    }
    
    public static int sigma(int a) {
        if (a==0) {
            return 0;
        }else {
            return a+sigma(a-1);
        }
    }*/
