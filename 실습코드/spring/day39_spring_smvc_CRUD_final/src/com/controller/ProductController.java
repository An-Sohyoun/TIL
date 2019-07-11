package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Product;
import com.vo.User;

@Controller
public class ProductController {

	@Resource(name = "pbiz")
	Biz<Integer, Product> biz;

	// ProductAdd
	@RequestMapping("/productadd.mc")
	public ModelAndView padd() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "product/add");
		mv.addObject("navi", Navi.productadd);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping("/productaddimpl.mc")
	public ModelAndView paddimpl(ModelAndView mv, Product product) {
		String imgname = product.getMf().getOriginalFilename();
		product.setImgname(imgname);

		try {
			biz.register(product);
			Utill.saveFile(product.getMf()); // register�� ������ �Ŀ� ������ �߰���
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.setViewName("main");
		return mv;
	}

	// ProductList
	@RequestMapping("/productlist.mc")
	public ModelAndView plist() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Product> list = null;

		try {
			list = biz.get();

		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("productlist", list);
		mv.addObject("center", "product/list");
		mv.addObject("navi", Navi.productlist);
		mv.setViewName("main");
		return mv;
	}

	// ProductDetail
	@RequestMapping("/productdetail.mc")
	public ModelAndView plist(ModelAndView mv, String id) { // request �� �ᵵ �̷��� �ϸ� �޾ƿ� �� ����
		Product product = null;

		try {
			product = biz.get(Integer.parseInt(id));
			mv.addObject("productdetail", product);
			mv.addObject("center", "product/detail");
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.setViewName("main");
		return mv;
	}

	// ProductUpdate
	@RequestMapping("/productupdateimpl.mc")
	public String productupdateimpl(Product product) {
	
		try {
			if (product.getMf().getSize() != 0) { // �̹��� ������ �ٲ� ���
				product.setImgname(product.getMf().getOriginalFilename());
				// product ���� Mf�� ���� �̸��� �����ʹ޶�
				Utill.saveFile(product.getMf()); // �̹��� ���ε�
			}

			biz.modify(product); // DB�� update ��û
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:productdetail.mc?id=" + product.getId();
	}

	@RequestMapping("/productupdate.mc")
	public ModelAndView pupdate(ModelAndView mv, String id) {
		// DATA�� String ���·� �ְ� �����Ƿ�, String ���·� ���� �� int�� ��ȯ
		Product product = null;

		try {
			product = biz.get(Integer.parseInt(id));

			mv.addObject("productupdate", product);
			mv.addObject("center", "product/update");
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.setViewName("main");
		return mv;
	}

	// ProductDelete
	@RequestMapping("/productdelete.mc")
	public String pdel(ModelAndView mv, String id) {

		try {
			biz.remove(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:productlist.mc"; // �ٽ� ����Ʈ�� ����� �� �ֵ��� ��(�׻� mv�� ��µǴ� ���� �ƴ�)
	}

}
