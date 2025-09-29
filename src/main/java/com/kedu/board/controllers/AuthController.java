package com.kedu.board.controllers;

import com.kedu.board.dto.MemberDTO;
import com.kedu.board.services.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class AuthController {

    @Autowired
    private MemberService memberService;

    @GetMapping(value ="/login", params={"id","pw"})
    public ResponseEntity<Boolean> login(@RequestParam String id, @RequestParam String pw, HttpSession session) {
        System.out.println("id:"+id);
        System.out.println("pw:"+pw);

       boolean loginCheck =  memberService.login(id,pw);
       session.setAttribute("loginId", id);

        return ResponseEntity.ok(loginCheck);
    }

    @PostMapping(value="/join")
    public ResponseEntity<Boolean> join(@RequestBody MemberDTO memberDTO) {

        boolean joinCheck = memberService.addMember(memberDTO);
        return ResponseEntity.ok(joinCheck);
    }

    @PostMapping(value="/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
       session.invalidate();
       return ResponseEntity.ok().build();
    }


}
