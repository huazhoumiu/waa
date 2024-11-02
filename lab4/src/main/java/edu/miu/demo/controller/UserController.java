package edu.miu.demo.controller;

import edu.miu.demo.aspect.annotation.ExecutionTime;
import edu.miu.demo.aspect.annotation.LogMe;
import edu.miu.demo.entity.Post;
import edu.miu.demo.entity.User;
import edu.miu.demo.entity.dto.PostDto;
import edu.miu.demo.entity.dto.UserDto;
import edu.miu.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping()
    @ExecutionTime
    @LogMe
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/id/{id}")
    @ExecutionTime
    @LogMe
    public UserDto getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @ExecutionTime
    @LogMe
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
    }

    @GetMapping("/{id}/posts")
    @ExecutionTime
    @LogMe
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Long id) {
        List<Post> posts = userService.findPostsByUserId(id);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/with-multiple-posts")
    @ExecutionTime
    @LogMe
    public ResponseEntity<List<UserDto>> getUsersWithMultiplePosts() {
        List<UserDto> users = userService.getUsersWithMoreThanOnePost();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/with-n-comments/{num}")
    @ExecutionTime
    @LogMe
    public ResponseEntity<List<UserDto>> getUsersByNum(@PathVariable int num) {
        List<UserDto> users = userService.findUserWithMoreThanNComments(num);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/with-title/{title}")
    @ExecutionTime
    @LogMe
    public ResponseEntity<List<UserDto>> getUsersByTitle(@PathVariable String title) {
        List<UserDto> users = userService.findUserWithPostsWithTitle(title);
        return ResponseEntity.ok(users);
    }


    @DeleteMapping("/{id}")
    @ExecutionTime
    @LogMe
    public void deleteUserById(@PathVariable Long id) {userService.deleteUserById(id);}


}
