package cn.edu.guet.bll.impl;

import cn.edu.guet.bean.Demands;
import cn.edu.guet.bll.DemandsService;
import cn.edu.guet.config.Log;
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
    @Log("根据选择了的员工号，删除职位需求，保证员工号不重复")
    public void deleteEmpid(String empid) {
        demandsMapper.deleteEmpid(empid);
    }

    @Override
    @Log("根据选择的录用者id分配选择的员工号")
    public void updateA(String empid, String id) {
        demandsMapper.updateA(empid,id);
    }

    @Override
    public List<Demands> findDemands(String value) {
        return demandsMapper.findDemands(value);
    }

    @Override
    @Log("添加职位需求")
    public void addDemands(Demands demands) {
         demandsMapper.addDemands(demands);
    }

    @Override
    @Log("删除职位需求记录")
    public void deleteDemands(String demand_key) {
        demandsMapper.deleteDemands(demand_key);
    }
}
