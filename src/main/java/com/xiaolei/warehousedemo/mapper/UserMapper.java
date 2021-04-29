package com.xiaolei.warehousedemo.mapper;

import com.xiaolei.warehousedemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    List<User> findUser(String username);

    User findUserByUsername(String username);

    int updateUserById(User user);

    int deleteUserById(int id);

    int saveUser(User user);

    List<User> getUserList();

    int getcount();
    List<User> getUserBypage(int page,int size);

}
