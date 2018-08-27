package com.hikvision.usermanager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.hikvision.usermanager.bean.UserInfo;
import com.hikvision.usermanager.dao.FriendsRelationDao;
import com.hikvision.usermanager.dao.ManagerDao;
import com.hikvision.usermanager.dao.UserDao;
import com.hikvision.usermanager.service.UserManagerService;

@Controller
@RequestMapping("/")
public class UserManagerController {
	@Autowired
	private ManagerDao managerDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserManagerService userManagerService;
	
	@Autowired
	private FriendsRelationDao friendsRelationDao;

	@RequestMapping(value = "/login")
	public String login() {
		return "/login";
	}

	@RequestMapping(value = "/tologin", method = RequestMethod.POST)
	public String tologin(@RequestParam(name = "username") String userName,
			@RequestParam(name = "password") String password, HttpSession session) throws IOException {
		session.removeAttribute("userName");
		if (null == userName || null == password) {
			return null;
		}
		if (userManagerService.login(userName, password)) {
			session.setAttribute("userName", userName);
			return "redirect:/main";
		} else {
			return "用户名或密码错误";
		}

	}

	@RequestMapping("/main")
	public ModelAndView mainView() {
		List<UserInfo> userList = userManagerService.queryAllUser();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", userList);
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	@RequestMapping("/insert")
	public String Insert(UserInfo userInfo) {
		System.out.println("========================"+userInfo.getUserName());
		userManagerService.insertUser(userInfo);
		return "redirect:/main";	
	}

	@RequestMapping("/update")
	public String update(UserInfo userInfo) {
		System.out.println("========================"+userInfo.getId());
		userManagerService.updateUserInfo(userInfo);
		return "redirect:/main";
	}
	
	@RequestMapping("/delete")
	public String delete(int id) {
		System.out.println("========================"+id);
		userManagerService.deleteUser(id);
		return "redirect:/main";
	}
	
//	@RequestMapping("/friends")
//	public ModelAndView friendsView() {
//		List<UserInfo> friendsList = userManagerService.queryFriends(id);
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("friendsList", friendsList);
//		modelAndView.setViewName("friends");
//		return modelAndView;
//	}
//	
	@RequestMapping("/friends")
	public ModelAndView friendId(@RequestParam("id")int id) {
		System.out.println("====================="+id);
		List<UserInfo> friendsList = userManagerService.queryFriends(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("friendsList", friendsList);
		modelAndView.setViewName("friends");
		return modelAndView;
	}


	@RequestMapping(value = "/show")
	public String queryByName() {
		System.out.println("==================="+friendsRelationDao.queryById(1));
		return null;
	}

}
