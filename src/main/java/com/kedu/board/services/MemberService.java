package com.kedu.board.services;

import com.kedu.board.dao.MemberDAO;
import com.kedu.board.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberDAO memberDAO;

    public boolean addMember(String id,String pw){
       return memberDAO.searchById(MemberDTO.builder().id(id).pw(pw).build()) >0;
    }
}
