package cn.edu.guet.bll.impl;

import cn.edu.guet.bean.Postt;
import cn.edu.guet.bll.PostService;
import cn.edu.guet.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Postt> viewPost() {
        return postMapper.viewPost();
    }

    @Override
    public List<Postt> viewPostByKeyword(String keyword) {
        return postMapper.viewPostByKeyword(keyword);
    }

    @Override
    public void deletePostById(String postId) {
        postMapper.deletePostById(postId);
    }

    @Override
    public void deletePostByIds(String[] ids) {
        postMapper.deletePostByIds(ids);
    }

    @Override
    public void outputExcel(HttpServletResponse response) throws IOException {
        String sheetName = "职位表";
        String[] headers = {"职位编号","职位名称","职位级别","职位简介"};
        List<Postt> posts = postMapper.viewPost();
        List<List<String>> data = new ArrayList();
        for (Postt p : posts) {
            List<String> row = new ArrayList<>();
            row.add(p.getPostId());
            row.add(p.getPostName());
            row.add(p.getPostLevel());
            row.add(p.getPostResp());
            data.add(row);
        }
        ExcelUtil.exportExcel(response, sheetName, headers, data);
    }

    @Override
    public Postt getPostById(String postId) {
        return postMapper.getPostById(postId);
    }

    @Override
    public void editPost(Postt post) {
        postMapper.editPost(post);
    }


    @Override
    public void addPost(Postt post) {
        postMapper.addPost(post);
    }

}
