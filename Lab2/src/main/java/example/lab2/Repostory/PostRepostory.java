package example.lab2.Repostory;

import example.lab2.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepostory extends JpaRepository<Post, Long> {
}
