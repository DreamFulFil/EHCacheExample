package dream.blog.practice.ehcache.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import dream.blog.practice.ehcache.dao.UserDao;
import dream.blog.practice.ehcache.model.User;
import dream.blog.practice.ehcache.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	private static volatile int count = 0;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Cacheable(value = "propertiesCache")
	@Override
	public User findById(Integer id) {
		try {
			Thread.sleep(1000);
			count++;
			return userDao.findById(id);
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@CacheEvict(value = "propertiesCache")
	@Override
	public User findByIdClearCache(Integer id) {
		count++;
		return userDao.findById(id);
	}

	@Override
	public int getMethodInvokedCount() {
		return UserServiceImpl.count;
	}

}
