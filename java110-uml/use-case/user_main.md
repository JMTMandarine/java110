- [로그인_하기](#로그인_하기)
- [오늘의공연_지역검색하기](#오늘의공연_지역검색하기)
- [메인화면_동영상보기](#메인화면_동영상보기)
- [메인화면_동영상보기](#메인화면_동영상보기)


## 로그인_하기

- 유스케이스명
    - 로그인 하기
- 엑터
    - 비로그인 유저
- 시작 조건
    - 비로그인 상태
- 종료 조건
    - 로그인 권한 상태로 메인화면을 출력한다.
- 성공 시나리오
    
    - 사용자 : 헤더의 '로그인' 버튼을 클릭한다.
    - 시스템 : 로그인 모달창을 출력한다.
    case1 : 해당회원인 경우
        - 사용자 : 로그인 모달창에서 아이디와 패스워드를 입력하고 '로그인' 버튼을 클릭한다.
        - 시스템 : 입력한 해당 회원의 권한을 가지고 있는 메인화면을 출력한다.
    case2 : SNS연동인 경우
        - 사용자 : 로그인 모달창에서 SNS로고를 클릭한다.
        - 시스템 : 해당하는 SNS와 연동하는 모달창을 출력한다.
        - 사용자 : SNS연동 모달창에서 '로그인' 버튼을 클릭한다.
        - 시스템 : 입력한 해당 회원의 권한을 가지고 있는 메인화면을 출력한다.
- 예외 시나리오
    - 사용자 : 아이디/패스워드가 일치하지 않는다.
    - 시스템 : 로그인 모달창에서 아이디/패스워드 입력 아래부분에 빨간색으로 '아이디/패스워드가 일치하지 않습니다.'라는 text를 출력해준다.
    
---------------------------------------------------------------------------

## 오늘의공연_지역검색하기

- 유스케이스명
    - 오늘의공연_지역검색하기
- 엑터
    - 비로그인 유저
- 시작 조건
    - 비로그인 상태
- 종료 조건
    - 오늘의공연 목록에 검색에 해당하는 지역의 목록을 출력한다.
- 성공 시나리오    
    - 사용자 : 오늘의공연 검색창에 지역을 입력하고 '검색' 버튼을 클릭한다.
    - 시스템 : 검색지역에 해당하는 오늘의공연 목록을 페이지에 출력한다.
- 예외 시나리오
    - 사용자 : 검색내용 지역에 해당하는 인원이 없다.
    - 시스템 : 오늘의공연 목록에 '현재 검색지역에 해당하는 인원이 없습니다.'라고 출력한다.

---------------------------------------------------------------------------

## 메인화면_동영상보기

- 유스케이스명
    - 메인화면_동영상보기
- 엑터
    - 비로그인 유저
- 시작 조건
    - 비로그인 상태
- 종료 조건
    - 동영상 모달창을 출력해준다.
- 성공 시나리오    
    - 사용자 : 동영상 이미지를 클릭한다.
    - 시스템 : 해당하는 동영상 정보를 담고있는 모달창을 출력해준다.
- 예외 시나리오
    - 없음.

---------------------------------------------------------------------------