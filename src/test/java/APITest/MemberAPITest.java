package APITest;

import Controller.MemberController;
import DAO.Impl.MemberDAOImpl;
import DAO.MemberDAO;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import DataBase.MemberDB;
import Service.Impl.MemberServiceImpl;
import Service.MemberService;

public class MemberAPITest {

    private static Member memberSample = Member.builder().id("id1")
            .passWord("pwd1").name("name1").phoneNumber("number1")
            .address("address1").email("email1").build();

    // Member API Init
    private static MemberDB memberDB = new MemberDB();
    private static MemberDAO memberDAO = new MemberDAOImpl(memberDB);
    private static MemberService memberService = new MemberServiceImpl(memberDAO);
    private static MemberController memberController = new MemberController(memberService);


    // Test Main
    public static void main(String[] args) {
        RegisterMemberSuccess();
        RegisterMemberFail_ExistedID();
        LoginMemberSuccess();
        LoginMemberFail_NoExistedID();
        LoginMemberFail_WrongPassword();
        UpdateMemberSuccess();
    }

    public static void RegisterMemberSuccess(){
        System.out.println("Test Method : Register Member Success");
        System.out.println(memberController.registerMember(memberSample));
        System.out.println();
    }

    public static void RegisterMemberFail_ExistedID(){
        System.out.println("Test Method : Register Member Fail : Existed ID");
        try{
            System.out.println(memberController.registerMember(memberSample));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
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

    public static void LoginMemberFail_NoExistedID(){
        System.out.println("Test Method : Login Member Fail : No Exited ID");
        try {
            LoginMember loginMemberSample = LoginMember.builder().id("WrongID").passWord(memberSample.getPassWord()).build();
            System.out.println(memberController.loginMember(loginMemberSample));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println();
        }
    }

    public static void LoginMemberFail_WrongPassword(){
        System.out.println("Test Method : Login Member Fail : Wrong Password");
        try{
            LoginMember loginMemberSample = LoginMember.builder().id(memberSample.getId()).passWord("WrongPWD").build();
            System.out.println(memberController.loginMember(loginMemberSample));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
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
}
