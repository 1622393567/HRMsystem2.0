package cn.edu.guet.mapper;

import cn.edu.guet.bean.Salarysecond;
import cn.edu.guet.bean.Sendsalary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalaryMapper {
    List<Salarysecond> viewSalary();
    void importSalary(Sendsalary sendsalary);
}
