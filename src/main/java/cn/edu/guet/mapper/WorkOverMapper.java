package cn.edu.guet.mapper;

import cn.edu.guet.bean.WorkOver;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface WorkOverMapper {
    void workoverApplication(WorkOver workOver);
    List<WorkOver> viewAddchuli();
    List<WorkOver> viewAddkaoqin(String emp_id);
    void deleteWork(String addwork_application_key);
    int updateWork(WorkOver workOver);
    WorkOver getWorkById(String addwork_application_key);


}
