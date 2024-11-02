package edu.miu.demo.service;

import edu.miu.demo.entity.Comment;
import edu.miu.demo.entity.Post;
import edu.miu.demo.entity.User;
import edu.miu.demo.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(long id);

    void createUser(UserDto userDto);

    public User createUserWithPosts(String name, Post... posts);

    List<Post> findPostsByUserId(long id);

    List<UserDto> getUsersWithMoreThanOnePost();

    public Post createPost(String author, String title, String context, Comment... comments);

    void deleteUserById(long id);

    List<UserDto> findUserWithMoreThanNComments(int n);

    List<UserDto> findUserWithPostsWithTitle(String title);
}