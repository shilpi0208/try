<!DOCTYPE html>
<html>
<style>
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
/* Set a style for all buttons */
button {
	background-color: #3399ff;
	color: white;
	padding: 14px 20px;
	margin:  24px 0 12px 0;
	border: none;
	cursor: pointer;
	width: auto;
}
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}
/* Add padding to container elements */
.container {
    padding: 16px;
}
/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}
/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>
 
<jsp:include page="Navbar.jsp"></jsp:include>
 
<body>

<h2>Signup Form</h2>

<form action="SignUp" style="border:1px solid #ccc" method="POST">
  <div class="container">

    <label><b>User Name</b></label>
    <input type="text" placeholder="Enter User Name" name="uname" required>
    <label><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <label><b>Customer Name</b></label>
    <input type="text" placeholder="Enter customer name" name="CustName" required>
    
    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="Upswd" required>
    
    <label><b>Address</b></label>
    <input type="text" placeholder="Enter Address" name="Addr" required>
    
    <label><b>Mobile</b></label>
    <input type="text" placeholder="Enter Mobile Number" name="Mobile" required>
    
    <input type="checkbox" checked="checked"> Remember me
    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn"><a href="Success">SignUp</a></button>
    
    
  </div>
</form>

</body>


</html>
