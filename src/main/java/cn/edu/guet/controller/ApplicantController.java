package cn.edu.guet.controller;


import cn.edu.guet.bean.Applicant;
import cn.edu.guet.bean.Demands;
import cn.edu.guet.bll.ApplicantService;
import cn.edu.guet.bll.DemandsService;
import cn.edu.guet.utiltool.AdmitMailUtil;
import cn.edu.guet.utiltool.FileUtil;
import cn.edu.guet.utiltool.PassMailUtil;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.util.List;

@EnableAsync
@Controller
@RequestMapping("applicant")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private DemandsService demandsService;


    //应聘者页面
    @GetMapping("/viewApplicant")
    public String view(Model model) {
        List<Applicant> applicantList=applicantService.viewApplicant();
        model.addAttribute("applicant",new Applicant());//为添加功能引入一个对象
        model.addAttribute("pageInfo",applicantList);
        return "viewApplicant";
    }

    @GetMapping("/deleteApplicant")
    public String delete(Model model,String applicant_id) {
        applicantService.deleteApplicant(applicant_id);
        List<Applicant> applicantList=applicantService.viewApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "redirect:viewApplicant";
    }
    //批量操作
    @GetMapping("/deletesomeApplicant")
    public ModelAndView deletesomeApplicant( String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                applicantService.deleteApplicant(strs[i]);
            } catch (Exception e) {
            }
        }
        return new ModelAndView("redirect:viewApplicant");
    }
    @GetMapping("/passSomeApplicant")
    public ModelAndView passsomeApplicant( String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                applicantService.passApplicant(strs[i]);
            } catch (Exception e) {
            }
        }
        return new ModelAndView("redirect:viewApplicant");
    }
    //单选
    @GetMapping("/passApplicant")
    public String pass(Model model,String applicant_id,String mail,String post,String name) throws MessagingException {
        PassMailUtil mailUtils=new PassMailUtil();
        mailUtils.sendEmail(mail,post,name);
        applicantService.passApplicant(applicant_id);
        List<Applicant> applicantList=applicantService.viewApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "redirect:viewApplicant";
    }


    @GetMapping("/searchApplicant")
    public String search(Model model,@ModelAttribute(value="keyValue")String keyValue) {
        List<Applicant> applicantList=applicantService.searchApplicant(keyValue);
        model.addAttribute("pageInfo",applicantList);
        return "redirect:viewApplicant";
    }
    @GetMapping("/filtrateApplicant")
    public String filtrate(Model model,@ModelAttribute(value="key")String key) {
        List<Applicant> applicantList=applicantService.searchApplicant(key);
        model.addAttribute("pageInfo",applicantList);
        return "redirect:viewApplicant";
    }

    @PostMapping ("/saveedit")
    public String saveedit(Model model,@ModelAttribute("applicant") Applicant applicant) {
            applicantService.addApplicant(applicant);
            System.out.println(applicant.getApplicant_info_key());
        return "redirect:viewApplicant";
    }

    @PostMapping ("/saveApplicant")
    public String save(Model model,@ModelAttribute Applicant applicant,@ModelAttribute("applicant_info_key") Integer applicant_info_key) {
        if (applicant_info_key==0){
            applicantService.addApplicant(applicant);
            System.out.println(applicant.getApplicant_info_key());
       }else {
            applicantService.editApplicant(applicant);
            System.out.println(applicant.getApplicant_name());
        }
        List<Applicant> applicantList=applicantService.viewApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "redirect:viewApplicant";
    }

    @RequestMapping ("/editApplicant")
    public String editApplicnat(ModelMap map,@ModelAttribute("applicant_id") int applicant_id ){
        map.addAttribute("applicant",applicantService.findByid(applicant_id));
        return "addApplicant";
    }



    @PostMapping("/importApplicant")
    public String  importExcel (@RequestParam("applicantfile") MultipartFile file) throws NotFoundException {
        System.out.println(file);
        List<Applicant> applicantLists = FileUtil.importExcel(file,0,1,Applicant.class);
        for (Applicant applicants : applicantLists){
            Applicant applicant =new Applicant();
            applicant.setApplicant_name(applicants.getApplicant_name());
            System.out.println(applicants.getApplicant_name());

            applicant.setApplicant_sex(applicants.getApplicant_sex());
            System.out.println(applicants.getApplicant_sex());

            applicant.setApplicant_state(applicants.getApplicant_state());
            System.out.println(applicants.getApplicant_state());

            applicant.setApplicant_identify_type(applicants.getApplicant_identify_type());


            applicant.setApplicant_identify_number(applicants.getApplicant_identify_number());
            System.out.println(applicants.getApplicant_identify_number());


            applicant.setApplicant_phone_number(applicants.getApplicant_phone_number());


            applicant.setApplicant_e_mail(applicants.getApplicant_e_mail());

            applicant.setApplicant_nation(applicants.getApplicant_nation());

            applicant.setApplicant_native_place(applicants.getApplicant_native_place());

            applicant.setApplicant_birthday(applicants.getApplicant_birthday());

            applicant.setApplicant_location(applicants.getApplicant_location());

            applicant.setApplicant_edu_bgd(applicants.getApplicant_edu_bgd());
            System.out.println(applicants.getApplicant_edu_bgd());

            applicant.setApplicant_entry_way(applicants.getApplicant_entry_way());

            applicant.setApplicant_edu_school(applicants.getApplicant_edu_school());
            System.out.println(applicants.getApplicant_edu_school());

            applicant.setApplicant_post_intention(applicants.getApplicant_post_intention());

            applicantService.addApplicant(applicant);
        }
        System.out.println("导入完成");
        return "redirect:viewApplicant";
    }












