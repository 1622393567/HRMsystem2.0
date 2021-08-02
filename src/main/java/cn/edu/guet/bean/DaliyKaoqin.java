package cn.edu.guet.bean;

public class DaliyKaoqin {

    private int daliy_work_key;
    private String emp_id;
    private String dept_id;
    private String emp_name;
    private String work_begin_time;
    private String work_endding_time;
    private String work_state;
    private String work_states;
    private String month;

    public String getWork_states() {
        return work_states;
    }

    public void setWork_states(String work_states) {
        this.work_states = work_states;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getDaliy_work_key() {
        return daliy_work_key;
    }

    public void setDaliy_work_key(int daliy_work_key) {
        this.daliy_work_key = daliy_work_key;
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

    public String getWork_begin_time() {
        return work_begin_time;
    }

    public void setWork_begin_time(String work_begin_time) {
        this.work_begin_time = work_begin_time;
    }

    public String getWork_endding_time() {
        return work_endding_time;
    }

    public void setWork_endding_time(String work_endding_time) {
        this.work_endding_time = work_endding_time;
    }

    public String getWork_state() {
        return work_state;
    }

    public void setWork_state(String work_state) {
        this.work_state = work_state;
    }

    @Override
    public String toString() {
        return "DaliyKaoqin{" +
                "emp_id='" + emp_id + '\'' +
                ", dept_id='" + dept_id + '\'' +
                ", work_begin_time='" + work_begin_time + '\'' +
                ", work_endding_time='" + work_endding_time + '\'' +
                ", work_state='" + work_state + '\'' +
                '}';
    }
}
