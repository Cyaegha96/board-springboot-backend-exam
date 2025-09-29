package com.kedu.board.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String id;
    private String pw;
    private String name;
    private String phone;
    private String email;
    private long zone_code;
    private String address1;
    private String address2;
    private Timestamp join_date;
}
