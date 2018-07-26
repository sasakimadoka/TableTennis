<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import= "beans.Tour" %>
<%@ page import= "java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
ArrayList<Tour> list =  (ArrayList)session.getAttribute("list");
%>
<%
HttpSession session2 = request.getSession();
String userId = (String)session2.getAttribute("userId");


%>

<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/campusPay/font-awesome-4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="/campusPay/css/common.css" type="text/css">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</head>
<body>

  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1>大会一覧</h1>
        </div>
      </div>
    </div>
  </div>


    <div class="container">
    参加した大会を選んでください
      <div class="row">

        <div class="col-md-6">
          <div class="btn-group btn-group-lg">


            <button class="btn btn-primary dropdown-toggle form-control" data-toggle="dropdown">大会Id : 大会名</button>
            <div class="dropdown-menu">
              <div class="dropdown-divider"></div>

    		  <% for(int i=0;i<list.size();i++){ %>
     		  <% Tour tour = (Tour)list.get(i);%>

      		 <a class="dropdown-item" href="/TableTennis/jsp/TourPartRegistServlet?tourId=<%=tour.getTourId()%>"><%=tour.getTourId()%>:<c:out value="<%=tour.getTourName()%>"/></a>

			<%
				session2.setAttribute("userId",userId);
			%>

    		<% } %>
            </div>
          </div>
        </div>
        </div>
      </div>

  <div class="py-3">
    <div class="container">
      <div class="row">
        <div class="col-md-12 text-left">
          <a href="/TableTennis/jsp/role2/mypage.jsp" class="btn btn-outline-primary">戻る</a>
        </div>
      </div>
    </div>
  </div>

</body>

</html>