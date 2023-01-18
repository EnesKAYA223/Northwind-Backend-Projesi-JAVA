package com.enes.northwindProject.business.abstacts;


import com.enes.northwindProject.core.entities.User;
import com.enes.northwindProject.core.utilities.results.DataResult;
import com.enes.northwindProject.core.utilities.results.Result;

public interface UserService {

	Result Add(User user);
	
	
    DataResult<User> findByEmail(String email);


}
