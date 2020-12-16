package com.dsa.gs;
/*
**  Below formation is called Pascals Triangle.
**
**  Example:
**               1
**              1 1
**             1 2 1
**            1 3 3 1
**           1 4 6 4 1
**         1 5 10 10 5 1
**        1 6 15 20 15 6 1
**
**  Complete the 'pascal' function below so that given a
**  col and a row it will return the value in that positon.
**
**  Example, pascal(1,2) should return 2
**
*/

public class Low13PascalTriangle {

  public static  int pascal(int col, int row){
	if(row == 0 || row == col || col == 0) {
		return 1;
	}
	return pascal(col, row-1) + pascal(col-1, row-1);
	
  }

  public static void main(String[] args) {
	  if(Low13PascalTriangle.pascal(0,0) ==  1 &&
			  Low13PascalTriangle.pascal(1,2) ==  2 &&
			  Low13PascalTriangle.pascal(5,6) ==  6 &&
			  Low13PascalTriangle.pascal(4,8) ==  70 &&
			  Low13PascalTriangle.pascal(6,6) ==  1) {
		  System.out.println("Pass");		  
	  }else {
		  System.out.println("Failed");
	  }
  }
}
