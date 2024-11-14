package edu.miu.demo.service;

import edu.miu.demo.entity.Comment;
import edu.miu.demo.entity.Post;
import edu.miu.demo.entity.dto.PostDto;

import java.util.List;

public interface PostService {
//    PostDto getById(long id);
//    List<PostDto> getByAuthor(String author);
//    List<PostDto> getBySubName(String name);
//    void update(long id, PostDto post);
    public List<PostDto> findAll();
    void save(PostDto post);
    void delete(long id);
    List<Post> findPostByTitle(String title);
    List<Comment> findCommentByPostId(long postId);
    Post findById(long id);
}
