package application;
import java.lang.*;
import java.util.*;
 

public class Coupon 
{
	private int percentOff;
	private String expiration;
	private String code;
	
	
public Coupon(int newPercentOff, String newExpiration, String newCode)
{
	newPercentOff = 0;
	newExpiration = "xx/xx/2022";
	newCode = "xxx-xxx-xxxx";
}
	
public boolean setPercentOff(int newPercentOff)
{
	this.percentOff = newPercentOff;
	return true;
}

public boolean setExpiration(String newExpiration)
{
	this.expiration = newExpiration;
	return true;
}

public boolean setCode(String newCode)
{
	this.code = newCode;
	return true;
}

public int getPercentOff()
{
	return percentOff;
}

public String getExpiration()
{
	return expiration;
}

public String getCode()
{
	return code;
}

}