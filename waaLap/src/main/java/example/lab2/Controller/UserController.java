package example.lab2.Controller;

import example.lab2.Model.AppUser;
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
    public List<AppUser> getAllUsers(){
    return  aClass.getAll();
}
    @GetMapping("/users/{id}")
    public AppUser getUserById(@PathVariable Long id){
        return  aClass.findviaId(id);
    }
    @PostMapping("/users")
    public void addNewUsers(@RequestBody AppUser appUser){
        aClass.savenew(appUser);
    }

}
