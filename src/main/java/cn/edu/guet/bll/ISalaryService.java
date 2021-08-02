package cn.edu.guet.bll;

import cn.edu.guet.bean.Salarysecond;
import cn.edu.guet.bean.Sendsalary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISalaryService {
    List<Salarysecond> viewSalary();
    void importSalary(Sendsalary sendsalary);
}
