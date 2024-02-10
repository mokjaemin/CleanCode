package UnitTest.Member;

import DAO.Impl.MemberDAOImpl;
import DAO.MemberDAO;
import Data.Entity.MemberEntity;
import DataBase.Impl.MemberDBImpl;
import DataBase.MemberDB;
import TestUtil.MemberTestUtil;
import org.junit.jupiter.api.Test;
import Exception.*;

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





}