/************************************************************************************************************************/

    //面试页面
    @GetMapping("/viewpassApplicant")
    public String viewpass(Model model) {
        List<Applicant> applicantList=applicantService.viewpassApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewpassApplicant";
    }
    //批量操作
    @GetMapping("/noadmitSomeApplicant")
    public ModelAndView noadmitSomeApplicant( String tags) {
        String[] strs = tags.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                applicantService.noadmitApplicant(strs[i]);
            } catch (Exception e) {
            }
        }
        return new ModelAndView("redirect:viewpassApplicant");
    }
    @GetMapping("/admitSomeApplicant")
    public ModelAndView admitSomeApplicant( String tags) {
        String[] strs = tags.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                applicantService.admitApplicant(strs[i]);
            } catch (Exception e) {
            }
        }
        return new ModelAndView("redirect:viewpassApplicant");
    }
    //单选

    @GetMapping("/admitApplicant")
    public String admit(Model model,String applicant_id,String mail,String post,String name) throws MessagingException {
        AdmitMailUtil mailUtils=new AdmitMailUtil();
        mailUtils.sendEmail(mail,post,name);
        applicantService.admitApplicant(applicant_id);
        List<Applicant> applicantList=applicantService.viewpassApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "redirect:viewpassApplicant";
    }

    @GetMapping("/noadmitApplicant")
    public String noadmit(Model model,String applicant_id) {
        applicantService.noadmitApplicant(applicant_id);
        List<Applicant> applicantList=applicantService.viewpassApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewpassApplicant";
    }
    @GetMapping("/filtratepassApplicant")
    public String filtratepass(Model model,@ModelAttribute(value="key1")String key1) {
        List<Applicant> applicantList=applicantService.findpassApplicant(key1);
        model.addAttribute("pageInfo",applicantList);
        return "viewpassApplicant";
    }
    @GetMapping("/findpassApplicant")
    public String findpass(Model model,@ModelAttribute(value="keyValue")String keyValue) {
        List<Applicant> applicantList=applicantService.findpassApplicant(keyValue);
        model.addAttribute("pageInfo",applicantList);
        return "viewpassApplicant";
    }













    /************************************************************************************************************************/

    //查看录取人员
    @GetMapping("/viewadmitApplicant")
    public String viewadmit(Model model) {
        List<Applicant> applicantList=applicantService.viewadmitApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewadmitApplicant";
    }
    @GetMapping("/filtrateadmitApplicant")
    public String filtrateadmit(Model model,@ModelAttribute(value="key2")String key2) {
        List<Applicant> applicantList=applicantService.findadmitApplicant(key2);
        model.addAttribute("pageInfo",applicantList);
        return "viewadmitApplicant";
    }
    @GetMapping("/findadmitApplicant")
    public String findadmit(Model model,@ModelAttribute(value="keyValue")String keyValue) {
        List<Applicant> applicantList=applicantService.findadmitApplicant(keyValue);
        model.addAttribute("pageInfo",applicantList);
        return "viewadmitApplicant";
    }
    //批量操作
    @GetMapping("/deleteSomeadmitApplicant")
    public ModelAndView deleteSomeadmitApplicant( String tages) {
        String[] strs = tages.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                applicantService.deleteadmitApplicant(strs[i]);
            } catch (Exception e) {
            }
        }
        return new ModelAndView("redirect:viewadmitApplicant");
    }
      //删除
    @GetMapping("/deleteadmitApplicant")
    public String deleteadmit(Model model,String applicant_id) {
        applicantService.deleteadmitApplicant(applicant_id);
        List<Applicant> applicantList=applicantService.viewadmitApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewadmitApplicant";
    }

    //批量操作
    @GetMapping("/roportSomeadmitApplicant")
    public ModelAndView reportSomeadmitApplicant( String tags) {
        String[] strs = tags.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                applicantService.toreport(strs[i]);
            } catch (Exception e) {
            }
        }
        return new ModelAndView("redirect:viewadmitApplicant");
    }
    //待报到
    @GetMapping("/toreport")
    public String toreport(Model model,String applicant_id) {
        applicantService.toreport(applicant_id);
        List<Applicant> applicantList=applicantService.viewadmitApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewadmitApplicant";
    }















    /************************************************************************************************************************/

    //查看待报到人员
    @GetMapping("/viewreportApplicant")
    public String viewreport(Model model) {
        List<Applicant> applicantList=applicantService.viewreportApplicant();
        List<Demands> demand=demandsService.Getempid();
        model.addAttribute("demands",demand);
        model.addAttribute("pageInfo",applicantList);
        return "viewreportApplicant";
    }

    @GetMapping("/filtratereportApplicant")
    public String filtratereport(Model model,@ModelAttribute(value="key3")String key3) {
        List<Applicant> applicantList=applicantService.findreportApplicant(key3);
        model.addAttribute("pageInfo",applicantList);
        return "viewreportApplicant";
    }
    @GetMapping("/findreportApplicant")
    public String findreport(Model model,@ModelAttribute(value="keyValue")String keyValue) {
        List<Applicant> applicantList=applicantService.findreportApplicant(keyValue);
        List<Demands> demand=demandsService.Getempid();
        model.addAttribute("demands",demand);
        model.addAttribute("pageInfo",applicantList);
        return "viewreportApplicant";
    }
    //批量操作
    @GetMapping("/deleteSomereportApplicant")
    public ModelAndView deleteSomereportApplicant( String tages) {
        String[] strs = tages.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                applicantService.deletereportApplicant(strs[i]);
            } catch (Exception e) {
            }
        }
        return new ModelAndView("redirect:viewreportApplicant");
    }
    //删除
    @GetMapping("/deletereportApplicant")
    public String deletereport(Model model,String applicant_id) {
        applicantService.deletereportApplicant(applicant_id);
        List<Applicant> applicantList=applicantService.viewreportApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewreportApplicant";
    }

    //批量操作
    @GetMapping("/roportSomeApplicant")
    public ModelAndView reportSomeApplicant( String tags,String empid) {
        String[] strs = tags.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                empid=applicantService.findempid(Integer.parseInt(strs[i]));
                applicantService.report(empid,Integer.parseInt(strs[i]));
            } catch (Exception e) {
            }
        }
        return new ModelAndView("redirect:viewreportApplicant");
    }
    //报到
    @GetMapping("/report")
    public String report(Model model,@ModelAttribute("id") int id) {
        System.out.println(id);
        String empid=applicantService.findempid(id);
        applicantService.report(empid,id);
        List<Applicant> applicantList=applicantService.viewreportApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewreportApplicant";
    }
    @GetMapping("/chooesEMP")
    public ModelAndView chooes(@ModelAttribute("empid") String empid,@ModelAttribute("ID") String id) {
        System.out.println(empid+id);
        demandsService.updateA(empid,id);
        demandsService.deleteEmpid(empid);
        return new ModelAndView("redirect:viewreportApplicant");
    }



