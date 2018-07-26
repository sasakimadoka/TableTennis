<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import= "beans.User" %>
<%@ page import= "beans.Tour" %>
<%@ page import= "java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
ArrayList<User> list =  (ArrayList<User>)session.getAttribute("list");
%>

<%
ArrayList<Tour> list2 =  (ArrayList<Tour>)session.getAttribute("list2");
%>

<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/TableTennis/font-awesome-4.7.0/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="/TableTennis/css/common.css" type="text/css">

<body>
	<div class="py-5 text-black">
		<div class="container">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<h1 class="text-gray-dark">試合登録</h1>

					<form class="" method="post" action="/TableTennis/jsp/GameRegistServlet">
					<p class="lead">試合結果を登録してください</p>



   		 <div class="container">
   			 試合した選手を選んでください
      		<div class="row">

      		<div class="col-md-12">
        	<div class="btn-group btn-group-lg">
			<div class="row">
			<br>
			<br>
          <select name="userId1" class="btn btn-primary dropdown-toggle form-control" data-toggle="dropdown">
            <div class="dropdown-menu">
              <div class="dropdown-divider"></div>
			<option value="" selected disabled>選手Id:選手名</option>
    		  <% for(int i=0;i<list.size();i++){ %>
     		  <% User user = (User)list.get(i);
     		  	System.out.println(user.getUserName());%>

      		 <option value="<%=user.getUserId()%>"><%=user.getUserId()%>:<c:out value="<%=user.getUserName()%>"/></option>
    		<% } %>
            </div>
            </select>
			</div>
          	</div>
          	</div>

         <div class="col-md-12">
          <div class="btn-group btn-group-lg">

		<div class="col-md-12">
			<div class="row">
				<br>
          <select name="userId2" class="btn btn-primary dropdown-toggle form-control" data-toggle="dropdown">
            <div class="dropdown-menu">
              <div class="dropdown-divider"></div>
			<option value="" selected disabled>選手Id:選手名</option>
    		  <% for(int i=0;i<list.size();i++){ %>
     		  <% User user = (User)list.get(i);
     		  	System.out.println(user.getUserName());%>

      		 <option value="<%=user.getUserId()%>"><%=user.getUserId()%>:<c:out value="<%=user.getUserName()%>"/></option>
    		<% } %>
            </div>
            </select>
			</div>
          	</div>
          	</div>
			</div>
			</div>
			<br>
			<br>

	<div class="col-md-12">
	<div class="row">
		<br>
          <select name="tourId" class="btn btn-primary dropdown-toggle form-control" data-toggle="dropdown">
            <div class="dropdown-menu">
              <div class="dropdown-divider"></div>
			<option value="" selected disabled>大会Id:大会名</option>
    		  <% for(int i=0;i<list2.size();i++){ %>
     		  <% Tour tour = (Tour)list2.get(i);
     		  	System.out.println(tour.getTourName());%>

      		 <option value="<%=tour.getTourId()%>"><%=tour.getTourId()%>:<c:out value="<%=tour.getTourName()%>"/></option>
    		<% } %>
            </div>

            </select>

						<div class="form-group">
							<label>セットカウント</label>
							<input type="text" name="setpoint" class="form-control" placeholder="setpoint">
						</div>
						<div class="form-group">
							<label>ゲームポイント</label>
							<input type="text" name="gamepoint" class="form-control" placeholder="gamepoint">
						</div>
						<div class="form-group">
						<label>トーナメント位置選択</label><br>
						<input type="radio" name="data" value="決勝"> 決勝<br>
						<input type="radio" name="data" value="準決勝"> 準決勝<br>
						<input type="radio" name="data" value="ベスト4決め"> ベスト4決め<br>
						<input type="radio" name="data" value="べスト8決め"> べスト8決め<br>
						<input type="radio" name="data" value="その他"> その他<br>
						<br>
						<div class="form-group">
							<label>対戦日</label>
							<input type="date" name="gamedate" class="form-control" placeholder="gamedate">
						</div>

						<button type="submit" class="btn btn-primary">対戦結果登録</button>

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