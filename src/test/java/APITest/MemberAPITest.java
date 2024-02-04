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

    // Member API Init
    private static MemberDB memberDB = new MemberDB();
    private static MemberDAO memberDAO = new MemberDAOImpl(memberDB);
    private static MemberService memberService = new MemberServiceImpl(memberDAO);
    private static MemberController memberController = new MemberController(memberService);


    // Test Main
    public static void main(String[] args) {

    }

    public static void printExceptionMessage(Exception e){
        System.out.println(e.getMessage());
    }
}
