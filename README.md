# 에이블리 사전과제
> 에이블리 백엔드 개발 전형 진행을 위한 사전과제 프로젝트
# 사용 기술
> - 언어 : JAVA 
> - DB : H2 
> - 프레임워크 : spring framework
    
<h2> 프로그램 실행 </h2>

1. JDK 19 이상 설치
2. H2 DB 설치(https://h2database.com/html/main.html)
3. H2 DB 실행
4. spring boot run configuration 설정(com.victor.ably.AblyApplication)
5. 프로그램 실행

<h2> API 명세 </h2>

1.  회원
    - (POST)/member/join : 회원가입
    - (GET)/member/login : 로그인
    - (GET)/member/info : 내정보조회
2. 찜 목록 
   - (POST)/wish/product : 찜 상품등록
   - (DELETE)/wish/product : 찜 상품삭제
   - (GET)/wish/{wishlistSequence}/product : 찜 서랍의 찜 목록 조회
   - (POST)/wish/list : 찜 목록 등록
   - (DELETE)/wish/list : 찜 목록 삭제
   - (GET)/wish/list : 찜 목록 조회

<h2> 특별히 신경 쓴 부분 </h2>

- 공통익셉션 클래스 적용
- mapstruct를 사용하여 VO<->DTO간 데이터변환에 용이하도록 함
- 기본 DDL문을 실행하도록 하여 테이블 생성이 용이

<h2> 