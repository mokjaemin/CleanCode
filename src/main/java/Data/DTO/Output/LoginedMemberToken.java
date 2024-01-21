package Data.DTO.Output;

import Data.DTO.Input.LoginMember;

public class LoginedMemberToken {

    private String accessToken;
    private String refreshToken;

    private LoginedMemberToken() {

    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public static LoginedMemberTokenBuilder builder() {
        return new LoginedMemberTokenBuilder();
    }

    @Override
    public String toString() {
        return "LoginedMemberToken{" +
                "accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }

    public static class LoginedMemberTokenBuilder {

        private final LoginedMemberToken loginedMemberToken;

        public LoginedMemberTokenBuilder() {
            this.loginedMemberToken = new LoginedMemberToken();
        }

        public LoginedMemberTokenBuilder accessToken(String accessToken) {
            loginedMemberToken.accessToken = accessToken;
            return this;
        }

        public LoginedMemberTokenBuilder refreshToken(String refreshToken) {
            loginedMemberToken.refreshToken = refreshToken;
            return this;
        }

        public LoginedMemberToken build() {
            return loginedMemberToken;
        }
    }

}
