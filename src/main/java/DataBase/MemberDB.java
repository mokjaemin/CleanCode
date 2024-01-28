package DataBase;

import Data.DTO.Input.DeleteMember;
import Data.DTO.Input.LoginMember;
import Data.DTO.Input.Member;
import Data.Entity.MemberEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberDB {

    private static List<MemberEntity> memberEntities = new ArrayList<>();

    public static boolean isIDRegistered(String id){
        for(MemberEntity memberEntity : memberEntities){
            if(memberEntity.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public static void registerMemberEntity(MemberEntity memberEntity){
        memberEntities.add(memberEntity);
    }

    public static LoginMember getRegisteredLoginMember(LoginMember loginMember){
        Optional<MemberEntity> registeredMemberEntity = memberEntities.stream()
                .filter(entity -> entity.getId().equals(loginMember.getId()))
                .findFirst();
        if(registeredMemberEntity.isPresent()){
            return LoginMember.builder().id(registeredMemberEntity.get().getId())
                    .passWord(registeredMemberEntity.get().getPassWord()).build();
        }
        else{
            return null;
        }
    }

    public static void removeMemberEntityByID(String id){
        for(int i=0; i<memberEntities.size(); i++){
            if(memberEntities.get(i).getId().equals(id)){
                memberEntities.remove(i);
                return;
            }
        }
    }

    public static boolean isDeleteMemberValid(DeleteMember deleteMember){
        for(MemberEntity memberEntity : memberEntities){
            if(memberEntity.getId().equals(deleteMember.getId())
                    && memberEntity.getPassWord().equals(deleteMember.getPassWord())){
                return true;
            }
        }
        return false;
    }

    public List<MemberEntity> searchMemberEntitiesByMember(Member member){
        List<MemberEntity> result = new ArrayList<>();
        for(MemberEntity memberEntity : memberEntities){
            if(!memberEntity.getId().equals(member.getId())){
                continue;
            }
            if(!memberEntity.getAddress().equals(member.getAddress())){
                continue;
            }
            if(!memberEntity.getEmail().equals(member.getEmail())){
                continue;
            }
            if(!memberEntity.getName().equals(member.getName())){
                continue;
            }
            if(!memberEntity.getPhoneNumber().equals(member.getPhoneNumber())){
                continue;
            }
            result.add(memberEntity);
        }
        return result;
    }
}
