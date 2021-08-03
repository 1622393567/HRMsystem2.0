package cn.edu.guet.service.impl;

import cn.edu.guet.bean.EmployeesInf;
import cn.edu.guet.common.HttpUtils;
import cn.edu.guet.mapper.EmployeesInfMapper;
import cn.edu.guet.service.EmployeesInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesInfoServiceImpl implements EmployeesInfoService {
    @Autowired
    EmployeesInfMapper employeesInfMapper;

    @Override
    public void DepositInfo(String empId) {
        EmployeesInf employeesInf = this.employeesInfMapper.queryLeaderByEmpId(empId);
        //获得内容信息
        HttpUtils.setAttribute("leader", employeesInf.getLeader());
    }

    @Override
    public EmployeesInf queryEmpLeaderByEmpId(String empId) {
        return this.employeesInfMapper.queryLeaderByEmpId(empId);
    }

    @Override
    public List<EmployeesInf> queryEmpLeaderByHeadLike(String nameLike) {
        return this.employeesInfMapper.queryEmpLeaderByHeadLike(nameLike);
    }
}
