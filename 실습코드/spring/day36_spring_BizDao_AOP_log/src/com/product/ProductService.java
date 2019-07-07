package com.product;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vo.Product;
import com.frame.Dao;
// AOP�� ������ �ڵ忡 �α׸� ��� �Լ��� ��� ����
import com.frame.Biz;

@Service("pbiz")
public class ProductService implements Biz<String, Product> {
	@Resource(name="pdao")
	Dao<String, Product> dao;
	
	public void startBiz() {
		System.out.println("Start Biz ...");
	}
	
	public void endBiz() {
		System.out.println("End Biz ...");
	}
	
	public void setDao(Dao<String, Product> dao) {
		this.dao = dao;
	}

	public void insert(Product v) throws Exception {
		
		dao.insert(v);
	}

	public void update(Product v) throws Exception {
		
		dao.update(v);

	}

	@Override
	public void delete(String k) throws Exception {
		dao.delete(k);

	}

	@Override
	public Product select(String k) throws Exception {
		System.out.println("----- Biz Selected -----");
		//Thread.sleep(2800); // 2.8�� ���� delay time�� �־� Processing Time�� ����� �����Ǵ��� Ȯ��
//		if(k.equals("id00")) {
//			throw new Exception("Not Found Exception..");
//		}
		return dao.select(k);
		
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		return dao.select();
	}

}







