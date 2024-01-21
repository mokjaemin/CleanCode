package DAO.Impl;

import DAO.MemberDAO;
import Data.DTO.Input.LoginMember;
import Data.Entity.MemberEntity;
import DataBase.MemberDB;
import Exception.ExistedIDException;
import Exception.NoExistedIDException;
import Exception.WrongPassWordException;

public class MemberDAOImpl implements MemberDAO {

    private final MemberDB memberDB;

    public MemberDAOImpl(MemberDB memberDB){
        this.memberDB = memberDB;
    }

    @Override
    public String postMemberEntity(MemberEntity memberEntity) throws RuntimeException {
        if(memberDB.isIDExisted(memberEntity.getId())){
            throw new ExistedIDException();
        }
        memberDB.postMemberEntity(memberEntity);
        return "회원가입 성공";
    }

    @Override
    public boolean isMemberLogined(LoginMember loginMember) throws RuntimeException {
        LoginMember savedLoginMember = memberDB.getLoginMember(loginMember);
        if(savedLoginMember == null){
            throw new NoExistedIDException();
        }
        if(!savedLoginMember.getPassWord().equals(loginMember.getPassWord())){
            throw new WrongPassWordException();
        }
        return true;
    }


}
