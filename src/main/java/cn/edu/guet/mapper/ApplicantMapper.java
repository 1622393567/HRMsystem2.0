package cn.edu.guet.mapper;

import cn.edu.guet.bean.Applicant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplicantMapper {
    //查看应聘者
    List<Applicant> viewApplicant();
    //删除所选应聘者
    void deleteApplicant(String applinticantId);
    //同意面试
    void passApplicant(String applicantId);
    //关键字搜索
    List<Applicant> searchApplicant(String keyword);
    //添加
    int addApplicant(Applicant applicant);
    //修改
    int editApplicant(Applicant applicant);
    //根据id查询
    Applicant findByid(int id);

    /************************************************************************************************************************/
    //查看面试者
    List<Applicant> viewpassApplicant();
    //通过面试
    void admitApplicant(String applicantId);
    //面试失败
    void noadmitApplicant(String applinticantId);
    //关键字搜索
    List<Applicant> findpassApplicant(String keyword);
   //获取邮箱

    String findmail(String applinticantId);

    String findpost(String applinticantId);

    /************************************************************************************************************************/
    //查看通过面试人员
    List<Applicant> viewadmitApplicant();
    //关键字搜索
    List<Applicant> findadmitApplicant(String keyword);
    //删除
    void deleteadmitApplicant(String applinticantId);
    //待报到
    void toreport(String applicantId);




    //查看待报到人员
    List<Applicant> viewreportApplicant();

    //关键字搜索
    List<Applicant> findreportApplicant(String keyword);
    //删除
    void deletereportApplicant(String applinticantId);
    //已经报到
    void report(@Param("empid") String empid, @Param("id") int id);

     String  findempid(int id);

}
