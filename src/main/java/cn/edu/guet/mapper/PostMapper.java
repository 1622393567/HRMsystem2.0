package cn.edu.guet.mapper;

import cn.edu.guet.bean.Postt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Postt> viewPost();
    List<Postt> viewPostByKeyword(String keyword);
    void deletePostById(String postId);
    void deletePostByIds(String[] ids);

    Postt getPostById(String postId);
    void editPost(Postt post);
    void addPost(Postt post);
}
