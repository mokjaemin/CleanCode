package Service.Impl;

import DAO.MemberDAO;
import Data.DTO.LoginMember;
import Data.DTO.Member;
import Data.Entity.MemberEntity;
import Service.MemberService;

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
    public String loginMember(LoginMember loginMember) {
        return memberDAO.loginMember(loginMember);
    }
}
