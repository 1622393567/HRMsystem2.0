package cn.edu.guet.mapper;

import cn.edu.guet.bean.EmployeesInf;
import cn.edu.guet.dto.DepartmentPartDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Entity generator.domain.EmployeesInfoTable
 */
@Repository
public interface EmployeesInfMapper {

    int deleteByPrimaryKey(Long id);

    int insert(EmployeesInf record);

    int insertSelective(EmployeesInf record);

    EmployeesInf selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EmployeesInf record);

    int updateByPrimaryKey(EmployeesInf record);

    DepartmentPartDto getCurrentUserDepartmentDto(@Param("empId") String userId);

    EmployeesInf queryLeaderByEmpId(String empId);

    List<EmployeesInf> queryEmpLeaderByHeadLike(@Param("empId") String nameLike);
}




