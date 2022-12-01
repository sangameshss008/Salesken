package org.jsp.student_reporting_system.dto;

public class ResponseStructure<T>
{
 int statusCode;
 String message;
 T dataT;

public int getStatusCode ( )
{
	return statusCode ;
}
public void setStatusCode ( int statusCode )
{
	this.statusCode = statusCode ;
}
public String getMessage ( )
{
	return message ;
}
public void setMessage ( String message )
{
	this.message = message ;
}
public T getDataT ( )
{
	return dataT ;
}
public void setDataT ( T dataT )
{
	this.dataT = dataT ;
}
}
