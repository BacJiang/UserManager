package com.hikvision.usermanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hikvision.usermanager.bean.ManagerInfo;
import com.hikvision.usermanager.bean.UserInfo;
import com.hikvision.usermanager.dao.FriendsRelationDao;
import com.hikvision.usermanager.dao.ManagerDao;
import com.hikvision.usermanager.dao.UserDao;
import com.hikvision.usermanager.service.UserManagerService;

@Service
public class UserManagerImpl implements UserManagerService {
	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FriendsRelationDao friendsRleationDao;

	@Override
	public boolean login(String userName, String password) {
		ManagerInfo userCheck = managerDao.queryByName(userName);
		if (userName.equals(userCheck.getUserName()) && password.equals(userCheck.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public List<UserInfo> queryAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}

	@Override
	public int updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userDao.update(userInfo);
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userDao.alterTable();
		return userDao.insert(userInfo);
	}

	@Override
	public List<UserInfo> queryFriends(int id) {
		// TODO Auto-generated method stub
		List<UserInfo> friendsInfo = new ArrayList<>();
		for(int friendId : friendsRleationDao.queryById(id) ) {
			System.out.println("======================"+friendId);
			System.out.println(userDao.queryById(friendId).getUserName());
			friendsInfo.add(userDao.queryById(friendId));
		}
		return friendsInfo;
	}
	
	
	
	

}
