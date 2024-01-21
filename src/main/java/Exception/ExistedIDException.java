package Exception;

public class ExistedIDException extends RuntimeException {

    public String message = "이미 존재하는 아이디입니다.";

    @Override
    public String getMessage(){
        return message;
    }
}
