package cn.edu.guet.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class Applicant {

  public Integer applicant_info_key;

    @Excel(name = "姓名",orderNum = "0")
  public String applicant_name;

    @Excel(name = "性别",orderNum = "1")
  public String applicant_sex;

    @Excel(name = "状态",orderNum = "2")
  public String applicant_state;

    @Excel(name = "证件类型",orderNum = "3")
  public String applicant_identify_type;

    @Excel(name = "证件号码",orderNum = "4")
  public String applicant_identify_number;

    @Excel(name = "电话号码",orderNum = "5")
  public String applicant_phone_number;

    @Excel(name = "邮箱",orderNum = "6")
  public String applicant_e_mail;

    @Excel(name = "民族",orderNum = "7")
  public String applicant_nation;

    @Excel(name = "籍贯",orderNum = "8")
  public String applicant_native_place;

    @Excel(name = "生日",orderNum = "9")
  public String applicant_birthday;

    @Excel(name = "居住地",orderNum = "10")
  public String applicant_location;

    @Excel(name = "学历",orderNum = "11")
  public String applicant_edu_bgd;

    @Excel(name = "招聘渠道",orderNum = "12")
  public String applicant_entry_way;

    @Excel(name = "毕业学校",orderNum = "13")
  public String applicant_edu_school;

    @Excel(name = "职位意向",orderNum = "14")
  public String applicant_post_intention;
  public String emp_id;
  public String dept_id;
  public String post_id;

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getApplicant_post_intention() {
        return applicant_post_intention;
    }

    public void setApplicant_post_intention(String applicant_post_intention) {
        this.applicant_post_intention = applicant_post_intention;
    }

    public Integer getApplicant_info_key() {
        return applicant_info_key;
    }

    public void setApplicant_info_key(Integer applicant_info_key) {
        this.applicant_info_key = applicant_info_key;
    }

    public String getApplicant_identify_number() {
        return applicant_identify_number;
    }

    public void setApplicant_identify_number(String applicant_identify_number) {
        this.applicant_identify_number = applicant_identify_number;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public String getApplicant_sex() {
        return applicant_sex;
    }

    public void setApplicant_sex(String applicant_sex) {
        this.applicant_sex = applicant_sex;
    }

    public String getApplicant_state() {
        return applicant_state;
    }

    public void setApplicant_state(String applicant_state) {
        this.applicant_state = applicant_state;
    }

    public String getApplicant_identify_type() {
        return applicant_identify_type;
    }

    public void setApplicant_identify_type(String applicant_identify_type) {
        this.applicant_identify_type = applicant_identify_type;
    }

    public String getApplicant_phone_number() {
        return applicant_phone_number;
    }

    public void setApplicant_phone_number(String applicant_phone_number) {
        this.applicant_phone_number = applicant_phone_number;
    }

    public String getApplicant_e_mail() {
        return applicant_e_mail;
    }

    public void setApplicant_e_mail(String applicant_e_mail) {
        this.applicant_e_mail = applicant_e_mail;
    }

    public String getApplicant_nation() {
        return applicant_nation;
    }

    public void setApplicant_nation(String applicant_nation) {
        this.applicant_nation = applicant_nation;
    }

    public String getApplicant_native_place() {
        return applicant_native_place;
    }

    public void setApplicant_native_place(String applicant_native_place) {
        this.applicant_native_place = applicant_native_place;
    }

    public String getApplicant_birthday() {
        return applicant_birthday;
    }

    public void setApplicant_birthday(String applicant_birthday) {
        this.applicant_birthday = applicant_birthday;
    }

    public String getApplicant_location() {
        return applicant_location;
    }

    public void setApplicant_location(String applicant_location) {
        this.applicant_location = applicant_location;
    }

    public String getApplicant_edu_bgd() {
        return applicant_edu_bgd;
    }

    public void setApplicant_edu_bgd(String applicant_edu_bgd) {
        this.applicant_edu_bgd = applicant_edu_bgd;
    }

    public String getApplicant_entry_way() {
        return applicant_entry_way;
    }

    public void setApplicant_entry_way(String applicant_entry_way) {
        this.applicant_entry_way = applicant_entry_way;
    }

    public String getApplicant_edu_school() {
        return applicant_edu_school;
    }

    public void setApplicant_edu_school(String applicant_edu_school) {
        this.applicant_edu_school = applicant_edu_school;
    }
}
