package dream.blog.practice.ehcache.dao;

import java.util.List;

import dream.blog.practice.ehcache.model.User;

public interface UserDao {
	
	List<User> findAll();
	
	User findById(Integer id);
	
}
