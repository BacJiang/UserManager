package com.hikvision.usermanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hikvision.usermanager.bean.UserInfo;

@Mapper
public interface UserDao {

	int insert(UserInfo userInfo);

	int deleteById(int id);

	int update(UserInfo userInfo);

	List<UserInfo> findAllUser();

	UserInfo queryByName(String userName);
	
	UserInfo queryById(int id);
	
	int alterTable();
}
