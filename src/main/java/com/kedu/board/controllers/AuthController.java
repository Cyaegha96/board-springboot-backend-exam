package com.kedu.board.controllers;

import com.kedu.board.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class AuthController {

    @Autowired
    private MemberService memberService;

    @GetMapping(value ="/login", params={"id","pw"})
    public ResponseEntity<Boolean> login(@RequestParam String id,@RequestParam String pw) {
        System.out.println("id:"+id);
        System.out.println("pw:"+pw);

       boolean loginCheck =  memberService.addMember(id,pw);

        return ResponseEntity.ok(loginCheck);
    }

}
