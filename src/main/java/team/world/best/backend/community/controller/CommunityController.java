package team.world.best.backend.community.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import team.world.best.backend.community.domain.Post;
import team.world.best.backend.community.dto.comment.CommentSaveRequestDto;
import team.world.best.backend.community.dto.comment.CommentSaveResponseDto;
import team.world.best.backend.community.dto.post.*;
import team.world.best.backend.community.service.CommunityService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping("/api/v1/community/posts")
    public PostResponseWithCount findPosts(){
        List<Post> posts = communityService.findPosts();
        List<PostListResponseDto> collect = posts.stream().map(PostListResponseDto::new).collect(Collectors.toList());

        return new PostResponseWithCount(collect);
    }

    @GetMapping("/api/v1/community/post/{id}")
    public PostResponseDto findPost(@PathVariable("id") Long id){
        Post findPost = communityService.findPostById(id);
        return new PostResponseDto(findPost);
    }

    @PutMapping("/api/v1/community/post/{id}")
    public PostUpdateResponseDto updatePost(@PathVariable("id") Long id, @RequestBody PostUpdateRequestDto dto) {
        Long postId = communityService.updatePost(id, dto.getAuthorEmail(), dto.getTitle(), dto.getContent());
        return new PostUpdateResponseDto(postId);
    }

    @PostMapping("/api/v1/community/post")
    public PostSaveResponseDto savePost(@RequestBody PostSaveRequestDto dto) {
        Long postId = communityService.post(dto.getTitle(), dto.getContent(), dto.getAuthorEmail());
        return new PostSaveResponseDto(postId);
    }

    @PostMapping("/api/v1/community/comment")
    public CommentSaveResponseDto saveComment(@RequestBody CommentSaveRequestDto dto) {
        Long commentId = communityService.comment(dto.getPostId(), dto.getAuthorEmail(), dto.getContent());
        return new CommentSaveResponseDto(commentId);
    }
}
