package Service.Impl;

import DAO.MemberDAO;
import Service.MemberService;

public class MemberServiceImpl implements MemberService {

    private MemberDAO memberDAO;

    public MemberServiceImpl(MemberDAO memberDAO){
        this.memberDAO = memberDAO;
    }
}
