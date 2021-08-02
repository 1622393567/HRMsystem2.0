package cn.edu.guet.controller;

import cn.edu.guet.bean.WorkOver;
import cn.edu.guet.bll.IWorkOverService;
import cn.edu.guet.utiltool.Sessionkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WorkOverController {

    @Autowired
    private IWorkOverService iWorkOverService;

    //放入作用域
    @RequestMapping("/workover")
    public String addApplication(Model model, WorkOver workover){
        model.addAttribute("workover",workover);
        System.out.println(workover);
        return "workover";
    }

    //存入数据库
    @PostMapping(value ="/viewAddchuli")
    public String workoverApplication(HttpServletRequest request, WorkOver workOver){
        iWorkOverService.workoverApplication(workOver);
        System.out.println("wwwww"+workOver);
        return "redirect:/viewAddchuli";
    }

    //显示数据
    @GetMapping("/viewAddchuli")
    public String viewAddchuli(Model model, WorkOver workOver){
        model.addAttribute("workover",iWorkOverService.viewAddchuli());
        System.out.println(iWorkOverService.viewAddchuli());
        return "addchuli";
    }

    @RequestMapping("/updateWork")
    public String getWork(Model model,String addwork_application_key){
        WorkOver workover=iWorkOverService.getWorkById(addwork_application_key);
        System.out.println("aaaaaaaa");
        model.addAttribute("workover",workover);
        System.out.println("abab"+workover);
        return "tanchuang";
    }

    //修改
    @RequestMapping("/tanchuang")
    public String updateWork(WorkOver workover){
        System.out.println("BBBBBBBB");
        System.out.println("sda"+workover);
        iWorkOverService.updateWork(workover);
        return  "redirect:/viewAddchuli";
    }


    //删除
    @RequestMapping(value="/deleteWork",method = RequestMethod.GET)
    public String deleteWork(@RequestParam("addwork_application_key") String addwork_application_key, HttpServletRequest request){
        System.out.println("sssssssssssssssssssssssss");
        iWorkOverService.deleteWork(addwork_application_key);
        System.out.println(addwork_application_key);
        return "redirect:/viewAddchuli";
    }

    //查看
    @RequestMapping("/viewAddkaoqin")
    public String viewAddkaoqin(Model model,HttpServletRequest request,String emp_id){
        emp_id= Sessionkey.getCurrentUserId();
        System.out.println("awv"+emp_id);
        request.setAttribute("addkaoqin",iWorkOverService.viewAddkaoqin(emp_id));
        return "addkaoqin";
    }

}
