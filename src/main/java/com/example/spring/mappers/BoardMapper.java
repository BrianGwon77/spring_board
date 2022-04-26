package com.example.spring.mappers;

import com.example.spring.dto.PostDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    public int getCount(int board_no);
    public PostDto getPost(int post_no);
    public List<PostDto> getPostList(Map<String, Object> map);
}
