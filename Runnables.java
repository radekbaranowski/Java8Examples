package com.example.streams;

public class Runnables {
	
	class MyThread extends Thread{
		public void run(){
			System.out.println("1. thread extended");
		}
	}
	
	class MyRunnable implements Runnable {
		public void run(){
			System.out.println("2. runnable extended");
		}
	}
	
	
	public static void main (String[] args){
		
		// 1.
		Runnables r = new Runnables();
		r.new MyThread().run();
		
		// 2.
		MyRunnable mr = r.new MyRunnable();
		mr.run();
	
		// 3.
		 new Thread() {
			    public void run() {
			      System.out.println("3. anonymous thread");
			    }
			  }.start();
	
	
	}
	
}
