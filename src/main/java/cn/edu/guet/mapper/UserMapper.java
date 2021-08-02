package cn.edu.guet.mapper;

import cn.edu.guet.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> viewUser();
    List<User> viewUserByKeyword(String keyword);
    void deleteUserById(String empId);

    void deleteUserByIds(String[] ids);
    User getUserById(String empId);
    void editUser(User user);
    void addUser(User user);

}
