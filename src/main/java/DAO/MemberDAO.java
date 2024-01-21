package DAO;

import Data.DTO.Input.LoginMember;
import Data.Entity.MemberEntity;

public interface MemberDAO {

    String postMemberEntity(MemberEntity memberEntity);
    boolean isMemberLogined(LoginMember loginMember);

}
