package lab1.com.Controller;

import lab1.com.Model.Post;
import lab1.com.Service.Imp.SerImplimention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/V1")
@RestController
public class PostControllers {
    @Autowired
    private SerImplimention impliment;

    public PostControllers(SerImplimention impliment) {
        this.impliment = impliment;
    }

    @GetMapping("/posts")
    public List<Post> getAll(){
        return impliment.findAll();
    }
    @GetMapping("/posts/{id}")
    public Post getById(Long id){
        return impliment.findById(id);
    }
    @PostMapping("/posts")
    public Post save(@RequestBody Post post){
        return impliment.save(post);
    }

    @DeleteMapping("/posts/{id}")
    public void DeleteViaId(Long id){
        impliment.DeleteById(id);
    }

    @PutMapping("/posts/{id}")
    public Post update(@RequestParam Long id , @RequestBody Post post){
        return impliment.save(post);
    }
}
