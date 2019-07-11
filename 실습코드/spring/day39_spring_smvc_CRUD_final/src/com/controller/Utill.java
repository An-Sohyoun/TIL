package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utill {
	public static void saveFile(MultipartFile mf) { // ������ �־��ָ� Ư�� ���丮�� ����
		String dir = "C:\\spring\\smvc4\\web\\img\\"; // Web�� image�� ������ �ž� ���߿� �� �� ����
		byte[] data; // byte array �غ�
		String imgname = mf.getOriginalFilename(); // mf�� �־��ָ� ������ �� ����
		try {
			data = mf.getBytes(); // ������ �ø��� �� byte array�� ��..?
			FileOutputStream fo = new FileOutputStream(dir + imgname);
			fo.write(data);
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
