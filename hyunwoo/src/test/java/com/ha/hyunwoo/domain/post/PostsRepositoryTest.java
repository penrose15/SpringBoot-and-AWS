package com.ha.hyunwoo.domain.post;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach //@AfterEach는 단위 테스트 끝날 때마다 실행시켜 데이터 침범을 막음
    public void cleanup() {
        postsRepository.deleteAll();;
    }

    @Test
    public void 게시글_저장_불러오기() {
        //given
        String title = "#test title";
        String content = "#test contents";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("hsj@gmail.com")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts post = postsList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }
}
