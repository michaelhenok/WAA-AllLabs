package example.lab2.Repostory;

import example.lab2.Model.AppLogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppLoggerRepostory extends JpaRepository<AppLogger , Long> {
}
