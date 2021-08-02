package cn.edu.guet.bll.impl;

import cn.edu.guet.bean.WorkOver;
import cn.edu.guet.bll.IWorkOverService;
import cn.edu.guet.config.Log;
import cn.edu.guet.mapper.WorkOverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class WorkOverServiceImpl implements IWorkOverService {
    @Autowired
    private WorkOverMapper workOverMapper;
    @Override
    public void workoverApplication(WorkOver workover){
        workOverMapper.workoverApplication(workover);
    }

    @Override
    public List<WorkOver> viewAddchuli() {
        return workOverMapper.viewAddchuli();
    }

    @Override
    public List<WorkOver> viewAddkaoqin(String emp_id) {
        return workOverMapper.viewAddkaoqin(emp_id);
    }

    @Override
    @Log("员工删除加班信息")
    public void deleteWork(String addwork_application_key) {
        workOverMapper.deleteWork(addwork_application_key);
    }

    @Override
    public int updateWork(WorkOver workOver) {
        return workOverMapper.updateWork(workOver);
    }

    @Override
    public WorkOver getWorkById(String addwork_application_key) {
        return workOverMapper.getWorkById(addwork_application_key);
    }


}
