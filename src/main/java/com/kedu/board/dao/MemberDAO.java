package com.kedu.board.dao;

import com.kedu.board.dto.MemberDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
    @Autowired
    private SqlSession mybatis;

public int searchById(MemberDTO dto){
    return mybatis.selectOne("Member.searchById",dto);
}

    public int insertMember(MemberDTO memberDTO) {
        return mybatis.insert("Member.insertMember",memberDTO);
    }

    public int deleteMemberById(String id) {
        return mybatis.delete("Member.deleteMemberById",id);
    }
}
