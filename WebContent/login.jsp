<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div class="container" align="center">
     		<!-- <form action="login" method="post">
     			<table width="380" border="0" >
     				<tr>
     					<td class="td_prompt">
     						username:</td>
     				<td colspan=2><input name="username" type="text" required="required" pattern="[\S]+" title="Blank is not allowed."></td>
     						<tr>
     						<td class="td_prompt">password:</td>
     						<td colspan=2>
     						<input name="pwd" type="password" required="required"></td>
     						</tr>
     						<tr>
     						<td >
     						<input class="btn" type="submit" name="submit" value="login">
     						 </td>
     						 <td>
     						 <input class="btn" type="button" value="register" onclick="window.location='register.jsp'"> 	
     						</td>
     						<td>
     						<input class="btn" type="button" value="modify" onclick="window.location='modify.jsp'"> 
     						</td>
     						</tr>  				
     			</table>
     		</form> -->
     <div class="container col-md-6 col-md-offset-3">
        <form action="login" class="form-horizontal">
            <div class="form-group">
            <label class="control-label col-md-3"> Username </label>
                <div class=" col-md-9">
                    <input type="text" class="form-control" placeholder="Input your username" 
                    required="required" pattern="[\S]+" title="Blank is not allowed." name="username"></input>
                </div>
            </div>
            <div class="form-group">
            <label class="control-label col-md-3"> Password </label>
                <div class="col-md-9">
                    <input type="password" class="form-control" placeholder="Input your password"
                    required="required" pattern="[\S]+" title="Blank is not allowed." name="pwd"></input>
                </div>
            </div>
           <!--  <div class="checkbox">
                <label>
                    <input type="checkbox"> Remember me for a month
                </label>
            </div> -->
            
            <input type="submit" class="btn btn-primary" value="Login" ></input>
            <button type="button" class="btn btn-default" onclick="window.location='register.jsp'">Register</button>
            <button type="button" class="btn btn-default" onclick="window.location='modify.jsp'">Change Password</button>
        </form>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>