package bitcamp.java110.cms.annotaion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* 에노테이션 유지 정책
 * CLASS   : 컴파일 한 후에도 .class 파일에 남겨 둔다. 실행할 때는 참조 불가.
 *           Reflection API로 클래스에서 에노테이션 정보를 추출 불가
 *           에노테이션 미지정시 CLASS가 기본 Default값.
 *           
 * SOURCE  : 컴파일 항 때 제거된다. 즉 .class 파일에 남겨 두지 않음.
 * 
 * RUNTIME : 컴파일 한 후에도 .class 파일에 남겨 둔다. 실핼할 때도 참조할 수 있음.
 *           Reflection API로 클래스에서 에노테이션 정보를 추출 가능  
 */


// 변수명이 value일경 우 생략 가능. 단, 무조건 1개일경우 이며 변수명이 value이여야 함
@Retention(RetentionPolicy.RUNTIME)//기본 : 컴파일 한 후 .class 파일에 남겨둔다.
public @interface Component {
    String value() default "";
}
