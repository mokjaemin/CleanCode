package Util;

import Data.DTO.Output.LoginedMemberToken;

public class JwtUtil {

    private JwtUtil() {
        throw new AssertionError();
    }

    public static String createAccessToken(){
        return "AccessToken";
    }

    public static String createRefreshToken(){
        return "RefreshToken";
    }

    public static LoginedMemberToken getLoginedMemberToken(){
        return LoginedMemberToken.builder().accessToken(createAccessToken())
                .refreshToken(createRefreshToken()).build();
    }

}
