package edu.miu.demo.repo;

import edu.miu.demo.entity.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> findAll();
    public Post getById(long id);
    public void save(Post post);
    public void delete(long id);
    public void update(long id, Post post);
    public List<Post> getByAuthor(String author);
    public List<Post> getBySubName(String name);
}
