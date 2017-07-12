<!DOCTYPE html>
<html>
<style>
form {
	border: 3px solid #f1f1f1;
}
input[type=text], input[type=password] {
	width: auto;
	padding: 12px 20px;
	margin:  24px 0 12px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}
button {
	background-color: #3399ff;
	color: white;
	padding: 14px 20px;
	margin:  24px 0 12px 0;
	border: none;
	cursor: pointer;
	width: auto;
}
/* button:hover {
	opacity: 0.8;
}
 */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}
.imgcontainer {
	text-align: left;
	margin: 24px 0 12px 0;
}
img.avatar {
	width: 40%;
	border-radius: 50%;
}
</style>
 
<jsp:include page="Navbar.jsp"></jsp:include>
 
<body background="resources/img/b4.jpg">


	<h2><center>Login Form</center></h2>

	<form action="perform_login" method="post">
	 <!-- <form action="login" method="post">  -->
		

		<div class="container">
			<label><span class="glyphicons glyphicons-user"></span><b>Username</b></label><input type="text"
				placeholder="Enter Username" name="uname" required><br>

			<label><span class="glyphicons glyphicons-lock"></span><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="passwd" required><br>

			<button type="submit" value="SUBMIT">Login</button></a>

			<button type="button" class="cancelbtn">Cancel</button>
		<input type="checkbox" checked="checked"> Remember me
  
		</div>

		<div class="container" style="background-color: #f1f1f1">
			<span class="psw">Forgot <a href="#">password?</a></span>
		</div>
	</form>

</body>

<jsp:include page="Footer.jsp"></jsp:include>
</html>