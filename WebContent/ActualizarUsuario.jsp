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
			<h1>
				<a href="/Inventory" target="_self"> <img src="img/logo.png"
					width="150 150" "/>
			</h1>
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
				<section id="services" class="clear"> <html:errors />
				<h1 style="color: orange;">Actualizar Usuario</h1>

				<html:form action="/ActualizarUsuario" method="post">
					<div id="izquierda">
						<h2>Usuario</h2>
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
					</div>
					<div id="izquierdat">
						<h2>Tabla Centros de Costo</h2>
						<table border="1">
							<thead>
								<tr>
									<th>ID:</th>
									<th>CENTRO COSTO:</th>
								</tr>
							</thead>
							<tbody>
								cl.ciisa.cokedb.model.CentCostBean cCostList = (cl.ciisa.cokedb.model.CentCostBean) pageContext.getAttribute("cCostList");
									<tr>
										<td><bean:write property="centroCostoId" name="cCostList" /></td>
										<td><bean:write property="centroCostoNombre"
												name="cCostList" /></td>
									</tr>
								</logic:iterate>
							</tbody>
						</table>
					</div>
					<div id="derechat">
						<h2>Tabla Áreas</h2>
						<table border="1">
							<thead>
								<tr>
									<th>ID:</th>
									<th>Área:</th>
								</tr>
							</thead>
							<tbody>
								cl.ciisa.cokedb.model.AreaDescBean aDescList = (cl.ciisa.cokedb.model.AreaDescBean) pageContext.getAttribute("aDescList");
									<tr>
										<td><bean:write property="areaId" name="aDescList" /></td>
										<td><bean:write property="areaNombre"
												name="aDescList" /></td>
									</tr>
								</logic:iterate>
							</tbody>
						</table>
					</div>
					<div id="derecha">
						<table>
							<h2>Nuevos datos de Usuario</h2>
							<h3 style="font-size: 10px;">(Solo llenar datos a modificar.)</h3>
							
							<tr>
								<td>ID:</td>
								<td><html:select property="userId">
										<html:options collection="userList" property="userId"
											labelProperty="userNombre" />
									</html:select></td>
							</tr>
							<tr>
								<td>Nombre:</td>
								<td style="border: 1px"><html:text property="userName"
										size="15" /></td>
							</tr>
							<tr>
								<td>Email:</td>
								<td style="border: 1px"><html:text property="userEmail"
										size="15" /></td>
							</tr>

							<tr>
								<td>Area:</td>
								<td><html:select property="userDescAreaId">
										<html:option value="SELECCIONE..."></html:option>
										<html:options collection="areaDescList" property="areaId"
											labelProperty="areaNombre" />
									</html:select></td>
							</tr>

							<tr>
								<td>Centro Costo:</td>
								<td><html:select property="userCentCostId">
										<html:option value="SELECCIONE..."></html:option>
										<html:options collection="centCostList"
											property="centroCostoId" labelProperty="centroCostoNombre" />
									</html:select></td>
							</tr>





							<td colspan="2" align="left"><html:submit value='Ingresar' />
							</td>
							</tr>

						</table>

					</div>
				</html:form> </section>

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
			Template by <a href="http://www.ZevLaG.com/" title="www.ZevLaG.com">ZevLabG</a>
		</p>
		</footer>
</body>
</html>