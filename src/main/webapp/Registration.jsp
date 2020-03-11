<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<style>
.container {
	position: relative;
	font-family: Arial;
}

.text-block {
	position: absolute;
	bottom: 20px;
	right: 20px;
	background-color: black;
	color: white;
	opacity: 0.8;
	padding-left: 20px;
	padding-right: 20px;
}

img {
	opacity: 0.9;
}

.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
}

.button2:hover {
	box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0
		rgba(0, 0, 0, 0.19);
}
</style>
<body>
	<div class="container">
		<img src="assets/images/book2.jpg" alt="Book" width="1600"
			height="699">

		<div class="text-block">
			<h1>
				<center>Bookshelf Application</center>
			</h1>
			<br />
			<center>
				<h2>
					<u><i>Registration</i></u>
				</h2>
				<form action="registration">
					Enter Name : <input type="text" name="t1" pattern="^[0-9a-zA-Z]+$"
						placeholder="Enter Name" required autofocus /><br />
					<br /> Enter E-mail : <input type="text" name="t2"
						pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$"
						placeholder="Enter E-mail" required /></br>
					</br> Enter Phone Number : <input type="text" name="t3"
						pattern="[0-9]{10}" maxlength="10"
						placeholder="Enter phone number" required /></br>
					</br> Select your preference type :<select value="select your choice"
						name="ptype">
						<option value="Fiction">Fiction</option>
						<option value="Fantacy">Fantacy</option>
						<option value="Mythology">Mythology</option>
						<option value="Poetry">Poetry</option>
						<option value="Romance">Romance</option>
						<option value="Technical">Technical</option>
						<option value="Litreature">Litreature</option>
						<option value="Autobiographies">Autobiographies</option>
					</select></br>
					</br> Enter the password : <input type="password" name="t4"
						placeholder="set your password" required /></br>
					</br>

					<button class="button button2">Submit</button>


				</form>

			</center>
		</div>
	</div>

</body>
</html>

