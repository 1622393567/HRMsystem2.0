package cn.edu.guet.controller;

import cn.edu.guet.bean.Sendsalary;
import cn.edu.guet.bll.ISalaryService;
import cn.edu.guet.utiltool.FileUtil;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private ISalaryService salaryService;

    @RequestMapping("/importSendsalary")
    public String viewSalary(HttpServletRequest request, Model model){
        model.addAttribute("salary",salaryService.viewSalary());
        return "salary";
    }
    @PostMapping("/importSalary")
    public String  importSendsalary (@RequestParam("sendsalaryfile") MultipartFile file) throws NotFoundException {
        System.out.println(file);
        List<Sendsalary> salaryList = FileUtil.importExcel(file,0,1, Sendsalary.class);
        //调用导入excel的方法，然后循环插入
        for (Sendsalary sendsalarys : salaryList){
            Sendsalary sendsalary=new Sendsalary();
            sendsalary.setEmp_id(sendsalarys.getEmp_id());
            sendsalary.setDatem(sendsalarys.getDatem());
            sendsalary.setEmp_basic_salary(sendsalarys.getEmp_basic_salary());
            sendsalary.setEmp_bonus(sendsalarys.getEmp_bonus());
            sendsalary.setEmp_addwork(sendsalarys.getEmp_addwork());
            sendsalary.setEmp_punish(sendsalarys.getEmp_punish());
            sendsalary.setEmp_insurance(sendsalarys.getEmp_insurance());
            sendsalary.setEmp_tax(sendsalarys.getEmp_tax());
            sendsalary.setEmp_should_salary(sendsalarys.getEmp_should_salary());
            sendsalary.setEmp_real_salary(sendsalarys.getEmp_real_salary());
            salaryService.importSalary(sendsalary);
            System.out.println(sendsalary);
        }
        System.out.println("导入完成");
        return "redirect:findSalary";//重定向到数据页面
    }

}
