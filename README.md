# WORDWAVE (구현중)
![중간점검](https://github.com/dks044/WORDWAVE/assets/74749417/0cd53517-e5f6-4660-8df9-8e005eeadb75)

# **📅**기간

**기획 및 개인 학습 :** 23. 11. 15 ~ 23. 12. 31 

**구현 단계 :** 24.1.1 ~ 

# **🎯 기획 배경**

## **🖊**영어 공부와 프로그래밍 공부를 동시에 하고싶어서

영어는 ‘세계의 공통어’ 라고 할 정도로, 많이 쓰입니다.

여행을 가서 대화를 통해 외국인 친구를 사귈 수 있고,

해외 개발자와 영어를 사용해서 소통할 수 있고,

또는 채용 시장에서 공인 영어 실력을 증명해서 나만의 경쟁력을 증명할 수 있죠.

## **🏃**협업의 경험 쌓기

저희 팀은 우테코 6기 프리코스에서 만났습니다.

그곳에서 인연이 되어 팀을 결성하고, 프리코스에서 배운 컨벤션들을 적용해서
깔끔한 팀프로젝트를 만들어보기로 했습니다.
우테코 프리코스에서는 CBD, TDD, Git 컨벤션, 도메인 로직 등 협업에 중요한 전략들을 배웠습니다. 배운 것들을 활용해 프로젝트를 만들며 ‘협업에 강한 개발자’가 되고자 시작했습니다.

# **⭐️ 주요 기능**

## 영어 단어 퀴즈

- 단어 문제 유형은 2가지가 있다.
    - 랜덤 : 문제는 풀떄마다 랜덤으로 유형이 바뀐다.
    - 유형 1: 뜻을 제시하고, 객관식으로 맞춘다.
    - 유형 2: 일부분이 가려진 영단어를 제시하고, 주관식으로 해당 영단어를 맞춘다.
- 제한시간 20초 내에 못 풀면 오답처리한다.
- 퀴즈를 다풀면 해당 카테고리에 대한 결과를 그래프로 표시한다.

## 문법 퀴즈

- 문법 문제 유형은 2가지가 있다.
    - 랜덤 : 문제는 풀떄마다 랜덤으로 유형이 바뀐다.
    - 유형 1: 빈칸이 포함된 문장이 제시되고, 문법에 맞는 단어를 객관식으로 선택해서 맞춘다.
    - 유형 2:  뜻이 제시되고, 문법 블록을 클릭 및 조합을 해서 문법 문제를 맞춘다.

## 실시간 영어 단어 배틀

1. 한 채팅방에 2명의 사용자가 접속한다.
2. 서버가 이미지를 제시하고, 2명의 사용자가 해당단어가 무엇인지 채팅으로 정답을 맞춘다.
3. 영단어를 먼저 맞춘 사용자의 점수가 올라가는 방식.

# **🛠️ 기술 스택**
<h1 id="2e12bc84-1a2f-4bf2-83ab-5ba82b4635bd" class="">프론트</h1><div id="b576ee83-2e7b-4c72-838a-c7cbdae8f312" class="column-list"><div id="37bca5c8-3015-459d-8eeb-31e4632166b1" style="width:39.26380368098161%" class="column"></figure><p id="0daa3655-2660-4cc9-8efc-5bd1cba5ec6f" class="">
</p></div></div><p id="70f5024f-3d5b-42a1-9ed1-ddfc6e4efd1c" class="">
</p><h1 id="1db19029-8169-484a-a406-d1719d785688" class="">백엔드</h1><div id="ab988fa2-b1d7-4ce8-b458-0446f716603e" class="column-list"><div id="3ac43af0-7489-4f66-bcdf-8239ca6c67d3" style="width:25%" class="column"><figure id="a283ccef-486b-4063-b66c-05db92c77266" class="image"><a href="https://camo.githubusercontent.com/b0648ef7a9b6980ea27c1caaeb06d5c8503dbb4f9b4d9d7ca1df60a5edc14340/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465"><img src="https://camo.githubusercontent.com/b0648ef7a9b6980ea27c1caaeb06d5c8503dbb4f9b4d9d7ca1df60a5edc14340/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465"/></a></figure><figure id="2d97b466-2fa1-4ba1-b053-3e2b85005e74" class="image"><a href="https://camo.githubusercontent.com/aac74ca85b21ed1ff4fa88dda8712fce9cddbf786bdf807231e6179f70003ac5/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a57542d626c61636b3f7374796c653d666f722d7468652d6261646765266c6f676f3d4a534f4e253230776562253230746f6b656e73"><img src="https://camo.githubusercontent.com/aac74ca85b21ed1ff4fa88dda8712fce9cddbf786bdf807231e6179f70003ac5/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a57542d626c61636b3f7374796c653d666f722d7468652d6261646765266c6f676f3d4a534f4e253230776562253230746f6b656e73"/></a></figure></div><div id="a52e9383-b755-4cee-843b-13687826a2af" style="width:25%" class="column"><figure id="1e05e319-e272-4194-bcf9-4baf6570f82b" class="image"><a href="https://camo.githubusercontent.com/42dd3f9f9345fb4a3e1a24d0483c62ac853b227b6bec314dbd09aa0d9edc9671/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e67626f6f742d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67626f6f74266c6f676f436f6c6f723d7768697465"><img src="https://camo.githubusercontent.com/42dd3f9f9345fb4a3e1a24d0483c62ac853b227b6bec314dbd09aa0d9edc9671/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e67626f6f742d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67626f6f74266c6f676f436f6c6f723d7768697465"/></a></figure><figure id="f6646dbf-3f2c-45fd-a917-cbcee1e99a00" class="image"><a href="https://camo.githubusercontent.com/73e403d49e115d16cfca0f675bd93fad1aaf60b3b2e2cb6938b7aad13abc9b09/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e6773656375726974792d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e677365637572697479266c6f676f436f6c6f723d7768697465"><img src="https://camo.githubusercontent.com/73e403d49e115d16cfca0f675bd93fad1aaf60b3b2e2cb6938b7aad13abc9b09/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e6773656375726974792d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e677365637572697479266c6f676f436f6c6f723d7768697465"/></a></figure></div><div id="0efa4b15-f48a-403c-9c2c-4018483aa49b" style="width:25%" class="column"><figure id="dcd44a8c-3674-468f-8008-a9aa729ad100" class="image"><a href="https://camo.githubusercontent.com/92e843af63a4c5e2f893e9e1d2ed37f768c5a74315c8af46b16fe8661929266b/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f616d617a6f6e6563322d4646393930303f7374796c653d666f722d7468652d6261646765266c6f676f3d616d617a6f6e656332266c6f676f436f6c6f723d7768697465"><img src="https://camo.githubusercontent.com/92e843af63a4c5e2f893e9e1d2ed37f768c5a74315c8af46b16fe8661929266b/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f616d617a6f6e6563322d4646393930303f7374796c653d666f722d7468652d6261646765266c6f676f3d616d617a6f6e656332266c6f676f436f6c6f723d7768697465"/></a></figure></div><div id="5cdcbfd8-8f5f-4a10-9a9f-b72518b405a1" style="width:25%" class="column"><figure id="880f10c0-0f38-4f52-8dd2-25e1d73cfb36" class="image"><a href="https://camo.githubusercontent.com/d61eb16e74c265915596a84a51d5b50229367ad16915ca42da51f1a021bb3750/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6d7973716c2d3434373941313f7374796c653d666f722d7468652d6261646765266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465"><img src="https://camo.githubusercontent.com/d61eb16e74c265915596a84a51d5b50229367ad16915ca42da51f1a021bb3750/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6d7973716c2d3434373941313f7374796c653d666f722d7468652d6261646765266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465"/></a></figure></div></div><p id="0b414c74-8bc9-4a12-8581-95c09070a4e8" class="">
</p><h1 id="b300e9b1-2877-4507-9778-cd3c5205f635" class="">
협업</h1><figure id="50ee365d-70ce-4675-86d2-5ec03ba9574d" class="image" style="text-align:left"><a href="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/Untitled.png"><img style="width:98px" src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/Untitled.png"/></a></figure><figure id="80955660-c81a-4cdb-8024-ae8e6289f897" class="image" style="text-align:left"><a href="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/Untitled%201.png"><img style="width:48px" src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/Untitled%201.png"/></a></figure><p id="5e3cca99-b06a-48d0-99ef-e12f03ff380a" class="">
</p><p id="b4a212da-ac95-40bb-ab31-137ab5ad3793" class="">
</p><p id="b8a512d5-d899-446e-95f9-f86d88f1c1cf" class="">
</p><h1 id="fb832a98-ebfe-4d1e-8ece-82c06665a519" class="">

# **📋**트러블슈팅 희고록

[백엔드 트러블슈팅](https://storm-wormhole-609.notion.site/fc10406a146d436c907531ca4e276e07)   
[프론트 트러블슈팅](https://storm-wormhole-609.notion.site/74f729e1799c46b4ac20476c78b3ded1)   
[보안 트러블슈팅](https://storm-wormhole-609.notion.site/b64b79f8c9c04ac39881e1c258bf0c1d)

# 🌊팀 - 광안리형제들

### AJN - 팀장 (풀스택)

[dks044 - Overview](https://github.com/dks044)

- 전반적인 기능 및 아이디어 기획
- 전반적인 프론트 레이아웃 디자인 및 구현
- 회원로직
    - JWT 토큰 인증방식
- 영어 단어 퀴즈
- 실시간 영어단어 퀴즈

### JJY (풀스택)

[ddolboghi - Overview](https://github.com/ddolboghi)

- 전반적인 보안, 성능 취약점 검사
- 영어 문법 퀴즈
