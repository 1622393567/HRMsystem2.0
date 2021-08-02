package cn.edu.guet.controller;

import cn.edu.guet.bean.DaliyKaoqin;
import cn.edu.guet.bll.IDaliyKaoqinService;
import cn.edu.guet.utiltool.Sessionkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class DaliyKaoqinController {

    @Autowired
    private IDaliyKaoqinService daliyKaoqinService;

    @RequestMapping("/daliykaoqin")
    public String viewDaliyKaoqin(Model model,HttpServletRequest request){
        request.setAttribute("daliyKaoqins",daliyKaoqinService.viewDaliyKaoqin());
        return "daliykaoqin";
    }

    @RequestMapping("/perdaliykaoqin")
    public String viewperDaliyKaoqin(Model model,HttpServletRequest request,String emp_id){
        emp_id= Sessionkey.getCurrentUserId();
        System.out.println("adns"+emp_id);
        request.setAttribute("daliyKaoqins",daliyKaoqinService.viewperDaliyKaoqin(emp_id));
        return "daliykaoqin";
    }

    @GetMapping("/viewTime")
    public String viewTime(){
        return "time";
    }

    @GetMapping("/signIn")
    public String signIn(Model model,String emp_id,String work_begin_time){
        emp_id = Sessionkey.getCurrentUserId();
        daliyKaoqinService.signIn(emp_id,work_begin_time);
        System.out.println("ad"+emp_id+work_begin_time);
        return "time";
    }
    @GetMapping("/signOut")
    public String signOut(Model model,String emp_id,String work_endding_time){
        emp_id= Sessionkey.getCurrentUserId();
        daliyKaoqinService.signOut(emp_id,work_endding_time);
        System.out.println("b的"+emp_id+work_endding_time);
        return "time";
    }

    @GetMapping("/viewWorkTime")
    public String viewWorkTime(){
        return "worktime";
    }

    @GetMapping("/worksignIn")
    public String worksignIn(Model model,String emp_id,String real_begin_time){
        emp_id = Sessionkey.getCurrentUserId();
        daliyKaoqinService.worksignIn(emp_id,real_begin_time);
        System.out.println("ad"+emp_id+real_begin_time);
        return "worktime";
    }
    @GetMapping("/worksignOut")
    public String worksignOut(Model model,String emp_id,String real_endding_time){
        emp_id= Sessionkey.getCurrentUserId();
        daliyKaoqinService.worksignOut(emp_id,real_endding_time);
        System.out.println("b的"+emp_id+real_endding_time);
        return "worktime";
    }

    @RequestMapping("/getKaoqin")
    public String kaoqinList(Model model,String name){
        List<DaliyKaoqin> daliyKaoqins = daliyKaoqinService.getByName(name);
        model.addAttribute("daliykaoqins",daliyKaoqins);
        return "daliykaoqin";
    }
}
