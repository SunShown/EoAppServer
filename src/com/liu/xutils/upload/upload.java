package com.liu.xutils.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class upload extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(getServletConfig(), request, response);
		try {
			smartUpload.upload();
			String realPath = this.getServletContext().getRealPath("upload");
			System.out.println(realPath);
			File dir = new File(realPath);
			if (!dir.exists())
				dir.mkdir();
			// 支持多文件上传
			System.out.println("文件个数:" + smartUpload.getFiles().getCount());
			for (int i = 0; i < smartUpload.getFiles().getCount(); i++) {
				com.jspsmart.upload.SmartFile poster = smartUpload.getFiles()
						.getFile(i);
				System.out.println(poster.isMissing());
				if (!poster.isMissing()) {
					File file = new File(getServletContext().getRealPath(
							"upload"), poster.getFileName());
					String saveFileName = file.getAbsolutePath();
					// 以服务器根目录创建文件目录结构
					poster.saveAs("/upload/" + poster.getFilePathName(),
							smartUpload.SAVE_VIRTUAL);
					System.out.println(poster.getFilePathName());
				} else {
					response.getWriter().print("失败");
				}
			}

		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}
	
}
