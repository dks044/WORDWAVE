<div align=center><h1><a href="https://www.wordwave.xyz/">🌊WORDWAVE🌊</a></h1></div>
<img src="https://github.com/dks044/WORDWAVE/assets/74749417/4419bca1-f15b-4e26-aa88-acc051bfa3b8" alt="메인화면">
<div align=center>
    <h1>영어공부를 쉽고 재밌게 하는 사이트</h1>
</div>
<br>
<div align=center>
    <h1>📅 기간 📅</h1>
    <h4>기획 및 개인 학습</h4> 23. 11. 15 ~ 23. 12. 31
    <h4>구현 단계</h4> 24.1.1 ~ 24.5.13
</div>
<br>

<div align="center">
    <h1>🔎 목차</h1>
    <h4>1. 🎯 기획 배경 </h4>
    <h4>2. ⭐️ 주요 기능 </h4>
    <h4>3. ⚙ 시스템 아키텍처</h4>
    <h4>4. 👉 API 명세서 </h4>
    <h4>5. 🗂️ 파일 구조 </h4>
    <h4>6. 💾 ERD </h4>
    <h4>7. 🖥️ 화면 소개 </h4>
    <h4>8. 😎 트러블슈팅 </h4>
    <h4>9. 🌊 팀원 소개 </h4>
</div>


<br>
<div align=center>
    <h2>🎯기획 배경</h2>
    <h3>🖊영어 공부와 프로그래밍 공부를 동시에 하고싶어서</h3>
    영어는 ‘세계의 공통어’ 라고 할 정도로, 많이 쓰입니다. <br>
    여행을 가서 대화를 통해 외국인 친구를 사귈 수 있고, <br>
    해외 개발자와 영어를 사용해서 소통할 수 있고, <br>
    또는 채용 시장에서 공인 영어 실력을 증명해서 나만의 경쟁력을 증명할 수 있죠.
    <br>
    <h3>🏃협업의 경험 쌓기</h3>
    저희 팀은 우테코 6기 프리코스에서 만났습니다.<br>
    그곳에서 인연이 되어 팀을 결성하고, 프리코스에서 배운 컨벤션들을 적용해서<br>
    깔끔한 팀프로젝트를 만들어보기로 했습니다.   <br>
    우테코 프리코스에서는 CBD, TDD, Git 컨벤션, 도메인 로직 등 협업에 중요한 전략들을 배웠습니다.   <br>
    배운 것들을 활용해 프로젝트를 만들며 ‘협업에 강한 개발자’가 되고자 시작했습니다.<br>
</div>
<br>
<div align=center>
    <h2>⭐️ 주요 기능</h2>
    <h3>영어 단어 퀴즈</h3>
    <h4>단어 문제 유형은 2가지가 있다.</h4>
    <p>랜덤 : 문제는 풀떄마다 랜덤으로 유형이 바뀐다.</p>
    <p><strong>유형 1:</strong> 뜻을 제시하고, 객관식으로 맞춘다.</p>
    <p><strong>유형 2:</strong> 일부분이 가려진 영단어를 제시하고, 주관식으로 해당 영단어를 맞춘다.</p>
    <h4>제한시간 20초 내에 못 풀면 오답처리한다.</h4>
    <h4>퀴즈를 다풀면 해당 카테고리에 대한 결과를 그래프로 표시한다.</h4>
    <h4>퀴즈를 다풀고 나서 마이페이지에서 확인할 수 있다.</h4>
    <br>
    <h3>문법 퀴즈</h3>
    <h4>문법 문제 유형은 2가지가 있다.</h4>
    <p>랜덤 : 문제는 풀떄마다 랜덤으로 유형이 바뀐다.</p>
    <p><strong>유형 1:</strong> 빈칸이 포함된 문장이 제시되고, 문법에 맞는 단어를 객관식으로 선택해서 맞춘다.</p>
    <p><strong>유형 2:</strong> 뜻이 제시되고, 문법 블록을 클릭 및 조합을 해서 문법 문제를 맞춘다.</p>
    <h4>제한시간 60초 내에 못 풀면 오답처리한다.</h4>
    <h4>퀴즈를 다풀면 해당 카테고리에 대한 결과를 그래프로 표시한다.</h4>
    <h4>퀴즈를 다풀고 나서 마이페이지에서 확인할 수 있다.</h4>
    <br>
    <h3>나만의 영어 단어장</h3>
    <h4>나만의 영어 단어장을 만들수 있다.</h4>
    <h4>나만의 영어 단어장을 썸네일을 정해서 만들수도 있다.</h4>
    <h4>나만의 영어 단어장에 단어 정보를 넣고, 수정도 할 수 있으며 퀴즈로도 공부할 수 있다.</h4>
