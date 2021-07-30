package cn.edu.guet.bll.impl;

import cn.edu.guet.bean.Demands;
import cn.edu.guet.bll.DemandsService;
import cn.edu.guet.mapper.DemandsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandsImpl implements DemandsService {
    @Autowired
    private DemandsMapper demandsMapper;

    @Override
    public List<Demands> Getempid() {
       return demandsMapper.Getempid();
    }

    @Override
    public void deleteEmpid(String empid) {
        demandsMapper.deleteEmpid(empid);
    }

    @Override
    public void updateA(String empid, String id) {
        demandsMapper.updateA(empid,id);
    }

    @Override
    public List<Demands> findDemands(String value) {
        return demandsMapper.findDemands(value);
    }

    @Override
    public void addDemands(Demands demands) {
         demandsMapper.addDemands(demands);
    }

    @Override
    public void deleteDemands(String demand_key) {
        demandsMapper.deleteDemands(demand_key);
    }
}
