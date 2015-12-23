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
     <div class="container col-md-6 col-md-offset-3">
        <form action="Modify" class="form-horizontal">
            <div class="form-group">
            <label class="control-label col-md-4"> Username </label>
                <div class=" col-md-8">
                    <input type="text" class="form-control" placeholder="Input your username" 
                    required="required" pattern="[\S]+" title="Blank is not allowed." name="username"></input>
                </div>
            </div>
            <div class="form-group">
            <label class="control-label col-md-4">Old Password </label>
                <div class="col-md-8">
                    <input type="password" class="form-control" placeholder="Input your old password"
                    required="required" pattern="[\S]+" title="Blank is not allowed." name="pwd"></input>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4">New Password</label>
                <div class="col-md-8">
                    <input type="password" class="form-control" placeholder="Input your new password"
                    required="required" pattern="[\S]+" title="Blank is not allowed." name="newpwd"></input>
                </div>
            </div>
            
            <input type="submit" class="btn btn-primary" value="Submit" ></input>
        </form>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>