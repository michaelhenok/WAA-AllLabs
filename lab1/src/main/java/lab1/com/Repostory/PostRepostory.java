package lab1.com.Repostory;

import lab1.com.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepostory extends JpaRepository<Post , Long> {
}
