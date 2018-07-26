<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/campusPay/font-awesome-4.7.0/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="/TableTennis/css/common.scss" type="text/css">
<link rel="stylesheet" href="/TableTennis/css/common.css" type="text/css">
<script src="/campusPay/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
	  <title>ログインページ</title>
</head>

<body>
	<div class="py-5 text-white opaque-overlay">
		<div class="container">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<h1 class="text-gray-dark">ログインページ</h1>
					<form class="" method="post" action="/TableTennis/jsp/LoginServlet">
						<p class="lead">IDとパスワードを入力してください</p>
						<%
							String error = (String) request.getAttribute("error");
							if (error != null) {
						%>
						<p class="lead text-danger">
							<%
							System.out.println("ここ？");
								out.println(error);
							%>

						</p>
						<%
							}
						%>

						<%
							String accountError = (String) request.getAttribute("accountError");
							if (accountError != null) {
						%>
						<p class="lead text-danger">
							<%
							System.out.println("ここかな？");
								out.println(accountError);
							%>

						</p>
						<%
							}
						%>

						<div class="form-group">
							<label>ID</label>
							<input type="text" name="id" class="form-control" placeholder="ID" pattern="^([a-zA-Z0-9]{1,12})$" required>
						</div>
						<div class="form-group">
							<label>Password</label>
							<input type="password" name="password" class="form-control" placeholder="Password" pattern="^([a-zA-Z0-9]{4,12})$" required>
						</div>
						<button type="submit" class="btn btn-primary">ログイン</button>

					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
</body>

</html>
