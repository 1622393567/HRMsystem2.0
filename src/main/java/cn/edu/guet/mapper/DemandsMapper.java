package cn.edu.guet.mapper;

import cn.edu.guet.bean.Demands;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemandsMapper {
    List<Demands> Getempid();
    void deleteEmpid(String empid);
    void deleteDemands(String demand_key);
    void updateA(String empid, String id);
    List<Demands> findDemands(String value);
    void addDemands(Demands demands);
}
