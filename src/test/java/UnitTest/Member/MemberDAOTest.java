package UnitTest.Member;

import DAO.Impl.MemberDAOImpl;
import DAO.MemberDAO;
import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.Entity.MemberEntity;
import DataBase.Impl.MemberDBImpl;
import DataBase.MemberDB;
import TestUtil.MemberTestUtil;
import org.junit.jupiter.api.Test;
import Exception.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MemberDAOTest {

    MemberDB memberDB = mock(MemberDBImpl.class);
    MemberDAO memberDAO = new MemberDAOImpl(memberDB);

    @Test
    public void isMemberRegisteredSuccess(){
        // Given
        MemberEntity memberEntity = MemberTestUtil.givenMemberEntity();
        when(memberDB.isIDRegistered(memberEntity.getId())).thenReturn(false);

        // When
        boolean response = memberDAO.isMemberRegisterValid(memberEntity);

        // Then
        assert response;
    }

    @Test
    public void isMemberRegisteredFail_RegisteredIDException(){
        // Given
        MemberEntity memberEntity = MemberTestUtil.givenMemberEntity();
        when(memberDB.isIDRegistered(memberEntity.getId())).thenReturn(true);

        try{
            // When
            memberDAO.isMemberRegisterValid(memberEntity);
        }
        catch (RuntimeException e){
            // Then
            MemberTestUtil.thenErrorMessageShouldBeEquals(RegisteredIDException.message, e.getMessage());
        }
    }


    @Test
    public void registerMemberEntitySuccess(){
        // Given
        MemberEntity memberEntity = MemberTestUtil.givenMemberEntity();

        // When
        memberDAO.registerMemberEntity(memberEntity);

        // Then
        verify(memberDB, times(1)).registerMemberEntity(memberEntity);
    }

    @Test
    public void isMemberLoginValidSuccess(){
        // Given
        LoginMember loginMember = MemberTestUtil.givenLoginMember();
        when(memberDB.getRegisteredLoginMember(loginMember)).thenReturn(loginMember);

        // When
        boolean response = memberDAO.isMemberLoginValid(loginMember);

        // Then
        assert response;
    }

    @Test
    public void isMemberLoginValidFail_NoRegisteredIDException(){
        // Given
        LoginMember loginMember = MemberTestUtil.givenLoginMember();
        when(memberDB.getRegisteredLoginMember(loginMember)).thenReturn(null);

        try {
            // When
            memberDAO.isMemberLoginValid(loginMember);
        }
        catch (RuntimeException e){
            MemberTestUtil.thenErrorMessageShouldBeEquals(NoRegisteredIDException.message, e.getMessage());
        }
    }

    @Test
    public void isMemberLoginValidFail_InvalidPassWordException(){
        // Given
        LoginMember loginMember = MemberTestUtil.givenLoginMember();
        LoginMember getLoginMember = MemberTestUtil.givenLoginMember();
        getLoginMember.setPassWord("Wrong PWD");
        when(memberDB.getRegisteredLoginMember(loginMember)).thenReturn(getLoginMember);

        try {
            // When
            memberDAO.isMemberLoginValid(loginMember);
        }
        catch (RuntimeException e){
            MemberTestUtil.thenErrorMessageShouldBeEquals(InvalidPassWordException.message, e.getMessage());
        }
    }

    @Test
    public void updateMemberEntitySuccess(){
        // Given
        MemberEntity memberEntity = MemberTestUtil.givenMemberEntity();

        // When
        memberDAO.updateMemberEntity(memberEntity);

        // Then
        verify(memberDB, times(1)).removeMemberEntityByID(memberEntity.getId());
        verify(memberDB, times(1)).registerMemberEntity(memberEntity);
    }

    @Test
    public void deleteMemberSuccess(){
        // Given
        DeleteMember deleteMember = MemberTestUtil.givenDeleteMember();
        when(memberDB.isDeleteMemberValid(deleteMember)).thenReturn(true);

        // When
        memberDAO.deleteMember(deleteMember);

        // Then
        verify(memberDB, times(1)).removeMemberEntityByID(deleteMember.getId());

    }

    @Test
    public void deleteMemberFail_InvalidPassWordException(){
        // Given
        DeleteMember deleteMember = MemberTestUtil.givenDeleteMember();
        when(memberDB.isDeleteMemberValid(deleteMember)).thenReturn(false);

        try{
            // When
            memberDAO.deleteMember(deleteMember);
        }
        catch (RuntimeException e){
            MemberTestUtil.thenErrorMessageShouldBeEquals(InvalidPassWordException.message, e.getMessage());
        }

    }

    @Test
    public void searchMemberEntitiesByMemberSuccess(){
        // Given
        Member member = MemberTestUtil.givenMember();
        List<MemberEntity> memberEntities = new ArrayList<>();
        when(memberDB.searchMemberEntitiesByMember(member)).thenReturn(memberEntities);

        // When
        List<MemberEntity> response = memberDAO.searchMemberEntitiesByMember(member);

        // Then
        assert response.equals(memberEntities);
    }



}
