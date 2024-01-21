package Exception;

public class NoExistedIDException extends RuntimeException{

    public String message = "아이디가 존재하지 않습니다.";

    @Override
    public String getMessage(){
        return message;
    }

}