</div>

<br><br><br><br>

<div align=center><h1>⚙️ 시스템 아키텍처 ⚙️</h1></div>
<div align=center>
    <img src="https://github.com/dks044/WORDWAVE/assets/74749417/40067796-87e4-4e7e-9266-7ab09626567a" alt="시스템아키텍처v1">
    <h4>깃허브 액션 워크플로우 트리거:</h4> main 브랜치에 푸시가 발생할 때마다 워크플로우가 실행됩니다.
    <h4>도커 이미지 빌드 및 도커허브에 푸시:</h4> 어플리케이션을 컨테이너화하기 위해 Dockerfile을 기반으로 도커 이미지를 빌드하고, 이를 도커허브에 푸시합니다.
    <h4>EC2에서의 도커 컨테이너 관리:</h4> EC2 인스턴스에 SSH 접속을 통해 기존에 실행 중이던 도커 컨테이너를 모두 제거하고,<br>새로운 도커 이미지를 풀한 뒤 도커 컴포즈를 이용하여 어플리케이션을 다시 실행합니다.
    <h4>프론트엔드 배포:</h4> 프론트엔드 리액트 프로젝트는 AWS S3에 빌드되어 업로드되며, AWS CloudFront를 통해 전 세계에 배포됩니다.
    <h4>HTTPS 적용:</h4> 전체 시스템은 HTTPS를 통해 보안이 강화된 통신을 제공합니다. 이는 Keystore 설정 및 서버 구성을 통해 이루어집니다.
</div>

<br><br><br><br>

<div align=center><h1>🛠 TECH STACKS 🛠</h1></div>
<div align=center>
  <div align=center>
    <h3>⚙️ Backend ⚙️</h3>
    <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
    <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
    <img alt="Static Badge" src="https://img.shields.io/badge/JPA-grey?style=for-the-badge&logo=databricks&logoSize=auto">
    <img alt="Static Badge" src="https://img.shields.io/badge/SpringSecurity-black?style=for-the-badge&logo=springsecurity&logoColor=white&color=%236DB33F">
    <img alt="Static Badge" src="https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=jsonwebtokens&logoSize=auto">
    <br>
    <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
    <img alt="Static Badge" src="https://img.shields.io/badge/Redis-red?style=for-the-badge&logo=redis&logoColor=white&logoSize=auto">
    <img alt="Static Badge" src="https://img.shields.io/badge/Swagger-green?style=for-the-badge&logo=swagger&logoColor=white&logoSize=auto">
    <br>
      <img alt="Static Badge" src="https://img.shields.io/badge/AWS%20EC2-orange?style=for-the-badge&logo=amazonec2&logoSize=auto">
      <img alt="Static Badge" src="https://img.shields.io/badge/DOCKER-blue?style=for-the-badge&logo=docker&logoSize=auto">
      <img alt="Static Badge" src="https://img.shields.io/badge/GitHub_Actions-black?style=for-the-badge&logo=githubactions&logoColor=white&color=%232088FF">
  </div>
  <br>
  <div align=center>
    <h3>🖌 Frontend 🖌</h3>
    <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black">
    <img alt="Static Badge" src="https://img.shields.io/badge/styled_components-pink?style=for-the-badge&logo=styledcomponents&logoColor=white&color=%23DB7093">
    <img alt="Static Badge" src="https://img.shields.io/badge/Redux-black?style=for-the-badge&logo=redux&logoColor=white&color=%23764ABC">
    <img alt="Static Badge" src="https://img.shields.io/badge/Redux_Saga-black?style=for-the-badge&logo=reduxsaga&logoColor=white&color=%23764ABC">
    <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">
    <br>
    <img alt="Static Badge" src="https://img.shields.io/badge/React_router-black?style=for-the-badge&logo=reactrouter&logoColor=white&color=%23CA4245">
    <img alt="Static Badge" src="https://img.shields.io/badge/Axios-black?style=for-the-badge&logo=axios&logoColor=white&color=%235A29E4">

  </div>
  <br>
  <div align=center>
    <h3>🔧 Tool 🔧</h3>
    <img alt="Static Badge" src="https://img.shields.io/badge/Notion-black?style=for-the-badge&logo=notion&logoColor=white&color=%23000000">
    <img alt="Static Badge" src="https://img.shields.io/badge/Git-black?style=for-the-badge&logo=git&logoColor=white&color=%23F05032">
  </div>
