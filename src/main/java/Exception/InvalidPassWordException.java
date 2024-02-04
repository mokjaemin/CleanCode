package Exception;

public class InvalidPassWordException extends RuntimeException{

    public static final String message = "비밀번호가 일치하지 않습니다.";

    @Override
    public String getMessage(){
        return message;
    }

}
