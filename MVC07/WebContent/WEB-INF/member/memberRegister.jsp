<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<c:set var="ctx" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script>
  function add() {
	  // form의 데이터 유효성 체크
	  document.form1.action="<c:url value='memberInsert.do' />";
	  document.form1.submit();
  }
  
  function frmReset() {
	  document.form1.reset();
  }
  function doublecheck(){
	  if($("#id").val()==''){
		  alert("Input Id please....");
		  $("#id").focus();
		  return;
	  }
	  var id = $("#id").val();
	  $.ajax({
		  url : "<c:url value='/memberDbcheck.do' />",
		  type : "POST",
		  data : {"id" : id},
		  success : dbCheck, 	// 여기 석세스를 일반적으로 callback함수라고 함
		  error : function(){ alert("error"); }
	  });
  }
  // response.getWriter().print(dbId);
  function dbCheck(data){	// 여기서 Data가 YES인지 NO인지 둘중 하나가 들어가겠지?
	  if(data != "NO"){
		  alert("중복된 아이디 입니다");
		  $("#id").focus();
	  }else{
		  alert("사용 가능 아이디 입니다");
		  $("#id").focus();
	  }
  }
  function add2() {
	  if($("#file").val() != ''){	// 파일이 첨부가 된 경우 
		var formData = new FormData();
	  	formData.append("file", $("input[name=file]")[0].files[0]);
	  	$.ajax({
	  		url : "<c:url value='/fileAdd.do' />",
	  		type : "post",
	  		data : formData,
	  		processData : false,	// ajax로 파일 업로드할때는 processData, contentType 이 두개의 속성에 false값을 줘야 한다
	  		contentType : false,
	  		success : function(data) {	// 업로드된 실제 파일 이름을 전달 받기 
	  			$('#filename').val(data);
	  			document.form1.action="<c:url value='/memberInsert.do' />";		// text데이터를 저장하는 부분  
	  			document.form1.submit();
	  		},
	  		error : function(){alert("Upload error")}
	  	});
	  }else{			// 파일이 첨부가 되지 않은 경우 
		  
	  }
  }
  </script>
</head>
<body>

<div class="container">
  <h2>회원가입 화면</h2>
  <div class="panel panel-default">
  
    <div class="panel-heading">
    	<c:if test="${sessionScope.userId != null && sessionScope.userId != ''}">
			<label>${sessionScope.userName}님이 로그인 했습니다.</label>
		</c:if>
		<c:if test="${sessionScope.userId == null || sessionScope.userId == ''}">
			<label>안녕하십니까.</label>
		</c:if>
    </div>
    
	<div class="panel-body">
		<form id="form1" name="form1" class="form-horizontal" action="" method="post">
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="id">ID : </label>
		    <div class="col-sm-10">
		      <table>
		      <tr>
		      	<td>
		      		<input type="text" class="form-control" id="id" name="id" placeholder="ID를 입력 하세요" />
		      	</td>
		      	<td>
		      		<input type="button" value="중복확인" class="btn-warning" onclick="doublecheck()" />
		      	</td>
		      </tr>
		      </table>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="pass">Password : </label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="pass" name="pass" placeholder="P.W를 입력하세요" style="width:30%">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="name">Name : </label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="name" name="name" placeholder="Name을 입력하세요" style="width:30%">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="age">Age : </label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="age" name="age" placeholder="Age를 입력하세요" style="width:30%">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="email">Email : </label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="email" name="email" placeholder="Email을 입력하세요" style="width:30%">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="phone">Phone : </label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone를 입력하세요" style="width:30%">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="">File : </label>
		    <div class="col-sm-10">
		      <input type="file" class="control-label" id="file" name="file">
		    </div>
		  </div>
		  <input type="hidden" name="filename" id="filename" value="" />
		</form>
    </div>
    <div class="panel-footer" style="text-align:center">
    	
    	<c:if test="${sessionScope.userId==null || sessionScope.userId=='' }">
    		<input type="button" value="등록" class='btn btn-primary' onclick="add2()" />
    	</c:if>
    	<c:if test="${sessionScope.userId!=null && sessionScope.userId!='' }">
    		<input type="button" value="등록" class='btn btn-primary' onclick="add()" disabled="disabled" />
    	</c:if>
    	
    	<input type="button" value="취소" class='btn btn-warning' onclick="frmReset()" />
    	<input type="button" value="리스트" onclick="location.href='${ctx}/memberList.do'" class='btn btn-success'/>
    </div>
  </div>
</div>

</body>
</html>