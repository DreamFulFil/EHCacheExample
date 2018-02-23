package dream.blog.practice.ehcache.service;

import java.util.List;

import dream.blog.practice.ehcache.model.User;

public interface UserService {

	List<User> findAll();
	
	User findById(Integer id);
	
	User findByIdClearCache(Integer id);
	
	int getMethodInvokedCount();
	
}
