package bitcamp.java110.cms.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//IoC 컨테이너가 의존 객체를 주입하기 위해 호출하는 메서드에 대해 이 애노테이션을 붙임
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
    boolean required() default true;
}
