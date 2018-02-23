package dream.blog.practice.ehcache.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import dream.blog.practice.ehcache.dao.UserDao;
import dream.blog.practice.ehcache.model.User;

@Component
public class UserDaoImpl implements UserDao {

	private static Map<Integer, User> users = new HashMap<>();
	
	static {
		users.put(1, new User("Tom","1234"));
		users.put(2, new User("Jack","1234"));
		users.put(3, new User("Jim","1234"));
		users.put(4, new User("Laura","1234"));
		users.put(5, new User("Imp","1234"));
	}
	
	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User findById(Integer id) {
		System.err.println("Fetching from DB:" + id);
		return users.get(id);
	}
	
}
