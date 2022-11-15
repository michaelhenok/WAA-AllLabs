package example.lab2.Service.Interface;


import example.lab2.Model.AppUser;
import example.lab2.Model.Comment;
import example.lab2.Model.Post;

import java.util.List;

public interface ComInt {

    public void AddComment(Long id , Comment c);
    public Comment saveComment(Comment comment);
    public void deleteViaId(Long id);
    public List<AppUser> greterthan(int n);
    public List<Post> findMatch(String s);



}


