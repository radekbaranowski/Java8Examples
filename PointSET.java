import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class PointSET {
	
	
	private TreeSet<Point2D> set;
	
   // construct an empty set of points
   public PointSET() {
	   set = new TreeSet<Point2D>();
   }                                
	
   // 	is the set empty?
   public boolean isEmpty() {
	   return set.isEmpty();
   }                      
   
   // number of points in the set
   public int size() {
	   return set.size();
   }                          
   
   // add the point to the set (if it is not already in the set)
   public void insert(Point2D p) {
	   if (p == null) throw new java.lang.NullPointerException ();
	   if (!set.contains(p)) set.add(p);
   }          
   
   // does the set contain point p?
   public boolean contains(Point2D p) {
	   if (p == null) throw new java.lang.NullPointerException ();
	   return set.contains(p);
   }          
   
   // draw all points to standard draw
   public void draw() {
	    //StdDraw.enableDoubleBuffering();
	    /*StdDraw.setXscale(0, 32768);
	    StdDraw.setYscale(0, 32768);*/
	   
	   for (Point2D p : set) {
	        p.draw();
	    }
	    
	    StdDraw.show();
   }                        
   
   // all points that are inside the rectangle
   public Iterable<Point2D> range(RectHV rect) {
	   if (rect == null) throw new java.lang.NullPointerException ();
	   TreeSet<Point2D> range = new TreeSet<Point2D>();
	   for (Point2D p : set){
		   if (p.x() <= rect.xmax() && p.x() >= rect.xmin() && p.y() <= rect.ymax() && p.y() >= rect.ymin()) range.add(p);
	   }
	   
	   return range;
   }            
   
   // a nearest neighbor in the set to point p; null if the set is empty
   public Point2D nearest(Point2D p) {
	   if (p == null) throw new java.lang.NullPointerException ();
	   Point2D[] pArr = new Point2D[set.size()];
	   int i = 0;
	   Point2D nearest = null;
	   double minDistance = Double.POSITIVE_INFINITY;
	   for (Point2D pt : set){
		   if (p.distanceSquaredTo(pt) <= minDistance) {
			   nearest = pt;
			   minDistance = p.distanceSquaredTo(pt);
			  // System.out.println("set new nearest: " + pt);
		   }
	   }
	   
	   
	   return nearest;
	   
   }           

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PointSET ps = new PointSET();
		if (ps != null & true)
		
		assert(ps.isEmpty());
		Point2D basePoint = new Point2D(0.5,0.5);
		ps.insert(new Point2D(0.3,0.3));
		ps.insert(new Point2D(0.4,0.3));
		ps.insert(new Point2D(0.5,0.3));
		ps.insert(new Point2D(0.6,0.3));
		System.out.println(ps.isEmpty());
		//assert ps.isEmpty() : "not empty";
		// ps.draw();
		RectHV r = new RectHV(0.5,0.25,0.75,0.75);
		StdDraw.setPenRadius(0.0075); 
		//r.draw();
		Iterable<Point2D> ts = ps.range(r);
		StdDraw.setPenColor(StdDraw.PINK);
		//ts.forEach(p -> p.draw());
		basePoint.draw();
		StdDraw.setPenColor(StdDraw.RED);
		ps.draw();
		Point2D nearest = ps.nearest(basePoint);
		StdDraw.setPenColor(StdDraw.BLACK);
		basePoint.drawTo(nearest);
	}

}
