package DAO;

import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.Entity.MemberEntity;

public interface MemberDAO {

    boolean isMemberRegisterValid(MemberEntity memberEntity);
    boolean isMemberLoginValid(LoginMember loginMember);
    String updateMemberEntity(MemberEntity memberEntity);

}
