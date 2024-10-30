<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">
Bus_id : <input type="text" name="bId" value=${busData.bId} readOnly=true><br/>
Seat : <input type="text" name="seats" value=${busData.seats}><br/>
Source : <input type="text" name="source" value=${busData.source}><br/>
Destination: <input type="text" name="destination" value=${busData.destination}><br/>
DriverName : <input type="text" name="driverName" value=${busData.driverName}><br/>
DriverNumber : <input type="text" name="driverNumber" value=${busData.driverNumber}><br/>
Date : <input type="text" name="doj" value=${busData.date}><br/>
Time : <input type="text" name="time" value=${busData.time}><br/>
Price : <input type="text" name="price" value=${busData.price}><br/>
<input type="submit" value="UPDATE">
</form>
</body>
</html> 