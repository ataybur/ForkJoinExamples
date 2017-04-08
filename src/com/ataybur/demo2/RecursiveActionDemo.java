package com.ataybur.demo2;

import java.util.concurrent.ForkJoinPool;

public class RecursiveActionDemo {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		int [] data = {1,2,3,4,5,6,7,8,9,10};
		Square app = new Square(data, 0, data.length);
		pool.invoke(app);
		System.out.println(app.result);
	}
}
