package cn.edu.guet.controller;

import cn.edu.guet.bean.Performance;
import cn.edu.guet.bll.IDaliyKaoqinService;
import cn.edu.guet.bll.IPerformService;
import cn.edu.guet.utiltool.Sessionkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/performance")
public class PerformanceController {


    @Autowired
    private IPerformService iPerformService;
    @Autowired
    private IDaliyKaoqinService daliyKaoqinService;

    @RequestMapping("/agencyPerform")
    public String viewPerfom(Model model){
        model.addAttribute("perform",iPerformService.viewPerform());
        model.addAttribute("emp",daliyKaoqinService.selectId());
        model.addAttribute("emp_m",daliyKaoqinService.selectMonth());
        System.out.println(iPerformService.viewPerform());
        System.out.println(daliyKaoqinService.selectId());
        return "agencyPerform";
    }

    @RequestMapping("/performsave")
    public String performsave(Model model,@ModelAttribute("emp_id") String emp_id,String month){
        iPerformService.performsave(emp_id,month);
        return "redirect:agencyPerform";
    }

    //个人查看绩效
    @RequestMapping("/personPerform")
    public String personPerform(HttpServletRequest request,String emp_id){
        emp_id= Sessionkey.getCurrentUserId();
        System.out.println("wode"+emp_id);
        request.setAttribute("person",iPerformService.personPerform(emp_id));
        return "performance";
    }

    //拿到个人考勤记录
    @GetMapping("/getPerform")
    public String getPerform(Model model,@ModelAttribute("person_perfor_key") String person_perfor_key){
        System.out.println("llllll");
        Performance perform = iPerformService.getPerform(person_perfor_key);
        System.out.println("kkkkkkk");
        model.addAttribute("performs", perform);
        return "upperform";
    }

    //录入审核信息
    @GetMapping("/upperforms")
    public String updatePerform(@ModelAttribute("performs") Performance perform){
        iPerformService.updatePerform(perform);
        return "redirect:agencyPerform";
    }
}
