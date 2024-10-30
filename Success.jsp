<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.ts.dao.BusDAO" %>
<%@ page import = "com.ts.dto.Bus" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link  rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
   <link rel="stylesheet" href="css/style.css">
   <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
<style type="text/css">
body {margin: 0;}

ul.topnav {
    list-style-type: none;
    margin: 0;
    padding: 0;
    background-color: #333;
    position: fixed;
    top: 0;
    width: 100%;
}

ul.topnav li {float: left;}

ul.topnav li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

ul.topnav li:hover a:not(.active) {
    background-color: #D3D3D3;
    color: #000;
}

ul.topnav li a.active {
    background-color: #1A5276;
    color: white;
}

ul.topnav li.right {float: right;}

@media screen and (max-width: 600px){
    ul.topnav,
    ul.topnav {position: unset}
    ul.topnav li.right, 
    ul.topnav li {float: none;}
}

ul.topnav .dropdown-content {
  display: none;
  position: absolute;
}
ul.topnav .dropdown-content a {
  color: black;
}
ul.topnav .dropdown:hover > .dropdown-content {
  display: block;
}
.jumbotron {
  margin-bottom: 100px;
  height: 100%;
  width: 100%;
  color: white;
  text-shadow: black 0.3em 0.3em 0.3em;
  background:transparent;
}
body {
  font-family: Arial, Helvetica, sans-serif;
  
    background-color: white; 
    }
    
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

/* Set a style for all buttons */
.button {
    background-color: #1A5276;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width:40%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

.center {
    margin: auto;
    width: 25%;
   
    padding: 10px;
}


table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>

</head>
<% Bus bus = (Bus)session.getAttribute("bus");
String source = (String)session.getAttribute("source");
String destination = (String)session.getAttribute("destination");
String date = (String)session.getAttribute("date");


System.out.println(source);
System.out.println(destination);
System.out.println(date);


%>

<body>
<ul class="topnav">
  <li><a class="active" href="#home">LanSe Bus</a></li>
  
  <li class="dropdown right">
    <a href="javascript:void(0)" class="dropbtn">My Profile</a>
    <div class="dropdown-content">
      <a href="#">My Transactions</a>
      <a href="Sample.html">Logout</a>
    </div>
  </li>
</ul></br>
<h4>Congratulations</h4>

<center>
 <font size="10" color = "#1A5276">Booking Confirmed!</font><br>
 </p>
 			<h2>Details</h2>
 			<h4>Driver Name :  ${bus.driverName}</h4>
 			<h4>Driver Number :  ${bus.driverNumber}</h4>
 			<h4>Bus Name :  ${bus.bId}</h4>
 			<h4>Pickup Point :  ${bus.source}</h4>
 			</center>
<style>
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: #1A5276;
   color: white;
   text-align: center;
}
</style>
<div class="footer">
  <p><a href="#" style="color:#D7DBDD"><br>www.lansebus.in</a></p>
</div>

</body>
</html>