package com.dudu.springbootdemo1.user.servicce;

import com.dudu.springbootdemo1.config.listener.MyEvent;
import com.dudu.springbootdemo1.dao.student.mapper.StudentMapper;
import com.dudu.springbootdemo1.domain.User;
import com.dudu.springbootdemo1.domain.student.Student;
import com.dudu.springbootdemo1.domain.student.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/12/24 8:34 下午
 */
@Service
public class UserService {
    @Resource
    private ApplicationContext applicationContext;
    @Autowired
    private StudentMapper studentMapper;

    public User getUser2(){
        User user = new User(10002, "李四", "147258");
        //发布事件
        MyEvent myEvent = new MyEvent(this,user);
        applicationContext.publishEvent(myEvent);
        return user;
    }
    public Student queryUser(){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andCourseEqualTo("数学");
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students.get(0);
    }
}
