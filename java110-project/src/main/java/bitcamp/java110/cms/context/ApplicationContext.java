package bitcamp.java110.cms.context;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;

public class ApplicationContext {
    HashMap<String, Object> objPool=new HashMap<>();
    
    public ApplicationContext(String packageName) throws Exception {
        // 패키지이름을 파일경로로 바꿈
        String path=packageName.replace(".", "/");
        
        // 패키지 경로를 가지고 전체 파일 경로를 알아낸다.
        File file=Resources.getResourceAsFile(path);
        System.out.println(file.getAbsolutePath());
    }
    
    public Object getBean(String name) {
        return null;
    }
}
