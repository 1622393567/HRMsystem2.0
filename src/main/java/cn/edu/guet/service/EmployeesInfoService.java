package cn.edu.guet.service;

import cn.edu.guet.bean.EmployeesInf;

import java.util.List;

public interface EmployeesInfoService {
    void DepositInfo(String empId);

    EmployeesInf queryEmpLeaderByEmpId(String empId);

    List<EmployeesInf> queryEmpLeaderByHeadLike(String nameLike);
}
