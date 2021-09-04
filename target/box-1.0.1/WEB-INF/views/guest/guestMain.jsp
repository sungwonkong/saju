<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>연남사주공간</title>
	<link rel="stylesheet" href="/resources/css/bootstrap.css">
	<link rel="stylesheet" href="/resources/css/sajuMain.css">
	<link rel="stylesheet" href="https://adminlte.io/themes/v3/plugins/toastr/toastr.min.css">	
</head>
<body>


<section id="intro">
	<div class="leftDiv">
	</div>	
	<div class="rightDiv">
		<div class="inputForm">	
			
			<div class="intro-text" style="height: 10%;">
				연남사주공간을 오신걸 환영합니다.<br/>
				성별을 선택해주세요.
				<br/><br/>	
			</div>	
			
			<div class="gender">
				<img class="icon" src="/resources/img/girl_black.png" alt="여성" id="femail" onClick="femailClick()">  
				&nbsp;&nbsp;&nbsp;
				<img class="icon" src="/resources/img/man_black.png" alt="남성" id="mail" onClick="mailClick()">
			</div>	
			
			<div class="intro-text">
				상담받으실분의 이름과 생년월일을 선택해주세요.
			</div>
		
			<div class="form-group">			
						
				<div class="year">
					<input type="text" class="form-control" id="orderName" placeholder="이름을 입력해주세요." style="margin-bottom:10px;">
					<select class="form-control custom-select" name="yy" id="year" style="margin-bottom:10px;"></select>
					<select class="form-control custom-select" name="mm" id="month" style="margin-bottom:10px;"></select>
					<select class="form-control custom-select" name="dd" id="day" style="margin-bottom:10px;"></select>
					<select class="form-control custom-select" name="hh" id="hour" style="margin-bottom:10px;"></select>
					<select class="form-control custom-select" name="mm" id="min"></select>
				</div>	
			</div>	
					
		</div>
		
		<div class="button">
			<button type="submit" class="btn btn-secondary" onClick="saveOrder();">상담신청하기</button>
		</div>
		
	</div>
	
</section>

<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
<script src="https://adminlte.io/themes/v3/plugins/toastr/toastr.min.js"></script>
</body>
</html>

<script type="text/javascript"> 
var compNo;

$(document).ready(function() {
    
	 $.ajax({
	        url: "/getCompInfo.json",
	        type: "POST",
	        dataType: 'json',  //json파일 형식으로 값 받기
	        data: {
	        	compNo:'A0001'
	        },
	        success: function(result){
	        	//alert(res.code);
	        	console.log(result.data[0].compName);
	        	compNo = result.data[0].compNo;
	        	//res.data[0].compName
	        	//$('#test').append(res.data[0].compName);
	        },
	        error: function(){
	            alert("err");
	        }
	  	});
     
    
var now = new Date(); 
var year = now.getFullYear(); 
var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate()); 
	//년도 selectbox만들기 
	for(var i = 1900 ; i <= year ; i++) { 
		$('#year').append('<option value="' + i + '">' + i + '년</option>'); 
	} 
	// 월별 selectbox 만들기 
	for(var i=1; i <= 12; i++) { 
		var mm = i > 9 ? i : "0"+i ; 
		$('#month').append('<option value="' + mm + '">' + mm + '월</option>'); 
	} 
	// 일별 selectbox 만들기 
	for(var i=1; i <= 31; i++) { 
		var dd = i > 9 ? i : "0"+i ; 
		$('#day').append('<option value="' + dd + '">' + dd+ '일</option>'); 
	} 
	
	// 시간 selectbox 만들기
	for(var i=1; i <= 23; i++) { 
		var hh = i > 9 ? i : "0"+i ; 
		$('#hour').append('<option value="' + hh + '">' + hh + '시</option>'); 
	}
	
	// 분 selectbox 만들기
	for(var i=0; i <= 5; i++) { 
				
		var mm = i*10;		
		$('#min').append('<option value="' + mm + '">' + mm + '분</option>'); 
	} 
			
	$("#year > option[value="+year+"]").attr("selected", "true"); 
	$("#month > option[value="+mon+"]").attr("selected", "true"); 
	$("#day > option[value="+day+"]").attr("selected", "true");
	
	//선택하기 쉽게 중간값 선택.
	formClear();			
});


function saveOrder(){
	if($('#orderName').val() == ""){
		toastr.info('이름을 입력해주세요.');
		return;
	}
	
	var gender="";	//성별체크
	if($('#femail').attr('src') == '/resources/img/girl_color.png'){
		gender="F";	//여성
	}else if($('#mail').attr('src') == '/resources/img/man_color.png'){
		gender="M"; //남성
	}else{
		gender="";
	}
	
	if(gender==""){
		toastr.info('성별을 선택해주세요.');
		return;
	}
	
	var orderNo = compNo + getCurrentDate();
	
	var orderName = $('#orderName').val();
	var year	= $('#year').val();
	var month	= $('#month').val();
	var day		= $('#day').val();
	var hour	= $('#hour').val();
	var min		= $('#min').val();
	
	try{
		
		$.ajax({
	        url: "/saveOrder.json",
	        type: "POST",
	        dataType: 'json',  //json파일 형식으로 값 받기
	        data: {
	        	orderNo:orderNo,
	        	orderName : orderName,
	        	orderYear : year,
	        	orderMonth : month,
	        	orderDay : day,
	        	orderHour : hour,
	        	orderMin : min,
	        	orderGender : gender
	        },
	        success: function(result){
	        	console.log(result.code);
	        	//console.log(result.data[0].compName);
	        	//res.data[0].compName
	        	//$('#test').append(res.data[0].compName);
	        	if(result.code == "0"){
	        		toastr.success('접수되었습니다.');
	        		formClear();
	        	}
	        },
	        error: function(){
	        	toastr.error('접수실패. 선생님께 종이로 전달주세요.');
	        }
	  	});
		
	}catch(e){
		
		
	}
	
		
}

function formClear(){
	//입력폼 초기화
	$('#orderName').val('');
	$('#year').val('1990');
	$('#month').val('06');
	$('#day').val('15');
	$('#hour').val('13');
	$('#min').val('30');
	//성별 초기화
	$('#mail').attr('src','/resources/img/man_black.png');
	$('#femail').attr('src','/resources/img/girl_black.png');
}

function femailClick(){
	if($('#femail').attr('src') == '/resources/img/girl_black.png'){
		$('#mail').attr('src','/resources/img/man_black.png');
		$('#femail').attr('src','/resources/img/girl_color.png');
	}else{
		$('#femail').attr('src','/resources/img/girl_black.png');
	}
}

function mailClick(){
	if($('#mail').attr('src') == '/resources/img/man_black.png'){
		$('#femail').attr('src','/resources/img/girl_black.png');
		$('#mail').attr('src','/resources/img/man_color.png');
	}else{
		$('#mail').attr('src','/resources/img/man_black.png');
	}
}
</script>