package ejb.service;

import com.alibaba.fastjson.JSON;
import ejb.pojo.Admin;
import ejb.pojo.Student;

public class JsonService {
    public static Student parseStudent(String str) {
        return JSON.parseObject(str, Student.class);
    }

    public static Admin parseAdmin(String str) {
        return JSON.parseObject(str, Admin.class);
    }
}
