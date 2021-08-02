package cn.edu.guet.bll.impl;

import cn.edu.guet.bean.Performance;
import cn.edu.guet.bll.IPerformService;
import cn.edu.guet.mapper.PerformanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPerformServiceImpl implements IPerformService {

    @Autowired
    private PerformanceMapper performanceMapper;

    @Override
    public List<Performance> viewPerform() {
        return performanceMapper.viewPerform();
    }

    @Override
    public List<Performance> personPerform(String emp_id) {
        return performanceMapper.personPerform(emp_id);
    }

    @Override
    public int updatePerform(Performance performance) {
        return performanceMapper.updatePerform(performance);
    }

    @Override
    public Performance getPerform(String person_perfor_key) {
        return performanceMapper.getPerform(person_perfor_key);
    }

    @Override
    public void performsave(String emp_id,String month) {

        performanceMapper.performsave(emp_id,month);

    }
}
