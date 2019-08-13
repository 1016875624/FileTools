package com.file.service;

import java.io.File;
import java.io.IOException;

import com.file.tool.FileUtil;
import com.file.tool.PackupToZip;

public class FileToolImpl implements FileTool{
	
	@Override
	public void copy(String src, String dest) {
		File srcFile=new File(src);
		if (srcFile.isDirectory()) {
			FileUtil.copyFloderByInputStream(src, dest);
		}
		else {
			FileUtil.copyFileByInputStream(src, dest);
		}
	}

	@Override
	public void delete(String path) {
		FileUtil.deleteFloder(path);
	}

	@Override
	public void zip(String path) {
		File file=new File(path);
		try {
			PackupToZip.compress(path, file.getParentFile().getAbsolutePath()+file.separator+file.getName()+".zip");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void zip(File[] files) {
		try {
			PackupToZip.compress(files, files[0].getParentFile().getAbsolutePath()+File.separator+files[0].getParentFile().getName()+".zip");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unzip(String path) {
		try {
			PackupToZip.decompress(path, path.substring(0, path.lastIndexOf('.')+1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
