package lab1.com.Controller;


import lab1.com.Model.Post;
import lab1.com.Model.PostDto;
import lab1.com.Service.Imp.SerImplimention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1")
public class PostController {

    @Autowired
   private SerImplimention impliment;

    @GetMapping("/posts")
    public List<Post> getAll(){
        return impliment.findAll();
    }
    @GetMapping("/posts/{id}")
    public PostDto getById(Long id){
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
        var getOld = impliment.findById(id);

    }
}
