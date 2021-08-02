package cn.edu.guet.bean;

public class WorkOver {
    private String addwork_application_key;
    private String emp_id;
    private String dept_id;
    private String emp_name;
    private String emp_app_begin_time;
    private String emp_app_endding_time;
    private String addwork_content;
    private String addwork_conductor;
    private String addwork_state;

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getAddwork_application_key() {
        return addwork_application_key;
    }

    public void setAddwork_application_key(String addwork_application_key) {
        this.addwork_application_key = addwork_application_key;
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

    public String getEmp_app_begin_time() {
        return emp_app_begin_time;
    }

    public void setEmp_app_begin_time(String emp_app_begin_time) {
        this.emp_app_begin_time = emp_app_begin_time;
    }

    public String getEmp_app_endding_time() {
        return emp_app_endding_time;
    }

    public void setEmp_app_endding_time(String emp_app_endding_time) {
        this.emp_app_endding_time = emp_app_endding_time;
    }

    public String getAddwork_content() {
        return addwork_content;
    }

    public void setAddwork_content(String addwork_content) {
        this.addwork_content = addwork_content;
    }

    public String getAddwork_conductor() {
        return addwork_conductor;
    }

    public void setAddwork_conductor(String addwork_conductor) {
        this.addwork_conductor = addwork_conductor;
    }

    public String getAddwork_state() {
        return addwork_state;
    }

    public void setAddwork_state(String addwork_state) {
        this.addwork_state = addwork_state;
    }

    @Override
    public String toString() {
        return "WorkOver{" +
                "emp_id='" + emp_id + '\'' +
                ", dept_id='" + dept_id + '\'' +
                ", emp_app_begin_time='" + emp_app_begin_time + '\'' +
                ", emp_app_endding_time='" + emp_app_endding_time + '\'' +
                ", addwork_content='" + addwork_content + '\'' +
                ", addwork_conductor='" + addwork_conductor + '\'' +
                ", addwork_state='" + addwork_state + '\'' +
                '}';
    }
}
