package com.kedu.board.controllers;

import com.kedu.board.dto.MemberDTO;
import com.kedu.board.services.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class AuthController {

    @Autowired
    private MemberService memberService;

    @PostMapping(value ="/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody MemberDTO dto, HttpSession session) {
        System.out.println("id:"+dto.getId());
        System.out.println("pw:"+dto.getId());

       boolean loginCheck =  memberService.login(dto.getId(),dto.getPw());
        Map<String, String> resp =  new HashMap<>();
       if(loginCheck){
           session.setAttribute("loginId", dto.getId());
           resp.put("status", "success");
           resp.put("loginId", dto.getId());
           return ResponseEntity.ok(resp);
       }else{
           resp.put("status", "fail");
           return ResponseEntity.ok(resp);

       }


    }

    @PostMapping(value="/join")
    public ResponseEntity<Map<String, String>> join(@RequestBody MemberDTO memberDTO) {

        boolean joinCheck = memberService.addMember(memberDTO);
        Map<String, String> resp =  new HashMap<>();
        if(joinCheck){
            resp.put("status", "success");
            resp.put("loginId", memberDTO.getId());
            return ResponseEntity.ok(resp);
        }else{
            resp.put("status", "fail");
            return ResponseEntity.ok(resp);
        }

    }

    @PostMapping(value="/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        System.out.println("로그아웃 id:"+session.getAttribute("loginId"));
       session.invalidate();

       return ResponseEntity.ok().build();
    }


}
