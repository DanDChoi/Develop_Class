<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />

    <title>Togather</title>
    <meta content="" name="description" />
    <meta content="" name="keywords" />

    <!-- Favicons -->
    <link href="/assets/img/favicon.png" rel="icon" />
    <link href="/assets/img/apple-touch-icon.png" rel="apple-touch-icon" />

    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
      rel="stylesheet"
    />

    <!-- Vendor CSS Files -->
    <link href="/assets/vendor/animate.css/animate.min.css" rel="stylesheet" />
    <link href="/assets/vendor/aos/aos.css" rel="stylesheet" />
    <link
      href="/assets/vendor/bootstrap/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <link
      href="/assets/vendor/bootstrap-icons/bootstrap-icons.css"
      rel="stylesheet"
    />
    <link href="/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet" />
    <link href="/assets/vendor/remixicon/remixicon.css" rel="stylesheet" />
    <link href="/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet" />
	<script src="http://code.jquery.com/jquery-latest.js"></script>
    <!-- Template Main CSS File -->
    <link href="/assets/css/style.css" rel="stylesheet" />
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
      <script>
      Kakao.init('11400a9267d93835389eb9255fcaad0b');
      function signout(){
        if(Kakao.Auth.getAccessToken() != null){
    	  Kakao.Auth.logout(function(){
    	    setTimeout(function(){
              location.href="member/logout.do";
              
           },500);
         });
        }else{
        	location.href="member/logout.do";
        	 
        }
      }

     	$(function(){
     		$("#???????????????id").on("click", function(){
     			$.ajax({
     				url:"handleWishList",
     				type:"POST",
     				dataType:"json",
     				contentType:"application/json",
     				data:{
     					
     				},
     				success: function(result){
     					$("numberOfWish").empty();
     					$("numberOfWish").append();
     				},
     				error:function(error){
     					
     				}
     			})
     		});
     	});
     	window.onpageshow = function(event) {
     		if ( event.persisted || (window.performance && window.performance.navigation.type == 2)) { 
     			location.reload();
     		} 
     		
     	}

      </script>
  </head>

  <body >
    <!-- ======= Header ======= -->
    <header id="header" class="fixed-top">
      <div class="container d-flex align-items-center">
        <h1 class="logo me-auto"><a href="/">Togather</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
		
        <nav id="navbar" class="navbar order-last order-lg-0">
          <ul>
            <li><a class="active" href="/">Home</a></li>
            <li><a href="about.html">About</a></li>
          <c:if test="${m ne null}">
            <li><a href="groupTab/myGroup.do?mnum=${m.mnum }">?????? ??????</a></li><!--?????????????????? ????????? ??????-->
           	<li><a href="wishlist.html">?????????
           	<span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
           	</a></li>
           </c:if>
            <li><a href="board/listPage">?????????</a></li>
            <li class="dropdown">
              <a href="#"
                ><span>????????????</span> <i class="bi bi-chevron-down"></i
              ></a>
              <ul>
                <li><a href="notice.html">????????????</a></li>
                <li><a href="FAQ.html">???????????? ??????</a></li>
                <li><a href="qa">Q&A</a></li>
                <li><a href="contact.html">Contact</a></li>
              </ul>
            </li>
            
           <c:choose>
           		<c:when test="${m eq null}">
            		<li><a href="member/login.do">????????? ${sessionScope.m} </a></li>
        		</c:when>
          		<c:otherwise>
            		<li><a href="javascript:void(0);" onclick="signout();">????????????</a></li>
            	</c:otherwise>
         </c:choose>
          </ul>
          <i class="bi bi-list mobile-nav-toggle"></i>

        </nav>
        <!-- .navbar -->

        <!--?????????????????? ??????????????? ????????? ??????????????? ?????????????????? ????????? ????????? ???????????-->
        <c:choose>
           		<c:when test="${m eq null}">
		        	<a href="member/joinform.do" class="get-started-btn">????????????</a>
		        </c:when>
		        <c:otherwise>
        			<a href="groupTab/groupCreate.do" class="get-started-btn">???????????????</a>
        		</c:otherwise>
         </c:choose>
        
        
      </div>
    </header>
    <!-- End Header -->

    <!-- ======= Hero Section ======= -->
    <section id="hero" class="d-flex justify-content-center align-items-center">
      <div
        class="container position-relative"
        data-aos="zoom-in"
        data-aos-delay="100"
      >
        <h1>
          Togather??? ????????????<br />??????????????? ??????????????? <br />??????????????????
        </h1>
        <h2>?????? ?????? ????????? 1825?????? ???????????? ??????????????????</h2>
        <a href="courses.html" class="btn-get-started">????????????</a>
      </div>
    </section>
    <!-- End Hero -->
    <!-- Search Start -->
    <div
      class="container-fluid mb-5 wow fadeIn mt-5"
      data-wow-delay="0.1s"
      style="padding: 35px; background-color: #5fcf80"
    >
      <div class="container">
        <div class="row g-2">
          <div class="col-md-10">
            <div class="row g-2">
              <div class="col-md-4">
                <input
                  type="text"
                  class="form-control border-0 py-3"
                  placeholder="????????????"
                />
              </div>
              <div class="col-md-4">
                <select class="form-select border-0 py-3">
                  <option selected disabled>?????????</option>
                  <option value="1">????????????/??????</option>
                  <option value="2">??????/??????</option>
                  <option value="3">??????/??????</option>
                  <option value="4">???/????????????</option>
                  <option value="5">??????/??????</option>
                  <option value="6">??????/??????</option>
                  <option value="7">??????/??????/??????</option>
                  <option value="8">??????/?????????</option>
                  <option value="9">??????/??????</option>
                  <option value="10">????????????</option>
                  <option value="11">?????????/???/???</option>
                  <option value="12">??????/??????</option>
                  <option value="13">??????/??????</option>
                  <option value="14">????????????</option>
                  <option value="15">????????????</option>
                </select>
              </div>
              <div class="col-md-4">
                <select class="form-select border-0 py-3">
                  <option selected disabled>??????</option>
                  <option value="1">??????</option>
                  <option value="2">??????</option>
                  <option value="3">??????</option>
                  <option value="4">??????</option>
                  <option value="5">??????</option>
                  <option value="6">??????</option>
                  <option value="7">??????</option>
                  <option value="8">??????</option>
                  <option value="9">??????</option>
                  <option value="10">??????</option>
                  <option value="11">??????</option>
                </select>
              </div>
            </div>
          </div>
          <div class="col-md-2">
            <button class="btn btn-dark border-0 w-100 py-3">Search</button>
          </div>
        </div>
      </div>
    </div>
    <!-- Search End -->

          <!-- ======= Counts Section ======= -->
          <section id="counts" class="counts section-bg mb-5">
            <div class="container">
              <div class="row counters">
                <div class="col-lg-3 col-6 text-center">
                  <span
                    data-purecounter-start="0"
                    data-purecounter-end="${membercount }"
                    data-purecounter-duration="1"
                    class="purecounter"
                  ></span>
                  <p>?????????</p>
                </div>
    
                <div class="col-lg-3 col-6 text-center">
                  <span
                    data-purecounter-start="0"
                    data-purecounter-end="${groupcount }"
                    data-purecounter-duration="1"
                    class="purecounter"
                  ></span>
                  <p>????????? ??????</p>
                </div>
    
                <div class="col-lg-3 col-6 text-center">
                  <span
                    data-purecounter-start="0"
                    data-purecounter-end="${gatheringcount }"
                    data-purecounter-duration="1"
                    class="purecounter"
                  ></span>
                  <p>????????? ??????</p>
                </div>
    
                <div class="col-lg-3 col-6 text-center">
                  <span
                    data-purecounter-start="0"
                    data-purecounter-end="2198"
                    data-purecounter-duration="1"
                    class="purecounter"
                  ></span>
                  <p>???????????? ?????????</p>
                </div>
              </div>
            </div>
          </section>
          <!-- End Counts Section -->

   

      <!-- ======= Features Section ======= -->
      <section id="features" class="features">
        <div class="container" data-aos="fade-up">
          <div class="row" data-aos="zoom-in"  data-aos-delay="100">
            <div class="col-lg-3 col-md-4">
              <div class="icon-box">
                <i class="ri-football-fill" style="color: #ffbb2c"></i>
                <h3><a href="">??????/?????????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4 mt-md-0">
              <div class="icon-box">
                <i class="ri-footprint-line" style="color: #5578ff"></i>
                <h3><a href="">????????????/??????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4 mt-md-0">
              <div class="icon-box">
                <i class="ri-translate-2" style="color: #e80368"></i>
                <h3><a href="">??????/??????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4 mt-lg-0">
              <div class="icon-box">
                <i class="ri-music-2-line" style="color: #e361ff"></i>
                <h3><a href="">??????/??????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4">
              <div class="icon-box">
                <i class="ri-roadster-line" style="color: #47aeff"></i>
                <h3><a href="">???/????????????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4">
              <div class="icon-box">
                <i class="ri-cake-3-line" style="color: #ffa76e"></i>
                <h3><a href="">??????/??????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4">
              <div class="icon-box">
                <i class="ri-briefcase-5-line" style="color: #4233ff"></i>
                <h3><a href="">??????/??????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4">
              <div class="icon-box">
                <i class="ri-open-arm-line" style="color: #b2904f"></i>
                <h3><a href="">??????/??????/??????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4">
              <div class="icon-box">
                <i class="ri-palette-line" style="color: #b20969"></i>
                <h3><a href="">??????/?????????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4">
              <div class="icon-box">
                <i class="ri-group-line" style="color: #ff5828"></i>
                <h3><a href="">??????/??????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4">
              <div class="icon-box">
                <i class="ri-user-heart-line" style="color: #29cc61"></i>
                <h3><a href="">????????????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4">
              <div class="icon-box">
                <i class="ri-book-2-line" style="color: #11dbcf"></i>
                <h3><a href="">?????????/???/???<a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4">
              <div class="icon-box">
                <i class="ri-camera-line" style="color: #26c2d6"></i>
                <h3><a href="">??????/??????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4">
              <div class="icon-box">
                <i class="ri-gamepad-line" style="color: #e737cf"></i>
                <h3><a href="">??????/??????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4">
              <div class="icon-box">
                <i class="ri-mickey-line" style="color: #909b00"></i>
                <h3><a href="">????????????</a></h3>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 mt-4">
              <div class="icon-box">
                <i class="ri-send-plane-fill" style="color: #093166"></i>
                <h3><a href="">????????????</a></h3>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- End Features Section -->

      <!-- ======= Popular Courses Section ======= -->
      <section id="popular-courses" class="courses">
        <div class="container" data-aos="fade-up">
          <div class="section-title">
            <h2>?????????</h2>
            <p>Popular Groups</p>
          </div>
          <!--popular?????? ???????????? ??????-->
          <div class="row" data-aos="zoom-in" data-aos-delay="100">
          	  <c:forEach var="groupList" items="${list}"  varStatus="status" >
          	  	
	            <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
	              <div class="course-item">
	                <img
	                  src="/assets/img/course-1.jpg"
	                  class="img-fluid"
	                  alt="..."
	                />
	                <div class="course-content">
	                  <div
	                    class="d-flex justify-content-between align-items-center mb-3"
	                  >
	                    <h4>${groupList.interest}</h4>
	                    <p class="price">${groupList.gloc}</p>
	                  </div>
	
	                  <h3><a href="groupTab/groupInfo.do?gseq=${groupList.gseq}&mnum=${m.mnum}">${groupList.gname}</a></h3>
	                  <p>
				      		${groupList.gintro}
	                  </p>
	                  <p><i class="fa fa-map-marker-alt text-primary me-2"></i>${groupList.gloc}</p>
	                  <div
	                    class="trainer d-flex justify-content-between align-items-center"
	                  >
	                    <div class="trainer-profile d-flex align-items-center">
	                      <img
	                        src="/assets/img/trainers/trainer-1.jpg"
	                        class="img-fluid"
	                        alt=""
	                      />                   
	                      <span>${namelist[status.index].mname}</span>        
	                    </div>
	                    <div class="trainer-rank d-flex align-items-center">
	                    
	                      <i class="bx bx-user"></i>&nbsp;${groupMemberCount[status.index]} &nbsp;&nbsp;
	                     
	                      <i class="bx bx-heart"></i>&nbsp;65
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
	            
            </c:forEach>
            </div>
        </div>
      </section>
      <!-- End Popular Courses Section -->

   
    </main>
    <!-- End #main -->

    <!-- ======= Footer ======= -->
    <footer id="footer">
      <div class="footer-top">
        <div class="container">
          <div class="row">
            <div class="col-lg-3 col-md-6 footer-contact">
              <h3>Togather</h3>
              <p>
                ????????? ????????? <br />
                ?????? ????????? 2??? 123<br />
                ?????????????????? 2??? <br /><br />
                <strong>Phone:</strong> +82 2 1234 1234<br />
                <strong>Email:</strong> service@togather.com<br />
              </p>
            </div>

            <div class="col-lg-2 col-md-6 footer-links">
              <h4>Useful Links</h4>
              <ul>
                <li>
                  <i class="bx bx-chevron-right"></i> <a href="index.html">Home</a>
                </li>
                <li>
                  <i class="bx bx-chevron-right"></i> <a href="about.html">About us</a>
                </li>
                <li>
                  <i class="bx bx-chevron-right"></i> <a href="#">Services</a>
                </li>
                <li>
                  <i class="bx bx-chevron-right"></i>
                  <a href="#">Terms of service</a>
                </li>
                <li>
                  <i class="bx bx-chevron-right"></i>
                  <a href="#">Privacy policy</a>
                </li>
              </ul>
            </div>

            <div class="col-lg-3 col-md-6 footer-links">
              <h4>Our Services</h4>
              <ul>
                <li>
                  <i class="bx bx-chevron-right"></i> <a href="notice.html">????????????</a>
                </li>
                <li>
                  <i class="bx bx-chevron-right"></i>
                  <a href="FAQ.html">?????? ?????? ??????</a>
                </li>
                <li>
                  <i class="bx bx-chevron-right"></i>
                  <a href="QA.html">Q & A</a>
                </li>
                <li>
                  <i class="bx bx-chevron-right"></i> <a href="contact.html">Contact</a>
                </li>
              </ul>
            </div>

            <div class="col-lg-4 col-md-6 footer-newsletter">
              <h4>???????????? ????????????</h4>
              <p>
                ???????????? ??? ???????????? ????????? ?????? ??????????????? ????????? ??? ????????????.
              </p>
              <form action="" method="post">
                <input type="email" name="email" /><input
                  type="submit"
                  value="Subscribe"
                />
              </form>
            </div>
          </div>
        </div>
      </div>

      <div class="container d-md-flex py-4">
        <div class="me-md-auto text-center text-md-start">
          <div class="copyright">
            &copy; Copyright <strong><span>Togather</span></strong
            >. All Rights Reserved
          </div>
        </div>
        <div class="social-links text-center text-md-right pt-3 pt-md-0">
          <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
          <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
          <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
          <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
          <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
        </div>
      </div>
    </footer>
    <!-- End Footer -->

    <div id="preloader"></div>
    <a
      href="#"
      class="back-to-top d-flex align-items-center justify-content-center"
      ><i class="bi bi-arrow-up-short"></i
    ></a>

    <!-- Vendor JS Files -->
    <script src="../assets/vendor/purecounter/purecounter.js"></script>
    <script src="../assets/vendor/aos/aos.js"></script>
    <script src="../assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="../assets/vendor/swiper/swiper-bundle.min.js"></script>
    <script src="/assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script src="/assets/js/main.js"></script>
  </body>
</html>
