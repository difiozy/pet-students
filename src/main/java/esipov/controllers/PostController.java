package esipov.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import esipov.exception.ResourceNotFoundException;
import esipov.model.Post;
import esipov.repo.PostRepository;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    // get all post
    @GetMapping
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @GetMapping("/c")
    public void createTestPosts() {
        Post post = new Post();
        post.setTitle("TitleText");
        post.setFull_text("FullTextasdfjslkdfskf");
        post.setViews(102);
        postRepository.save(post);
    }

    // create post rest api
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    // get post by id rest api
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not exist with id :" + id));
        return null;
    }

    // update post rest api
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post postDetails){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not exist with id :" + id));

        post.setTitle(postDetails.getTitle());
        post.setFull_text(postDetails.getFull_text());
        post.setViews(postDetails.getViews());
        post.setId(postDetails.getId());

        Post updatedPost = postRepository.save(post);
        return null;
    }

    // delete post rest api
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deletePost(@PathVariable Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post not exist with id :" + id));
        postRepository.delete(post);
        return null;
    }
}
