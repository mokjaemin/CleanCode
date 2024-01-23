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
    public String registerMemberEntity(MemberEntity memberEntity) {
        if(memberDAO.isMemberRegisterValid(memberEntity)){
            return "success";
        }
        else{
            throw new RuntimeException("회원가입 중 서버 오류 발생");
        }
    }

    @Override
    public LoginedMemberToken createLoginMemberToken(LoginMember loginMember){
        if(memberDAO.isMemberLoginValid(loginMember)){
            return JwtUtil.getLoginedMemberToken();
        }
        else{
            throw new RuntimeException("로그인 중 서버 오류 발생");
        }
    }

    @Override
    public String updateMemberEntity(MemberEntity memberEntity) {
        String updateMemebrEntityResult = memberDAO.updateMemberEntity(memberEntity);
        return updateMemebrEntityResult;
    }
}
