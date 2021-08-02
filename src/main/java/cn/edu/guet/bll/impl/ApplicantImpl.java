package cn.edu.guet.bll.impl;
import cn.edu.guet.bean.Applicant;
import cn.edu.guet.bll.ApplicantService;
import cn.edu.guet.config.Log;
import cn.edu.guet.mapper.ApplicantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
 class ApplicantImpl implements ApplicantService {
    @Autowired
    private ApplicantMapper applicantMapper;
    @Override
    public List<Applicant> viewApplicant() {
        return applicantMapper.viewApplicant();
    }

    @Override
    @Log("删除应聘者信息")
    public void deleteApplicant(String applicantId) {
        applicantMapper.deleteApplicant(applicantId);
    }
    @Override
    @Log("同意面试，改变状态为待面试")
    public void passApplicant(String applicantId) {
        applicantMapper.passApplicant(applicantId);
    }

    @Override
    @Log("通过面试，改变状态为面试通过")
    public void admitApplicant(String applicantId) {
        applicantMapper.admitApplicant(applicantId);
    }

    @Override
    @Log("不通过面试，并删除面试者数据")
    public void noadmitApplicant(String applinticantId) {
        applicantMapper.noadmitApplicant(applinticantId);
    }

    @Override
    public List<Applicant> findpassApplicant(String keyword) {
        return applicantMapper.findpassApplicant(keyword);
    }

    @Override

    public String findmail(String applinticantId) {
        return applicantMapper.findmail(applinticantId);
    }

    @Override
    public List<Applicant> viewadmitApplicant() {
        return applicantMapper.viewadmitApplicant();
    }

    @Override
    public List<Applicant> findadmitApplicant(String keyword) {
        return applicantMapper.findadmitApplicant(keyword);
    }

    @Override
    @Log("删除面试通过者")
    public void deleteadmitApplicant(String applinticantId) {
        applicantMapper.deleteadmitApplicant(applinticantId);
    }

    @Override
    @Log("把面试通过者状态改为待报到")
    public void toreport(String applicantId) {
        applicantMapper.toreport(applicantId);
    }

    @Override
    public List<Applicant> viewreportApplicant() {
        return applicantMapper.viewreportApplicant();
    }

    @Override
    public List<Applicant> findreportApplicant(String keyword) {
        return applicantMapper.findreportApplicant(keyword);
    }

    @Override
    @Log("删除待报到者")
    public void deletereportApplicant(String applinticantId) {
          applicantMapper.deletereportApplicant(applinticantId);
    }

    @Override
    @Log("根据id，把分配了员工号的录用者信息插入员工表，调用了存储过程，参数为员工号和id")
    public void report(String empid,int id) {
         applicantMapper.report(empid,id);
    }

    @Override
    public String findpost(String applinticantId) {
        return applicantMapper.findpost(applinticantId);
    }

    @Override
    public String findempid(int id) {
        return applicantMapper.findempid(id);
    }

    @Override
    public List<Applicant> searchApplicant(String keyword) {
        return applicantMapper.searchApplicant(keyword);
    }

    @Override
    @Log("添加应聘者")
    public int addApplicant(Applicant applicant) {

        return applicantMapper.addApplicant(applicant);
    }

    @Override
    @Log("编辑应聘者信息，更新数据")
    public int editApplicant(Applicant applicant) {
        return applicantMapper.editApplicant(applicant);
    }

    @Override
    public Applicant findByid(int id) {
        return applicantMapper.findByid(id);
    }

    @Override
    public List<Applicant> viewpassApplicant() {
        return applicantMapper.viewpassApplicant();
    }
}
