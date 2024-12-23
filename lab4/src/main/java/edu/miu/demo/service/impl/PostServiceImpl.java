package edu.miu.demo.service.impl;

import edu.miu.demo.entity.Comment;
import edu.miu.demo.entity.Post;
import edu.miu.demo.entity.dto.PostDto;
import edu.miu.demo.helper.ListMapper;
import edu.miu.demo.repo.PostRepo;
import edu.miu.demo.service.PostService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final ListMapper listMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepo postRepo, ListMapper listMapper, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.listMapper = listMapper;
        this.modelMapper = modelMapper;
    }

    public List<Post> findPostByTitle(String title) {
        return postRepo.findPostsByTitle(title);
    }

    public List<PostDto> findAll() {
        return (List<PostDto>) listMapper.mapList(postRepo.findAll(), new PostDto());
    }

    public void save(PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    public void delete(long id) {
        postRepo.deleteById(id);
    }

    public List<Comment> findCommentByPostId(long id) {
        return postRepo.findById(id).getComments();
    }

    public Post findById(long id) {
        return postRepo.findById(id);
    }

//
//    @Autowired
//    ModelMapper modelMapper;
//
//    @Autowired
//    ListMapper listMapper;
//
//
//    public List<PostDto> findAll() {
//        return (List<PostDto>) listMapper.mapList(postRepo.findAll(), new PostDto());
//    }
//
//    public PostDto getById(long id) {
//        return modelMapper.map(postRepo.getById(id), PostDto.class);
//    }
//
////    public Post getById(int id) {
////        return modelMapper.map(postRepo.getById(id), PostDto.class);
////    }
//
//    public void save(PostDto p) {
//        postRepo.save(modelMapper.map(p, Post.class));
//    }
//

//
//    public void update(long id, PostDto post) {
//        postRepo.update(id, modelMapper.map(post, Post.class));
//    }
//
//    public List<PostDto> getByAuthor(String author) {
//        List<Post> posts = postRepo.getByAuthor(author);
//        return posts.stream()
//                .map(post->modelMapper.map(post, PostDto.class))
//                .collect(Collectors.toList());
//    }
//    public List<PostDto> getBySubName(String name){
//        List<Post> posts = postRepo.getBySubName(name);
//        return posts.stream()
//                .map(post->modelMapper.map(post, PostDto.class))
//                .collect(Collectors.toList());
//    }
}
