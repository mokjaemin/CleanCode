package Service.Impl;

import DAO.MemberDAO;
import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.DTO.Output.LoginedMemberToken;
import Data.Entity.MemberEntity;
import Service.MemberService;
import Util.JwtUtil;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    public MemberServiceImpl(MemberDAO memberDAO){
        this.memberDAO = memberDAO;
    }

    @Override
    public void registerMemberEntity(MemberEntity memberEntity) {
        if(memberDAO.isMemberRegisterValid(memberEntity)){
            memberDAO.registerMemberEntity(memberEntity);
        }
    }

    @Override
    public LoginedMemberToken createLoginMemberToken(LoginMember loginMember){
        if(memberDAO.isMemberLoginValid(loginMember)){
            return JwtUtil.getLoginedMemberToken();
        }
        else{
            throw new RuntimeException("로그인 오류");
        }
    }

    @Override
    public void updateMemberEntity(MemberEntity memberEntity) {
        memberDAO.updateMemberEntity(memberEntity);
    }

    @Override
    public void deleteMember(DeleteMember deleteMember) {
        memberDAO.deleteMember(deleteMember);
    }

    @Override
    public List<MemberEntity> searchMemberEntitiesByMember(Member member) {
        return memberDAO.searchMemberEntitiesByMember(member);
    }


}
