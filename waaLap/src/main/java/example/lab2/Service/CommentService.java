package example.lab2.Service;



import example.lab2.Model.Comment;
import example.lab2.Model.Post;
import example.lab2.Model.AppUser;
import example.lab2.Repostory.CommentRepostory;
import example.lab2.Repostory.PostRepostory;
import example.lab2.Repostory.UserRepository;
import example.lab2.Service.Interface.ComInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService implements ComInt {

    private CommentRepostory commentRepostory;
    private PostRepostory postRepostory;

    private UserRepository userRepository;
     @Autowired
    public CommentService(CommentRepostory commentRepostory, PostRepostory postRepostory, UserRepository userRepository) {
        this.commentRepostory = commentRepostory;
        this.postRepostory = postRepostory;
        this.userRepository = userRepository;
    }
    
    @Override
    public void AddComment(Long id , Comment c) {
      var temp = postRepostory.findById(id).orElse(null);
        assert temp != null;
        temp.getCommentList().add(c);
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepostory.save(comment);
    }

    @Override
    public void deleteViaId(Long id) {
        postRepostory.deleteById(id); ;
    }

    @Override
    public List<AppUser> greterthan(int n) {
        var temp = userRepository.findAll().stream()
                .filter(p->p.getPosts().size() > n).collect(Collectors.toList());
        return temp;
    }

    @Override
    public List<Post> findMatch(String s) {
         var tem = postRepostory.findAll().
                 stream().filter(p -> p.getTitle().equals(s)).toList();
        return tem;
    }
}
