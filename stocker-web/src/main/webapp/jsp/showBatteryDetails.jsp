<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@ page
	import="com.preciapps.stocker.dao.service.inter.BatteryServiceInterface"%>
<%@ page import="com.preciapps.stocker.model.Battery"%>

<!DOCTYPE html>

<html>
<head>
<title>Propiedades de la batería</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="../images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/noui/nouislider.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="../css/util.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<%
		ServletContext context = getServletContext();
		AnnotationConfigApplicationContext springContext = (AnnotationConfigApplicationContext) context
				.getAttribute("springContext");
		BatteryServiceInterface bServ = springContext.getBean(BatteryServiceInterface.class);
		Battery battery = bServ.findById(Integer.valueOf(request.getParameter("id")));
	%>
	<div class="container-contact100">
		<div class="wrap-contact100">
			<span class="contact100-form-title">Detalles de la batería <%=battery.getSerial()%></span>
			<div class="table">
				<div class="row">
					<div class="cell">Brand</div>
					<div class="cell">
						<%=battery.getBrand()%>
					</div>
				</div>
				<div class="row">
					<div class="cell">Capacity</div>
					<div class="cell">
						<%=battery.getCapacity()%>
					</div>
				</div>
				<div class="row">
					<div class="cell">Leakage</div>
					<div class="cell">
						<%=battery.getLeakage()%>
					</div>
				</div>
				<div class="row">
					<div class="cell">OCV</div>
					<div class="cell">
						<%=battery.getOcv()%>
					</div>
				</div>
				<div class="row">
					<div class="cell">Resistance</div>
					<div class="cell">
						<%=battery.getResistance()%>
					</div>
				</div>
				<div class="row">
					<div class="cell">Stage</div>
					<div class="cell">
						<%=battery.getStage()%>
					</div>
				</div>
				<div class="row">
					<div class="cell">Structure</div>
					<div class="cell">
						<%=battery.getStructure()%>
					</div>
				</div>
				<div class="row">
					<div class="cell">Comments</div>
					<div class="cell"><%=battery.getMessage()%></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>