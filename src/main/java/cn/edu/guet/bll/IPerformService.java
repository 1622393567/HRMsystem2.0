package cn.edu.guet.bll;

import cn.edu.guet.bean.Performance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPerformService {
    List<Performance> viewPerform();
    List<Performance> personPerform(String emp_id);
    int updatePerform(Performance performance);
    Performance getPerform(String person_perfor_key);
    void performsave(String emp_id, String month);
}
