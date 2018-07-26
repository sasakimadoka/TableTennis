<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String answer = "";
	if(request.getAttribute("answer") != null){
		answer = (String)request.getAttribute("answer");
	}
%>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/campusPay/font-awesome-4.7.0/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="/TableTennis/css/common.css" type="text/css">

<body>

  <div class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>管理者さんようこそ</h1>
				</div>
			</div>
		</div>
	</div>

  <% if(!(answer.equals(""))&&answer.equals("yes")){%>
   <script>alert("正常に処理が行われました。");</script>
  <%}%>

  <div class="py-5">
    <div class="container">

      <div class="row">
        <div class="col-md-6">
        <a class="btn btn-primary w-100" href="/TableTennis/jsp/GoUserRegistServlet"><br>ユーザー登録<br>&nbsp;</a>
        </div>
        <div class="col-md-6">
          <a class="btn btn-primary w-100" href="/TableTennis/jsp/ActorServlet"><br>使用可否切り替え<br>&nbsp;</a>
        </div>
      </div>
      </div>
    </div>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/campusPay/css/userHistory.css" type="text/css">
</html>