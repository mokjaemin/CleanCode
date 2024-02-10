package UnitTest.Member;

import Controller.MemberController;
import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.DTO.Output.LoginedMemberToken;
import Data.Entity.MemberEntity;
import Service.Impl.MemberServiceImpl;
import Service.MemberService;
import TestUtil.MemberTestUtil;
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
        Member member = MemberTestUtil.givenMember();

        // when
        String response = memberController.registerMember(member);

        // then
        assert response.equals("success");
    }

    @Test
    public void loginMemberSuccessTest(){
        // Given
        LoginMember loginMember = MemberTestUtil.givenLoginMember();
        LoginedMemberToken loginedMemberToken = MemberTestUtil.givenLoginedMemberToken();
        when(memberService.createLoginMemberToken(loginMember)).thenReturn(loginedMemberToken);

        // When
        LoginedMemberToken response = memberController.loginMember(loginMember);

        // Then
        assert loginedMemberToken.equals(response);
    }


    @Test
    public void updateMemberSuccessTest(){
        // Given
        Member member = MemberTestUtil.givenMember();

        // when
        String response = memberController.updateMember(member);

        // then
        assert response.equals("success");
    }

    @Test
    public void deleteMemberSuccessTest(){
        // Given
        DeleteMember deleteMember = MemberTestUtil.givenDeleteMember();

        // when
        String response = memberController.deleteMember(deleteMember);

        // then
        assert response.equals("success");
    }

    @Test
    public void searchMemberSuccessTest(){
        // Given
        Member member = MemberTestUtil.givenMember();
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
        Member member = MemberTestUtil.givenMember();
        List<MemberEntity> emptyList = Collections.emptyList();
        when(memberService.searchMemberEntitiesByMember(member)).thenReturn(emptyList);


        try{
            // when
            memberController.searchMemberEntitiesByMember(member);
        }
        catch (RuntimeException e){
            // Then
            MemberTestUtil.thenErrorMessageShouldBeEquals(NoMemberEntityInCondition.message, e.getMessage());
        }
    }


}
