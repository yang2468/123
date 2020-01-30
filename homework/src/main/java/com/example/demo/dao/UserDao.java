package com.example.demo.dao;


import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    //增加
    @Insert("INSERT INTO course(img, title, name, des,classify, isdownload, empower) value(#{img},#{title},#{name}" +
            ",#{des},#{classify},#{isdownload},#{empower})")
    void add(String img,String title,String name,String des,String classify,Integer isdownload,String empower);

    //删除
    @Delete("DELETE FROM course WHERE id = #{id} ")
    void del(long id);

    //查找一个
    @Select("SELECT * FROM course where id = #{id} ")
    User get(long id);

    //查找多个
    @Select("SELECT * FROM course")
    List<User> lists();

    //修改
    @Update("UPDATE course set img=#{img},title=#{title},name=#{name},des=#{des},classify=#{classify},isdownload=" +
            "#{isdownload},empower=#{empower} where id=#{id}")
    void up(User user);
}
