<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>
<body>
	Time: <span id="foo"></span>

	<br><br>
	<button onclick="start()">Start</button>

	<script type="text/javascript">
	function start() {

		var eventSource = new EventSource("HelloServlet");

		eventSource.onmessage = function(event) {

			document.getElementById('foo').innerHTML = event.data;

		};

	}
	</script>
</body>
</html>