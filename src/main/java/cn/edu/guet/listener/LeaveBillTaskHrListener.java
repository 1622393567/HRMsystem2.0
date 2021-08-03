package cn.edu.guet.listener;

import cn.edu.guet.bean.EmployeesInf;
import cn.edu.guet.common.HttpUtils;
import cn.edu.guet.service.EmployeesInfoService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public class LeaveBillTaskHrListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        HttpServletRequest request = HttpUtils.getRequest();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        EmployeesInfoService employeesInfoService = webApplicationContext.getBean(EmployeesInfoService.class);
        List<EmployeesInf> employeesInfs = employeesInfoService.queryEmpLeaderByHeadLike("H");
        List<String> users = employeesInfs.stream().map(EmployeesInf::getEmpName).collect(Collectors.toList());
        delegateTask.addCandidateUsers(users);

    }
}
