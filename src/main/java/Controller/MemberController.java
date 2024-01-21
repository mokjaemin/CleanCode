package Controller;

import Data.DTO.LoginMember;
import Data.DTO.Member;
import Service.MemberService;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    public String postMember(Member member){
        return memberService.postMember(member);
    }

    public String loginMember(LoginMember loginMember){
        return memberService.loginMember(loginMember);
    }

}
