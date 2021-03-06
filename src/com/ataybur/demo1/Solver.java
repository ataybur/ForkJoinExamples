package com.ataybur.demo1;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class Solver extends RecursiveAction {

	private static final long serialVersionUID = 3401579436263638423L;

	private int[] list;
	private long result;

	public Solver(int[] array) {
		this.list = array;
	}

	@Override
	protected void compute() {
		if (list.length == 1) {
			result = list[0];
		} else {
			int midpoint = list.length / 2;
			int[] l1 = Arrays.copyOfRange(list, 0, midpoint);
			int[] l2 = Arrays.copyOfRange(list, midpoint, list.length);
			Solver s1 = new Solver(l1);
			Solver s2 = new Solver(l2);
			forkJoin(s1, s2);
			result = s1.result + s2.result;
		}
	}

	private void forkJoin(Solver s1, Solver s2) {
		s1.fork();
		s2.fork();
		s1.join();
		s2.join();
	}

	public long getResult() {
		return result;
	}
}
