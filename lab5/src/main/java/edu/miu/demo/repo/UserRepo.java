package edu.miu.demo.repo;

import edu.miu.demo.entity.Post;
import edu.miu.demo.entity.User;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAll();
    User findById(long id);
    void deleteById(long id);
    User save(User user);
    //@Query("select u from User u Join u.products p Join p.reviews r where r.numberOfStars>4")
    //public List<User> sampleQuery();
    @Query("SELECT u FROM User u WHERE size(u.posts) > 1")
    List<User> findUserWithMoreThanOnePosts();
    //@Query("SELECT u FROM User u JOIN u.posts p WHERE size(p.comments) > :num")
    @Query("SELECT u FROM User u JOIN u.posts p JOIN p.comments c GROUP BY u HAVING count (c) > :num")
    List<User> findUserWithMoreThanNComments(int num);
    @Query("SELECT u FROM User u JOIN u.posts p WHERE p.title = :title ")
    List<User> findUserWithPostsWithTitle(String title);
    User findByEmail(String email);
}
