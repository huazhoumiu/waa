package edu.miu.demo.repo;

import edu.miu.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
//    public List<Post> findAll();
//    public Post getById(long id);
//    public void save(Post post);
//    public void delete(long id);
//    public void update(long id, Post post);
//    public List<Post> getByAuthor(String author);
//    public List<Post> getBySubName(String name);

    @Query("SELECT p FROM Post p WHERE p.title = :title")
    List<Post> findPostsByTitle(String title);
}
