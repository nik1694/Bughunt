package com.utils;

import static com.utils.Constant.printLogFlag;;

public class Log {
	public static void d(String msg) {
		if (printLogFlag) {
			System.out.println("DAO _ " + msg);
		}

	}
	public static void s(String msg) {
		if (printLogFlag) {
			System.out.println("service _ " + msg);
		}

	}
	public static void c(String msg) {
		if (printLogFlag) {
			System.out.println("controller _ " + msg);
		}

	}
	public static void j(String msg) {
		if (printLogFlag) {
			System.out.println("jsp _ " + msg);
		}

	}
	public static void test(String msg) {
		if (printLogFlag) {
			System.out.println("test _ " + msg);
		}

	}
}
