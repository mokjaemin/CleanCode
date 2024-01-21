import Controller.MemberController;
import DAO.Impl.MemberDAOImpl;
import DAO.MemberDAO;
import Data.DTO.LoginMember;
import Data.DTO.Member;
import DataBase.MemberDB;
import Service.Impl.MemberServiceImpl;
import Service.MemberService;

public class MemberTest {

    private static Member memberSample = Member.builder().id("id1")
            .passWord("pwd1").name("name1").phoneNumber("number1")
            .address("address1").email("email1").build();

    // Member API Init
    private static MemberDB memberDB = new MemberDB();
    private static MemberDAO memberDAO = new MemberDAOImpl(memberDB);
    private static MemberService memberService = new MemberServiceImpl(memberDAO);
    private static MemberController memberController = new MemberController(memberService);


    public static void PostMemberSuccess(){
        System.out.println("Test Method : Post Member Success");
        System.out.println(memberController.postMember(memberSample));
        System.out.println();
    }

    public static void PostMemberFailExistedID(){
        System.out.println("Test Method : Post Member Fail : Existed ID");
        System.out.println(memberController.postMember(memberSample));
        System.out.println();
    }

    public static void LoginMemberSuccess(){
        System.out.println("Test Method : Login Member Success");
        LoginMember loginMemberSample = LoginMember.builder().id(memberSample.getId()).passWord(memberSample.getPassWord()).build();
        System.out.println(memberController.loginMember(loginMemberSample));
        System.out.println();
    }

    public static void LoginMemberFailNoExistedID(){
        System.out.println("Test Method : Login Member Fail : No Exited ID");
        LoginMember loginMemberSample = LoginMember.builder().id("WrongID").passWord(memberSample.getPassWord()).build();
        System.out.println(memberController.loginMember(loginMemberSample));
        System.out.println();
    }

    public static void LoginMemberFailWrongPassword(){
        System.out.println("Test Method : Login Member Fail : Wrong Password");
        LoginMember loginMemberSample = LoginMember.builder().id(memberSample.getId()).passWord("WrongPWD").build();
        System.out.println(memberController.loginMember(loginMemberSample));
        System.out.println();
    }

    public static void main(String[] args) {
        PostMemberSuccess();
        PostMemberFailExistedID();
        LoginMemberSuccess();
        LoginMemberFailNoExistedID();
        LoginMemberFailWrongPassword();
    }
}
