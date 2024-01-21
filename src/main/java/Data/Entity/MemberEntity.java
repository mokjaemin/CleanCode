package Data.Entity;


import Data.DTO.Input.Member;

public class MemberEntity {

    private String id;
    private String passWord;
    private String name;
    private String phoneNumber;
    private String address;
    private String email;

    private MemberEntity(){

    }

    public static MemberEntityBuilder builder() {
        return new MemberEntityBuilder();
    }

    public static class MemberEntityBuilder {

        private final MemberEntity memberEntity;

        private MemberEntityBuilder() {
            this.memberEntity = new MemberEntity();
        }

        public MemberEntityBuilder id(String id) {
            memberEntity.id = id;
            return this;
        }

        public MemberEntityBuilder passWord(String passWord) {
            memberEntity.passWord = passWord;
            return this;
        }

        public MemberEntityBuilder name(String name) {
            memberEntity.name = name;
            return this;
        }

        public MemberEntityBuilder phoneNumber(String phoneNumber) {
            memberEntity.phoneNumber = phoneNumber;
            return this;
        }

        public MemberEntityBuilder address(String address) {
            memberEntity.address = address;
            return this;
        }

        public MemberEntityBuilder email(String email) {
            memberEntity.email = email;
            return this;
        }

        public MemberEntity build() {
            // 필요한 경우 추가적인 유효성 검사 등을 수행할 수 있음
            return memberEntity;
        }
    }

    public static MemberEntity toMemberEntity(Member member) {
        return MemberEntity.builder().id(member.getId()).passWord(member.getPassWord())
                .name(member.getName()).phoneNumber(member.getPhoneNumber())
                .address(member.getAddress()).email(member.getEmail()).build();
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
    public String toString() {
        return "MemberEntity{" +
                "id='" + id + '\'' +
                ", passWord='" + passWord + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
