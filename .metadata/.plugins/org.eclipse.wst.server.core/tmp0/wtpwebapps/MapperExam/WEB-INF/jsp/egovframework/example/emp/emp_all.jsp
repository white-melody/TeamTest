<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 	부트스트랩 css  -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 	개발자 css -->
	<link rel="stylesheet" href="/css/style.css">

</head>
<body>
${emps}
<jsp:include page="/common/header.jsp"></jsp:include>
<div class="page mt3">
		<form id="listForm" name="listForm" method="get">
		<!-- 수정페이지 열기때문에 필요 -->
	    <input type="hidden" id="eno" name="eno">
	    <!-- 컨트롤러로 보낼 페이지번호 -->
	    <input type="hidden" id="pageIndex" name="pageIndex">
	    
		<div class="input-group mb3 mt3">
		  <input type="text" 
		         class="form-control" 
		         id="searchKeyword"
		         name="searchKeyword"
		         placeholder="사원명입력"
		  >
		  <button class="btn btn-primary"
		          type="button" 
		          onclick="fn_egov_selectList()"
		  >
		          검색
		  </button>
		</div>
	    <div id="result"></div>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">eno</th>
		      <th scope="col">ename</th>
		      <th scope="col">job</th>
		      <th scope="col">manager</th>
		      <th scope="col">hiredate</th>
		      <th scope="col">salary</th>
		      <th scope="col">commission</th>
		      <th scope="col">dno</th>
		    </tr>
		  </thead>
		  <tbody>
			<!-- 반복문 -->
		  	<c:forEach var="data" items="${emps}">  	
		  		<tr>
		  		  <td>
		  		  	<a href="javascript:fn_select('<c:out value="${data.eno}" />')">
			          <c:out value="${data.eno}"></c:out>
			        </a>
		  		  </td>
			      <td><c:out value="${data.ename}"></c:out></td>
			      <td><c:out value="${data.job}"></c:out></td>
			      <td><c:out value="${data.manager}"></c:out></td>
			      <td><c:out value="${data.hiredate}"></c:out></td>
			      <td><c:out value="${data.salary}"></c:out></td>
			      <td><c:out value="${data.commission}"></c:out></td>
			      <td><c:out value="${data.dno}"></c:out></td>
			    </tr>
		  	</c:forEach>

		  </tbody>
		</table>
		<!-- 페이지 번호 태그 -->
		<ul class="pagination" id="pagination"></ul>
	</form>
	
</div>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- 페이지 플로그인 추가 -->
<script src="/js/jquery.twbsPagination.js" type="text/javascript"></script>

<script type="text/javascript">
	/* 페이지번호 클릭시 전체조회 */
	function fn_egov_link_page(page) {
		/* 현재페이지번호 저장 */
		$("#pageIndex").val(page);
		$("#listForm").attr("action",'<c:out value="/emp/emp.do" />')
					.submit();
	}

    /* 전체조회 */
	function fn_egov_selectList() {
		$("#pageIndex").val(1);    // 최초 화면에서는 페이지번호를 1페이지로 지정
		$("#listForm").attr("action",'<c:out value="/emp/emp.do" />')
					.submit();
	}
	/* 수정페이지 열기 */
	function fn_select(eno) {
		$("#eno").val(eno);        // 사원번호(기본키)
		/* 수정페이지 URL:/emp/edition.do */
		$("#listForm").attr("action",'<c:out value="/emp/edition.do" />')
					.submit();		
	}
</script>

<script type="text/javascript">
/* 페이징 처리 */
    $('#pagination').twbsPagination({
        totalPages: "${paginationInfo.totalPageCount}",
        startPage:parseInt("${paginationInfo.currentPageNo}"),
        visiblePages: "${paginationInfo.recordCountPerPage}",
        initiateStartPageClick: false,
        onPageClick: function (event, page) {
            /* 재조회 함수 실행 */
            fn_egov_link_page(page);
        }
    });

</script>


<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
