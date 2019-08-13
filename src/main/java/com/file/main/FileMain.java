package com.file.main;

import java.util.Scanner;

import com.file.controller.FileController;
import com.file.controller.FileController2;

public class FileMain {
	public static void main(String[] args) {
		FileController fileController = new FileController();
		//FileController2 fileController = new FileController2();
		Scanner sc = new Scanner(System.in);
		int select = 0;
		while (true) {
			showMenu();
			try {
				select = sc.nextInt();
			} catch (Exception e) {
				// e.printStackTrace();
				// 清除异常
				select = -1;
				sc.next();
				// continue;
			}
			switch (select) {
			case 0:
				System.exit(0);
				break;
			case 1:
				fileController.copy();
				break;
			case 2:
				fileController.delete();
				break;
			case 3:
				fileController.zip();
				break;
			case 4:
				fileController.unzip();
				break;
			default:
				System.out.println("请输入正常的选项！");
				break;
			}
		}
	}

	public static void showMenu() {
		System.out.println("------------------------------");
		System.out.println("0.退出系统");
		System.out.println("1.复制文件");
		System.out.println("2.删除文件");
		System.out.println("3.压缩成zip");
		System.out.println("4.解压成zip");
		System.out.println("------------------------------");
	}
}
