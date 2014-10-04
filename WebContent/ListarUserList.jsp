<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="layout.css" type="text/css">
<title>Listar Centro de Costos</title>
<body>

	<div class="wrapper row1">
		<header id="header" class="clear">
		<div id="hgroup">
      <!-- <h1><a href="/Inventory">ZevLabG</a></h1> -->
      <h1><a href="/Inventory" target="_self">
 				<img src="img/logo.png" width="150 150" "/></h1>
			<h2>Inventory System's</h2>
		</div>
		<nav>
		<ul>
			<li><a href="/Inventory">Home</a></li>
			<li><a href="/Inventory/Usuarios.jsp">Usuarios</a></li>
			<li><a href="/Inventory/CentCost.jsp">Centros de Costo</a></li>
			<li><a href="/Inventory/Areas.jsp">Áreas</a></li>
			<li><a href="/Inventory/Inventario.jsp">Inventario</a></li>
			<li class="last"><a href="#"></li>
		</ul>
		</nav> </header>
	</div>
	<!-- content -->
	<div class="wrapper row2">
		<div id="container" class="clear">

			<!-- main content -->
			<div id="homepage" class="clear">
				<section id="services" class="clear">

				<H1>SUCCESS</H1>
				<br>
				<table border="1">
					<thead>
						<tr>
							<th>USUARIO:</th>
							<th>AREA:</th>
							<th>CENTRO COSTO:</th>
							<th>NOMBRE:</th>
							<th>EMAIL:</th>
						</tr>
					</thead>
					<tbody>
						cl.ciisa.cokedb.model.UserListBean UserList = (cl.ciisa.cokedb.model.UserListBean) pageContext.getAttribute("UserList");
							<tr>
								<td><bean:write property="userId" name="UserList" /></td>
								<td><bean:write property="userDescAreaId" name="UserList" /></td>
								<td><bean:write property="userCostCentId" name="UserList" /></td>
								<td><bean:write property="userNombre" name="UserList" /></td>
								<td><bean:write property="userEmail" name="UserList" /></td>
							</tr>
						</logic:iterate>
					</tbody>
				</table>
				</section>
			</div>
			<!-- / content body -->
		</div>
	</div>
	<!-- Footer -->
	<div class="wrapper row3">
		<footer id="footer" class="clear">
		<p class="fl_left">
			Copyright &copy; 2014 - All Rights Reserved - <a href="#">WWW.ZevLaG.CL</a>
		</p>
		<p class="fl_right">
			Template by <a href="http://www.ZevLaG.com/" title="www.ZevLabG.com">ZevLaG</a>
		</p>
		</footer>
</body>
</html>