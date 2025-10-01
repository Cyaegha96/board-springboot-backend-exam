package com.kedu.board.controllers;

import com.kedu.board.dto.BoardDTO;
import com.kedu.board.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService bServ;

    @GetMapping("/list")
    public ResponseEntity<List<BoardDTO>> getAll(){
       List<BoardDTO> list =  bServ.getList();

       return ResponseEntity.ok(list);
    }

    @GetMapping("/detail")
    public ResponseEntity<BoardDTO> getBoardById(int id){
        BoardDTO dto = bServ.getBoardById(id);

        return ResponseEntity.ok(dto);
    }
}
