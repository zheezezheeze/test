$(document).ready(function () {
	$('#settingButton').click(function (){
		var b_num = 0;
		if(window.opener.document.getElementById("b_number") != null) {
			b_num = window.opener.document.getElementById("b_number").value;
		}
		var b_password = $('#firstValue').val();
		var b_retry = $('#secondValue').val();
		if(b_password !== b_retry) {
			alert('비밀번호가 일치하지 않습니다.');
			window.opener.document.getElementById("hasPassword").innerHTML = 'N';
		}
		var requestData = {
			'b_num':b_num,
			'b_password':b_password,
			'b_retry':b_retry	
		}
		
		$.post("ajax_setting_password", requestData , function (data) {
			window.opener.document.getElementById('hasPassword').innerHTML = 'Y';
			window.opener.document.getElementById('b_password').value = b_password;
			window.close();
		}).
		fail(function(data) {
			alert(data);
		})
	});
	
	$('#confirmButton').click(function () {
		var b_password = $('#inputPassword').val();
		var b_num = function () {
		    var params = location.search.substr(location.search.indexOf('?') + 1);
		    var sval = '';
		    params = params.split('&');
		    for(var i = 0; i < params.length; i++) {
		        temp = params[i].split('=');
		        if([temp[0]] == 'b_num') {
		        	sval = temp[1]; 
		        }
		    }
		    return sval;
		}
		var requestData = {
			'b_password':b_password,
			'b_num':b_num
		}
		$.post("ajax_confirm_password", requestData, function (data) {
			if(data == 'goList') {
				alert('비밀번호가 일치하지 않습니다');
			}
			window.opener.location.href=data;
			window.close();
		})
	})
	
	
});