</div>
<br><br><br><br>

<h1 align="center">
  <a href="https://back.wordwave.xyz/swagger-ui/index.html">👉API 명세서👈</a>
</h1>
<br><br><br><br>
<div align=center><h1>🗂️ 파일 구조 🗂️</h1></div>
<div align=center>
    <h3>백엔드</h3>
    <details>
      <summary>자세히</summary>
        <div align=left>
<code>
📦Backend
 ┣ 📂gradle
 ┃ ┗ 📂wrapper
 ┃ ┃ ┣ 📜gradle-wrapper.jar
 ┃ ┃ ┗ 📜gradle-wrapper.properties
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂wordwave
 ┃ ┃ ┃ ┃ ┃ ┣ 📂aws
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜S3Config.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜S3Service.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂emailcode
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EmailAuthenicateDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DataNotFoundException.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂grammar
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Grammar.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GrammarController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GrammarDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GrammarRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GrammarService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂grammarBook
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GrammarBook.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GrammarBookController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GrammarBookDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GrammarBookRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GrammarBookService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂main
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MainController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂myvoca
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyVocaCreateFormDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyVocaDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyVocaResponseDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyVocaUpdateFormDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyVocaUpdateFormRequestDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyVoca.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyVocaController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyVocaRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyVocaService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂myvocabook
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyVocaBookCategoriesDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyVocaBookDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyVocaBookFormDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyVocaBook.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyVocaBookController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyVocaBookRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyVocaBookService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂redis
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RedisConfig.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂security
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CorsConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CustomAuthenticationEntryPoint.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtAuthenticationFilter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SecurityApplication.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SecurityConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TokenInfo.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TokenProvider.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebConfig.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂swagger
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SwaggerConfig.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂userLearnPerformance
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLearnHistoryDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLearnPerformance.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLearnPerformanceController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLearnPerformanceDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserLearnPerformanceRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserLearnPerformanceService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyPageDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SiteUser.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRole.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRoleConverter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂util
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MailDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MailService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ResponseDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UrlParser.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂voca
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂data
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜VocaDataCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜VocaDataTool.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Voca.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜VocaController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜VocaDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜VocaRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜VocaService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂vocabook
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜VocaBook.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜VocaBookController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜VocaBookDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜VocaBookRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜VocaBookService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜WordwaveApplication.java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┣ 📂ssl
 ┃ ┃ ┃ ┣ 📂static
 ┃ ┃ ┃ ┣ 📂templates
 ┃ ┃ ┃ ┃ ┗ 📜mail.html
 ┃ ┃ ┃ ┗ 📜application.properties
 ┃ ┗ 📂test
 ┃ ┃ ┗ 📂java
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂wordwave
 ┃ ┃ ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenRefreshTest.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂emailcode
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EmailCodeTest.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂grammar
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GrammarBookTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GrammarDataTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GrammarTest.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂main
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WordwaveApplicationTests.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂myvoca
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyVocaTest.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂userLearnPerformance
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserLearnPerformanceTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserTest.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂voca
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜VocaBookTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜VocaDataTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜VocaTest.java
 ┣ 📜.classpath
 ┣ 📜.gitignore
 ┣ 📜.project
 ┣ 📜build.gradle
 ┣ 📜Dockerfile
 ┣ 📜gradlew
 ┣ 📜gradlew.bat
 ┗ 📜settings.gradle
</code>
        </div>
    </details>
