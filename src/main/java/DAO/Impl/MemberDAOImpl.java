package DAO.Impl;

import DAO.MemberDAO;
import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.Entity.MemberEntity;
import DataBase.Impl.MemberDBImpl;
import DataBase.MemberDB;
import Exception.RegisteredIDException;
import Exception.NoRegisteredIDException;
import Exception.InvalidPassWordException;

import java.util.List;

public class MemberDAOImpl implements MemberDAO {

    private final MemberDB memberDB;

    public MemberDAOImpl(MemberDB memberDB){
        this.memberDB = memberDB;
    }

    @Override
    public boolean isMemberRegisterValid(MemberEntity memberEntity) {
        if(memberDB.isIDRegistered(memberEntity.getId())){
            throw new RegisteredIDException();
        }
        return true;
    }

    public void registerMemberEntity(MemberEntity memberEntity){
        memberDB.registerMemberEntity(memberEntity);
    }

    @Override
    public boolean isMemberLoginValid(LoginMember loginMember) {
        LoginMember registeredLoginMember = memberDB.getRegisteredLoginMember(loginMember);
        if(registeredLoginMember == null){
            throw new NoRegisteredIDException();
        }
        else if(!registeredLoginMember.getPassWord().equals(loginMember.getPassWord())){
            throw new InvalidPassWordException();
        }
        else{
            return true;
        }
    }

    @Override
    public String updateMemberEntity(MemberEntity memberEntity) {
        memberDB.removeMemberEntityByID(memberEntity.getId());
        memberDB.registerMemberEntity(memberEntity);
        return "success";
    }

    @Override
    public void deleteMember(DeleteMember deleteMember) {
        if(!memberDB.isDeleteMemberValid(deleteMember)){
            throw new InvalidPassWordException();
        }
        memberDB.removeMemberEntityByID(deleteMember.getId());
    }

    @Override
    public List<MemberEntity> searchMemberEntitiesByMember(Member member) {
        return memberDB.searchMemberEntitiesByMember(member);
    }


}
