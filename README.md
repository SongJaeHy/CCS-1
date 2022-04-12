# :pushpin: Company Commute System

> 사원들의 통근을 관리하고, 사원들끼리 소통할 수 있는 서비스

<br>

## 1) 제작 기간 & 참여 인원
+ 2021년 8월 16일 ~ 8월 27일 (약 2주)
+ 팀 프로젝트 (4명)

<br>

## 2) 사용 기술
+ Java 8
+ JSP
+ MySQL 8.0
+ Bootstrap 5.1.0
+ Javascript

<br>

## 3) ERD 설계 
![CCS_ERD](/img/CCS_ERD.jpg)
<br>
+ 다이어그램
![CCS_Diagram](/img/CCS_Diagram.png)
<br>

+ 사내 서비스라 로그인을 하지 않으면 서비스를 이용할 수 없게끔 기능을 구현하였습니다. 

<br>

## 4) 핵심 기능
+ 이 서비스의 특징은 간단한 CRUD시스템 위에 다양한 핵심 기능을 추가하였습니다.<br>
+ CCS의 핵심 기능은 출퇴근 관리와 결재 시스템입니다.<br>
+ 사용자(사원)는 간편하고 직관적인 UI를 통해 따로 보고할 필요없이 단지 몇번의 클릭만으로 출퇴근을 기록하며, 결재 요청을 할 수 있습니다.
+ 그리고 게시판을 추가해 사원들끼리 소통할 수 있는 공간도 마련하였습니다. 
![버튼](https://user-images.githubusercontent.com/86466976/132124207-9afb3550-5330-43a0-a2c4-566a375cc78a.gif)
<br><br/>
+ 또한 관리자 페이지를 만들어 관리자 계정으로 로그인하면 사용할 수 있는 사원 정보와 출퇴근 관리, 결재 승인/비승인 등등의 기능을 추가하였습니다.    
![관리자 메인](https://user-images.githubusercontent.com/86466976/132124550-2b8875ec-8c16-471c-8701-47b1e5e9f85b.gif)

<br>

## 4-1) 로그인 / 회원가입
<details>
<summary><b>로그인시 세션을 저장받아 모든 페이지에서 세션을 검사하는 로직</b></summary>
<div markdown="1">

```java
// 세션 검사
HttpSession session = request.getSession();
String idSession = (String)session.getAttribute("session_id");

if(idSession == null) {
  try {
    RequestDispatcher rd = request.getRequestDispatcher("/member/member_login_form.jsp");
    rd.forward(request, response);
  } catch(Exception e) {
    e.printStackTrace();
  }
}
```

+ 사내 서비스라 로그인을 하지 않으면 서비스를 이용할 수 없게끔 기능을 구현해야 했습니다. 
+ 따라서 위의 로직을 통해 세션을 검사하도록 해서 세션값이 존재하지 않으면 로그인 화면으로 돌아가도록 구성하였습니다.
</div>
</details>  
<br>
<details>
<summary><b>회원가입시 비밀번호 일치여부 검사 및 조건 설정</b></summary>
<div markdown="1">  
<br> 

![비밀번호 검사](https://user-images.githubusercontent.com/86466976/132125912-1f412572-0bd7-4573-b32c-58748d0b6f3e.gif)
  
<br>
  
+ __아래는 비밀번호는 6글자 이상, 16글자 이하로 / 특수문자 필수 / 비밀번호 일치여부__ 이 3가지 기능을 구현해주는 로직입니다. 
  
```html
<script>
function check_pw(){
		
    var pw = document.getElementById('mpw').value;
    var SC = ["!","@","#","$","*"];
    var check_SC = 0;

    if(pw.length < 6 || pw.length > 16){
        window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
        document.getElementById('mpw').value='';
    }
    for(var i=0;i<SC.length;i++){
        if(pw.indexOf(SC[i]) != -1){
            check_SC = 1;
        }
    }
    if(check_SC == 0){
        window.alert('!,@,#,$,* 의 특수문자가 들어가 있지 않습니다.')
        document.getElementById('mpw').value='';
    }
    if(document.getElementById('mpw').value !='' && document.getElementById('repw').value!=''){
        if(document.getElementById('mpw').value==document.getElementById('repw').value){
            document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
            document.getElementById('check').style.color='blue';
        }
        else{
            document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
            document.getElementById('check').style.color='red';
        }
    }
}
</script>
```
</div>
</details>

<br>


## 4-2) 메인페이지
<details>
<summary><b>출퇴근 체크</b></summary>
<div markdown="1">   
<br>

+ 로그인을 하면 바로 접속되는 화면으로, 출근하기 버튼을 누르면 출근 시간이 기록되고 퇴근하기 버튼이 뜹니다.
+ 이후 퇴근하기 버튼을 누르면 퇴근 시간도 기록되고 버튼이 사라지며 다음 날이 되면 출근하기 버튼이 생기도록 기능 구현하였습니다. 
	
![출퇴근 확인](https://user-images.githubusercontent.com/86466976/135083815-b465e035-010e-4687-af4f-bc1cc55ead06.gif)
  
</div>
</details>

<br>


## 4-3) 게시판
<details>
<summary><b>기본적인 CRUD 구현 및 페이징 처리</b></summary>
<div markdown="1">
<br>

![게시판 글쓰기](https://user-images.githubusercontent.com/86466976/132120612-0e909500-079d-45d9-a3dc-f59204ba61c3.gif)

+ 사용자가 제목과 본문을 작성할 수 있도록 구현했고, 아래에 글쓴이는 사용자의 아이디가 자동으로 저장되도록 하였습니다. 
+ 아무것도 입력하지 않으면 작성하라는 경고문이 뜨고, 정상적으로 작성하면 글이 올라가는 것을 볼 수 있습니다.  

<br>

![게시판 글 수정 및 삭제](https://user-images.githubusercontent.com/86466976/132974414-c7f2d6ab-1161-4340-a62c-fa95bf7d47a7.gif)

+ 글의 제목을 클릭하면 글의 상세 페이지에 들어가게 되고, 자신이 쓴 글에 한하여 수정 및 삭제를 할 수 있습니다.

<br>

![게시판 페이징](https://user-images.githubusercontent.com/86466976/132974432-0df14463-52f0-4a04-9300-677e97baa7d7.gif)

+ 게시판 페이징을 적용하여 페이지별로 글을 볼 수 있도록 구현하였습니다. 

</div>
</details>
<br>
<details>
<summary><b>세션 적용</b></summary>
<div markdown="1">
<br>

+ 아래의 gif와 같이 글의 상세페이지에 들어가면 자신이 작성한 글만 수정하기와 삭제하기 버튼이 보이는 것을 확인할 수 있습니다. `예시의 아이디 : asdasd)`

![게시판 세션](https://user-images.githubusercontent.com/86466976/132974473-98879977-56ac-48be-b320-09cf7e243175.gif)

```java
// 자신이 올린 게시물만 수정, 삭제할 수 있게 하는 로직
// 세션에 저장된 아이디와 게시판의 글쓴이가 일치하는지 검사
// 일치하면 1을, 일치하지 않을 경우 0을 보내준다.
if(idSession.equals(board.getM_id())) {
    System.out.println(1);
    request.setAttribute("writer", 1);
} else {
    System.out.println(0);
    request.setAttribute("writer", 0);
}
```
```html
<!-- 자신이 올린 게시물만 수정과 삭제 버튼이 보이게 하는 로직 -->
<c:choose>
    <c:when test="${ writer == 1}">
        <form class="col-md-2 offset-md-2" style='display: inline' action="/ccs/boardUpdate.do" method="post">
            <input type="hidden" value="${board.b_no }" name="b_no" /> 
            <input class="btn btn-outline-success" type="submit" value="수정하기" />
        </form>

        <form class="col-md-2" style='display: inline' action="/ccs/boardDelete.do" method="post">
            <input type="hidden" value="${board.b_no }" name="b_no" />
            <input class="btn btn-outline-success" type="submit" value="삭제하기" />
        </form>
        <button class="btn btn-outline-success col-md-3" type="button" onclick="location.href='/ccs/board.do'">리스트로 돌아가기</button>
    </c:when>
    <c:otherwise>
        <button class="btn btn-outline-success col-md-4 offset-md-4" type="button" onclick="location.href='/ccs/board.do'">리스트로 돌아가기</button>
    </c:otherwise>
</c:choose>
```
+ JSTL을 활용하여 조건문을 걸어서 `writer`가 1이란 값을 담아올 경우에만 버튼이 보이게 하였습니다. 
</div>
</details>
<br>
<details>
<summary><b>게시판 검색 기능</b></summary>
<div markdown="1">
<br>

+ 원하는 키워드를 작성하면, 그 키워드가 포함된 제목만 보여주는 검색 기능을 포함하고 있습니다. 

![게시판 검색](https://user-images.githubusercontent.com/86466976/132974552-46cdd8c8-5735-4470-acbf-c6fe27bd76bd.gif)

```html
<!-- 검색 폼태그 -->
<!-- keyword라는 이름으로 입력받은 검색어를 넘겨준다 -->
<form style='display:inline' action="/ccs/boardSearch.do" method="post">
    <input type="text" name="keyword" placeholder="검색어" />
    <input class="btn btn-success" type="submit" value="검색" />
</form>
```

![검색DAO](https://user-images.githubusercontent.com/86466976/132978835-efe02b9a-d1a5-4204-909b-615d11b78cc6.jpg)

+ 쿼리문은 LIKE 구문을 이용하여 키워드가 제목에 포함된 게시물만 가져오도록 합니다. 
+ `%`를 키워드의 앞뒤로 활용해 주어야 합니다. `%`가 없으면 키워드와 완전히 일치하는 제목의 게시물만 가져오게 됩니다. 

<br>        

![검색DAO2](https://user-images.githubusercontent.com/86466976/132979209-82e50b07-9a1d-4535-ad94-19a81c80b2d4.jpg)

+ 페이징을 위해 검색한 게시물의 총 개수도 구합니다. 

<br>

```html
<!-- 게시판 검색 페이징 버튼 -->
<c:if test="${searchTotal > 0 }">
    <ul class="pagination justify-content-center">
        <c:if test="${pageDTO.startPage > 10 }">
            <li class="page-item">
                <button type="button" class="page-link btn btn-light"
                    onclick="location.href='/ccs/boardSearch.do?page=${pageDTO.startPage - 10}&keyword=${keyword }'"><<</button>
            </li>
        </c:if>
        <c:forEach var="pNo" begin="${pageDTO.startPage}" end="${pageDTO.endPage}">
            <li class="page-item">
                <button type="button" class="page-link btn btn-light"
                    onclick="location.href='/ccs/boardSearch.do?page=${pNo}&keyword=${keyword }'">${pNo}</button>
            </li>
        </c:forEach>
        <c:if test="${pageDTO.endPage < pageDTO.totalPages }">
            <li class="page-item">
                <button type="button" class="page-link btn btn-light"
                    onclick="location.href='/ccs/boardSearch.do?page=${pageDTO.startPage + 10}&keyword=${keyword }'">>></button>
            </li>
        </c:if>
    </ul>
</c:if>
```
</div>
</details>    
<br>
<details>
<summary><b>게시물 필터</b></summary>
<div markdown="1">
<br>

![게시판 필터](https://user-images.githubusercontent.com/86466976/132974584-ac7ee75b-529a-4c48-a50c-e24ab352edc1.gif)

+ 게시물 필터는 조회순, 최신순 이렇게 2가지로 넣었습니다. 
+ 최신순 필터는 게시판의 기본값이 최신순이기에 게시판 메인 페이지로 이동하도록 했습니다. 
+ 따라서, 조회순 필터를 중점적으로 설명하겠습니다.    
<br>

![조회순DAO](https://user-images.githubusercontent.com/86466976/132982393-641c11ff-ea8d-47f1-8642-2c9f7b69d9dd.jpg)

+ sql 쿼리문은 ORDER BY 구문을 이용하여 조회수를 기준으로 내림차순 정렬을 해줍니다. 

<br>

```html
<!--  게시판 조회순 페이징 버튼 -->
<c:if test="${viewTotal > 0}">
    <ul class="pagination justify-content-center">
        <c:if test="${pageDTO.startPage > 10 }">
            <li class="page-item">
                <button type="button" class="page-link btn btn-light"
                    onclick="location.href='/ccs/boardView.do?page=${pageDTO.startPage - 10}'"><<</button>
            </li>
        </c:if>
        <c:forEach var="pNo" begin="${pageDTO.startPage}" end="${pageDTO.endPage}">
            <li class="page-item">
                <button type="button" class="page-link btn btn-light"
                    onclick="location.href='/ccs/boardView.do?page=${pNo}'">${pNo }</button>
            </li>
        </c:forEach>
        <c:if test="${pageDTO.endPage < pageDTO.totalPages }">
            <li class="page-item">
                <button type="button" class="page-link btn btn-light"
                    onclick="location.href='/ccs/boardView.do?page=${pageDTO.startPage + 10}'">>></button>
            </li>
        </c:if>
    </ul>
</c:if>
```
</div>
</details>

<br>


## 4-4) 결재창 / 관리자 페이지
<details>
<summary><b>결재요청 및 승인여부</b></summary>
<div markdown="1">   
<br>

+ 사원은 휴가, 반차, 월차, 연차에 대한 결재 요청을 남길 수 있습니다. 

![결재요청](https://user-images.githubusercontent.com/86466976/135084006-5b1fd678-2004-43dd-bee0-2242e9555bcf.gif)

<br>
	
+ 관리자는 관리자 페이지를 통해 결재에 대한 승인, 비승인 여부를 결정할 수 있습니다. 
	
![결재 승인,비승인](https://user-images.githubusercontent.com/86466976/135084063-58aca74b-3235-4268-9789-bb7ef7128809.gif)

</div>
</details>

