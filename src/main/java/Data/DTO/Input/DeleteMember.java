package Data.DTO.Input;

import java.util.Objects;

public class DeleteMember {
    private String id;

    private String passWord;

    private DeleteMember(){

    }

    public static DeleteMember.DeleteMemberBuilder builder() {
        return new DeleteMember.DeleteMemberBuilder();
    }

    public static class DeleteMemberBuilder {

        private final DeleteMember deleteMember;

        private DeleteMemberBuilder() {
            this.deleteMember = new DeleteMember();
        }

        public DeleteMember.DeleteMemberBuilder id(String id) {
            deleteMember.id = id;
            return this;
        }

        public DeleteMember.DeleteMemberBuilder passWord(String passWord) {
            deleteMember.passWord = passWord;
            return this;
        }

        public DeleteMember build() {
            return deleteMember;
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
        DeleteMember Delete = (DeleteMember) o;
        return Objects.equals(id, Delete.id) && Objects.equals(passWord, Delete.passWord);
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
