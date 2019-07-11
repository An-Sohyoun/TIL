package com.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.frame.Biz;
import com.frame.Dao;
import com.vo.User;


@Service("ubiz")
public class UserBiz implements Biz<String, User>{

	@Resource(name="udao") // UserBiz�� �ͼ� �ٽ� udao�� ���� �� UserDao�� ��
	Dao<String, User> dao;
	
	// @Transactional // Transaction ó���� ���Ͽ� �ߺ��Ǵ� �� �� �����Ͱ� �߸� ���� ���� ���� �� Biz������ �������൵��
	@Override
	public void register(User v) throws Exception {	
		dao.insert(v);
	}

	@Override
	public void modify(User v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k); // biz���� dao�� ȣ����
		
	}

	@Override
	public User get(String k) throws Exception {
		dao.select(k);	
		System.out.println("get����");
		return dao.select(k);
	}

	@Override
	public ArrayList<User> get() throws Exception {
		
		return dao.select();
		
	}
	

}
