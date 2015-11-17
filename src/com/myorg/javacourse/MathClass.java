package com.myorg.javacourse;

public class MathClass {

	static double radious,angle,hypotenuse, base, exp ;   
	public final static double PIE = java.lang.Math.PI;
	public MathClass (int radiousRes, int angleRes, int hypotenuseRes,int baseRes, int expRes)
	{
		radious = radiousRes;
		angle = angleRes;
		hypotenuse = hypotenuseRes;
		base = baseRes;
		exp = expRes;
		
	}
	
	
	private static double circleArea()
	{
		return PIE*radious*radious;
	}
	private static double calculateOpposite()
	{
		double radi= java.lang.Math.toRadians(angle);
		double result= java.lang.Math.sin(radi)*hypotenuse;
		return result;
		
	}
	private static double calculatePower()
	{
		double power= Math.pow(base, exp);
		return power;
		
	}
	
	public String getResults(){
		String q1= new String("Area of circle with radius " + MathClass.radious  + " is: " + MathClass.circleArea());
		String q2= new String("Length of opposite where angle B is 30 degrees andHypotenuse length is 50 cm is " + MathClass.calculateOpposite() + " cm"); 
		String q3= new String("Power of 20 with exp of 13 is " + MathClass.calculatePower() );
		
		String resultStr = q1 + "<br><br>" + q2 + "<br><br>" + q3;
		
		
		return resultStr;
		
	}

}
