package util;

public interface List<T>{
    void add(T obj);
    T get(int index);
    T remove(int index);
    int size();
    
    
    //default의 목적
    //=> 규칙을 추가되면 기존 클래스들이 영향을 받으므로
    //=> 기존 클래스들은 새로 추가한 메서드를 반드시 구현해야하기 때문에 에러가 많이생긴다
    //=> 이러한 문제를 해결하기 위해 등장한 문법 
    //=> 기존클래서에 영향을 주지않게 해주는 문법.
    default void insert(int index, T obj) {
        // 인터페이스내 메서드 규칙
        // 많은 작업 처리의 내용이 들어가서는 안된다.
        // 구현하더라도 다른 클래스들에게 영향을 끼치지 않는 선에서 코드를 작성해야함.

    };
}
