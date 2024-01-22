package Service;

import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.DTO.Output.LoginedMemberToken;
import Data.Entity.MemberEntity;

public interface MemberService {

    String registerMemberEntity(MemberEntity memberEntity);
    LoginedMemberToken createLoginMemberToken(LoginMember loginMember);
    String updateMemberEntity(MemberEntity memberEntity);

}
