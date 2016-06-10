package com.app.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.VersionDao;
import com.model.VersionInfo;

@Controller
public class DownloadController {

	@Resource
	VersionDao versionDao;

	@RequestMapping("download")
	public void download(HttpServletRequest req, HttpServletResponse res) {

		try {
			VersionInfo version = versionDao.queryVersion();
			FileInputStream in = new FileInputStream(
					req.getRealPath("") + "/WEB-INF/apk/xiaoxing_" + version.getName() + ".apk");
			res.setHeader("content-disposition", "attachment;filename="
					+ "xiaoxing_" + version.getName() + ".apk");
			res.addHeader("Content-Length", "" + in.getChannel().size());
			res.setContentType("application/octet-stream;charset=UTF-8");

			OutputStream out = res.getOutputStream();
			int len = 0;
	        //5.创建数据缓冲区
	        byte[]buffer = new byte[1024];
	        //7.将FileInputStream流写入到buffer缓冲区
	        while((len = in.read(buffer)) > 0) {
	            //8.使用OutputStream将缓冲区的数据输出到客户端浏览器
	            out.write(buffer,0, len);
	        }
	        in.close();
	        out.close();
		} catch (IOException e) {
			//会报异常org.apache.catalina.connector.ClientAbortException: java.io.IOException
			//问题出在Tomcat的connectionTimeout（网络连接超时时间毫秒数）
		}

	}

}
