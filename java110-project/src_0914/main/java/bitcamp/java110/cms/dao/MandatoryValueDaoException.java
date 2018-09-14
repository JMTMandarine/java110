package bitcamp.java110.cms.dao;

public class MandatoryValueDaoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public MandatoryValueDaoException() {
        super();
    }

    public MandatoryValueDaoException(String message, Throwable cause) {
        super(message, cause); //이부분 생략시 super클래스에 기본 생성자를 호출함 : super()
    }

    public MandatoryValueDaoException(String message) {
        super(message);
    }



}
