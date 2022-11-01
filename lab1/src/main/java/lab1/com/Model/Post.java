package lab1.com.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Post {
    private Long id;
    private String name;
    private String title;
    private String content;
    private String author;
}
