<%-- 
    Document   : Marketing
    Created on : 27 Jun 2024, 22:22:22
    Author     : 1
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
 <%@ page import="DAO.MarketingDAO" %>
<%@ page import="Model.Marketing" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Social Media Marketing</title>
    <style>
        /* General styles */
         body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            position: relative;
        }
        h1 {
            text-align: center;
            color: #4CAF50;
        }
        h2 {
            color: #4CAF50;
        }
        .section {
            margin-bottom: 20px;
        }
        .section p {
            margin: 10px 0;
        }
        .quote {
            font-style: italic;
            color: #555;
            border-left: 4px solid #4CAF50;
            padding-left: 10px;
            margin: 10px 0;
        }
        .footer {
            text-align: center;
            margin-top: 20px;
            font-size: 0.9em;
            color: #777;
        }
        .topnav {
            overflow: hidden;
            background-color: #333;
        }
        .topnav a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }
        .topnav a.active {
            background-color: #4CAF50;
            color: white;
        }
        .topnav .icon {
            display: none;
        }
        /* Slideshow button styles */
        .prev, .next {
            cursor: pointer;
            position: absolute;
            top: 50%;
            width: auto;
            padding: 16px;
            margin-top: -22px;
            color: white;
            font-weight: bold;
            font-size: 18px;
            transition: 0.6s ease;
            border-radius: 0 3px 3px 0;
            user-select: none;
            background-color: rgba(0, 0, 0, 0.5);
            text-decoration: none;
            display: inline-block;
        }
        .next {
            right: 0;
            border-radius: 3px 0 0 3px;
        }
        /* On hover, add a grey background color */
        .prev:hover, .next:hover {
            background-color: #f1f1f1;
            color: black;
        }
        .elon-image, .tony-image, .job-image {
            max-width: 40%; /* Smaller size for the image on medium screens */
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin-top: 6px; /* Adjusted margin to separate from the text */
        }
        @media screen and (min-width: 601px) {
            .elon-image, .tony-image, .job-image {
                float: right; /* Float the image to the right on larger screens */
                margin-left: 15px; /* Margin between image and text */
            }
        }
        /* Hide buttons on small screens */
        @media screen and (max-width: 600px) {
            .topnav a:not(:first-child) { display: none; }
            .topnav a.icon {
                float: right;
                display: block;
            }
            .topnav.responsive { position: relative; }
            .topnav.responsive .icon {
                position: absolute;
                right: 0;
                top: 0;
            }
            .topnav.responsive a {
                float: none;
                display: block;
                text-align: left;
            }
        }
        
        .footer {
            text-align: center;
            margin-top: 20px;
            font-size: 0.9em;
            color: #777;
        }
        /* Table styles */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        /* Form and button styles */
        .add-item-button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-top: 10px;
            cursor: pointer;
        }
        .add-item-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div id="myTopnav" class="topnav">
    
        <a href="Marketing.html" class="active">Add Inventory</a>
 
        <a href="javascript:void(0);" class="icon" onclick="myFunction()">
            <i class="fa fa-bars"></i>
        </a>
    </div>
   <div class="container">
        <h2>Marketing Inventory</h2>
        <div class="search-container">
            <i class="fa fa-search"></i>
            <input type="text" id="search" placeholder="Search...">
        </div>
        <table>
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Description</th>
     
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}">
                
                       <tr>
                           <td>${item.getLog_date}</td>
                           <td>${item.getDescription}</td>
                       </tr>
              
                </c:forEach>
            </tbody>
        </table>
    </div>
    <form id="marketInventory" action="AddMarketing.jsp" method="get">
        <input type="submit" value="Add Item" class="add-item-button">
        
    </form>

    <div class="footer">
        <p>&copy; 2024 Marketing</p>
    </div>
</body>
</html>
    