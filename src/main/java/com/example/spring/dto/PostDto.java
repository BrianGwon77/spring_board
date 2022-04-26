package com.example.spring.dto;

import lombok.Data;

@Data
public class PostDto {
    private String board_no;
    private String post_no;
    private String title;
    private String content;
    private String insrt_dt;
    private String insrt_usr;
    private String updt_dt;
    private String updt_usr;
}
