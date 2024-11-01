package edu.miu.demo.repo;

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
    void deleteById(int id);
    User save(User user);
    //@Query("select u from User u Join u.products p Join p.reviews r where r.numberOfStars>4")
    //public List<User> sampleQuery();
    @Query("SELECT u FROM User u WHERE size(u.posts) > 1")
    List<User> findUserWithMoreThanOnePosts();
}
