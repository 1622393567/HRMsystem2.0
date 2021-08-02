package cn.edu.guet.bll;

import cn.edu.guet.bean.Demands;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemandsService {
    List<Demands> Getempid();
    void deleteEmpid(String empid);
    void updateA(String empid, String id);
    List<Demands> findDemands(String value);
    void addDemands(Demands demands);
    void deleteDemands(String demand_key);
}
