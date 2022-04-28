package com.example.spring.controller;

import com.example.spring.dto.OrderDto;
import com.example.spring.dto.PostDto;
import com.example.spring.dto.PostListDto;
import com.example.spring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class MainController {

    private final BoardService boardService;

    @GetMapping("/post/list")
    public String getPostList(int board_no, int page_no, int per_page, Model model) {
        /** 전체 데이터 수 **/
        int totalCount = boardService.getCount(board_no);
        model.addAttribute("totalCount", totalCount);
        return "/board/postList";
    }

    @PostMapping("/post/list")
    @ResponseBody
    public PostListDto getPostListAjax(@RequestBody Map<String, Object> parameter) {
        List<PostDto> postDtoList =  boardService.getPostList(parameter);
        int totalCount = boardService.getCount(Integer.valueOf(parameter.get("board_no").toString()));
        return new PostListDto(totalCount, postDtoList);
    }

    @GetMapping("/post/{post_no}")
    public String getPost(@PathVariable int post_no, Model model) {
        PostDto postDto = boardService.getPost(post_no);
        model.addAttribute("postDto", postDto);
        return "/board/post";
    }
}
