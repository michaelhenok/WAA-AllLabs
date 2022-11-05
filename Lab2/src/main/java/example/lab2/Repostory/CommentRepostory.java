package example.lab2.Repostory;
import example.lab2.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CommentRepostory extends JpaRepository<Comment , Long> {


}
