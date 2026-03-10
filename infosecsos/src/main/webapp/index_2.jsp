<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!doctype html>
<html>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>InfoSecSoS Ontology</title>
<link
	href='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css'
	rel='stylesheet'>
<link
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'
	rel='stylesheet'>
<script type='text/javascript'
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	
<style>body {
    background: #eee
}

#regForm {
    background-color: #ffffff;
    margin: 0px auto;
   font-family: 'Josefin Sans', sans-serif;
    padding: 40px;
    border-radius: 10px
}

#register {
    color: #6A1B9A
}

h1 {
    text-align: center
}

input {
    padding: 10px;
    width: 100%;
    font-size: 17px;
   font-family: 'Josefin Sans', sans-serif;
    border: 1px solid #aaaaaa;
    border-radius: 10px;
    -webkit-appearance: none
}

.tab input:focus {
    border: 1px solid #6a1b9a !important;
    outline: none
}

input.invalid {
    border: 1px solid #e03a0666
}

.tab {
    display: none
}

button {
    background-color: #6A1B9A;
    color: #ffffff;
    border: none;
    border-radius: 50%;
    padding: 10px 20px;
    font-size: 17px;
   font-family: 'Josefin Sans', sans-serif;
    cursor: pointer
}

button:hover {
    opacity: 0.8
}

button:focus {
    outline: none !important
}

#prevBtn {
    background-color: #bbbbbb
}

.all-steps {
    text-align: center;
    margin-top: 30px;
    margin-bottom: 30px;
    width: 100%;
    display: inline-flex;
    justify-content: center
}

.step {
    height: 40px;
    width: 40px;
    margin: 0 2px;
    background-color: #bbbbbb;
    border: none;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 15px;
    color: #6a1b9a;
    opacity: 0.5
}

.step.active {
    opacity: 1
}

.step.finish {
    color: #fff;
    background: #6a1b9a;
    opacity: 1
}

.all-steps {
    text-align: center;
    margin-top: 30px;
    margin-bottom: 30px
}
body{
border:2px solid #aaaaaa;
margin:20px;
padding:10px;

}

.thanks-message {
    display: none
}</style>
</head>
<body oncontextmenu='return false' class='snippet-body'>
	<div class="container mt-5">
		<div class="row d-flex justify-content-center align-items-center">
			<div class="col-md-8">
				<form action="<%=request.getContextPath()%>/Form_01"
					method="get">
					<h1 id="register">InfoSecSoS  Ontology </h1>
					<div class="all-steps" id="all-steps">
						<span class="step"><i class="fa fa-user"></i></span> <span
							class="step"><i class="fa fa-spotify"></i></span> <span
							class="step"><i class="fa fa-mobile-phone"></i></span>
					</div>
					<div class="tab">
						<h6>1 - How is information security divided into systems-of-systems in InfoSecSoS?</h6>

					</div>
					

					<div style="overflow: auto;" id="nextprevious">
						<div style="float: left;">
							<button type="submit" id="nextBtn" onclick="nextPrev(1)">
								<i class="fa fa-angle-double-right"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>

	</div>
	<body oncontextmenu='return false' class='snippet-body'>
	<div class="container mt-5">
		<div class="row d-flex justify-content-center align-items-center">
			<div class="col-md-8">
				<form action="<%=request.getContextPath()%>/Form_02"
					method="get">
					<div>
						<h6>2 - What are the systems-of-systems information security technologies, models, techniques, tools or threat in InfoSecSoS?</h6>
						
					</div>
					<div style="overflow: auto;" id="nextprevious">
						<div style="float: left;">
							<button type="submit" id="nextBtn" onclick="nextPrev(1)">
								<i class="fa fa-angle-double-right"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>

	</div>
	<body oncontextmenu='return false' class='snippet-body'>
	<div class="container mt-5">
		<div class="row d-flex justify-content-center align-items-center">
			<div class="col-md-8">
				<form action="<%=request.getContextPath()%>/Form_03"
					method="get">
					<div>
						<h6>3 - What are the specific factors of information security in InfoSecSoS?</h6>
						
					</div>
					<div style="overflow: auto;" id="nextprevious">
						<div style="float: left;">
							<button type="submit" id="nextBtn" onclick="nextPrev(1)">
								<i class="fa fa-angle-double-right"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>

	</div>
	<body oncontextmenu='return false' class='snippet-body'>
	<div class="container mt-5">
		<div class="row d-flex justify-content-center align-items-center">
			<div class="col-md-8">
				<form action="<%=request.getContextPath()%>/Form_04"
					method="get">
					<div>
						<h6>4 - What are the types of information security human factors in InfoSecSoS?</h6>
						
					</div>
					<div style="overflow: auto;" id="nextprevious">
						<div style="float: left;">
							<button type="submit" id="nextBtn" onclick="nextPrev(1)">
								<i class="fa fa-angle-double-right"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>

	</div>
	<body oncontextmenu='return false' class='snippet-body'>
	<div class="container mt-5">
		<div class="row d-flex justify-content-center align-items-center">
			<div class="col-md-8">
				<form action="<%=request.getContextPath()%>/Form_05"
					method="get">
					<div>
						<h6>5 - What are the information security assessment methods of systems-of-systems in InfoSecSoS?</h6>
						
					</div>
					<div style="overflow: auto;" id="nextprevious">
						<div style="float: left;">
							<button type="submit" id="nextBtn" onclick="nextPrev(1)">
								<i class="fa fa-angle-double-right"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>

	</div>
	<body oncontextmenu='return false' class='snippet-body'>
	<div class="container mt-5">
		<div class="row d-flex justify-content-center align-items-center">
			<div class="col-md-8">
				<form action="<%=request.getContextPath()%>/Form_06"
					method="get">
					<div>
						<h6>6 - What encryption solutions are currently found in systems-of-systems in InfoSecSoS?</h6>
						
					</div>
					<div style="overflow: auto;" id="nextprevious">
						<div style="float: left;">
							<button type="submit" id="nextBtn" onclick="nextPrev(1)">
								<i class="fa fa-angle-double-right"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>

	</div>
	<body oncontextmenu='return false' class='snippet-body'>
	<div class="container mt-5">
		<div class="row d-flex justify-content-center align-items-center">
			<div class="col-md-8">
				<form action="<%=request.getContextPath()%>/Form_07"
					method="get">
					<div>
						<h6>7 - What algorithm solutions are currently found in systems-of-systems in InfoSecSoS?</h6>
						
					</div>
					<div style="overflow: auto;" id="nextprevious">
						<div style="float: left;">
							<button type="submit" id="nextBtn" onclick="nextPrev(1)">
								<i class="fa fa-angle-double-right"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>

	</div>
	<body oncontextmenu='return false' class='snippet-body'>
	<div class="container mt-5">
		<div class="row d-flex justify-content-center align-items-center">
			<div class="col-md-8">
				<form action="<%=request.getContextPath()%>/Form_10"
					method="get">
					<div>
						<h6>8 - What is the application domain of information security in systems-of-systems in InfoSecSoS?</h6>
						
					</div>
					<div style="overflow: auto;" id="nextprevious">
						<div style="float: left;">
							<button type="submit" id="nextBtn" onclick="nextPrev(1)">
								<i class="fa fa-angle-double-right"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>

	</div>
