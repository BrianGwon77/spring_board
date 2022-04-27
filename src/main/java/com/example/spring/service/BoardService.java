package com.example.spring.service;

import com.example.spring.dto.OrderDto;
import com.example.spring.dto.PostDto;
import com.example.spring.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public int getCount(int board_no) {
        return boardMapper.getCount(board_no);
    }

    public PostDto getPost(int post_no){
        return boardMapper.getPost(post_no);
    }

    public List<PostDto> getPostList(Map<String, Object> map){
        return boardMapper.getPostList(map);
    }

    public int test(List<OrderDto> orderDtoList) { return boardMapper.test(orderDtoList); }

}
