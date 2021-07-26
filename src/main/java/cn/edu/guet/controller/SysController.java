package cn.edu.guet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//这个好像用不着了
@Controller
public class SysController {
    @RequestMapping(value = {"/hrmlog"})
    public String SysLog(){
        return "hrmlog";
    }
}
