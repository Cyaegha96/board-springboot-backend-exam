package com.kedu.board.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private long id;
    private String writer;
    private String title;
    private String contents;
    private Timestamp write_date;
}
