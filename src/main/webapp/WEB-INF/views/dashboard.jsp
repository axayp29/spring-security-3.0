<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<style>
body {
	background-color: #f8f9fa;
}

.container {
	margin-top: 50px;
}

.card {
	background-color: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.card h2 {
	text-align: center;
	color: #007bff;
}

.dashboard-item {
	margin-top: 20px;
	text-align: center;
}

.btn-primary {
	background-color: #007bff;
	border-color: #007bff;
}

.btn-primary:hover {
	background-color: #0056b3;
	border-color: #0056b3;
}
</style>
</head>

<body>
	<div class="container">
		<div class="card">
			<h2>Welcome to Your Dashboard ${username}</h2>
			<div class="dashboard-item">
				<a href="/logout">
					<button class="btn btn-danger">Logout</button>
				</a>
			</div>
			<div class="dashboard-item">
				<p>This is some content on your dashboard.</p>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
