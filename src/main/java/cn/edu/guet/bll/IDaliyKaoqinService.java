package cn.edu.guet.bll;

import cn.edu.guet.bean.DaliyKaoqin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDaliyKaoqinService {
    List<DaliyKaoqin> viewDaliyKaoqin();
    List<DaliyKaoqin> viewperDaliyKaoqin(String emp_id);
    List<DaliyKaoqin> selectId();
    List<DaliyKaoqin> selectMonth();
    void signIn(String emp_id, String work_begin_time);
    void signOut(String emp_id, String work_endding_time);

    void worksignIn(String emp_id, String real_begin_time);
    void worksignOut(String emp_id, String real_endding_time);
    List<DaliyKaoqin> getByName(String name);
}
