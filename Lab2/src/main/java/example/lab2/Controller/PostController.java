package example.lab2.Controller;


import example.lab2.Model.Post;
import example.lab2.Model.User;
import example.lab2.Service.PostClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    private PostClass aClass;

    public PostController(PostClass aClass) {
        this.aClass = aClass;
    }

    @Autowired


    @GetMapping("/posts")
    public List<Post> getAllUsers(){
        return  aClass.getAll();
    }
    @GetMapping("/posts/{id}")
    public Post getUserById(@PathVariable Long id){
        return  aClass.findviaId(id);
    }
    @PostMapping("/posts")
    public void addNewUsers(@RequestBody Post post){
        aClass.addNew(post);
    }


}
