package example.lab2.Controller;

import example.lab2.Model.Post;
import example.lab2.Model.User;
import example.lab2.Service.UserClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    private UserClass aClass;
    @Autowired
    public UserController(UserClass aClass) {
        this.aClass = aClass;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
    return  aClass.getAll();
}
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return  aClass.findviaId(id);
    }
    @PostMapping("/users")
    public void addNewUsers(@RequestBody User user){
        aClass.savenew(user);
    }
    @GetMapping("/{id}/posts")
    public List<Post> userWithid(@PathVariable Long id ){
        return  aClass.findviaById(id);
    }

}
