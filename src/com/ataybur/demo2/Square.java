package com.ataybur.demo2;

import java.util.concurrent.RecursiveAction;

public class Square extends RecursiveAction {
	
	private static final long serialVersionUID = 31595297826164546L;
	
	final int LIMIT = 3;
	   //keep static
	   static int result;
	   int start, end;
	   int[] data;
	   Square(int[] data, int start, int end) {
		   this.start = start;
		   this.end = end;
		   this.data = data;
	   }
	   @Override
	   protected void compute() {
		   if((end - start)< LIMIT){
			   for(int i= start;i<end;i++){
				   result+= data[i]*data[i];   
			   }
		   }else {
			 int mid = (start + end)/2;
			 Square left = new Square(data, start, mid); 
			 Square right = new Square(data, mid, end);
			 left.fork();
			 right.fork();
			 left.join();
			 right.join();
		   }
	   }
}
