<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List" %>
    <%@ page import="bean.TinyURLBean" %>
    
    <%
        List<TinyURLBean> tinyUrlList = (List<TinyURLBean>) request.getAttribute("tinyURLList");
        Object tinyURLObj = request.getAttribute("tinyURL") == null ? "" : request.getAttribute("tinyURL");
        String tinyURL = (String)tinyURLObj;
        String loggedUsername = (String)session.getAttribute("username");
        if(null == session.getAttribute("username")){
            response.setHeader("Location", "./login.jsp");
        }
    %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="signup.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form class="modal-content" method="post" action="LinkShorter">
    <div class="container">
      <h1>Shrink ur URL</h1>
      <p></p>
      <hr>
      <label for=""><b></b></label>
      <input type="text" placeholder="Shorten your link" name="link" required>

      <button type="submit" class="short">Shorten</button><br><br>

      <label for="psw"><b>Tiny link is ready</b></label>
      <input type="text" placeholder="tiny link" name="tinylink" value="<%=tinyURL %>">

      </div>
    </div>
  </form>
  
    
   <h2>History of generated URLs</h2>

  <div class="table"> 
    <table border="1">
      <tr>
        <th>Sl No</th>
        <th>Long URL</th>
        <th>Tiny URL</th>
      </tr>
        <% int slNo = 1;
    	 for (TinyURLBean urlBean  : tinyUrlList){ %>
        <tr>
          <td><%=slNo++ %></td>
          <td><%=urlBean.getUrl() %></td>
          <td><%=urlBean.getTinyURL() %></td>
        </tr>
        <% } %>
        
    </table>
  </div>

</body>
</html>