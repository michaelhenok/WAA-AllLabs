package example.lab2.Controller;

import example.lab2.Aspect.annotetion.ExcutionTime;
import example.lab2.Aspect.annotetion.Log;
import example.lab2.Model.Comment;
import example.lab2.Model.Post;
import example.lab2.Model.User;
import example.lab2.Service.UserClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserClass aClass;

    @Autowired
    private CommentController commentClass;

    @GetMapping("/users")
    @Log()
    @ExcutionTime
    public List<User> getAllUsers(){
    return  aClass.getAll();
}
    @GetMapping("/{id}/users")
    @Log
    @ExcutionTime
    public User getUserById(@PathVariable Long id){
        return  aClass.findviaId(id);
    }
    @PostMapping("/user")
    @Log
    @ExcutionTime
    public void addNewUsers(@RequestBody User user){
        aClass.savenew(user);
    }
    @GetMapping("/{id}/posts")
    @Log
    @ExcutionTime

    public List<Post> userWithid(@PathVariable Long id ){
        return  aClass.findviaById(id);
    }




}
