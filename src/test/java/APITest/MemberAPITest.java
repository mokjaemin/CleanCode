package APITest;

import Controller.MemberController;
import DAO.Impl.MemberDAOImpl;
import DAO.MemberDAO;
import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.Entity.MemberEntity;
import DataBase.MemberDB;
import Service.Impl.MemberServiceImpl;
import Service.MemberService;

import java.util.List;

public class MemberAPITest {

    private static Member memberSample = Member.builder().id("id1")
            .passWord("pwd1").name("name1").phoneNumber("number1")
            .address("address1").email("email1").build();
    private static DeleteMember deleteMember = DeleteMember.builder().id("id1").passWord("pwd1").build();

    // Member API Init
    private static MemberDB memberDB = new MemberDB();
    private static MemberDAO memberDAO = new MemberDAOImpl(memberDB);
    private static MemberService memberService = new MemberServiceImpl(memberDAO);
    private static MemberController memberController = new MemberController(memberService);


    // Test Main
    public static void main(String[] args) {
        RegisterMemberSuccess();
        RegisterMemberFail_RegisteredIDException();
        LoginMemberSuccess();
        LoginMemberFail_NoRegisteredIDException();
        LoginMemberFail_InvalidPasswordException();
        UpdateMemberSuccess();
        DeleteMemberSuccess();
        DeleteMemberFail_InvalidPasswordException();
        SearchMemberEntitySuccess();
        SearchMemberEntityFail_NoMemberEntityInCondition();
    }

    public static void RegisterMemberSuccess(){
        System.out.println("Test Method : Register Member Success");
        System.out.println(memberController.registerMember(memberSample));
        System.out.println();
    }

    public static void RegisterMemberFail_RegisteredIDException(){
        System.out.println("Test Method : Register Member Fail : RegisteredIDException");
        try{
            System.out.println(memberController.registerMember(memberSample));
        }
        catch (RuntimeException e){
            printExceptionMessage(e);
        }
        finally {
            System.out.println();
        }
    }

    public static void LoginMemberSuccess(){
        System.out.println("Test Method : Login Member Success");
        LoginMember loginMemberSample = LoginMember.builder().id(memberSample.getId()).passWord(memberSample.getPassWord()).build();
        System.out.println(memberController.loginMember(loginMemberSample));
        System.out.println();
    }

    public static void LoginMemberFail_NoRegisteredIDException(){
        System.out.println("Test Method : Login Member Fail : NoRegisteredIDException");
        try {
            LoginMember loginMemberSample = LoginMember.builder().id("WrongID").passWord(memberSample.getPassWord()).build();
            System.out.println(memberController.loginMember(loginMemberSample));
        }
        catch (RuntimeException e){
            printExceptionMessage(e);
        }
        finally {
            System.out.println();
        }
    }

    public static void LoginMemberFail_InvalidPasswordException(){
        System.out.println("Test Method : Login Member Fail : InvalidPasswordException");
        try{
            LoginMember loginMemberSample = LoginMember.builder().id(memberSample.getId()).passWord("WrongPWD").build();
            System.out.println(memberController.loginMember(loginMemberSample));
        }
        catch (RuntimeException e){
            printExceptionMessage(e);
        }
        finally {
            System.out.println();
        }
    }

    public static void UpdateMemberSuccess(){
        System.out.println("Test Method : Update Member Success");
        System.out.println(memberController.updateMember(memberSample));
        System.out.println();
    }

    public static void DeleteMemberSuccess(){
        System.out.println("Test Method : Delete Member Success");
        System.out.println(memberController.deleteMember(deleteMember));
        System.out.println("----Delete Member Init----");
        RegisterMemberSuccess();
        System.out.println();
    }

    public static void DeleteMemberFail_InvalidPasswordException(){
        System.out.println("Test Method : Delete Member Fail : InvalidPasswordException");
        try{
            DeleteMember wrongDeleteMember = DeleteMember.builder().id("id1").passWord("pwd2").build();
            System.out.println(memberController.deleteMember(wrongDeleteMember));
        }
        catch (RuntimeException e){
            printExceptionMessage(e);
        }
        finally {
            System.out.println();
        }
    }

    public static void SearchMemberEntitySuccess(){
        System.out.println("Test Method : Search MemberEntity Success");
        System.out.println(memberController.searchMemberEntitiesByMember(memberSample));
        System.out.println();
    }

    public static void SearchMemberEntityFail_NoMemberEntityInCondition(){
        System.out.println("Test Method : Search MemberEntity Fail : NoMemberEntityInCondition");
        String originalId = memberSample.getId();
        try{
            memberSample.setId(null);
            System.out.println(memberController.searchMemberEntitiesByMember(memberSample));
        }
        catch (RuntimeException e){
            printExceptionMessage(e);
        }
        finally {
            memberSample.setId(originalId);
            System.out.println();
        }
    }

    public static void printExceptionMessage(Exception e){
        System.out.println(e.getMessage());
    }
}
