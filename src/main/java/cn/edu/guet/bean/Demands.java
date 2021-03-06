package cn.edu.guet.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class Demands {
   private int demand_key;

   @Excel(name = "部门" ,orderNum = "0")
    private String dept_name;

   @Excel(name = "员工号",orderNum = "1")
    private String emp_id;
   @Excel(name = "部门id",orderNum = "2")
    private String  dept_id;

   @Excel(name = "职位id",orderNum = "3")
    private String post_id;

   @Excel(name = "需求职位",orderNum = "4")
    private String  job;

    public int getDemand_key() {
        return demand_key;
    }

    public void setDemand_key(int demand_key) {
        this.demand_key = demand_key;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
