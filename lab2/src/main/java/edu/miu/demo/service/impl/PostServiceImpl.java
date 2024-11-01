//package edu.miu.demo.service.impl;
//
//import edu.miu.demo.entity.Post;
//import edu.miu.demo.entity.dto.PostDto;
//import edu.miu.demo.helper.ListMapper;
//import edu.miu.demo.repo.PostRepo;
//import edu.miu.demo.service.PostService;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class PostServiceImpl implements PostService {
//    private final PostRepo postRepo;
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
//    public void delete(long id) {
//        postRepo.delete(id);
//    }
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
//}