<br> 
    <div align=center>
    <h3>프론트</h3>
    <details>
      <summary>자세히</summary>
        <div align=left>
<code>
📦Frontend
 ┣ 📂api
 ┃ ┣ 📜authAPI.js
 ┃ ┣ 📜grammarAPI.js
 ┃ ┣ 📜myVocaAPI.js
 ┃ ┣ 📜userLearnPerformanceAPI.js
 ┃ ┗ 📜vocaAPI.js
 ┣ 📂components
 ┃ ┣ 📂grammar
 ┃ ┃ ┣ 📜Grammar.js
 ┃ ┃ ┣ 📜GrammarBook.js
 ┃ ┃ ┗ 📜GrammarBooks.js
 ┃ ┣ 📂myPage
 ┃ ┃ ┣ 📜MyPageComponent.js
 ┃ ┃ ┗ 📜MyPageUserLearnPerformance.js
 ┃ ┣ 📂myVoca
 ┃ ┃ ┣ 📜MyVoca.js
 ┃ ┃ ┣ 📜MyVocaBook.js
 ┃ ┃ ┣ 📜MyVocaBookForm.js
 ┃ ┃ ┣ 📜MyVocaBooks.js
 ┃ ┃ ┣ 📜MyVocaBookUpdateForm.js
 ┃ ┃ ┣ 📜MyVocaForm.js
 ┃ ┃ ┗ 📜MyVocaUpdateForm.js
 ┃ ┣ 📂voca
 ┃ ┃ ┣ 📜Voca.js
 ┃ ┃ ┣ 📜VocaBook.js
 ┃ ┃ ┗ 📜VocaBooks.js
 ┃ ┣ 📜CircleSpinner.js
 ┃ ┣ 📜DialMenu.js
 ┃ ┣ 📜IsNotData.js
 ┃ ┣ 📜LoginForm.js
 ┃ ┣ 📜NavComponent.js
 ┃ ┣ 📜SignUpForm.js
 ┃ ┣ 📜SimplePieChart.js
 ┃ ┣ 📜ToastComponent.js
 ┃ ┗ 📜WaveEffect.js
 ┣ 📂containers
 ┃ ┣ 📂grammar
 ┃ ┃ ┣ 📜GrammarBookContainer.js
 ┃ ┃ ┣ 📜GrammarBooksContainer.js
 ┃ ┃ ┗ 📜GrammarContainer.js
 ┃ ┣ 📂myPage
 ┃ ┃ ┣ 📜MyPageContainer.js
 ┃ ┃ ┗ 📜MyPageUserLearnPerformanceContainer.js
 ┃ ┣ 📂myVoca
 ┃ ┃ ┣ 📜MyVocaBookContainer.js
 ┃ ┃ ┣ 📜MyVocaBookFormContainer.js
 ┃ ┃ ┣ 📜MyVocaBooksContainer.js
 ┃ ┃ ┣ 📜MyVocaBookUpdateFormContainer.js
 ┃ ┃ ┣ 📜MyVocaContainer.js
 ┃ ┃ ┣ 📜MyVocaFormContainer.js
 ┃ ┃ ┗ 📜MyVocaUpdateFormContainer.js
 ┃ ┣ 📂voca
 ┃ ┃ ┣ 📜VocaBookContainer.js
 ┃ ┃ ┣ 📜VocaBooksContainer.js
 ┃ ┃ ┗ 📜VocaContainer.js
 ┃ ┣ 📜HeaderContainer.js
 ┃ ┣ 📜LayoutContainer.js
 ┃ ┣ 📜LoginContainer.js
 ┃ ┗ 📜SignUpContainer.js
 ┣ 📂lib
 ┃ ┣ 📜asyncUtils.js
 ┃ ┗ 📜SimpleDateText.js
 ┣ 📂modules
 ┃ ┣ 📂grammar
 ┃ ┃ ┣ 📜grammar.js
 ┃ ┃ ┣ 📜grammarBook.js
 ┃ ┃ ┣ 📜grammarBookSaga.js
 ┃ ┃ ┗ 📜grammarSaga.js
 ┃ ┣ 📂myVoca
 ┃ ┃ ┣ 📜myVoca.js
 ┃ ┃ ┣ 📜myVocaBook.js
 ┃ ┃ ┣ 📜myVocaBookSaga.js
 ┃ ┃ ┗ 📜myVocaSaga.js
 ┃ ┣ 📂userLearnPerformance
 ┃ ┃ ┣ 📜userLearnPerformance.js
 ┃ ┃ ┗ 📜userLearnPerformanceSaga.js
 ┃ ┣ 📂voca
 ┃ ┃ ┣ 📜voca.js
 ┃ ┃ ┣ 📜vocaBook.js
 ┃ ┃ ┣ 📜vocaBookSaga.js
 ┃ ┃ ┗ 📜vocaSaga.js
 ┃ ┣ 📜auth.js
 ┃ ┣ 📜popup.js
 ┃ ┣ 📜reducers.js
 ┃ ┗ 📜rootSaga.js
 ┣ 📂pages
 ┃ ┣ 📂grammar
 ┃ ┃ ┣ 📜GrammarBookPage.js
 ┃ ┃ ┣ 📜GrammarBooksPage.js
 ┃ ┃ ┗ 📜GrammarPage.js
 ┃ ┣ 📂myVoca
 ┃ ┃ ┣ 📜MyVocaBookFormPage.js
 ┃ ┃ ┣ 📜MyVocaBookPage.js
 ┃ ┃ ┣ 📜MyVocaBooksPage.js
 ┃ ┃ ┣ 📜MyVocaBookUpdateFormPage.js
 ┃ ┃ ┣ 📜MyVocaFormPage.js
 ┃ ┃ ┣ 📜MyVocaPage.js
 ┃ ┃ ┗ 📜MyVocaUpdateFormPage.js
 ┃ ┣ 📂voca
 ┃ ┃ ┣ 📜VocaBookPage.js
 ┃ ┃ ┣ 📜VocaBooksPage.js
 ┃ ┃ ┗ 📜VocaPage.js
 ┃ ┣ 📜HomePage.js
 ┃ ┣ 📜LoginPage.js
 ┃ ┣ 📜MyPage.js
 ┃ ┣ 📜NotFoundPage.js
 ┃ ┣ 📜SignUpPage.js
 ┃ ┗ 📜VocaBookListPage.js
 ┣ 📂resources
 ┃ ┣ 📜GmarketSansTTFLight.ttf
 ┃ ┗ 📜WAVELOGO.png
 ┣ 📜App.css
 ┣ 📜App.js
 ┣ 📜App.test.js
 ┣ 📜index.css
 ┣ 📜index.js
 ┣ 📜logo.svg
 ┣ 📜reportWebVitals.js
 ┣ 📜setProxy.js
 ┣ 📜setupTests.js
 ┗ 📜test.md
