package Exception;

public class NoMemberEntityInCondition extends RuntimeException{

    public static final String message = "해당 조건과 일치하는 정보가 없습니다.";

    @Override
    public String getMessage(){
        return message;
    }
}
