package cn.edu.guet.bll;

import cn.edu.guet.bean.Postt;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface PostService {
    List<Postt> viewPost();
    List<Postt> viewPostByKeyword(String keyword);
    void deletePostById(String postId);
    void deletePostByIds(String[] ids);
    void outputExcel(HttpServletResponse response) throws IOException;

    Postt getPostById(String postId);
    void editPost(Postt post);
    void addPost(Postt post);


}
