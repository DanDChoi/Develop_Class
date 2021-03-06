<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html >
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
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />

    <link
      href="/assets/vendor/bootstrap-icons/bootstrap-icons.css"
      rel="stylesheet"
    />
    <link href="/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet" />
    <link href="/assets/vendor/remixicon/remixicon.css" rel="stylesheet" />
    <link href="/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet" />
    <!-- alert -->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
     <!-- alert -->
	<script type="text/javascript" language="javascript" 
		     src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <!-- Template Main CSS File -->
    <link href="/assets/css/style.css" rel="stylesheet" />
    <script type="text/javascript">
    
    function groupJoin(){
    	Swal.fire({
			  title: '????????? ?????? ???????????????????',
			  icon: 'question',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes'
			}).then((result) => {
				console.log(result.isConfirmed);
			  if (result.isConfirmed) {
				var mnum = ${m.mnum};
	  			var gseq = ${groupInfo.gseq};
	  			var result = {"mnum":mnum,"gseq":gseq};
		  		$(function(){
  				$.ajax({
	   					url: "memInGroup.json",
	   					type: "POST",
	   					data: result,
	   					success: function(data){
	   					}
  				});
  				location.reload(); 
		  		});
		  		
			  }  			  
			});
    	}

    	function groupQuit(){
    		Swal.fire({
    			  title: '???????????? ?????? ???????????????????',
    			  icon: 'question',
    			  showCancelButton: true,
    			  confirmButtonColor: '#3085d6',
    			  cancelButtonColor: '#d33',
    			  confirmButtonText: 'Yes'
    			}).then((result) => {
    				console.log(result.isConfirmed);
    			  if (result.isConfirmed) {
    				var mnum = ${m.mnum};
  		  			var gseq = ${groupInfo.gseq};
  		  			var result = {"mnum":mnum,"gseq":gseq};
	  		  		$(function(){
	    				$.ajax({
		   					url: "groupQuit.json",
		   					type: "POST",
		   					data: result,
		   					success: function(data){
		   					}
	    				});
	    				location.reload(); 
	  		  		});
	  		  		
    			  }  			  
    			});
    	}
    	
    	function groupDeleteCheck(){ 
    		var mnum = ${m.mnum};
  			var gseq = ${groupInfo.gseq};
  			var result = {"mnum":mnum,"gseq":gseq};
	   			$(function(){
    				$.ajax({
	   					url: "groupDeletecheck.json",
	   					type: "POST",
	   					data: result,
	   					success: function(data){
	   						if(data==0){//?????????????????????
	   							groupDelete();
	   							console.log("check0: "+data);
	   						}else{//????????? ?????????
	   							console.log("check1: "+data);
	   							Swal.fire({
		  							  title: "???????????? ?????? ???????????????",
		  							  icon: "error"
	   							});
	   						}
	   					}
	   				});  
	   			});
    	}
    	
    	function groupUpdateCheck(){ 
    		var mnum = ${m.mnum};
  			var gseq = ${groupInfo.gseq};
  			var result = {"mnum":mnum,"gseq":gseq};
	   			$(function(){
    				$.ajax({
	   					url: "groupUpdatecheck.json",
	   					type: "POST",
	   					data: result,
	   					success: function(data){
	   						if(data==0){//?????????????????????
	   							groupUpdate();
	   							console.log("check0: "+data);
	   						}else if(data==1){//???????????????
	   							groupUpdate();
	   							console.log("check1: "+data);
	   							//swal("?????????,???????????? ?????? ???????????????");
	   						}else if(data==2){//????????????
	   							console.log("check2: "+data);
	   							Swal.fire({
		  							  title: "?????????,???????????? ?????? ???????????????",
		  							  icon: "error"
	   							});
	   						}else {//??????????????????
	   							Swal.fire({
		  							  title: "?????????,???????????? ?????? ???????????????",
		  							  icon: "error"
	   							});
	   							console.log("check3: "+data);
	   						}
	   					}
	   				});  
	   			});
    	}
    	
    	function groupUpdate(){
    		location="groupUpdate.do?gseq=${groupInfo.gseq}";
    	}
    	
    	function groupDelete(){
    		location="groupDelete.do?gseq=${groupInfo.gseq}";
    	}
    	
    	function memberInfo(index){
    		var arr = new Array();
    		<c:forEach var="memInGroupName" items="${memInGroupName}">	              
	        	arr.push({mnum:"${memInGroupName.MNUM}"});
        	</c:forEach>
        	console.log(arr);
        	console.log(arr[index].mnum);
        	baby_login = window.open(
        	  "../member/memberInfo?mnum="+arr[index].mnum+"&gseq=${groupInfo.gseq}", "memberInfo", 
        	   "width=1000, height=900, top=100, left=100");
        }
    </script>
    <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
    <script>
        Kakao.init('11400a9267d93835389eb9255fcaad0b');
        function signout(){
          if(Kakao.Auth.getAccessToken() != null){
      	  Kakao.Auth.logout(function(){
      	    setTimeout(function(){
                location.href="../member/logout.do";
             },500);
           });
          }else{
          	location.href="../member/logout.do";
          }
        }
    </script>
  </head>

  <body>
    <!-- ======= Header ======= -->
    <header id="header" class="fixed-top">
      <div class="container d-flex align-items-center">
        <h1 class="logo me-auto"><a href="../">Togather</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

        <nav id="navbar" class="navbar order-last order-lg-0">
          <ul>
            <li><a class="active" href="../">Home</a></li>
            <li><a href="about.html">About</a></li>
            <li><a href="myGroup.do?mnum=${m.mnum }">?????? ??????</a></li>
            <!--?????????????????? ????????? ??????-->
            <li><a href="boardMain.html">?????????</a></li>
            <li>
              <a href="wishlist.html"
                >?????????
                <span class="badge bg-dark text-white ms-1 rounded-pill"
                  >0</span
                >
              </a>
            </li>

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
		            <li><a href="login.html">?????????</a></li>		       
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
		        	<a href="../member/joinform.do" class="get-started-btn">????????????</a>
		        </c:when>
		        <c:otherwise>
		        	<a href="groupCreate.do" class="get-started-btn">???????????????</a>
		        </c:otherwise>
         </c:choose>
      </div>
    </header>
    <!-- End Header -->

    <main id="main">
      <!-- ======= Breadcrumbs ======= -->
      <div class="breadcrumbs" data-aos="fade-in">
        <div class="container">
          <h1>${groupInfo.gname}</h1>
          <p>?????? ??????? or ???????</p>
        </div>
      </div>
      <!-- End Breadcrumbs -->

      <!-- ======= Cource Details Section ======= -->
      <section id="course-details" class="course-details">
        <div class="container" data-aos="fade-up">
        <!-- ????????? nav ??? -->
        <ul class="nav nav-tabs mb-3">
        	<li class="nav-item">
        		<a class="nav-link active" aria-current="page" href="#">??????</a>
        	</li>
        	<li class="nav-item">
        		<a class="nav-link" href="#">?????????</a>
        	</li>
        	<li class="nav-item">
        		<a class="nav-link" href="#">?????????</a>
        	</li>
        </ul>
        
          <div class="row">
            <div class="col-lg-8">
              <img
                src="/assets/img/course-details.jpg"
                class="img-fluid"
                alt=""
              />
              <h3>${groupInfo.gname}</h3>
              <p>
                ${groupInfo.gintro}
              </p>
            </div>
            <div class="col-lg-4">
              <div
                class="course-info d-flex justify-content-between align-items-center"
              >
                <h5>?????????</h5>
                <p><a href="#">${groupMemberName.mname }</a></p>
              </div>

              <div
                class="course-info d-flex justify-content-between align-items-center"
              >
                <h5>??????</h5>
                <p>${groupInfo.gloc}</p>
              </div>

              <div
                class="course-info d-flex justify-content-between align-items-center"
              >
                <h5>?????????</h5>
                <p>${groupInfo.interest}</p>
              </div>

              <div
                class="course-info d-flex justify-content-between align-items-center"
              >
                <h5>??????</h5>
                <p>${groupMemberCount}/${groupInfo.limit}</p>
              </div>
              <!-- ???????????? ??????-->
              <div class="accordion acoordion-flush" id="accordionExample">
                <div class="accordion-item">
                  <h2 class="accordion-header" id="headingOne">
                    <button
                      class="accordion-button collapsed"
                      type="button"
                      data-bs-toggle="collapse"
                      data-bs-target="#collapseOne"
                      aria-expanded="true"
                      aria-controls="collapseOne"
                    >????????????
                    </button>
                  </h2>
                  <div
                    id="collapseOne"
                    class="accordion-collapse collapse"
                    aria-labelledby="headingOne"
                    data-bs-parent="#accordionExample"
                  >
                  <c:forEach items="${gatheringList}" var="gathering">
                    <div class="accordion-body">
                      <a href="../gathering/gatheringInfo.do?ga_seq=${gathering.ga_seq}&mnum=${m.mnum}">${gathering.ga_name}</a>
                    </div>
                   </c:forEach>
                   <div class="acoordion-body">
                   <nav aria-label="Page navigation example">
					  <ul class="pagination" style="justify-content:center">
					    <li class="page-item">
					      <a class="page-link" href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					   	<li class="page-item">
					      <a class="page-link" href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					  </ul>
					</nav>
                   </div>
                  </div>
                </div>
              </div>
              <!--???????????? ???-->
              <div
                class="course-info d-flex justify-content-between align-items-center"
              >
             <nav id="navbar" class="navbar order-last order-lg-0">
		       <ul>
			       <li class="dropdown">
		              <a href="#">
		              	???????????? 
		              	<i class="bi bi-chevron-down"></i>
		              	</a>
			              <ul >
			              	<c:forEach var="memInGroupName" items="${memInGroupName}" varStatus="index">
			              		<c:choose>
			              			<c:when test="${memInGroupName.GRADE eq 0}">
			              				<c:set var="grade" value="?????????"/>
			              			</c:when>
			              			<c:when test="${memInGroupName.GRADE eq 1}">
			              				<c:set var="grade" value="?????????"/>
			              			</c:when>
			              			<c:otherwise>
			              				<c:set var="grade" value=""/>
			              			</c:otherwise>
			              		</c:choose>  
			                	<c:choose>
				                	<c:when test="${m.mnum eq memInGroupName.MNUM}">
				                		<li><a href="javascript:void(0)">		           
					                	${memInGroupName.MNAME}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${grade}</a>
					                	
					                	</li>
				                	</c:when>
				                	<c:otherwise>
					                	<li><a href="javascript:void(0)" 
					                	onclick="location.href='javascript:memberInfo(${index.index})'">		           
					                	${memInGroupName.MNAME}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${grade}</a></li>
					                </c:otherwise>
				                </c:choose>
			                </c:forEach>
			              </ul>
			             
	            	</li>
	            </ul>
	          </nav>
	          </div>
              <div class="d-grid gap-2 mt-3 mb-3">
               <c:if test="${memInGroupCheck ne null}">
                <button
                  type="button"
                  class="btn btn-outline-success"
                  onclick="location.href='../gathering/gatheringCreate.do?gseq=${groupInfo.gseq}&mnum=${m.mnum}'"
                >
                 	???????????????
                </button>
                </c:if>
                
                <button type="button" class="btn btn-outline-secondary" 
                	onclick="location.href='javascript:groupUpdateCheck()'">
                  	?????? ????????????
                </button>
                <button type="button" class="btn btn-outline-secondary"
                onclick="location.href='javascript:groupDeleteCheck()'">
                 	 ?????? ????????????
                </button>
                <c:choose>
			         <c:when test="${memInGroupCheck eq null }">
		                <button type="button" class="btn btn-outline-secondary"
		                onclick="location.href='javascript:groupJoin()'">
		                 	 ?????? ????????????
		                </button>
		              </c:when>
			          <c:otherwise>
		                <button type="button" class="btn btn-outline-secondary"
		                onclick="location.href='javascript:groupQuit()'">
		                 	 ?????? ????????????
		                </button>
	                </c:otherwise>
                </c:choose>
              </div>
		         
            </div>
           
          </div>
          
        </div>
      </section>
      <!-- End Cource Details Section -->

      <!-- ======= Cource Details Tabs Section ======= -->
      <section id="cource-details-tabs" class="cource-details-tabs">
        <div class="container" data-aos="fade-up">
          <div class="row">
            <div class="col-lg-3">
              <ul class="nav nav-tabs flex-column">
                <li class="nav-item">
                  <a
                    class="nav-link active show"
                    data-bs-toggle="tab"
                    href="#tab-1"
                    >Modi sit est</a
                  >
                </li>
                <li class="nav-item">
                  <a class="nav-link" data-bs-toggle="tab" href="#tab-2"
                    >Unde praesentium sed</a
                  >
                </li>
                <li class="nav-item">
                  <a class="nav-link" data-bs-toggle="tab" href="#tab-3"
                    >Pariatur explicabo vel</a
                  >
                </li>
                <li class="nav-item">
                  <a class="nav-link" data-bs-toggle="tab" href="#tab-4"
                    >Nostrum qui quasi</a
                  >
                </li>
                <li class="nav-item">
                  <a class="nav-link" data-bs-toggle="tab" href="#tab-5"
                    >Iusto ut expedita aut</a
                  >
                </li>
              </ul>
            </div>
            <div class="col-lg-9 mt-4 mt-lg-0">
              <div class="tab-content">
                <div class="tab-pane active show" id="tab-1">
                  <div class="row">
                    <div class="col-lg-8 details order-2 order-lg-1">
                      <h3>Architecto ut aperiam autem id</h3>
                      <p class="fst-italic">
                        Qui laudantium consequatur laborum sit qui ad sapiente
                        dila parde sonata raqer a videna mareta paulona marka
                      </p>
                      <p>
                        Et nobis maiores eius. Voluptatibus ut enim blanditiis
                        atque harum sint. Laborum eos ipsum ipsa odit magni.
                        Incidunt hic ut molestiae aut qui. Est repellat minima
                        eveniet eius et quis magni nihil. Consequatur dolorem
                        quaerat quos qui similique accusamus nostrum rem vero
                      </p>
                    </div>
                    <div class="col-lg-4 text-center order-1 order-lg-2">
                      <img
                        src="/assets/img/course-details-tab-1.png"
                        alt=""
                        class="img-fluid"
                      />
                    </div>
                  </div>
                </div>
                <div class="tab-pane" id="tab-2">
                  <div class="row">
                    <div class="col-lg-8 details order-2 order-lg-1">
                      <h3>Et blanditiis nemo veritatis excepturi</h3>
                      <p class="fst-italic">
                        Qui laudantium consequatur laborum sit qui ad sapiente
                        dila parde sonata raqer a videna mareta paulona marka
                      </p>
                      <p>
                        Ea ipsum voluptatem consequatur quis est. Illum error
                        ullam omnis quia et reiciendis sunt sunt est. Non
                        aliquid repellendus itaque accusamus eius et velit ipsa
                        voluptates. Optio nesciunt eaque beatae accusamus lerode
                        pakto madirna desera vafle de nideran pal
                      </p>
                    </div>
                    <div class="col-lg-4 text-center order-1 order-lg-2">
                      <img
                        src="/assets/img/course-details-tab-2.png"
                        alt=""
                        class="img-fluid"
                      />
                    </div>
                  </div>
                </div>
                <div class="tab-pane" id="tab-3">
                  <div class="row">
                    <div class="col-lg-8 details order-2 order-lg-1">
                      <h3>Impedit facilis occaecati odio neque aperiam sit</h3>
                      <p class="fst-italic">
                        Eos voluptatibus quo. Odio similique illum id quidem non
                        enim fuga. Qui natus non sunt dicta dolor et. In
                        asperiores velit quaerat perferendis aut
                      </p>
                      <p>
                        Iure officiis odit rerum. Harum sequi eum illum corrupti
                        culpa veritatis quisquam. Neque necessitatibus illo
                        rerum eum ut. Commodi ipsam minima molestiae sed
                        laboriosam a iste odio. Earum odit nesciunt fugiat sit
                        ullam. Soluta et harum voluptatem optio quae
                      </p>
                    </div>
                    <div class="col-lg-4 text-center order-1 order-lg-2">
                      <img
                        src="/assets/img/course-details-tab-3.png"
                        alt=""
                        class="img-fluid"
                      />
                    </div>
                  </div>
                </div>
                <div class="tab-pane" id="tab-4">
                  <div class="row">
                    <div class="col-lg-8 details order-2 order-lg-1">
                      <h3>
                        Fuga dolores inventore laboriosam ut est accusamus
                        laboriosam dolore
                      </h3>
                      <p class="fst-italic">
                        Totam aperiam accusamus. Repellat consequuntur iure
                        voluptas iure porro quis delectus
                      </p>
                      <p>
                        Eaque consequuntur consequuntur libero expedita in
                        voluptas. Nostrum ipsam necessitatibus aliquam fugiat
                        debitis quis velit. Eum ex maxime error in consequatur
                        corporis atque. Eligendi asperiores sed qui veritatis
                        aperiam quia a laborum inventore
                      </p>
                    </div>
                    <div class="col-lg-4 text-center order-1 order-lg-2">
                      <img
                        src="/assets/img/course-details-tab-4.png"
                        alt=""
                        class="img-fluid"
                      />
                    </div>
                  </div>
                </div>
                <div class="tab-pane" id="tab-5">
                  <div class="row">
                    <div class="col-lg-8 details order-2 order-lg-1">
                      <h3>
                        Est eveniet ipsam sindera pad rone matrelat sando reda
                      </h3>
                      <p class="fst-italic">
                        Omnis blanditiis saepe eos autem qui sunt debitis porro
                        quia.
                      </p>
                      <p>
                        Exercitationem nostrum omnis. Ut reiciendis repudiandae
                        minus. Omnis recusandae ut non quam ut quod eius qui.
                        Ipsum quia odit vero atque qui quibusdam amet. Occaecati
                        sed est sint aut vitae molestiae voluptate vel
                      </p>
                    </div>
                    <div class="col-lg-4 text-center order-1 order-lg-2">
                      <img
                        src="/assets/img/course-details-tab-5.png"
                        alt=""
                        class="img-fluid"
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- End Cource Details Tabs Section -->
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
                  <i class="bx bx-chevron-right"></i>
                  <a href="../">Home</a>
                </li>
                <li>
                  <i class="bx bx-chevron-right"></i>
                  <a href="about.html">About us</a>
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
                  <i class="bx bx-chevron-right"></i>
                  <a href="notice.html">????????????</a>
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
                  <i class="bx bx-chevron-right"></i>
                  <a href="contact.html">Contact</a>
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
    <script src="/assets/vendor/purecounter/purecounter.js"></script>
    <script src="/assets/vendor/aos/aos.js"></script>
    <script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/assets/vendor/swiper/swiper-bundle.min.js"></script>
    <script src="/assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script src="/assets/js/main.js"></script>
  </body>
</html>
