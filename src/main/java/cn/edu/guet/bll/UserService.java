package cn.edu.guet.bll;

import cn.edu.guet.bean.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> viewUser();
    List<User> viewUserByKeyword(String keyword);
    void deleteUserById(String empId);
    void outputExcel(HttpServletResponse response) throws IOException;

    void deleteUserByIds(String[] ids);

    User getUserById(String deptId);

    void editUser(User user);
    void addUser(User user);
}
