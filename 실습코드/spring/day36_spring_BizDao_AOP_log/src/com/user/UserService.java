package com.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
// AOP�� ������ �ڵ忡 �α׸� ��� �Լ��� ��� ����
import com.vo.User;

@Service("ubiz")
public class UserService implements Biz<String, User> {
	@Resource(name = "udao")
	Dao<String, User> dao;

	public void startBiz() {
		System.out.println("Start Biz ...");
	}

	public void endBiz() {
		System.out.println("End Biz ...");
	}

	public void setDao(Dao<String, User> dao) {
		this.dao = dao;
	}

	@Override
	public void insert(User v) throws Exception {

		dao.insert(v);
	}

	@Override
	public void update(User v) throws Exception {

		dao.update(v);

	}

	@Override
	public void delete(String k) throws Exception {
		dao.delete(k);

	}

	@Override
	public User select(String k) throws Exception {
		System.out.println("----- Biz Selected -----");
		// Thread.sleep(2800); // 2.8�� ���� delay time�� �־� Processing Time�� ����� �����Ǵ��� Ȯ��
//		if(k.equals("id00")) {
//			throw new Exception("Not Found Exception..");
//		}
		return dao.select(k);

	}

	@Override
	public ArrayList<User> select() throws Exception {
		return dao.select();
	}

}
