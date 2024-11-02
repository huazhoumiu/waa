package edu.miu.demo.service.impl;

import edu.miu.demo.entity.Comment;
import edu.miu.demo.entity.Post;
import edu.miu.demo.entity.User;
import edu.miu.demo.entity.dto.PostDto;
import edu.miu.demo.entity.dto.UserDto;
import edu.miu.demo.helper.ListMapper;
import edu.miu.demo.repo.UserRepo;
import edu.miu.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ListMapper listMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, ListMapper listMapper, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.listMapper = listMapper;
        this.modelMapper = modelMapper;
    }

    public List<UserDto> findAll() {
        return (List<UserDto>) listMapper.mapList(userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto findById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }

    @Transactional
    public void deleteUserById(long id) { userRepo.deleteById(id);}

    @Transactional
    public void createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        userRepo.save(user);
    }

    public List<Post> findPostsByUserId(long id){
        User user =  userRepo.findById(id);
        return user.getPosts();
    }

    public List<UserDto> getUsersWithMoreThanOnePost(){
        return listMapper.mapList(userRepo.findUserWithMoreThanOnePosts(), new UserDto());
    }

    public List<UserDto> findUserWithMoreThanNComments(int n){
        return listMapper.mapList(userRepo.findUserWithMoreThanNComments(n), new UserDto());
    }

    public List<UserDto> findUserWithPostsWithTitle(String title){
        return listMapper.mapList(userRepo.findUserWithPostsWithTitle(title), new UserDto());
    }

    @Transactional
    public Post createPost(String author, String title, String context, Comment... comments) {
        Post post = new Post(title, author);
        post.setContent(context);
        post.setComments(Arrays.asList(comments));
        return post;
    }

    @Transactional
    public User createUserWithPosts(String name, Post... posts) {
        User user = new User();
        user.setName(name);

        for (Post post : posts) {
            post.setAuthor(name);
        }

        user.setPosts(Arrays.asList(posts));
        userRepo.save(user);
        return user;
    }

}
