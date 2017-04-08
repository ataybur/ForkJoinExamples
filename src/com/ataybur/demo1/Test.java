package com.ataybur.demo1;

import java.util.concurrent.ForkJoinPool;

public class Test {
	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();
        Problem test = new Problem();
        // check the number of available processors
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);
        Solver mfj = new Solver(test.getList());
        ForkJoinPool pool = new ForkJoinPool(nThreads);
        stopWatch.start();
        pool.invoke(mfj);
        long result = mfj.getResult();
        System.out.println("Done. Result: " + result);
        stopWatch.lap();
        long sum = 0;
        // check if the result was ok
        for (int i = 0; i < test.getList().length; i++) {
                sum += test.getList()[i];
        }
        System.out.println("Done. Result: " + sum);
        stopWatch.lap();
        stopWatch.printLaps();
        stopWatch.reset();
}
}
