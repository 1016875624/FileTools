package com.file.tool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class FileUtil {
	public static void deleteFloder(String path) {
		File file=new File(path);
		if (!file.isDirectory()) {
			file.delete();
		}
		else {
			File [] files=file.listFiles();
			for (File file2 : files) {
				if (file2.isDirectory()) {
					deleteFloder(file2.getAbsolutePath());
				}
				else {
					file2.delete();
				}
			}
			file.delete();
		}
	}
	
	public static void copyFloderByFiles(String source,String destination) {
		File sourceFile =new File(source);
		File destinationFile=new File(destination+File.separator+sourceFile.getName());
		System.out.println(destination);
		System.out.println(sourceFile.getAbsolutePath());
		System.out.println(destinationFile.getAbsolutePath());
		if (!sourceFile.exists()) {
			return;
		}
		new File(destination).mkdirs();
		if (!sourceFile.isDirectory()) {
			try {
				Files.copy(sourceFile.toPath(), destinationFile.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			destinationFile.mkdirs();
			File[] arrayFiles=sourceFile.listFiles();
			for (File file : arrayFiles) {
				if (file.isDirectory()) {
					copyFloderByFiles(file.getAbsolutePath(), destinationFile.getAbsolutePath());
				}
				else {
					try {
						Files.copy(file.toPath(), new File(destinationFile.getAbsolutePath(),file.getName()).toPath());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void copyFloderByInputStream(String source,String destination) {
		File sourceFile =new File(source);
		File destinationFile=new File(destination+File.separator+sourceFile.getName());
		System.out.println(destination);
		System.out.println(sourceFile.getAbsolutePath());
		System.out.println(destinationFile.getAbsolutePath());
		if (!sourceFile.exists()) {
			return;
		}
		new File(destination).mkdirs();
		if (!sourceFile.isDirectory()) {
			copyFileByInputStreamUseByFloder(source, destinationFile.getAbsolutePath());
		}
		else {
			destinationFile.mkdirs();
			File[] arrayFiles=sourceFile.listFiles();
			for (File file : arrayFiles) {
				if (file.isDirectory()) {
					copyFloderByInputStream(file.getAbsolutePath(), destinationFile.getAbsolutePath());
				}
				else {
					copyFileByInputStreamUseByFloder(file.getAbsolutePath(), new File(destinationFile.getAbsolutePath(),file.getName()).getAbsolutePath());
				}
			}
		}
	}
	
	public static void copyFileByInputStream(String source,String destination) {
		File sourceFile=new File(source);
		File destinationFile=new File(destination+File.separator+sourceFile.getName());
		if (!sourceFile.exists()) {
			return;
		}
		if (sourceFile.isDirectory()) {
			return;
		}
		new File(destination).mkdirs();
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try {
			bis=new BufferedInputStream(new FileInputStream(sourceFile));
			bos=new BufferedOutputStream(new FileOutputStream(destinationFile));
			byte[]buffer=new byte[1024];
			int len;
			while ((len=bis.read(buffer))!=-1) {
				bos.write(buffer, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (bis!=null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bos!=null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void copyFileByInputStreamUseByFloder(String source,String destination) {
		File sourceFile=new File(source);
		File destinationFile=new File(destination);
		if (!sourceFile.exists()) {
			System.out.println("复制的文件不存在");
			return;
		}
		if (sourceFile.isDirectory()) {
			return;
		}
		new File(destination).getParentFile().mkdirs();
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try {
			bis=new BufferedInputStream(new FileInputStream(sourceFile));
			bos=new BufferedOutputStream(new FileOutputStream(destinationFile));
			byte[]buffer=new byte[1024];
			int len;
			while ((len=bis.read(buffer))!=-1) {
				bos.write(buffer, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (bis!=null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bos!=null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void copyFloderByCMD(String source,String destination) {
		File sourceFile =new File(source);
		File destinationFile=new File(destination+File.separator+sourceFile.getName());
		System.out.println(sourceFile.getAbsolutePath());
		System.out.println(destinationFile.getAbsolutePath());
		new File(destination).mkdirs();
		try {
			Runtime.getRuntime().exec("xcopy "+sourceFile.getAbsolutePath()+" "+destinationFile.getAbsolutePath()+File.separator+" /S/E/Y");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
