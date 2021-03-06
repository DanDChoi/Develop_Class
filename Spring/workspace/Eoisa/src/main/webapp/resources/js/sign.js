$(document).ready(function() {
	// Ajax CSRF set
	$.ajaxSetup({
		headers : { "X-CSRF-TOKEN": $('meta[name = "_csrf_token"]').attr("content") },
		timeout: 10000,
		cache: false
	});
	
	// Popup Message hide
	$(".message-box").delay(3000).fadeOut("slow");
	
	// Popover init
	$("input").popover({
		container: "body",
		placement: "top",
		viewport: { selector: ".container" }
	});
	
	// Popover hide
	$("input").focusout(function() {
		$(this).popover("hide");
	});

	// Toggle form 
	$(function() {
	    $(".message a").click(function(){
			$(".register-form").animate({ height: "toggle", opacity: "toggle" }, "slow");
			$(".signin-form").fadeToggle();
	    });
	 
		$(".find a").click(function(){
			$(".findpw-form").animate({ height: "toggle", opacity: "toggle" }, "slow");
			$(".signin-form").fadeToggle();
		});
	});
	
	var emCheck = false;
	var nmCheck = false;
	var pwCheck = false;
	
	var em_regex = new RegExp("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+(?:[A-Z]{2}|com|org|net|gov|mil|biz|info|ac.kr|name|aero|jobs|museum)");
    var pw_regex = new RegExp("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,}$");
    
	// Email(username) Check
	$(function() {
		$(document).on("change keyup paste", "#input-signup-email", function() {
    		var email = $("#input-signup-email").val();
    		if(em_regex.test(email)) {
    			$("#input-signup-email").popover("hide");
    			emCheck = true;
    		} else {
    			$("#input-signup-email").popover("show");
    			emCheck = false;
    		}
		});
	});
	
	// Nickname Check
	$(function() {
    	$(document).on("change keyup paste", "#input-signup-nickname", function() {
			if($("#input-signup-nickname").val().trim().length >= 2) {
				$("#input-signup-nickname").popover("hide");
	    		nmCheck = true;
			} else {
				$("#input-signup-nickname").popover("show");
				nmCheck = false;
			}
    	});
	});
	
    // Password Check
	$(function() {
    	$(document).on("change keyup paste", "#input-signup-password", function() {
    		var password = $("#input-signup-password").val();
    		if(pw_regex.test(password)) {
    			$("#input-signup-password").popover("hide");
    			pwCheck = true;
    		} else {
    			$("#input-signup-password").popover("show");
    			pwCheck = false;
    		}
    	});
	});
	
	// Signin Submit
	$(function() {
		$(document).on("click", "#btn-signin", function(event) {
			if(em_regex.test($("#input-signin-email").val()) && pw_regex.test($("#input-signin-password").val())) {
        		$(".signin-form").submit();
    		} else {
    			alert("????????? ????????? ??????????????? ?????? ????????? ?????????.");
    			return false;
    		}
		});
	});
    
	// Signup Submit
	$(function() {
    	$(document).on("click", "#btn-signup", function(event) {
    		if(emCheck == true && nmCheck == true && pwCheck == true) {
    			$("#btn-signup").prop("disabled", true);
    			$.post("/nickname_check", { nickname: $("#input-signup-nickname").val() }, function(data) {
    				if(data == "duplicated") {
    					alert("????????? ???????????? ???????????????. ?????? ???????????? ????????? ?????????.");
    					$("#btn-signup").prop("disabled", false);
    					return false;
    				} else {
    					$("#btn-signup").text("????????? ????????? ????????? ???");
    					var params = { username: $("#input-signup-email").val(), nickname: $("#input-signup-nickname").val(), password: $("#input-signup-password").val(), platform: $("#input-signup-platform").val() };
    					$.post("/signup", params, function() {
    						location.href="/sign/success";
    					}).fail(function() {
    						alert("???????????? ?????? ??? ????????? ?????????????????????.\n?????? ????????? ?????????.");
    						location.reload();
    						return false;
    					});
    				}
    			});
    		} else if(emCheck == false) {
    			alert("????????? ????????? ????????? ?????????.");
    			return false;
    		} else if(nmCheck == false) {
    			alert("???????????? ????????? ?????????.");
    			return false;
    		} else if(pwCheck == false) {
				alert("??????????????? ????????? ?????????.");
				return false;
			}
    	});
	});
	
	// Find Password
	$(function() {
    	$(document).on("click", "#btn-findpw", function(event) {
    		if(em_regex.test($("#input-findpw-email").val())) {
        		$("#btn-findpw").prop("disabled", true);
        		$("#btn-findpw").text("????????? ????????? ????????? ???");
        		$(".findpw-form").submit();
    		} else {
    			alert("????????? ????????? ?????? ????????? ????????????.");
    			return false;
    		}
    	});
	});
});