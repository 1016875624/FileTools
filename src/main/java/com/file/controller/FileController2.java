package com.file.controller;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import com.file.service.FileTool;
import com.file.service.FileToolImpl;

public class FileController2{
	static FileTool fileTool=new FileToolImpl();
	public static void copy() {
		File[]files = getFiles("请选择要复制的文件");
		File dest=getDirectory("请选择要保存到的目的地");
		if (files==null) {
			return ;
		}
		for (File file : files) {
			fileTool.copy(file.getAbsolutePath(), dest.getAbsolutePath());
		}
	}

	public static void delete() {
		File[]files = getFiles("请选择要删除的文件");
		if (files==null) {
			return ;
		}
		for (File file : files) {
			fileTool.delete(file.getAbsolutePath());
		}
	}

	public static void zip() {
		File[]files = getFiles("请选择要删除的文件");
		if (files==null) {
			return ;
		}
		if (files.length==1) {
			fileTool.zip(files[0].getAbsolutePath());
		}
		else {
			fileTool.zip(files);
		}
	}

	public static void unzip() {
		JFileChooser fileChooser = new JFileChooser("D:\\");
		fileChooser.setDialogTitle("请选择要解压的zzip文件");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "zip格式的压缩文件";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.getName().endsWith(".zip")) {
					return true;
				}
				return false;
			}
		});
		fileChooser.setMultiSelectionEnabled(true);
		int returnVal = fileChooser.showOpenDialog(fileChooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileTool.unzip(fileChooser.getSelectedFile().getAbsolutePath());
		}
	}
	
	public static File[] getFiles(String title) {
		JFileChooser fileChooser = new JFileChooser("D:\\");
		fileChooser.setDialogTitle(title);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setMultiSelectionEnabled(true);

		int returnVal = fileChooser.showOpenDialog(fileChooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFiles();
		}
		else {
			return null;
		}
	}
	
	public static File getFile(String title) {
		JFileChooser fileChooser = new JFileChooser("D:\\");
		fileChooser.setDialogTitle(title);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int returnVal = fileChooser.showOpenDialog(fileChooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		else {
			return null;
		}
	}
	
	public static File getDirectory(String title) {
		JFileChooser fileChooser = new JFileChooser("D:\\");
		fileChooser.setDialogTitle(title);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int returnVal = fileChooser.showOpenDialog(fileChooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		else {
			return null;
		}
	}
	
	public static File getOnlyFile(String title) {
		JFileChooser fileChooser = new JFileChooser("D:\\");
		fileChooser.setDialogTitle(title);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int returnVal = fileChooser.showOpenDialog(fileChooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		else {
			return null;
		}
	}
	
	public static File getOnlyFileInWindows(String title) {
		FileDialog dialog = new FileDialog((Frame)null, title);
		//设置模式 可以试试load 和 save 一个是读取文件 一个是保存文件 但是有个问题   就是不能选择文件夹 只能是文件
		dialog.setMode(FileDialog.LOAD);
	    //dialog.setMode(FileDialog.LOAD);
	    dialog.setMultipleMode(true);
	    dialog.setVisible(true);
	    if (dialog.getFiles().length>0) {
			return dialog.getFiles()[0];
		}
	    return null;
	}
	
	public static void main(String[] args) {
		System.out.println("123456");
		FileController2 fileController=new FileController2();
		fileController.copy();
		//fileController.delete();
		//fileController.zip();
		//fileController.unzip();
	}
}
