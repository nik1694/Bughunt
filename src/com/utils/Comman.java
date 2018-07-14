package com.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class Comman {
	
	public static int getPriority(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static int getStatus(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static String getVersion(){
		String [] version = Constant.version;
		int idx = new Random().nextInt(version.length);
		String randoms = (version[idx]);
		return randoms;
	}
	
	public static String getReasion(){
		String [] reasion = Constant.reasion;
		int idx = new Random().nextInt(reasion.length);
		String reasions = (reasion[idx]);
		return reasions;
	}
	public static String getOS(){
		String [] os = Constant.os;
		int idx = new Random().nextInt(os.length);
		String reasions = (os[idx]);
		return reasions;
	}
	public static String getTech(){
		String [] os = Constant.tech;
		int idx = new Random().nextInt(os.length);
		String reasions = (os[idx]);
		return reasions;
	}
	public static String getSolution(){
		String [] solution = Constant.solution;
		int idx = new Random().nextInt(solution.length);
		String solutions = (solution[idx]);
		return solutions;
	}
	
	public static boolean fileUploader(HttpServletRequest request, HttpServletResponse response) {
		/*referance links 
		 * 
		 * http://javainfinite.com/jsp-and-servlet/saving-image-in-folder-and-path-in-database-using-java/
		 * 
		 * 
		 * */
		try {

			HttpSession session = request.getSession();
			String name = request.getParameter("unname");
			Part filePart = request.getPart("filecover");

			String photo = "";
			String path = "~/iparker/root";

			File file = new File(path);
			file.mkdir();
			String fileName = getFileName(filePart);

			OutputStream out = null;

			InputStream filecontent = null;

			PrintWriter writer = response.getWriter();
			try {
				out = new FileOutputStream(new File(path + File.separator + fileName));
				filecontent = filePart.getInputStream();
				int read = 0;
				final byte[] bytes = new byte[1024];
				while ((read = filecontent.read(bytes)) != -1) {
					out.write(bytes, 0, read);
					photo = path + "/" + fileName;
				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	private static String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");

		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
