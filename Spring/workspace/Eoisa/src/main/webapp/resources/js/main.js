$(document).ready(function() {
	// Page Loading Overlay
	$(".loading-overlay").fadeOut(100);
	
	// Ajax CSRF set
	$.ajaxSetup({
		headers : { "X-CSRF-TOKEN": $('meta[name = "_csrf_token"]').attr("content") },
		timeout: 10000,
		cache: false
	});
	
    // Sticky Navbar
    $(function() {
        var stickyToggle = function(sticky, stickyWrapper, scrollElement) {
            var stickyHeight = sticky.outerHeight();
            var stickyTop = stickyWrapper.offset().top;
            if (scrollElement.scrollTop() >= stickyTop) {
                stickyWrapper.height(stickyHeight);
                sticky.addClass("is-sticky");
            } else {
                sticky.removeClass("is-sticky");
                stickyWrapper.height('auto');
            }
        };

        $("[data-toggle='sticky-onscroll']").each(function() {
            var sticky = $(this);
            var stickyWrapper = $("<div>").addClass("sticky-wrapper");
            sticky.before(stickyWrapper);
            sticky.addClass("sticky");

            $(window).on("scroll.sticky-onscroll resize.sticky-onscrol", function() {
                stickyToggle(sticky, stickyWrapper, $(this));
            });

            stickyToggle(sticky, stickyWrapper, $(window));
        });
    });
    
    // Sidenav(Mobile) btn
    $(function() {
        $(document).on("click", ".btn-sidenav-open", function() {
            $(".sidenav").css("left", "0vw");
            $(".sidenav-overlay").show();
        });

        $(document).on("click", ".btn-sidenav-close", function() {
            $(".sidenav").css("left", "-70vw");
            $(".sidenav-overlay").hide();
        });
        
        $(document).on("click", ".sidenav-overlay", function() {
            $(".sidenav").css("left", "-70vw");
            $(".sidenav-overlay").hide();
        });
    });
	
    // Follow Sidebar
    $(function() {
        var md = new MobileDetect(window.navigator.userAgent);
        if(md.mobile() == null && $(document).width() > 576){
            var $sidebar = $(".follow"),
                $window = $(window),
                offset = $sidebar.offset(),
                topPadding = 45;

            $window.scroll(function() {
                if ($window.scrollTop() > (offset.top + 500)) {
                    $sidebar.stop().animate({
                        marginTop: $window.scrollTop() - offset.top + topPadding
                    }, 750);
                } else {
                    $sidebar.stop().animate({
                        marginTop: 0
                    }, 750);
                }
            });
        }
    });
    
 	// Scrolltop btn
    $(function() {
        $(window).scroll(function() {
            if ($(this).scrollTop() > 600) {
                $("#scrolltop").fadeIn();
            } else {
                $("#scrolltop").fadeOut();
            }
        });

        $("#scrolltop").click(function() {
            $("html, body").animate({
                scrollTop: 0
            }, 500);
            return false;
        });
    });
    
    // Ticker
    $(function() {
        $(".ticker").easyTicker({
            direction: "up",
            easing: "swing",
            speed: "slow",
            interval: 2500,
            height: 24,
            visible: 1,
            mousePause: 1,
        });
        
        $("#ranking").hover(function() {
			$(".ticker").stop().animate({ height: "220px"}, 250);
        }, function() {
			$(".ticker").stop().animate({ height: "24px"}, 250);
        });
    });
	
    // Navbar Dropdown
    $(function() {
    	$(document).on("click", ".dropdown .dropdown-menu", function(event) {
    		event.stopPropagation();
    	});
    	
        $(".dropdown").on("show.bs.dropdown", function() {
            $(this).find(".dropdown-menu").first().stop(true, true).fadeIn("fast");
        });

        $(".dropdown").on("hide.bs.dropdown", function() {
            $(this).find(".dropdown-menu").first().stop(true, true).fadeOut("fast");
        });
    });

    // Mobile Topnav Active Effect
    $(function() {            	
        var url = $(location).attr("href");
        
    	if(!url.includes("rank") && !url.includes("theme")) {
    		$(".nav-item.home").addClass("active");
    	} else if(url.includes("rank")) {
        	$(".nav-item.rank").addClass("active");
    	} else if(url.includes("theme")) {
    		$(".nav-item.theme").addClass("active");
    	} else {
    		$("#left-sidebar").removeClass("component-desktop");
        }
    });
                     
    // Search
    $(function() {
    	$(document).on("click", "#div-search .fa-search", function() {
    		$("#form-search").submit();
    	});
    	
        $("#form-search").submit(function() {
            if($(this).children("input[name = keyword]").val().trim().length < 2) {
                alert("???????????? ?????? ??? ?????? ??????????????? ?????????.");
                return false;
            } else {
            	$(this).attr("action", "/search/" + $("input[name = keyword]").val());
                return true;
            }
        });
    });

    // Clipboard Copy
    $(function() {                
        var clipboard = new ClipboardJS(".btn-share");

		clipboard.on("success", function(e) {
			e.clearSelection();
			alert("URL??? ??????????????? ?????????????????????.");
        });

        clipboard.on("error", function(e) {
            alert("URL ?????? ??? ????????? ?????????????????????.");
        });
    });
    
    // Wishlist
    $(function() {                
    	$(document).on("click", ".btn-wish", function() {
    		var dealno = $(this).data("dealno");
    		var username = $("input[name = 'username']").val();
    		if(username == null) return false;
    		var params = { username: username, dealno: dealno };
    		
			$.ajax({
    			type: "POST",
    			url: "/wishlist",
    			data: params,
    			success: function(result) {
    				if(result == 'full') {
    					alert("?????? 10?????? ????????? ??? ????????? ????????? ??? ????????????.");
    					return false;
    				} else {
    					$('.btn-wish[data-dealno = "' + dealno + '"]').children().toggleClass("fas");
    				}
    			},
    			error: function() {
    				alert("?????? ?????? ?????? ??? ????????? ?????????????????????.\n?????? ????????? ?????????.");
    				return false;
    			}
    		});
    	});
    });
    
    // Modify Userinfo
    $(function() {
    	var nmCheck = true;
    	var pwCheck = true;
    	
    	// Nickname Duplicate Check Button
    	$(document).on("change keyup paste", "#input-nickname", function() {
    		if($("#input-nickname").val() == $("input[name = 'nickname'").val()) {
    			$("#btn-namecheck").prop("disabled", true);
    			nmCheck = true;
    		} else if($("#input-nickname").val().trim() == "") { 
    			$("#btn-namecheck").prop("disabled", true);
    			nmCheck = false;
    		} else {
    			$("#btn-namecheck").prop("disabled", false);
    			nmCheck = false;
    		}
    	});
    	
    	// Nickname Duplicate Check
	    $(document).on("click", "#btn-namecheck", function() {
	    	var nickname = $("#input-nickname").val();
	    	$.post("/nickname_check", { nickname: nickname }, function(data) {
	    		if(data == "duplicated") {
	    			$(".message-namecheck").css("color", "#ff5a5f");
	    			$(".message-namecheck").html("?????? ???????????? ??????????????????.");
	    			nmCheck = false;
	    		} else {
	    			$(".message-namecheck").css("color", "#8ce071");
	    			$(".message-namecheck").html("?????? ????????? ??????????????????.");
	    			nmCheck = true;
	    		}
	    	});
	    });
	    
	    // Password Check
	    var pw_regex = new RegExp("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,}$");
    	$(document).on("change keyup paste", "#input-password", function() {
    		var password = $("#input-password").val();
    		if(pw_regex.test(password)) {
    			$(".message-passwordcheck").css("color", "#8ce071");
    			$(".message-passwordcheck").html("?????? ????????? ?????????????????????.");
    			pwCheck = true;
    		} else if(!pw_regex.test(password) && password == "") {
    			$(".message-passwordcheck").html("");
    			pwCheck = true;
    		} else {
    			$(".message-passwordcheck").css("color", "#ff5a5f");
    			$(".message-passwordcheck").html("????????? ???????????? ???????????????.");
    			pwCheck = false;
    		}
    	});
    	
    	// Profile Image Upload
    	var ppCheck = false;
    	var uploadedFilePath = "";
    	var blob;
    	$(document).on("change", "#input-profile", function(event) {
    		var file = event.target.files[0];
    		console.log(file.type);
    		if(file.size > 5242880) {
    			alert("?????? 5MB??? ???????????? ???????????????. ?????? ????????? ?????????.");
    			$("#input-profile").val("");
    			return false;
    		} else if(!file.type.match("image/jpeg|image/png")) {
    			alert("???????????? ??? ?????? ?????? ???????????????. ?????? ????????? ?????????.");
    			$("#input-profile").val("");
    			return false;
    		} else {
        		var reader = new FileReader();
        		reader.onload = function(event) {
        			// Image Resizing
        			var image = new Image();
        			image.onload = function() {
            			var canvas = document.createElement("canvas");
            			var ctx = canvas.getContext("2d");
                        ctx.drawImage(image, 0, 0);

                        var MAX_WIDTH = 500;
                        var MAX_HEIGHT = 500;
                        var width = image.width;
                        var height = image.height;
                        if (width > height) {
                            if (width > MAX_WIDTH) {
                                height *= MAX_WIDTH / width;
                                width = MAX_WIDTH;
                            }
                        } else {
                            if (height > MAX_HEIGHT) {
                                width *= MAX_HEIGHT / height;
                                height = MAX_HEIGHT;
                            }
                        }
                        canvas.width = width;
                        canvas.height = height;
                        var ctx = canvas.getContext("2d");
                        ctx.drawImage(image, 0, 0, width, height);
                        
                        dataURL = canvas.toDataURL(file.type, 0.5);
            			$(".div-profile #profile-img").attr("src", dataURL);
            			blob = dataURItoBlob(dataURL);

            			ppCheck = true;
        			}
        			image.src = event.target.result;
        		}
        		reader.readAsDataURL(file);
    		}
    		
        	function dataURItoBlob(dataURI) {
        	    var byteString;
        	    if(dataURI.split(",")[0].indexOf("base64") >= 0) {
        	        byteString = atob(dataURI.split(",")[1]);
        	    } else {
        	        byteString = unescape(dataURI.split(",")[1]);
        	    }
        	    var mimeString = dataURI.split(",")[0].split(":")[1].split(";")[0];

        	    var ia = new Uint8Array(byteString.length);
        	    for(var i=0; i<byteString.length; i++) {
        	        ia[i] = byteString.charCodeAt(i);
        	    }

        	    return new Blob([ia], { type:mimeString });
        	}
    	});
    
    	$(document).on("click", ".div-profile button", function(event) {
    		$(".div-profile button").prop("disabled", true);
    		if(ppCheck == true) {
    			var formData = new FormData($("#form-profile")[0]);
    			formData.set("profile_pic", blob);
    			$.ajax({
    				url: "/profile_upload",
    				type: "POST",
    				data: formData,
    				processData: false,
    				contentType: false,
    				success: function(data) {
    					uploadedFilePath = data;
    					alert("????????? ????????? ????????????????????????.");
    				},
    				error: function(err) {
    					console.log(err);
    					alert("?????? ?????? ??? ????????? ?????????????????????.\n?????? ????????? ?????????.");
    					$(".div-profile button").prop("disabled", false);
    					return false;
    				}
    			});
    		} else {
    			alert("???????????? ????????? ????????????.");
    			$(".div-profile button").prop("disabled", false);
    			return false;
    		}
    	});
    	
    	// Modify Submit
    	$(document).on("click", "#btn-complete", function(event) {
    		if(nmCheck == true && pwCheck == true) {
    			var params = { 
    				username: $("input[name = 'username']").val(), 
    				nickname: $("#input-nickname").val(), 
    				password: $("#input-password").val(),
    				profile_pic: uploadedFilePath
    			};
    			modify(params);
    		} else if(nmCheck == false) {
    			alert("????????? ?????? ?????? ????????? ????????? ?????????.");
    		} else if(pwCheck == false) {
    			alert("???????????? ????????? ????????? ?????????.");
    		}
    	});
    	
    	function modify(params) {
    		$.post("/modify", params, function(result) {
    			if(result == "success") {
    				alert("?????? ????????? ??????????????? ?????????????????????.\n?????? ????????? ?????? ??????????????? ???????????????.");
    			} else if(result == "fail") {
    				alert("?????? ????????? ??????????????? ???????????? ???????????????.\n?????? ????????? ?????????.");
    				location.reload();
    			}
    			$("#modal-modify-userinfo").modal("hide");
    		}).fail(function() {
				alert("?????? ?????? ?????? ??? ????????? ?????????????????????.\n?????? ????????? ?????????.");
				location.reload();
    		});
    	};
    });
    
	// Ajax Infinite Scroll
	var path = window.location.href + "/";
    var param = "";
    var lastIndex = $(".total-page").data("value");
    var initIS = function() {
		$("#main-content-wrapper").infiniteScroll({
			path: function() {
				if(this.loadCount < (lastIndex - 1)) {
					var nextIndex = this.loadCount + 2;
					return path + nextIndex + param;
				}
			},
			append: "#main-content",
			checkLastPage: true,
			history: false
		});
	}
   	initIS();
   	
   	$("#main-content-wrapper").on("request.infiniteScroll", function(event) {
   		$(".loading-indicator").show();
   	});
   	
   	$("#main-content-wrapper").on("load.infiniteScroll", function(event) {
   		$(".loading-indicator").hide();
   	});
    
    // Filtering
    $(function() {
        var scanFilterList = function() {
        	var selected = { regions:[], sites:[], shops:[], isended:[] };
	        $("ul.filter-menu li.filter-list").each(function() {
	            var key = $(this).data("key");
	            var value = $(this).data("value");
	
	            if(key == "region" && (selected.regions.indexOf(value) < 0) && $(this).hasClass("active")) {
	            	selected.regions.push(value);
	            } else if(key == "site" && (selected.sites.indexOf(value) < 0) && !$(this).hasClass("active")) {
	            	selected.sites.push(value);
	            } else if(key == "shop" && (selected.shops.indexOf(value) < 0) && !$(this).hasClass("active")) {
	            	selected.shops.push(value);
	            } else if(key == "isended" && (selected.isended.indexOf(value) < 0) && !$(this).hasClass("active")) {
	            	selected.isended.push(value);
	            }
	        });
		    return selected;
        }
        
        var checkMin = function() {
        	if($("li.filter-list.active[data-key = region]").length < 1) {
        		alert("?????? ?????? ????????? ?????? ????????? ??????????????? ?????????.");
				return false;
        	}
        }
        
        $.ajaxSettings.traditional = true;
        $(".filter-list").click(function() {
            $(this).toggleClass("active");
        	if(checkMin() == false) {
        		$(this).toggleClass("active");
        		return false;
        	}
            var params = scanFilterList();
            $.ajax({
            	type: "GET",
            	url: "/filter/1",
            	data: { region: params.regions, site: params.sites, shop: params.shops, isended: params.isended },
            	dataType: "html",
            	success: function(data) {
            		$("#main-content-wrapper").infiniteScroll("destroy");
            		$("#main-content").remove();
            		$(document).scrollTop(0);
            		$("#main-content-wrapper").html(data);
        			path = this.url.substr(0, this.url.indexOf("?") - 1);
            		if($("li.filter-list.active").length == 20) {
            			param = "";
            		} else {
                    	param = this.url.substr(this.url.indexOf("?"));
            		}
            		lastIndex = $(".total-page").data("value");
            		initIS(); // Reinitialize Infinite Scroll
            	},
            	error: function() {
            		alert("????????? ?????? ??? ????????? ?????????????????????.\n?????? ????????? ?????????.");
            		return false;
            	}
            });
        });
    });
    
    $(document).on("click", "#filter button", function() {
    	$(this).children().toggleClass("fa-angle-up");
    });
});