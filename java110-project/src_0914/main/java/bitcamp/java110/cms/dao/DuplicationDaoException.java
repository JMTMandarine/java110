package bitcamp.java110.cms.dao;

public class DuplicationDaoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DuplicationDaoException() {
        super();
    }

    public DuplicationDaoException(String message, Throwable cause) {
        super(message, cause); //이부분 생략시 super클래스에 기본 생성자를 호출함 : super()
    }

    public DuplicationDaoException(String message) {
        super(message);
    }



}
