package ex11.step7;

public interface Service {
    void add(); //인터페이스는 무조건 public이라 생략가능
    void update();
    void delete();
    void list();
    int addPhoto(String filename);
}
