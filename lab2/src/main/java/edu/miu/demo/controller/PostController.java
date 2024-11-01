//package edu.miu.demo.controller;
//
//import edu.miu.demo.entity.Post;
//import edu.miu.demo.entity.dto.PostDto;
//import edu.miu.demo.service.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/posts")
//@CrossOrigin(origins = {"http://localhost:3000"})
//public class PostController {
//    private final PostService postService;
//    @Autowired
//    public PostController(PostService postService) {
//        this.postService = postService;
//    }
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping
//    public List<PostDto> getAll() {
//        return postService.findAll();
//    }
//
//    @GetMapping("/id/{id}")
//    public ResponseEntity<PostDto> getById(@PathVariable long id) {
//        var post = postService.getById(id);
//        return ResponseEntity.ok(post);
//    }
//
//    @GetMapping("/author/{author}")
//    public ResponseEntity<List<PostDto>> getByAuthor(@PathVariable String author) {
//        var post = postService.getByAuthor(author);
//        return ResponseEntity.ok(post);
//    }
//
//    @GetMapping("/sub/{name}")
//    public ResponseEntity<List<PostDto>> getBySubName(@PathVariable String name) {
//        var post = postService.getBySubName(name);
//        return ResponseEntity.ok(post);
//    }
//
//    @ResponseStatus(HttpStatus.OK)
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable long id) {
//        postService.delete(id);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@PathVariable long id, @RequestBody PostDto postDto) {
//        postService.update(id, postDto);
//    }
//
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping
//    public void save(@RequestBody PostDto post) {
//        postService.save(post);
//    }
//
//}
