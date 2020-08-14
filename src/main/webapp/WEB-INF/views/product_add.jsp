<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
	<h2>New Product</h2>
	<hr>
	<form action="product/new" method="POST">
		<input type="text" name="product_category" placeholder="Product Category">
		<input type="text" name="product_name" placeholder="Product Name">
		<input type="number" name="quantity" placeholder="Quantity">
		<input type="number" name="price" placeholder="Price">  
		<input type="submit" name="SAVE">
	</form>
</body>
</html>