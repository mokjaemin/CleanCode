package APITest;

import Controller.MemberController;
import DAO.Impl.MemberDAOImpl;
import DAO.MemberDAO;
import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.DTO.Output.LoginedMemberToken;
import Data.Entity.MemberEntity;
import DataBase.Impl.MemberDBImpl;
import Service.Impl.MemberServiceImpl;
import Service.MemberService;
import TestUtil.MemberTestUtil;
import org.junit.jupiter.api.Test;
import Exception.RegisteredIDException;
import Exception.NoRegisteredIDException;
import Exception.InvalidPassWordException;
import Exception.NoMemberEntityInCondition;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberAPITest {


    // Member API Init
    private static MemberDBImpl memberDB = new MemberDBImpl();
    private static MemberDAO memberDAO = new MemberDAOImpl(memberDB);
    private static MemberService memberService = new MemberServiceImpl(memberDAO);
    private static MemberController memberController = new MemberController(memberService);


    // Process
    // given - when - then - init
    // Then : Check Response, Transition, Result
    // Each Test Should Check 'Then' Only One Time

    @Test
    public void registerMemeberSuccess(){
        // Given
        Member member = MemberTestUtil.givenMember();

        // When
        memberController.registerMember(member);

        // Then
        thenCheckMemberRegisteredById(member.getId());

        // Init
        initMemberDBByRegisteredId(member.getId());
    }


    @Test
    public void registerMemeberFail_RegisteredIDException(){
        // Given
        Member member = MemberTestUtil.givenMember();
        givenMemberRegisteredAndCheckValid(member);

        try{
            // When
            memberController.registerMember(member);
        }
        catch (RuntimeException e){
            // Then
            MemberTestUtil.thenErrorMessageShouldBeEquals(RegisteredIDException.message, e.getMessage());
        }
        finally {
            // Init
            initMemberDBByRegisteredId(member.getId());
        }
    }

    @Test
    public void loginMemberSueccess(){
        // Given
        Member member = MemberTestUtil.givenMember();
        givenMemberRegisteredAndCheckValid(member);
        LoginMember loginMember = givenLoginMemberByMember(member);

        // When
        LoginedMemberToken loginedMemberToken = memberController.loginMember(loginMember);

        // Then
        assert loginedMemberToken instanceof LoginedMemberToken;

        // Init
        initMemberDBByRegisteredId(member.getId());
    }

    @Test
    public void loginMemberFail_NoRegisteredIDException(){
        // Given
        Member member = MemberTestUtil.givenMember();
        givenMemberRegisteredAndCheckValid(member);
        LoginMember loginMember = givenLoginMemberByMember(member);
        loginMember.setId("WrongID");

        try {
            // When
            memberController.loginMember(loginMember);
        }
        catch (RuntimeException e){
            // Then
            MemberTestUtil.thenErrorMessageShouldBeEquals(NoRegisteredIDException.message, e.getMessage());
        }
        finally {
            // Init
            initMemberDBByRegisteredId(member.getId());
        }
    }

    @Test
    public void loginMemberFail_InvalidPassWordException(){
        // Given
        Member member = MemberTestUtil.givenMember();
        givenMemberRegisteredAndCheckValid(member);
        LoginMember loginMember = givenLoginMemberByMember(member);
        loginMember.setPassWord("WrongPassword");

        try {
            // When
            memberController.loginMember(loginMember);
        }
        catch (RuntimeException e){
            // Then
            MemberTestUtil.thenErrorMessageShouldBeEquals(InvalidPassWordException.message, e.getMessage());
        }
        finally {
            // Init
            initMemberDBByRegisteredId(member.getId());
        }
    }

    @Test
    public void updateMemberSuccess(){
        // Given
        Member member = MemberTestUtil.givenMember();
        givenMemberRegisteredAndCheckValid(member);
        String changedName = "Changed Name";
        Member changedMember = changeMemberName(member, changedName);

        // When
        String response = memberController.updateMember(changedMember);

        // Then
        thenCheckMemberRegisteredById(member.getId());
        assertEquals(response, "success");

        // init
        initMemberDBByRegisteredId(member.getId());
    }

    @Test
    public void DeleteMemberSuccess(){
        // Given
        Member member = MemberTestUtil.givenMember();
        givenMemberRegisteredAndCheckValid(member);
        DeleteMember deleteMember = givenDeleteMemberByMember(member);

        // When
        String response = memberController.deleteMember(deleteMember);

        // Then
        thenCheckMemberDeletedById(deleteMember.getId());
        assertEquals(response, "success");
    }

    @Test
    public void DeleteMemberFail_InvalidPassWordException(){
        // Given
        Member member = MemberTestUtil.givenMember();
        givenMemberRegisteredAndCheckValid(member);
        DeleteMember deleteMember = givenDeleteMemberByMember(member);
        String wrodPwd = "Wrong Pwd";
        deleteMember.setPassWord(wrodPwd);

        try {
            // When
            String response = memberController.deleteMember(deleteMember);
        }
        catch (RuntimeException e){
            MemberTestUtil.thenErrorMessageShouldBeEquals(InvalidPassWordException.message, e.getMessage());
        }
        finally {
            // init
            initMemberDBByRegisteredId(member.getId());
        }
    }

    @Test
    public void SearchMemberSuccess(){
        // Given
        Member member = MemberTestUtil.givenMember();
        givenMemberRegisteredAndCheckValid(member);

        // When
        List<MemberEntity> memberEntities = memberController.searchMemberEntitiesByMember(member);

        // Then
        assert thenMemberEntitiesHaveThisMember(memberEntities, member);

        // Init
        initMemberDBByRegisteredId(member.getId());
    }

    @Test
    public void SearchMemberFail_NoMemberEntityInCondition(){
        // Given
        Member member = MemberTestUtil.givenMember();
        givenMemberRegisteredAndCheckValid(member);
        String originalId = member.getId();
        member.setId("Wrong ID");

        try {
            // When
            List<MemberEntity> memberEntities = memberController.searchMemberEntitiesByMember(member);
        }
        catch (RuntimeException e){
            // Then
            MemberTestUtil.thenErrorMessageShouldBeEquals(NoMemberEntityInCondition.message, e.getMessage());
        }
        finally {
            // Init
            initMemberDBByRegisteredId(originalId);
        }
    }




    // Given Method

    private static LoginMember givenLoginMemberByMember(Member member){
        return LoginMember.builder().id(member.getId()).passWord(member.getPassWord()).build();
    }

    private static DeleteMember givenDeleteMemberByMember(Member member){
        return DeleteMember.builder().id(member.getId()).passWord(member.getPassWord()).build();
    }

    private static void givenMemberRegisteredAndCheckValid(Member member){
        memberController.registerMember(member);
        thenCheckMemberRegisteredById(member.getId());
    }

    private static Member changeMemberName(Member member, String name){
        member.setName(name);
        return member;
    }


    // Then Method
    private static void thenCheckMemberRegisteredById(String id){
        assert memberDB.isIDRegistered(id);
    }

    private static void thenCheckMemberDeletedById(String id){
        assert !memberDB.isIDRegistered(id);
    }

    private static boolean thenMemberEntitiesHaveThisMember(List<MemberEntity> memberEntities, Member member){
        for(MemberEntity memberEntity : memberEntities){
            if(memberEntity.getId().equals(member.getId())){
                return true;
            }
        }
        return false;
    }



    // Init Method
    private static void initMemberDBByRegisteredId(String id){
        memberDB.removeMemberEntityByID(id);
    }




}
