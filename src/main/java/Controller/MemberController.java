package Controller;

import Data.DTO.Input.DeleteMember;
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
        memberService.registerMemberEntity(memberEntity);
        return "success";
    }

    public LoginedMemberToken loginMember(LoginMember loginMember){
        LoginedMemberToken loginedMemberToken = memberService.createLoginMemberToken(loginMember);
        return loginedMemberToken;
    }

    public String updateMember(Member member){
        MemberEntity memberEntity = MemberEntity.toMemberEntity(member);
        memberService.updateMemberEntity(memberEntity);
        return "success";
    }

    public String deleteMember(DeleteMember deleteMember){
        memberService.deleteMember(deleteMember);
        return "success";
    }

}
