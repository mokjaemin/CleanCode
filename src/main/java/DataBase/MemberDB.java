package DataBase;

import Data.DTO.Input.LoginMember;
import Data.Entity.MemberEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberDB {

    private static List<MemberEntity> memberEntities = new ArrayList<>();

    public MemberDB(){

    }

    public static boolean isIDExisted(String id){
        for(MemberEntity memberEntity : memberEntities){
            if(memberEntity.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public static void postMemberEntity(MemberEntity memberEntity){
        memberEntities.add(memberEntity);
    }

    public static LoginMember getLoginMember(LoginMember loginMember){
        Optional<MemberEntity> savedMemberEntity = memberEntities.stream()
                .filter(entity -> entity.getId().equals(loginMember.getId()))
                .findFirst();
        if(savedMemberEntity.isPresent()){
            return LoginMember.builder().id(savedMemberEntity.get().getId())
                    .passWord(savedMemberEntity.get().getPassWord()).build();
        }
        return null;
    }


}
