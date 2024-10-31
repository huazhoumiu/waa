package edu.miu.demo.service;

import edu.miu.demo.entity.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();
    PostDto getById(long id);
    List<PostDto> getByAuthor(String author);
    List<PostDto> getBySubName(String name);
    void save(PostDto post);
    void delete(long id);
    void update(long id, PostDto post);
}
