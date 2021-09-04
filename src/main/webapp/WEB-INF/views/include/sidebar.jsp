<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
      <img src="/resources/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">AdminLTE 3</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="/resources/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">${compName} <br> ${teacherNm} 선생님</a>          
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item">
            <a href="/admin" id="/admin" class="nav-link">
              <i class="nav-icon fas fa-home"></i>
              <p>메인</p>
            </a>
          </li>
               
          <li class="nav-item">
            <a href="/admin/consult" id="/admin/consult" class="nav-link">
              <i class="nav-icon fas fa-comment-dollar"></i>
              <p>상담 관리</p>
            </a>
          </li>
          
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
  
<script type="text/javascript"> 
$(document).ready(function() {
	//현재 선택된 메뉴 active 클래스 추가
	var pathName = location.pathname;	
	$('.sidebar a').each(function(index, item){		
		if($(item).attr('id') == pathName){
			$(item).addClass('active');
		}
	});
	
});
</script>  