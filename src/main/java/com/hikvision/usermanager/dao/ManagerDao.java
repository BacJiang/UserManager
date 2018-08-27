package com.hikvision.usermanager.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hikvision.usermanager.bean.ManagerInfo;

@Mapper
public interface ManagerDao {
	ManagerInfo queryByName(String userName);
}
