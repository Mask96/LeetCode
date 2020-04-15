package com.company;


public class Main {

    public static void main(String[] args) {
        Point a = new Point(1,1);
        Point b = new Point(2,2);
        Point c = new Point(3,3);
        Point[] input = {a,b,c};
        int max =  new Solution().maxPoints(input);
        System.out.println(max);
    }
}
