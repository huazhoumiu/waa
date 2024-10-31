package edu.miu.demo.repo.impl;

import edu.miu.demo.entity.Post;
import edu.miu.demo.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;
    private static int bookId = 300;
    static{
        posts = new ArrayList<>();

        Post b1 = new Post(123,"What are the stupidest money mistakes most people make?","Jane" );
        Post b2 = new Post(124,"what is the best TV in Netflix","Tom" );
        posts.add(b1);
        posts.add(b2);
    }

    public List<Post> findAll(){
        return posts;
    }

    public void save(Post b){
        b.setId(bookId++);
        posts.add(b);
    }

    public void delete(long id){
        var book = posts
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst().get();
        posts.remove(book);
    }

    public void update(long id, Post b){
        Post toUpdate = getById(id);
        toUpdate.setAuthor(b.getAuthor());
        toUpdate.setTitle(b.getTitle());
        toUpdate.setContent(b.getContent());
    }

    public Post getById(long id){
        return posts
                .stream()
                .filter(l->l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Post> getByAuthor(String author){
        return posts
                .stream()
                .filter(l->author.equalsIgnoreCase(l.getAuthor()))
                .collect(Collectors.toList());
    }
    public List<Post> getBySubName(String name){
        return posts
                .stream()
                .filter(l->l.getAuthor() != null && l.getAuthor().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

}
