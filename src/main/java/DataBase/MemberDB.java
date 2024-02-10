package DataBase;

import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.Entity.MemberEntity;

import java.util.List;

public interface MemberDB {

    boolean isIDRegistered(String id);
    void registerMemberEntity(MemberEntity memberEntity);
    LoginMember getRegisteredLoginMember(LoginMember loginMember);
    void removeMemberEntityByID(String id);
    boolean isDeleteMemberValid(DeleteMember deleteMember);
    List<MemberEntity> searchMemberEntitiesByMember(Member member);


}
