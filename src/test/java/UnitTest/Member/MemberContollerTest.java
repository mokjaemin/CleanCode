package UnitTest.Member;

import Controller.MemberController;
import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.DTO.Output.LoginedMemberToken;
import Data.Entity.MemberEntity;
import Service.Impl.MemberServiceImpl;
import Service.MemberService;
import org.junit.jupiter.api.Test;
import java.util.*;
import Exception.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MemberContollerTest {

    MemberService memberService = mock(MemberServiceImpl.class);
    MemberController memberController = new MemberController(memberService);

    @Test
    public void registerMemberSuccessTest(){
        // Given
        Member member = givenMember();

        // when
        String response = memberController.registerMember(member);

        // then
        assert response.equals("success");
    }

    @Test
    public void loginMemberSuccessTest(){
        // Given
        LoginMember loginMember = givenLoginMember();
        LoginedMemberToken loginedMemberToken = givenLoginedMemberToken();
        when(memberService.createLoginMemberToken(loginMember)).thenReturn(loginedMemberToken);

        // When
        LoginedMemberToken response = memberController.loginMember(loginMember);

        // Then
        assert loginedMemberToken.equals(response);
    }


    @Test
    public void updateMemberSuccessTest(){
        // Given
        Member member = givenMember();

        // when
        String response = memberController.updateMember(member);

        // then
        assert response.equals("success");
    }

    @Test
    public void deleteMemberSuccessTest(){
        // Given
        DeleteMember deleteMember = givenDeleteMember();

        // when
        String response = memberController.deleteMember(deleteMember);

        // then
        assert response.equals("success");
    }

    @Test
    public void searchMemberSuccessTest(){
        // Given
        Member member = givenMember();
        List<MemberEntity> memberEntities = new ArrayList<>();
        MemberEntity memberEntity = MemberEntity.toMemberEntity(member);
        memberEntities.add(memberEntity);
        when(memberService.searchMemberEntitiesByMember(member)).thenReturn(memberEntities);

        // when
        List<MemberEntity> response = memberController.searchMemberEntitiesByMember(member);

        // then
        assert response.equals(memberEntities);
    }

    @Test
    public void searchMemberFailTest_NoMemberEntityInCondition(){
        // Given
        Member member = givenMember();
        List<MemberEntity> emptyList = Collections.emptyList();
        when(memberService.searchMemberEntitiesByMember(member)).thenReturn(emptyList);


        try{
            // when
            List<MemberEntity> response = memberController.searchMemberEntitiesByMember(member);
        }
        catch (RuntimeException e){
            // Then
            thenErrorMessageShouldBeEquals(NoMemberEntityInCondition.message, e.getMessage());
        }
    }




    public static Member givenMember(){
        return Member.builder().id("id").passWord("pwd").name("name").email("email")
                .address("address").phoneNumber("phoneNumber").build();
    }

    public static LoginMember givenLoginMember(){
        return LoginMember.builder().id("id").passWord("pwd").build();
    }

    public static LoginedMemberToken givenLoginedMemberToken(){
        return LoginedMemberToken.builder().build();
    }

    public static DeleteMember givenDeleteMember(){
        return DeleteMember.builder().build();
    }

    public static void thenErrorMessageShouldBeEquals(String originalErrorMessage, String receivedErrorMessage){
        assertEquals(originalErrorMessage, receivedErrorMessage);
    }

}
