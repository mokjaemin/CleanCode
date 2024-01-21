package Service;

import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.DTO.Output.LoginedMemberToken;

public interface MemberService {

    String postMember(Member member);
    LoginedMemberToken getLoginMemberToken(LoginMember loginMember);

}
