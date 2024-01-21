package DAO.Impl;

import DAO.MemberDAO;
import Data.DTO.LoginMember;
import Data.Entity.MemberEntity;
import DataBase.MemberDB;

public class MemberDAOImpl implements MemberDAO {

    private final MemberDB memberDB;

    public MemberDAOImpl(MemberDB memberDB){
        this.memberDB = memberDB;
    }

    @Override
    public String postMemberEntity(MemberEntity memberEntity) {
        if(memberDB.isIDExisted(memberEntity.getId())){
            return "이미 존재하는 아이디입니다.";
        }
        memberDB.postMemberEntity(memberEntity);
        return "회원가입 성공";
    }

    @Override
    public String loginMember(LoginMember loginMember) {
        LoginMember savedLoginMember = memberDB.getLoginMember(loginMember);
        if(savedLoginMember == null){
            return "존재하지 않는 아이디입니다.";
        }
        if(!savedLoginMember.getPassWord().equals(loginMember.getPassWord())){
            return "비밀번호가 틀립니다.";
        }
        return "로그인 성공";
    }


}
