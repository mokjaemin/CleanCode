package Exception;

public class WrongPassWordException extends RuntimeException{

    public String message = "비밀번호가 일치하지 않습니다.";

    @Override
    public String getMessage(){
        return message;
    }

}
