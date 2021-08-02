package cn.edu.guet.bll.impl;

import cn.edu.guet.bean.DaliyKaoqin;
import cn.edu.guet.bll.IDaliyKaoqinService;
import cn.edu.guet.mapper.DaliyKaoqinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaliyKaoqinServiceImpl implements IDaliyKaoqinService {

    @Autowired
    private DaliyKaoqinMapper daliyKaoqinMapper;
    @Override
    public List<DaliyKaoqin> viewDaliyKaoqin() {
        return daliyKaoqinMapper.viewDaliyKaoqin();
    }

    @Override
    public List<DaliyKaoqin> viewperDaliyKaoqin(String emp_id) {
        return daliyKaoqinMapper.viewperDaliyKaoqin(emp_id);
    }

    @Override
    public List<DaliyKaoqin> selectId() {
        return daliyKaoqinMapper.selectId();
    }

    @Override
    public List<DaliyKaoqin> selectMonth() {
        return daliyKaoqinMapper.selectMonth();
    }

    @Override
    public void signIn(String emp_id, String work_begin_time) {
        daliyKaoqinMapper.signIn(emp_id,work_begin_time);
    }

    @Override
    public void signOut(String emp_id, String work_endding_time) {
        daliyKaoqinMapper.signOut(emp_id,work_endding_time);
    }

    @Override
    public void worksignIn(String emp_id, String real_begin_time) {
        daliyKaoqinMapper.worksignIn(emp_id,real_begin_time);
    }

    @Override
    public void worksignOut(String emp_id, String real_endding_time) {
        daliyKaoqinMapper.worksignOut(emp_id,real_endding_time);
    }


    @Override
    public List<DaliyKaoqin> getByName(String name) {
        return daliyKaoqinMapper.getByName(name);
    }
}
