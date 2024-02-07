package UnitTest.Member;

import DAO.MemberDAO;
import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.DTO.Output.LoginedMemberToken;
import Data.Entity.MemberEntity;
import Service.Impl.MemberServiceImpl;
import Service.MemberService;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MemberServiceTest {

    MemberDAO memberDAO = mock(MemberDAO.class);
    MemberService memberService = new MemberServiceImpl(memberDAO);

    @Test
    public void registerMemberSuccessTest(){
        // Given
        Member member = givenMember();
        MemberEntity memberEntity = MemberEntity.toMemberEntity(member);
        when(memberDAO.isMemberRegisterValid(memberEntity)).thenReturn(true);

        // when
        memberService.registerMemberEntity(memberEntity);

        // then
        verify(memberDAO, times(1)).registerMemberEntity(memberEntity);
    }

    @Test
    public void registerMemberFailTest_RegisteredIDException(){
        // Given
        Member member = givenMember();
        MemberEntity memberEntity = MemberEntity.toMemberEntity(member);
        when(memberDAO.isMemberRegisterValid(memberEntity)).thenReturn(false);

        // when
        memberService.registerMemberEntity(memberEntity);

        // then
        verify(memberDAO, times(0)).registerMemberEntity(memberEntity);
    }

    @Test
    public void createLoginMemberTokenSuccessTest(){
        LoginMember loginMember = givenLoginMember();
        when(memberDAO.isMemberLoginValid(loginMember)).thenReturn(true);

        LoginedMemberToken loginedMemberToken = memberService.createLoginMemberToken(loginMember);

        assert loginedMemberToken != null;
    }

    @Test
    public void createLoginMemberTokenFailTest(){
        LoginMember loginMember = givenLoginMember();
        when(memberDAO.isMemberLoginValid(loginMember)).thenReturn(false);

        try {
            memberService.createLoginMemberToken(loginMember);
        }
        catch (RuntimeException e){
            thenErrorMessageShouldBeEquals("로그인 오류", e.getMessage());
        }
    }

    @Test
    public void updateMemberSuccessTest(){
        // Given
        Member member = givenMember();
        MemberEntity memberEntity = MemberEntity.toMemberEntity(member);

        // when
        memberService.updateMemberEntity(memberEntity);

        // then
        // - Non
    }

    @Test
    public void deleteMemberSuccessTest(){
        // Given
        DeleteMember deleteMember = givenDeleteMember();

        // when
        memberService.deleteMember(deleteMember);

        // then
        // - Non
    }

    @Test
    public void searchMemberSuccessTest(){
        // Given
        Member member = givenMember();
        List<MemberEntity> memberEntities = new ArrayList<>();
        MemberEntity memberEntity = MemberEntity.toMemberEntity(member);
        memberEntities.add(memberEntity);
        when(memberDAO.searchMemberEntitiesByMember(member)).thenReturn(memberEntities);

        // when
        List<MemberEntity> response = memberService.searchMemberEntitiesByMember(member);

        // then
        assert response.equals(memberEntities);
    }


    public static Member givenMember(){
        return Member.builder().id("id").passWord("pwd").name("name").email("email")
                .address("address").phoneNumber("phoneNumber").build();
    }

    public static LoginMember givenLoginMember(){
        return LoginMember.builder().id("id").passWord("pwd").build();
    }

    public static DeleteMember givenDeleteMember(){
        return DeleteMember.builder().build();
    }

    public static void thenErrorMessageShouldBeEquals(String originalErrorMessage, String receivedErrorMessage){
        assertEquals(originalErrorMessage, receivedErrorMessage);
    }


}
