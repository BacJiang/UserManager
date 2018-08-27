package com.hikvision.usermanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FriendsRelationDao {
	List<Integer> queryById(@Param("id")int id);
}
