package cn.edu.guet.bll;

import cn.edu.guet.bean.WorkOver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWorkOverService {
    void workoverApplication(WorkOver workOver);
    List<WorkOver> viewAddchuli();
    List<WorkOver> viewAddkaoqin(String emp_id);
    void deleteWork(String addwork_application_key);
    int updateWork(WorkOver workOver);
    WorkOver getWorkById(String addwork_application_key);

}
