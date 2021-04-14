package com.information.mapper;

import com.information.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    public User getUser(String userName);

    public void setUserByPhone(@Param("phone")String phone, @Param("password")String password);

    public void setUserByEmail(@Param("email")String email, @Param("password")String password);

    public void updateUserCollection(@Param("userName")String userName,@Param("collection")String collection);

}
