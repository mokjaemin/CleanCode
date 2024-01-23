package Controller;

import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.DTO.Output.LoginedMemberToken;
import Data.Entity.MemberEntity;
import Service.MemberService;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    public String registerMember(Member member){
        MemberEntity memberEntity = MemberEntity.toMemberEntity(member);
        String registerMemberResult = memberService.registerMemberEntity(memberEntity);
        return registerMemberResult;
    }

    public LoginedMemberToken loginMember(LoginMember loginMember){
        LoginedMemberToken loginedMemberToken = memberService.createLoginMemberToken(loginMember);
        return loginedMemberToken;
    }

    public String updateMember(Member member){
        MemberEntity memberEntity = MemberEntity.toMemberEntity(member);
        String updateMemberEntityResult = memberService.updateMemberEntity(memberEntity);
        return updateMemberEntityResult;
    }

}
