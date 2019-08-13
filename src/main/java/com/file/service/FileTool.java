package com.file.service;

import java.io.File;

public interface FileTool {
	
	/**
	* <p>方法名称: copy</p>
	* <p>描述：复制文件或者复制文件夹</p>
	* @param src 需要复制的文件或者文件夹
	* @param dest 目的地址
	* void 返回类型
	*/
	void copy(String src,String dest);
	
	/**
	* <p>方法名称: delete</p>
	* <p>描述：删除文件或者删除文件夹</p>
	* @param path 需要删除的文件路径
	* void 返回类型
	*/
	void delete(String path);
	
	/**
	* <p>方法名称: zip</p>
	* <p>描述：打包成zip</p>
	* @param path 需要打包的文件
	* void 返回类型
	*/
	void zip(String path);
	
	void zip(File[] files);
	
	/**
	* <p>方法名称: unzip</p>
	* <p>描述：解压zip</p>
	* @param path 解压zip
	* void 返回类型
	*/
	void unzip(String path);
}
