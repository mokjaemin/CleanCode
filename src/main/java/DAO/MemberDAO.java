package DAO;

import Data.DTO.LoginMember;
import Data.Entity.MemberEntity;

public interface MemberDAO {

    String postMemberEntity(MemberEntity memberEntity);
    String loginMember(LoginMember loginMember);

}
