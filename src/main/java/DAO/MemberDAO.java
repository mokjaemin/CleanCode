package DAO;

import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.Entity.MemberEntity;

import java.util.List;

public interface MemberDAO {

    boolean isMemberRegisterValid(MemberEntity memberEntity);
    boolean isMemberLoginValid(LoginMember loginMember);
    String updateMemberEntity(MemberEntity memberEntity);
    void deleteMember(DeleteMember deleteMember);
    List<MemberEntity> searchMemberEntitiesByMember(Member member);

}
