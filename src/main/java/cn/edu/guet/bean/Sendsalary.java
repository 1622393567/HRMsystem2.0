package cn.edu.guet.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class Sendsalary {
    private int emp_salary_key;

    @Excel(name="员工号",orderNum = "0")
    private String emp_id;

    @Excel(name="年月",orderNum = "1")
    private String datem;

    @Excel(name="基本工资",orderNum = "2")
    private String emp_basic_salary;

    @Excel(name="奖金补贴",orderNum = "3")
    private String emp_bonus;

    @Excel(name="加班",orderNum = "4")
    private String emp_addwork;

    @Excel(name="惩处",orderNum = "5")
    private String emp_punish;

    @Excel(name="五险一金",orderNum = "6")
    private String emp_insurance;

    @Excel(name="个税",orderNum = "7")
    private String emp_tax;

    @Excel(name="应发工资",orderNum = "8")
    private String emp_should_salary;

    @Excel(name="实发工资",orderNum = "9")
    private String emp_real_salary;


    public int getEmp_salary_key() {
        return emp_salary_key;
    }

    public void setEmp_salary_key(int emp_salary_key) {
        this.emp_salary_key = emp_salary_key;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getDatem() {
        return datem;
    }

    public void setDatem(String datem) {
        this.datem = datem;
    }

    public String getEmp_basic_salary() {
        return emp_basic_salary;
    }

    public void setEmp_basic_salary(String emp_basic_salary) {
        this.emp_basic_salary = emp_basic_salary;
    }

    public String getEmp_bonus() {
        return emp_bonus;
    }

    public void setEmp_bonus(String emp_bonus) {
        this.emp_bonus = emp_bonus;
    }

    public String getEmp_addwork() {
        return emp_addwork;
    }

    public void setEmp_addwork(String emp_addwork) {
        this.emp_addwork = emp_addwork;
    }

    public String getEmp_punish() {
        return emp_punish;
    }

    public void setEmp_punish(String emp_punish) {
        this.emp_punish = emp_punish;
    }

    public String getEmp_insurance() {
        return emp_insurance;
    }

    public void setEmp_insurance(String emp_insurance) {
        this.emp_insurance = emp_insurance;
    }

    public String getEmp_tax() {
        return emp_tax;
    }

    public void setEmp_tax(String emp_tax) {
        this.emp_tax = emp_tax;
    }

    public String getEmp_should_salary() {
        return emp_should_salary;
    }

    public void setEmp_should_salary(String emp_should_salary) {
        this.emp_should_salary = emp_should_salary;
    }

    public String getEmp_real_salary() {
        return emp_real_salary;
    }

    public void setEmp_real_salary(String emp_real_salary) {
        this.emp_real_salary = emp_real_salary;
    }


}
