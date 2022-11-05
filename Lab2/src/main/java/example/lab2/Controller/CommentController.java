package example.lab2.Controller;


import example.lab2.Model.Comment;
import example.lab2.Model.Post;
import example.lab2.Model.User;
import example.lab2.Service.CommentService;
import example.lab2.Service.PostClass;
import example.lab2.Service.UserClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users/{id}/posts")
public class CommentController {

private CommentService commentService;
private UserClass userClass ;

private PostClass postClass;
@Autowired
    public CommentController(CommentService commentService, UserClass userClass, PostClass postClass) {
        this.commentService = commentService;
        this.userClass = userClass;
        this.postClass = postClass;
    }
 //  	Make it possible to add a comment that will be associated with its post.
    @PutMapping("/{id}/addComment")
    public void addComment(@PathVariable Long id , @RequestBody Comment comment){
        var temp = postClass.findviaId(id).getCommentList();
        temp.add(comment);
    }


//	Cascade all the operations from the User to the Posts and Posts to the comments.So, if you delete a User, it should delete all related data. (Delete a User to verify)
    @DeleteMapping("/{id}")
    public void deleteviaId(@PathVariable Long id){
    userClass.deleteViaId(id);
    }


//   Make a query that will retrieve all the users that have more than (n) posts.
    @GetMapping("/morethan/{id}")
    public List<User> highPost(@RequestParam int number){
    return commentService.greterthan(number);
    }

//   Make a query that will find all the posts that match a given title.
    @GetMapping("/{id}")
    public List<Post> title(@RequestParam String titel){
    return commentService.findMatch(titel);
    }

}