//职位需求表

    @GetMapping("/viewdemands")
    public String viewdemands(Model model) {
        List<Demands> demands=demandsService.Getempid();
        Demands demand=new Demands();
        model.addAttribute("demand",demand);
        model.addAttribute("pageInfo",demands);
        return "viewdemands";
          }

    @GetMapping("/findDemands")
    public String findDemands(Model model,@ModelAttribute(value="keyValue")String keyValue) {
        List<Demands> demandsList=demandsService.findDemands(keyValue);
        model.addAttribute("pageInfo",demandsList);
        return "redirect:viewdemands";
    }

    @GetMapping("/filtrateDemands")
    public String filtrateDemands(Model model,@ModelAttribute(value="key")String key) {
        List<Demands> demandsList=demandsService.findDemands(key);
        model.addAttribute("pageInfo",demandsList);
        return "redirect:viewdemands";
    }

    @GetMapping("/deleteDemands")
    public String deleteDemands(Model model,String demand_key) {
        demandsService.deleteDemands(demand_key);
        List<Demands> demandsList=demandsService.Getempid();
        model.addAttribute("pageInfo",demandsList);
        return "redirect:viewdemands";
    }

    //批量操作
    @GetMapping("/deleteSomedmands")
    public ModelAndView deleteSomedmands( String dmands) {
        String[] strs = dmands.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                demandsService.deleteDemands(strs[i]);
            } catch (Exception e) {
            }
        }
        return new ModelAndView("redirect:viewdemands");
    }

    @PostMapping ("/addDemands")
    public String addDemands(Model model,@ModelAttribute("demand") Demands demand) {
        System.out.println("开始添加");
        demandsService.addDemands(demand);
        System.out.println("添加成功");
        return "redirect:viewdemands";
    }

    @PostMapping("/importDemands")
    public String  importDemands (@RequestParam("demandsfile") MultipartFile file) throws NotFoundException {
        System.out.println(file);
        List<Demands> demandsList = FileUtil.importExcel(file,0,1,Demands.class);
        for (Demands demands : demandsList){
            Demands demand=new Demands();
            demand.setDept_name(demands.getDept_name());
            demand.setDept_id(demands.getDept_id());
            demand.setEmp_id(demands.getEmp_id());
            demand.setPost_id(demands.getPost_id());
            demand.setJob(demands.getJob());
            demandsService.addDemands(demand);
        }
        System.out.println("导入完成");
        return "redirect:viewdemands";
    }
}