</code>
        </div>
    </details>
</div>
<br>
<div align=center><h1>💾 ERD 💾</h1></div>
<img src="https://github.com/dks044/WORDWAVE/assets/74749417/5aa3487a-c47d-4bc9-9a43-db576e91f5a7" alt="WAVE">
<br>
<div align=center><h1>🖥️ 화면 소개 🖥️</h1></div>
<h2>홈 페이지</h2>
<img width="50%" height="50%" src="https://github.com/dks044/WORDWAVE/assets/74749417/d142430d-cfae-49f7-9557-c67f85e49d83" alt="Home1 (1)">
<img width="50%" height="50%" src="https://github.com/dks044/WORDWAVE/assets/74749417/de6db540-bf67-4f2c-afd7-c46a358febd6" alt="Home1 (2)">
<h2>로그인 페이지</h2>
<img width="50%" height="50%" src="https://github.com/dks044/WORDWAVE/assets/74749417/ecd4f89b-1f53-4476-8833-42a91eb28499" alt="로그인페이지">
<h2>회원가입 페이지</h2>
<img width="50%" height="50%"  src="https://github.com/dks044/WORDWAVE/assets/74749417/cfe8be4b-704a-4724-be47-0b575fc40189" alt="회원가입페이지">
<h2>Grammar 페이지(문법)</h2>
<img width="50%" height="50%"  src="https://github.com/dks044/WORDWAVE/assets/74749417/8a91f8d5-473f-4b4b-a3e4-677a35e3015b" alt="GrammarBooks">
<img width="50%" height="50%" src="https://github.com/dks044/WORDWAVE/assets/74749417/2ccbcc77-47a4-4332-bfea-52fee9d02024" alt="GrammarBook">
<img width="50%" height="50%" src="https://github.com/dks044/WORDWAVE/assets/74749417/184aeb55-e177-47ba-ba31-863ef9abd7b3" alt="Grammar">
<img width="50%" height="50%" src="https://github.com/dks044/WORDWAVE/assets/74749417/82d945e4-655c-414e-8080-df76688897eb" alt="Grammar2">
<h2>Voca 페이지(단어)</h2>
<img width="50%" height="50%" src="https://github.com/dks044/WORDWAVE/assets/74749417/c8e4995e-2ba3-442e-ba23-b7a2c402e1b1" alt="VocaBooks">
<img width="50%" height="50%" src="https://github.com/dks044/WORDWAVE/assets/74749417/682df728-26ea-4584-9c5d-bd4b89fca64f" alt="VocaBook">
<img width="50%" height="50%" src="https://github.com/dks044/WORDWAVE/assets/74749417/c9391485-799e-48e1-bca1-21956092abfe" alt="Voca1">
<img width="50%" height="50%" src="https://github.com/dks044/WORDWAVE/assets/74749417/59e0965a-d1f5-470b-8cf2-18ee54120e92" alt="Voca2">
<img width="50%" height="50%" src="https://github.com/dks044/WORDWAVE/assets/74749417/3b6bac65-593b-46b0-8d65-4e36e80601ac" alt="Grammar2">
<h2>마이 페이지</h2>
<img width="50%" height="50%" src="https://github.com/dks044/WORDWAVE/assets/74749417/14474cf2-8640-4c40-899c-76bb90c8be54" alt="MyPage">
<br><br>

