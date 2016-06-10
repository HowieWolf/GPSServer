package com.admin.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dao.VersionDao;
import com.model.VersionInfo;

@Controller
@RequestMapping("/admin")
public class UploadController {

	@Resource
	VersionDao versionDao;
	
	@RequestMapping(value = "/submitNewVersion", method = RequestMethod.POST)
	public String submitNewVersion(VersionInfo info, @RequestParam("newApk") CommonsMultipartFile newApk,
			HttpSession session, HttpServletRequest req) {
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		if (isLogin != null && isLogin) {
			try {
				if (!newApk.isEmpty() && newApk.getOriginalFilename().toLowerCase().endsWith(".apk")) {
					// 拿到输出流，同时重命名上传的文件
					FileOutputStream os = new FileOutputStream(req.getRealPath("")+"/WEB-INF/apk/xiaoxing_" + info.getName() + ".apk");
					// 拿到上传文件的输入流
					FileInputStream in = (FileInputStream) newApk.getInputStream();
					
					// 以写字节的方式写文件
					int b = 0;
					while ((b = in.read()) != -1) {
						os.write(b);
					}
					os.flush();
					os.close();
					in.close();
					versionDao.addVersion(info);
					req.setAttribute("result", "上传成功");
				} else {
					req.setAttribute("result", "上传失败");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				req.setAttribute("result", "上传失败");
			}

			return "upload";
		}
		return "redirect:/";
	}

}
