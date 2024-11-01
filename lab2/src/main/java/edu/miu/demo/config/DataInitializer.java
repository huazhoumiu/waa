package edu.miu.demo.config;

import edu.miu.demo.entity.Post;
import edu.miu.demo.entity.User;
import edu.miu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserService userService;
    @Autowired
    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

//        Post post1 = new Post();
//        post1.setTitle("First Post");
//        post1.setContent("This is the content of the first post.");
//        post1.setAuthor("John Doe");
//
//        Post post2 = new Post();
//        post2.setTitle("Second Post");
//        post2.setContent("This is the content of the second post.");
//        post2.setAuthor("John Doe");
//
//        userService.createUserWithPosts("John Doe", post1, post2);
        // User 1
        Post post1_1 = new Post(0, "Journey to the West", "It is a detailed narrative of adventures and experiences.", "Alice");
        //Post post1_2 = new Post(0, "Alice in Wonderland", "It explores adventures through whimsical worlds.", "Alice");
        //Post post1_3 = new Post(0, "Mysteries of the East", "Discussing ancient eastern philosophies.", "Alice");
        //Post post1_4 = new Post(0, "The Art of Cuisine", "Delving into the art of French cooking.", "Alice");
        //userService.createUserWithPosts("Alice", post1_1, post1_2, post1_3, post1_4);
        userService.createUserWithPosts("Alice", post1_1);


        // User 2
        Post post2_1 = new Post(0, "Space Exploration", "New frontiers in space travel and exploration.", "Bob");
        Post post2_2 = new Post(0, "Deep Sea Mysteries", "Exploring the uncharted depths of the ocean.", "Bob");
        Post post2_3 = new Post(0, "Quantum Realities", "Discussing the strange behavior of quantum particles.", "Bob");
        Post post2_4 = new Post(0, "Futuristic Fiction", "Imagining the future through stories.", "Bob");
        userService.createUserWithPosts("Bob", post2_1, post2_2, post2_3, post2_4);

        // User 3
        Post post3_1 = new Post(0, "Philosophy of Mind", "Exploring concepts of consciousness.", "Charlie");
        Post post3_2 = new Post(0, "World Religions", "A study on various world religions.", "Charlie");
        Post post3_3 = new Post(0, "Digital Nomads", "Life of remote workers traveling the world.", "Charlie");
        Post post3_4 = new Post(0, "The Rise of AI", "Implications of artificial intelligence in modern society.", "Charlie");
        userService.createUserWithPosts("Charlie", post3_1, post3_2, post3_3, post3_4);

        // User 4
        Post post4_1 = new Post(0, "The Great Artists", "Discussion on the lives of great painters.", "David");
        Post post4_2 = new Post(0, "Classical Music", "Exploring the era of classical music compositions.", "David");
        Post post4_3 = new Post(0, "Modern Architecture", "Evolution of architectural designs.", "David");
        Post post4_4 = new Post(0, "The Coffee Culture", "Exploring coffee culture around the world.", "David");
        userService.createUserWithPosts("David", post4_1, post4_2, post4_3, post4_4);

        // User 5
        Post post5_1 = new Post(0, "Evolving Technologies", "Emerging technologies shaping our future.", "Eva");
//        Post post5_2 = new Post(0, "Health and Wellness", "Tips on maintaining a healthy lifestyle.", "Eva");
//        Post post5_3 = new Post(0, "Global Economics", "Discussing the global economic landscape.", "Eva");
//        Post post5_4 = new Post(0, "Ancient Civilizations", "Exploring the mysteries of ancient civilizations.", "Eva");
//        userService.createUserWithPosts("Eva", post5_1, post5_2, post5_3, post5_4);
        userService.createUserWithPosts("Eva", post5_1);

    }

}