<div align=center>
    <h1>😎 트러블슈팅 😎</h1>
    <a href="https://storm-wormhole-609.notion.site/fc10406a146d436c907531ca4e276e07">백엔드 트러블슈팅</a><br>
    <a href="https://storm-wormhole-609.notion.site/74f729e1799c46b4ac20476c78b3ded1">프론트 트러블슈팅</a><br>
    <a href="https://storm-wormhole-609.notion.site/b64b79f8c9c04ac39881e1c258bf0c1d">보안 트러블슈팅</a><br>
    <a href="https://blog.naver.com/buzz7811/223438977530">[CI/CD] GitHub Actions</a><br>
    <a href="https://blog.naver.com/buzz7811/223433243301">Redis</a>
</div>
<br><br>
<div align=center>
    <h1>🌊 팀원소개 🌊</h1>
    <h2>AJN - 팀장 (풀스택)</h2>
    <h3><a href="https://github.com/dks044">깃허브주소</a></h3>
    <p>전반적인 기능 및 아이디어 기획</p>
    <p>디자인 및 컨셉 기획</p>
    <p>시스템 아키텍처 및 ERD 설계</p>
    <p>전반적인 프론트 레이아웃 디자인 및 구현</p>
    <p>JWT 토큰 인증 방식 구현 (쿠키 저장) </p>
    <p>영어 단어 퀴즈 로직 구현</p>
    <p>영어 문법 퀴즈 로직 구현(버전2)</p>
    <p>사용자 학습이력 저장 및 조회 기능 구현</p>
    <p>GitHub Actions를 활용한 CI|CD 환경 구축 </p>
    <p>보안서버 SSL 설치를 통해 프론트, 백엔드 서버를 HTTPS 전환</p>
    <p>나만의 영어 단어장 생성, 수정, 퀴즈 기능 구현</p>
    <br>
    <h2>JJY - (풀스택) (23.11.15 ~ 24.2.24)</h2>
    <h3><a href="https://github.com/ddolboghi">깃허브주소</a></h3>
    <p>전반적인 보안, 성능 취약점 검사</p>
    <p>개발에 필요한 기술스택들 기술 문서들 정리</p>
    <p>팀 프로젝트 스토리보드 운영(노션)</p>
    <p>영어 문법 퀴즈(버전1)</p>
</div>
