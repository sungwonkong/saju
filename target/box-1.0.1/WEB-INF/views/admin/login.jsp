<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Log in</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/resources/plugins/fontawesome-free/css/all.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/resources/dist/css/adminlte.min.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html"><b>SAJU</b> BOX</a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">사주박스에 오신걸 환영합니다.</p>

      
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="ID" id="inputId">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas power-off"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" placeholder="Password" id="inputPw">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
              <input type="checkbox" id="remember">
              <label for="remember">
                Remember Me
              </label>
            </div>
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button  class="btn btn-primary btn-block" onclick="login()">로그인</button>
          </div>
          <!-- /.col -->
        </div>      
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/resources/dist/js/adminlte.min.js"></script>
<script type="text/javascript">
function login(){
	
	var id = $('#inputId').val();
	var pw = $('#inputPw').val();
		
	$.ajax({
        url: "getLogin.json",
        type: "POST",
        dataType: 'json',  //json파일 형식으로 값 받기
        data: {
        	teacherId:id,
        	pwd	: pw
        },
        success: function(result){
        	//console.log(result);
        	if(result.code=="0"){
        		window.location.href="/admin";
        	}else{
        		alert("정보가 맞지 않습니다. 다시 한번 확인해주세요.");
        	}
        },
        error: function(){
            alert("로그인에 실패했습니다. 관리자에게 문의해주세요.");
        }
  	});	
}
</script>
</body>
</html>


