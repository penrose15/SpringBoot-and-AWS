package com.ha.hyunwoo.service.post;

import com.ha.hyunwoo.domain.post.PostsRepository;
import com.ha.hyunwoo.web.dto.PostsSaveRequestDto;
import org.springframework.transaction.annotation.Transactional;

public class PostsService {

    private final PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
