<%@ page contentType="text/html;charset=utf-8" import="java.util.ArrayList, team1.togather.domain.GroupTab"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>ToGather 모임 수정</title>
	<meta charset='utf-8'>
	<script language="javascript">
	   function check()
	   {
	       for(var i=0; i<document.input.elements.length; i++)
		   {
		      if(document.input.gName.value == "" || 
	    		  document.input.gIntro.value == "" || 
	    		  document.input.gLoc.value == "" ||
	    		  document.input.limit.value == "")
			  {
			     alert("필수입력란이 비었습니다.");
			     return false;
			  }
		   }
		   document.input.submit();
       }
	</script>
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>모임 수정</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/ToGather.ico" />
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
      rel="stylesheet"
    />

    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/styles.css" rel="stylesheet" />
    <link href="../css/main.css" rel="stylesheet" />
    <link href="../css/groupList.css" rel="stylesheet" />
    <script src="../js/main.js" defer></script>
    <script src="../js/splitting.js"></script>
    <script src="../js/typed.js"></script>
  </head>
 <body onload="input.name.focus()">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light bg-gray">
      <div class="container px-4 px-lg-5">
        <h1 class="logo">
          <a href="../"
            ><img src="../imgs/topLogo.png" alt="ToGather" title="홈으로 이동"
          /></a>
        </h1>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
            <li class="nav-item">
              <a
                class="nav-link active"
                aria-current="page"
                href="introduce.html"
                >ToGather란?</a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="notice.html">공지사항</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="group/groupTab.do?m=groupList">모임 목록</a>
            </li>
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                id="navbarDropdown"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
                >자주하는 질문(Q&A 게시판필요)</a
              >
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li>
                  <a class="dropdown-item" href="FAQ.html">FAQ</a>
                </li>
                <li>
                  <a class="dropdown-item" href="QA.html">Q&A(게시판필요)</a>
                </li>
              </ul>
            </li>
          </ul>
          <form class="d-flex">
            <!-- 로그인시 보이게하기
            <button class="btn btn-outline-success" type="button" onclick="location.href='logout.html'">
              <i class="bi bi-person-check-fill"></i>
              로그아웃
            </button>
          -->
            <button
              class="btn btn-outline-dark"
              type="button"
              onclick="location.href='login.html'"
            >
              <i class="bi bi-person-fill"></i>
              로그인
            </button>
            <button
              class="btn btn-outline-primary"
              type="button"
              onclick="location.href='join.html'"
            >
              <i class="bi bi-person-plus-fill"></i>
              회원가입
            </button>
            <button
              class="btn btn-outline-dark"
              type="button"
              onclick="location.href='wish.html'"
            >
              <i class="bi-cart-fill me-1"></i>
              찜
              <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
            </button>
            <!--회원전용 메뉴. 비로그인시 로그인먼저 하도록 alert 띄우기-->
            <button
              class="btn btn-outline-danger"
              type="button"
              onclick="location.href='groupTab.do?m=groupInput'"
            >
              <i class="bi bi-people-fill"></i>
              모임 만들기
            </button>
          </form>
        </div>
      </div>
    </nav>
    <c:forEach items="${groupGetUpdate}" var="groupTab">
	    <section class="vh-100" style="background-color: #eee">
	      <div class="container h-75">
	        <div class="row d-flex justify-content-center align-items-center h-100">
	          <div class="col-lg-10 col-xl-10">
	            <div class="card text-black" style="border-radius: 25px">
	              <div class="card-body p-md-5">
	                <div class="row justify-content-center">
	                  <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
	                    <p
	                      class="text-center h1 fw-bold mb-3 mx-1 mx-md-4 mt-2"
	                    ></p>
	                    <p class="text-center h2 fw-bold mb-1 mx-1 mx-md-4 mt-3">
	                      모임 수정
	                    </p>
	                    <form class="mx-1 mx-md-4" method="post" action="groupTab.do?m=groupUpdate&gSeq=${groupTab.gSeq}">
	                      <div class="d-flex flex-row align-items-center mb-0">
	                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
	                        <div class="form-outline flex-fill mb-2">
	                          <label class="form-label mb-0" for="form3Example1c"
	                            >모임 이름</label
	                          >
	                          <input
	                            type="text"
	                            name="gName"
	                            value="${groupTab.gName}"
	                            maxlength="30"
	                            id="form3Example1c"
	                            class="form-control"
	                          />
	                        </div>
	                      </div>
	                      <div class="d-flex flex-row align-items-center mb-0">
	                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
	                        <div class="form-outline flex-fill mb-2">
	                          <label class="form-label mb-0" for="form3Example4cd"
	                            >지역</label
	                          >
	                          <select class="form-control" name="gLoc">
	                            <option>선택</option>
	                            <option>서울</option>
	                            <option>경기</option>
	                            <option>인천</option>
	                          </select>
	                        </div>
	                      </div>
	
	                      <div class="d-flex flex-row align-items-center mb-0">
	                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
	                        <div class="form-outline flex-fill mb-2">
	                          <label class="form-label mb-0" for="form3Example4cd"
	                            >관심사</label
	                          >
	                          <select class="form-control" name="interest" disabled>
	                            <option selected>${groupTab.interest}</option>
	                            <option>아웃도어</option>
	                            <option>운동</option>
	                            <option>인문학</option>
	                            <option>업종</option>
	                            <option>언어</option>
	                            <option>문학</option>
	                            <option>음악</option>
	                            <option>공예</option>
	                            <option>댄스</option>
	                            <option>봉사활동</option>
	                            <option>자유주제</option>
	                          </select>
	                        </div>
	                      </div>
	
	                      <div class="d-flex flex-row align-items-center mb-0">
	                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
	                        <div class="form-outline flex-fill mb-2">
	                          <label class="form-label mb-0" for="form3Example4c"
	                            >모임 정원</label
	                          >
	                          <input
	                            type="number"
	                            name="limit"
	                            value="${groupTab.limit}"
	                            min="2"
	                            max="100"
	                            placeholder="2~100"
	                            id="form3Example4c"
	                            class="form-control"
	                          />
	                        </div>
	                      </div>
	                      <div class="d-flex flex-row align-items-center mb-0">
	                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
	                        <div class="form-outline flex-fill mb-2">
	                          <label class="form-label mb-0" for="form3Example4c"
	                            >모임소개</label
	                          >
	                          <textarea
	                            name="gIntro"
	                            placeholder="소개글을 작성해주세요"
	                            rows="10"
	                            cols="53"
	                            id="form3Example4c"
	                            class="form-control"
	                          >${groupTab.gIntro}</textarea>
	                        </div>
	                      </div>
	                      <div class="d-flex flex-row align-items-center mb-0">
	                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
	                        <div class="form-outline flex-fill mb-2">
	                          <label class="form-label mb-0" for="form3Example4c"
	                            >메인 사진</label
	                          >
	                          <input
	                            type="file"
	                            name="gFile"
	                            id="form3Example4c"
	                            class="form-control"
	                          />
	                        </div>
	                      </div>
	                      <br />
	                      <br />
	                      <div class="d-flex justify-content-center mx-1 mb-lg-4">
	                        <button
	                          type="submit"
	                          class="btn btn-primary"
	                          style="margin: 3px"
	                        >
	                          수정하기
	                        </button>
	                        <button
	                          type="reset"
	                          class="btn btn-warning"
	                          style="margin: 3px"
	                        >
	                          다시작성
	                        </button>
	                        <button
	                          type="button"
	                          class="btn btn-danger"
	                          style="margin: 3px"
	                          onclick="location.href='groupTab.do?m=groupInfo&gSeq=${groupTab.gSeq}'"
	                        >
	                          취소
	                        </button>
	                      </div>
	                    </form>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
	    </section>
    </c:forEach>
  </body>
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">
        Copyright &copy; Your Website 2021
      </p>
    </div>
  </footer>
  <!-- Bootstrap core JS-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Core theme JS-->
  <script src="js/scripts.js"></script>
</html>