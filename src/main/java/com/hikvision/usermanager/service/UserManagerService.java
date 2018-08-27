package com.hikvision.usermanager.service;

import java.util.List;

import com.hikvision.usermanager.bean.UserInfo;

public interface UserManagerService {
	boolean login(String userName, String password);

	List<UserInfo> queryAllUser();

	int insertUser(UserInfo userInfo);

	int updateUserInfo(UserInfo userInfo);

	int deleteUser(int id);
	
	List<UserInfo> queryFriends(int id);
}
