package com.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class PostListDto {
    int totalCount;
    List<PostDto> postDtoList;

}
