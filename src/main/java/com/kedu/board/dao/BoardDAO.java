package com.kedu.board.dao;

import com.kedu.board.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    private SqlSession mybatis;

    public List<BoardDTO> selectAll(){
        return mybatis.selectList("Board.getList");
    }

    public BoardDTO getBoardById(int id){
        return mybatis.selectOne("Board.getBoardById",id);
    }

    public int writeBoard(BoardDTO boardDTO){
        return mybatis.insert("Board.write",boardDTO);
    }

    public int deleteBoard(int id){
        return mybatis.delete("Board.delete",id);
    }

    public int updateBoard(BoardDTO boardDTO){
        return mybatis.update("Board.update",boardDTO);
    }
}
