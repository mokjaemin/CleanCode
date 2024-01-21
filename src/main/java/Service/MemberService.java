package Service;

import Data.DTO.LoginMember;
import Data.DTO.Member;

public interface MemberService {

    String postMember(Member member);
    String loginMember(LoginMember loginMember);

}
