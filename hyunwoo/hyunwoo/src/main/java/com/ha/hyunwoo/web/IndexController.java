package com.ha.hyunwoo.web;

import com.ha.hyunwoo.service.post.PostsService;
import com.ha.hyunwoo.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts",service.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = service.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
