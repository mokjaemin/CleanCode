package Controller;

import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.DTO.Output.LoginedMemberToken;
import Service.MemberService;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    public String postMember(Member member){
        return memberService.postMember(member);
    }

    public LoginedMemberToken loginMember(LoginMember loginMember){
        return memberService.getLoginMemberToken(loginMember);
    }

}
