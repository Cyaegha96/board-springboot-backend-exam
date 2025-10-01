package com.kedu.board.controllers;

import com.kedu.board.dto.BoardDTO;
import com.kedu.board.services.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/write")
    public ResponseEntity<Void> writeBoard(@RequestBody BoardDTO boardDTO, HttpSession session){
       String writer =  (String)session.getAttribute("loginId");
       boardDTO.setWriter(writer);
        bServ.writeBoard(boardDTO);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable int id){
        bServ.deleteBoard(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateBoard(@RequestBody BoardDTO boardDTO,
                                            HttpSession session,@PathVariable int id){
        String loginId = (String)session.getAttribute("loginId");

        boardDTO.setId(id);
        bServ.updateBoard(boardDTO,loginId);
        return ResponseEntity.ok().build();
    }
}
