$(document).ready(function() {

	$("#iuserPassword").keyup(function() {

		var len = $("#iuserPassword").val().length;

		if (len <= 0) {
			$("#suserPassword").text("*");
			$("#suserPassword").removeClass("red");
		} else if (len <= 4) {
			$("#suserPassword").text("WEAK");
			$("#suserPassword").addClass("red");
			$("#suserPassword").removeClass("orange");
		} else if (len <= 8) {
			$("#suserPassword").text("MEDIUM");
			$("#suserPassword").addClass("orange");
			$("#suserPassword").removeClass("green");
		} else {
			$("#suserPassword").text("STRONG");
			$("#suserPassword").addClass("green");
		}

	});
});