package Data.DTO.Input;


import java.util.Objects;

public class LoginMember {

    private String id;

    private String passWord;

    private LoginMember(){

    }

    public static LoginMemberBuilder builder() {
        return new LoginMemberBuilder();
    }

    public static class LoginMemberBuilder {

        private final LoginMember loginMember;

        private LoginMemberBuilder() {
            this.loginMember = new LoginMember();
        }

        public LoginMemberBuilder id(String id) {
            loginMember.id = id;
            return this;
        }

        public LoginMemberBuilder passWord(String passWord) {
            loginMember.passWord = passWord;
            return this;
        }

        public LoginMember build() {
            return loginMember;
        }
    }

    public String getId() {
        return id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginMember login = (LoginMember) o;
        return Objects.equals(id, login.id) && Objects.equals(passWord, login.passWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passWord);
    }

    @Override
    public String toString() {
        return "Login{" +
                "id='" + id + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
