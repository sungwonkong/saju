<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<!-- REQUIRED SCRIPTS -->
<jsp:include page="../include/script.jsp"/>
<jsp:include page="../include/header.jsp"/>


<body class="hold-transition sidebar-mini">
<div class="wrapper">
<script src="/resources/plugins/jsgrid/jsgrid.min.js"></script>
<jsp:include page="../include/navbar.jsp"/>  
<jsp:include page="../include/sidebar.jsp"/>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">상담관리</h1>
          </div><!-- /.col -->          
          <!-- 검색조건 시작-->
          <div class="col-sm-12 card">	          
          	<div class="card-body">
          		<table class="table table-bordered seachTable">	          		
          			<tr>
          				<td style="width:10%">성별</td>
          				<td style="width:10%">
          					asdfasdf
          				</td>
          				<td style="width:10%">이름</td>
          				<td style="width:10%">
          				
          				</td>
          				<td style="width:10%">
          					<button type="button" class="btn btn-block btn-info btn-lg" id="search">검색</button>
          				</td>
          			</tr>
          		</table>
          	</div>	                  
          </div>
          <!-- 검색조건 끝 -->
          <!-- 그리드 시작 -->
          <div class="col-sm-12 card">
          	<div class="card-body">
                <table class="table table-bordered sajuTable">
                  <thead>
                    <tr>
                      <th style="width: 10%">구분</th>
                      <th style="width: 10%">성별</th>
                      <th style="width: 15%">이름</th>
                      <th style="width: 15%">생년월일</th>
                      <th style="width: 15%">시간</th>
                      <th style="width: 20%">신청일자</th>    
                      <th style="width: 15%">자세히</th>                      
                    </tr>
                  </thead>
                  <tbody id="listTable">                    
                 
                  </tbody>
                </table>
              </div>
          
          </div>        
          <!-- 그리드 끝 -->
          
          <!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-default">
      Launch Default Modal
    </button>
 	<jsp:include page="consultDetail.jsp"/>	
  </div>
  <!-- /.content-wrapper -->
  <jsp:include page="../include/footer.jsp"/>  
</div>

<script>

var noData = '<tr><td colspan=\"7\">상담신청이 없습니다.</td></tr>'

$(document).ready(function() {
	//$('#listTable').append(noData);
	getList();
});

$('#search').click(function(){	
	getList();
});
	

function getList(){
	if('<%=(String)session.getAttribute("compNo")%>' == ''){
		alert("세션이 만료되었습니다. 다시 로그인해주세요.")
		location.replace('/admin/logout');
	}
	
	var compNo = '<%=(String)session.getAttribute("compNo")%>';
	
	//테이블 초기화
	$('#listTable').empty();
	
	$.ajax({
	        url: "/admin/getOrderList.json",
	        type: "POST",
	        dataType: 'json',  //json파일 형식으로 값 받기
	        data: {
	        	compNo : compNo
	        },
	        success: function(result){
	        	//console.log(result)
	        	if(result.code == '0' && result.totalCnt > 0){
	        		makeData(result.list);
	        	}else if(result.code == '0' && result.totalCnt == 0){
	        		$('#listTable').append(noData);
	        	}
	        },
	        error: function(){
	            alert("err");
	        }
	  	});
}

//데이터를 받아서 테이블에 뿌려준다.
function makeData(list){	
	var html = '';			//화면에 뿌려줄 데이터
	var orderGubun = '';	//사주(S),타로(T)
	var birthDay = '';		//생년월일
	var birthHourMin = '';	//시간
	
	
	$.each(list, function(index, value){
		
		
		orderGubun  = (value.orderGubun == 'S') ? '사주' : '타로';
		orderGender = (value.orderGender == 'M') ? '남' : '여'; 
		birthDay = value.orderYear + '.' + value.orderMonth + '.' + value.orderDay;
		birthHourMin = value.orderDay + ':' + value.orderMin
		
		if(value.orderGubun == 'S'){
			html = html + '<tr>'
				 + '<td style="vertical-align:middle">' + orderGubun + '</td>'
				 + '<td style="vertical-align:middle">' + orderGender + '</td>'
				 + '<td style="vertical-align:middle">' + value.orderName + '</td>'
				 + '<td style="vertical-align:middle">' + birthDay + '</td>'
				 + '<td style="vertical-align:middle">' + birthHourMin + '</td>'
				 + '<td style="vertical-align:middle">' + value.regDtm + '</td>'
				 + '<td style="vertical-align:middle">' + '<button type="button" data-toggle="modal" data-target="#modal-default" data-orderno="' + value.orderNo + '" class="btn btn-block bg-gradient-success" onclick="openDetail(\'' + value.orderNo + '\')">자세히</button>' + '</td>'
				 + '</tr>';
		}else{
			html = html + '<tr style="background-color:#fdf1e2">'
			 + '<td style="vertical-align:middle">' + orderGubun + '</td>'
			 + '<td>' + '' + '</td>'
			 + '<td style="vertical-align:middle">' + value.orderName + '</td>'
			 + '<td>' + '' + '</td>'
			 + '<td>' + '' + '</td>'
			 + '<td style="vertical-align:middle">' + value.regDtm + '</td>'
			 + '<td style="vertical-align:middle">' + '<button type="button"  data-toggle="modal" data-target="#modal-default" data-orderno="' + value.orderNo + '" class="btn btn-block bg-gradient-success" onclick="openDetail(\'' + value.orderNo + '\')">자세히</button>' + '</td>'
			 + '</tr>';
		}
		
	});
	
	$('#listTable').append(html);
}

function openDetail(orderNo){

}

</script>
    
</body>
</html>
