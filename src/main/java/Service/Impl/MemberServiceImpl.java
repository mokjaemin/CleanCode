package Service.Impl;

import DAO.MemberDAO;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.DTO.Output.LoginedMemberToken;
import Data.Entity.MemberEntity;
import Service.MemberService;
import Util.JwtUtil;

public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    public MemberServiceImpl(MemberDAO memberDAO){
        this.memberDAO = memberDAO;
    }

    @Override
    public String postMember(Member member) {
        return memberDAO.postMemberEntity(MemberEntity.toMemberEntity(member));
    }

    @Override
    public LoginedMemberToken getLoginMemberToken(LoginMember loginMember) throws RuntimeException {
        if(memberDAO.isMemberLogined(loginMember)){
            return JwtUtil.getLoginedMemberToken();
        }
        throw new RuntimeException("로그인 중 서버 오류 발생");
    }
}
