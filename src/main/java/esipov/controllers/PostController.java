package esipov.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import esipov.exception.ResourceNotFoundException;
import esipov.model.Post;
import esipov.repo.PostRepository;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    // get all post
    @GetMapping("/posts")
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    // create post rest api
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    // get post by id rest api
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not exist with id :" + id));
        return ResponseEntity.ok(post);
    }

    // update post rest api
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not exist with id :" + id));

        post.setTitle(postDetails.getTitle());
        post.setFull_text(postDetails.getFull_text());
        post.setViews(postDetails.getViews());
        post.setId(postDetails.getId());

        Post updatedPost = postRepository.save(post);
        return ResponseEntity.ok(updatedPost);
    }

    // delete post rest api
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePost(@PathVariable Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post not exist with id :" + id));

        postRepository.delete(post);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

/*
    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

 */
}
