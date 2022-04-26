package com.example.spring.controller;

import com.example.spring.dto.PostDto;
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
        int totalCount = boardService.getCount(board_no);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("board_no", board_no);
        map.put("page_no", page_no);
        map.put("per_page", per_page);
        map.put("keyword", "");
        List<PostDto> postDtoList = boardService.getPostList(map);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("postDtoList", postDtoList);
        return "/board/postList";
    }

    @PostMapping("/post/list")
    @ResponseBody
    public List<PostDto> getPostListAjax(@RequestBody Map<String, Object> parameter) {
        int totalCount = boardService.getCount(Integer.valueOf(parameter.get("board_no").toString()));
        return boardService.getPostList(parameter);
    }

    @GetMapping("/post/{post_no}")
    public String getPost(@PathVariable int post_no, Model model) {
        PostDto postDto = boardService.getPost(post_no);
        model.addAttribute("postDto", postDto);
        return "/board/post";
    }

}
