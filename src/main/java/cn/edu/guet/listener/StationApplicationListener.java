package cn.edu.guet.listener;

import cn.edu.guet.bean.EmployeesInf;
import cn.edu.guet.common.HttpUtils;
import cn.edu.guet.dto.UserAndNameDto;
import cn.edu.guet.service.EmployeesInfoService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

public class StationApplicationListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        UserAndNameDto user = HttpUtils.getAttribute("user", UserAndNameDto.class);
        HttpServletRequest request = HttpUtils.getRequest();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        EmployeesInfoService employeesInfoService = webApplicationContext.getBean(EmployeesInfoService.class);
        EmployeesInf employeesInf = employeesInfoService.queryEmpLeaderByEmpId(user.getEmpId());
        delegateTask.setAssignee(employeesInf.getEmpName());
    }
}
