package Data.DTO;


import java.util.Objects;

public class Member {

    private String id;
    private String passWord;
    private String name;
    private String phoneNumber;
    private String address;
    private String email;

    private Member(){

    }

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    public static class MemberBuilder {

        private final Member member;

        private MemberBuilder() {
            this.member = new Member();
        }

        public MemberBuilder id(String id) {
            member.id = id;
            return this;
        }

        public MemberBuilder passWord(String passWord) {
            member.passWord = passWord;
            return this;
        }

        public MemberBuilder name(String name) {
            member.name = name;
            return this;
        }

        public MemberBuilder phoneNumber(String phoneNumber) {
            member.phoneNumber = phoneNumber;
            return this;
        }

        public MemberBuilder address(String address) {
            member.address = address;
            return this;
        }

        public MemberBuilder email(String email) {
            member.email = email;
            return this;
        }

        public Member build() {
            // 필요한 경우 추가적인 유효성 검사 등을 수행할 수 있음
            return member;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(passWord, member.passWord) && Objects.equals(name, member.name) && Objects.equals(phoneNumber, member.phoneNumber) && Objects.equals(address, member.address) && Objects.equals(email, member.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passWord, name, phoneNumber, address, email);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", passWord='" + passWord + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
