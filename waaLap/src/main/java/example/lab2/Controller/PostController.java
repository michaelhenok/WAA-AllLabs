package example.lab2.Controller;


import example.lab2.Model.Post;
import example.lab2.Service.PostClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostClass aClass;
    @Autowired
    public PostController(PostClass aClass) {
        this.aClass = aClass;
    }

    @GetMapping("/")
    public List<Post> getAllUsers(){
        return  aClass.getAll();
    }
    @PostMapping("/{id}")
    public void addNewUsers(@RequestBody Post post){
        aClass.addNew(post);
    }


}
