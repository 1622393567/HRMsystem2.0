package cn.edu.guet.bll.impl;

import cn.edu.guet.bean.Salarysecond;
import cn.edu.guet.bean.Sendsalary;
import cn.edu.guet.bll.ISalaryService;
import cn.edu.guet.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements ISalaryService {

    @Autowired
    private SalaryMapper salaryMapper;
    @Override
    public List<Salarysecond> viewSalary() {

        return salaryMapper.viewSalary();
    }

    @Override
    public void importSalary(Sendsalary sendsalary) {
        salaryMapper.importSalary(sendsalary);
    }
}
