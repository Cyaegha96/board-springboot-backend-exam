package com.kedu.board.services;

import com.kedu.board.dao.BoardDAO;
import com.kedu.board.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardDAO boardDAO;

    public List<BoardDTO> getList(){
       return boardDAO.selectAll();
    }

    public BoardDTO getBoardById(int id){
        return boardDAO.getBoardById(id);
    }

    public int writeBoard(BoardDTO boardDTO){
        return boardDAO.writeBoard(boardDTO);
    }

    public int deleteBoard(int id){
        return boardDAO.deleteBoard(id);
    }

    public int updateBoard(BoardDTO boardDTO,String loginId){
        if(boardDTO.getWriter().equals(loginId)){
            return boardDAO.updateBoard(boardDTO);
        }
        else{
            return -1;
        }
    }
}
