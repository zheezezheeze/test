
function goPage(url, form) {
	form.action = url;
	form.method = "post";
	form.submit();
}

function goNewWindow(url) {
	window.open(url, "child", "width=600,height=400");
}