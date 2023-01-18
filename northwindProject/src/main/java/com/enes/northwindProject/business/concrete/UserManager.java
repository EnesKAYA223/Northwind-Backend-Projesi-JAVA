package com.enes.northwindProject.business.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enes.northwindProject.business.abstacts.UserService;
import com.enes.northwindProject.core.dataAccess.UserDao;
import com.enes.northwindProject.core.entities.User;
import com.enes.northwindProject.core.utilities.results.DataResult;
import com.enes.northwindProject.core.utilities.results.Result;
import com.enes.northwindProject.core.utilities.results.SuccessDataResult;
import com.enes.northwindProject.core.utilities.results.SuccessResult;


@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result Add(User user) {
		 this.userDao.save(user);
		return new SuccessResult("Kullanici Eklendi");
	}

	@Override													
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanici Bulundu");
	}

	
}
