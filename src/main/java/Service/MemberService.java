package Service;

import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.DTO.Output.LoginedMemberToken;
import Data.Entity.MemberEntity;

public interface MemberService {

    void registerMemberEntity(MemberEntity memberEntity);
    LoginedMemberToken createLoginMemberToken(LoginMember loginMember);
    void updateMemberEntity(MemberEntity memberEntity);
    void deleteMember(DeleteMember deleteMember);

}
