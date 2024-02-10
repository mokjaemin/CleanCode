package TestUtil;

import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.DTO.Output.LoginedMemberToken;
import Data.Entity.MemberEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberTestUtil {

    public static Member givenMember(){
        return Member.builder().id("id").passWord("pwd").name("name").email("email")
                .address("address").phoneNumber("phoneNumber").build();
    }

    public static LoginMember givenLoginMember(){
        return LoginMember.builder().id("id").passWord("pwd").build();
    }

    public static MemberEntity givenMemberEntity(){
        Member member = Member.builder().id("id").passWord("pwd").name("name").email("email")
                .address("address").phoneNumber("phoneNumber").build();
        return MemberEntity.toMemberEntity(member);
    }

    public static LoginedMemberToken givenLoginedMemberToken(){
        return LoginedMemberToken.builder().build();
    }

    public static DeleteMember givenDeleteMember(){
        return DeleteMember.builder().id("id").passWord("pwd").build();
    }


    public static void thenErrorMessageShouldBeEquals(String originalErrorMessage, String receivedErrorMessage){
        assertEquals(originalErrorMessage, receivedErrorMessage);
    }


}