<body oncontextmenu='return false' class='snippet-body'>
	<div class="container mt-5">
		<div class="row d-flex justify-content-center align-items-center">
			<div class="col-md-8">
				<form action="<%=request.getContextPath()%>/Form_08"
					method="get">
					<div>
						<h6>9 - Search for information security encryption in systems-of-systems in InfoSecSoS.</h6>
						<p>
							<input placeholder="Name..." type="text" name="criptografia">
						</p>
					</div>
					<div style="overflow: auto;" id="nextprevious">
						<div style="float: left;">
							<button type="submit" id="nextBtn" onclick="nextPrev(1)">
								<i class="fa fa-angle-double-right"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>

	</div>
	
	<body oncontextmenu='return false' class='snippet-body'>
	<div class="container mt-5">
		<div class="row d-flex justify-content-center align-items-center">
			<div class="col-md-8">
				<form action="<%=request.getContextPath()%>/Form_09"
					method="get">
					<div>
						<h6>10 - Search for information security algorithm in systems-of-systems in InfoSecSoS.</h6>
						<p>
							<input placeholder="Name..." type="text" name="algoritmo">
						</p>
					</div>
					<div style="overflow: auto;" id="nextprevious">
						<div style="float: left;">
							<button type="submit" id="nextBtn" onclick="nextPrev(1)">
								<i class="fa fa-angle-double-right"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>

	</div>
	<body oncontextmenu='return false' class='snippet-body'>
	<div class="container mt-5">
		<div class="row d-flex justify-content-center align-items-center">
			<div class="col-md-8">
				<form action="treeView.jsp" method="POST">
					<div>
						<h6>11 - Hierarchy Tree View.</h6>
						
					</div>
					<div style="overflow: auto;" id="nextprevious">
						<div style="float: left;">
							<button type="submit" id="nextBtn" onclick="nextPrev(1)">
								<i class="fa fa-angle-double-right"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>

	</div>
	</div>
	
	<script type='text/javascript'
		src='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'></script>
	<script type='text/javascript' src=''></script>
	<script type='text/javascript' src=''></script>
	<script type='text/Javascript'>
		var currentTab = 0;
		document.addEventListener("DOMContentLoaded", function(event) {

			showTab(currentTab);

		});

		function showTab(n) {
			var x = document.getElementsByClassName("tab");
			x[n].style.display = "block";
			if (n == 0) {
				document.getElementById("prevBtn").style.display = "none";
			} else {
				document.getElementById("prevBtn").style.display = "inline";
			}
			if (n == (x.length - 1)) {
				document.getElementById("nextBtn").innerHTML = '<i class="fa fa-angle-double-right"></i>';
			} else {
				document.getElementById("nextBtn").innerHTML = '<i class="fa fa-angle-double-right"></i>';
			}
			fixStepIndicator(n)
		}

		function nextPrev(n) {
			var x = document.getElementsByClassName("tab");
			if (n == 1 && !validateForm())
				return false;
			x[currentTab].style.display = "none";
			currentTab = currentTab + n;
			if (currentTab >= x.length) {

				document.getElementById("nextprevious").style.display = "none";
				document.getElementById("all-steps").style.display = "none";
				document.getElementById("register").style.display = "none";
				document.getElementById("text-message").style.display = "block";

			}
			showTab(currentTab);
		}

		function validateForm() {
			var x, y, i, valid = true;
			x = document.getElementsByClassName("tab");
			y = x[currentTab].getElementsByTagName("input");
			for (i = 0; i < y.length; i++) {
				if (y[i].value == "") {
					y[i].className += " invalid";
					valid = false;
				}
			}
			if (valid) {
				document.getElementsByClassName("step")[currentTab].className += " finish";
			}
			return valid;
		}
		function fixStepIndicator(n) {
			var i, x = document.getElementsByClassName("step");
			for (i = 0; i < x.length; i++) {
				x[i].className = x[i].className.replace(" active", "");
			}
			x[n].className += " active";
		}
	</script>
</body>
</html>