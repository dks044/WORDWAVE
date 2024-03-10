# WORDWAVE (구현중)

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

# 프론트

![Untitled][https://camo.githubusercontent.com/5e7e215d9ff3a7c2e96d09232c11b2205565c841d1129dd2185ebd967284121f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f68746d6c352d2532334533344632362e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d68746d6c35266c6f676f436f6c6f723d7768697465](https://camo.githubusercontent.com/5e7e215d9ff3a7c2e96d09232c11b2205565c841d1129dd2185ebd967284121f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f68746d6c352d2532334533344632362e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d68746d6c35266c6f676f436f6c6f723d7768697465)

![Untitled][https://camo.githubusercontent.com/6531a4161596e3d9fdab3d0499a7b7ce5c5c8b568be219f3e9707af042e575d2/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f637373332d2532333135373242362e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d63737333266c6f676f436f6c6f723d7768697465](https://camo.githubusercontent.com/6531a4161596e3d9fdab3d0499a7b7ce5c5c8b568be219f3e9707af042e575d2/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f637373332d2532333135373242362e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d63737333266c6f676f436f6c6f723d7768697465)

![Untitled][https://camo.githubusercontent.com/53ec2e58e03ba275d9b3a386abd96a243cf744a1a7121bdf8262fc8ae6ebc335/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176617363726970742d2532333332333333302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6a617661736372697074266c6f676f436f6c6f723d253233463744463145](https://camo.githubusercontent.com/53ec2e58e03ba275d9b3a386abd96a243cf744a1a7121bdf8262fc8ae6ebc335/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176617363726970742d2532333332333333302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6a617661736372697074266c6f676f436f6c6f723d253233463744463145)

![Untitled][https://camo.githubusercontent.com/3babc94d778f96441b3a66615fb5ee88c6ed04f174ed49b04df92b071a7d0e80/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f72656163742d2532333230323332612e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d7265616374266c6f676f436f6c6f723d253233363144414642](https://camo.githubusercontent.com/3babc94d778f96441b3a66615fb5ee88c6ed04f174ed49b04df92b071a7d0e80/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f72656163742d2532333230323332612e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d7265616374266c6f676f436f6c6f723d253233363144414642)

![Untitled][https://camo.githubusercontent.com/4da1605c9c424c73f102b2be0a900d8fc55083441b2eda9964e9307770032fa3/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f5374796c6564636f6d706f6e656e742d4442373039333f7374796c653d666f722d7468652d6261646765266c6f676f3d7374796c6564636f6d706f6e656e7473266c6f676f436f6c6f723d7768697465](https://camo.githubusercontent.com/4da1605c9c424c73f102b2be0a900d8fc55083441b2eda9964e9307770032fa3/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f5374796c6564636f6d706f6e656e742d4442373039333f7374796c653d666f722d7468652d6261646765266c6f676f3d7374796c6564636f6d706f6e656e7473266c6f676f436f6c6f723d7768697465)

![Untitled][icons8-redux-an-open-source-javascript-library-for-managing-application-state-96.png](WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/icons8-redux-an-open-source-javascript-library-for-managing-application-state-96.png)

![Untitled][https://camo.githubusercontent.com/eb158764299635e01f05400dde56b7d3e6d1a147612e349dded5c08b8fa042ed/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6178696f732d3541323945343f7374796c653d666f722d7468652d6261646765266c6f676f3d6178696f73266c6f676f436f6c6f723d7768697465](https://camo.githubusercontent.com/eb158764299635e01f05400dde56b7d3e6d1a147612e349dded5c08b8fa042ed/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6178696f732d3541323945343f7374796c653d666f722d7468652d6261646765266c6f676f3d6178696f73266c6f676f436f6c6f723d7768697465)

# 백엔드

![Untitled][https://camo.githubusercontent.com/b0648ef7a9b6980ea27c1caaeb06d5c8503dbb4f9b4d9d7ca1df60a5edc14340/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465](https://camo.githubusercontent.com/b0648ef7a9b6980ea27c1caaeb06d5c8503dbb4f9b4d9d7ca1df60a5edc14340/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465)

![Untitled][https://camo.githubusercontent.com/aac74ca85b21ed1ff4fa88dda8712fce9cddbf786bdf807231e6179f70003ac5/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a57542d626c61636b3f7374796c653d666f722d7468652d6261646765266c6f676f3d4a534f4e253230776562253230746f6b656e73](https://camo.githubusercontent.com/aac74ca85b21ed1ff4fa88dda8712fce9cddbf786bdf807231e6179f70003ac5/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a57542d626c61636b3f7374796c653d666f722d7468652d6261646765266c6f676f3d4a534f4e253230776562253230746f6b656e73)

![Untitled][https://camo.githubusercontent.com/42dd3f9f9345fb4a3e1a24d0483c62ac853b227b6bec314dbd09aa0d9edc9671/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e67626f6f742d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67626f6f74266c6f676f436f6c6f723d7768697465](https://camo.githubusercontent.com/42dd3f9f9345fb4a3e1a24d0483c62ac853b227b6bec314dbd09aa0d9edc9671/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e67626f6f742d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67626f6f74266c6f676f436f6c6f723d7768697465)

![Untitled][https://camo.githubusercontent.com/73e403d49e115d16cfca0f675bd93fad1aaf60b3b2e2cb6938b7aad13abc9b09/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e6773656375726974792d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e677365637572697479266c6f676f436f6c6f723d7768697465](https://camo.githubusercontent.com/73e403d49e115d16cfca0f675bd93fad1aaf60b3b2e2cb6938b7aad13abc9b09/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e6773656375726974792d3644423333463f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e677365637572697479266c6f676f436f6c6f723d7768697465)

![Untitled][https://camo.githubusercontent.com/92e843af63a4c5e2f893e9e1d2ed37f768c5a74315c8af46b16fe8661929266b/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f616d617a6f6e6563322d4646393930303f7374796c653d666f722d7468652d6261646765266c6f676f3d616d617a6f6e656332266c6f676f436f6c6f723d7768697465](https://camo.githubusercontent.com/92e843af63a4c5e2f893e9e1d2ed37f768c5a74315c8af46b16fe8661929266b/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f616d617a6f6e6563322d4646393930303f7374796c653d666f722d7468652d6261646765266c6f676f3d616d617a6f6e656332266c6f676f436f6c6f723d7768697465)

![Untitled][https://camo.githubusercontent.com/d61eb16e74c265915596a84a51d5b50229367ad16915ca42da51f1a021bb3750/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6d7973716c2d3434373941313f7374796c653d666f722d7468652d6261646765266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465](https://camo.githubusercontent.com/d61eb16e74c265915596a84a51d5b50229367ad16915ca42da51f1a021bb3750/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6d7973716c2d3434373941313f7374796c653d666f722d7468652d6261646765266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465)

# 협업

![Untitled](WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/Untitled.png)

![Untitled](WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/Untitled%201.png)

# **📋**트러블슈팅 희고록

## 백엔드

---

### 스프링시큐리티 라이브러리 import를 어떤것을 해야하는가?
(servlet, reactive)

```java
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
```

### 문제

SpringSecrutiy가 버전업이 되면서 기존의 코드들이 레거시코드들이 되거나 deprecated가 되버렸다.

코드 리팩토링중에 어떠한 import문을 써야하는지 헷갈림에 직면했다.

우리는 Spring+React 프로젝트이다, 어떤것을 써야할까?

### 해결

1. **서블릿 기반의 스프링 MVC와 `org.springframework.boot.autoconfigure.security.servlet.PathRequest` 사용:**
    - 기존에 서블릿 기반의 스프링 MVC를 사용하고 있거나, 향후에도 서블릿 기반의 애플리케이션을 계속 사용할 계획이 있다면 이를 선택할 수 있습니다.
    - 이 경우에는 **`org.springframework.boot.autoconfigure.security.servlet.PathRequest`**를 사용하여 경로 요청에 대한 보안 구성을 지원할 수 있습니다.
2. **WebFlux와 `org.springframework.boot.autoconfigure.security.reactive.PathRequest` 사용:**
    - React와 함께 비동기 및 Reactive한 프로그래밍 스타일을 사용하려는 경우, 혹은 향후에도 리액티브한 방식으로 개발하고자 하는 경우에는 WebFlux와 해당 패키지를 사용하는 것이 좋습니다.
    - **`org.springframework.boot.autoconfigure.security.reactive.PathRequest`**는 Reactive 스타일의 애플리케이션과 함께 사용됩니다.

> 따라서 프로젝트의 성격과 향후 개발 방향을 고려하여 두 가지 중 하나를 선택하면 됩니다.
만약 새로운 프로젝트를 시작하는 경우에는 React와의 통합을 고려하여 WebFlux와 **`org.springframework.boot.autoconfigure.security.reactive.PathRequest`**를 선택하는 것이 더욱 적합할 것입니다.
> 

### 스프링 시큐리티 관련 기능 구현중에 꼭 알아야할것!

스프링 시큐리티 config를 작성하기 전 알고 넘어가야하는 것이 있다.

Spring Security 5.7 이후부터 @Bean으로 SecurityFilterChain을 구현해서 시큐리티를 적용시키는 방법을 권장하기 때문에 필터체인 구성을 extends로 하는 이전방식을 사용하지 않고 빈등록 방식으로 코드를 작성했다.

### **JSON 변환 과정에서의 순환 참조 문제 해결
(양뱡향참조-무한루프 문제)**

## **Jackson**

<aside>
💡 JSON (JavaScript Object Notation) 데이터를 Java 객체로 변환하거나,
그 반대로 Java 객체를 JSON 데이터로 변환하는 작업을 수행하는 라이브러리입니다.
이런 변환 작업을 **'직렬화(Serialization)'**와 '**역직렬화**(Deserialization)'라고 합니다.

</aside>

**직렬화:**

Java 객체를 JSON 형태의 문자열로 변환하는 작업. 이는 RESTful API에서 응답 데이터를 생성할 때 주로 사용됩니다.

**역직렬화:**

JSON 형태의 문자열을 Java 객체로 변환하는 작업. 이는 API에서 요청 데이터를 받아 처리할 때 주로 사용됩니다.

**데이터 바인딩:**

JSON을 Java 객체로 변환하거나 그 반대의 작업을 수행할 때, 어떤 JSON 필드가 어떤 Java 객체의 어떤 필드와 연결되는지를 정의합니다.

**어노테이션:**

Jackson은 다양한 어노테이션을 제공하여, 직렬화/역직렬화 과정에서의 세부적인 동작을 제어할 수 있게 합니다.

예를 들어, `@JsonIgnore` 어노테이션은 특정 필드를 직렬화 과정에서 무시하도록 지시할 수 있습니다.

**프리티 프린트:**

JSON 데이터를 읽기 좋은 형태로 출력하는 기능입니다.

> Jackson에 대해서 궁금하다면 위에 정보를 보자.
> 

### 문제

양방향 연관 관계를 가지는 엔티티 클래스들이 JSON으로 변환되는 과정에서 각각이 서로를 참조하면서 무한루프가 발생했음

### 해결

```java
@Entity
@Getter
public class VocaBook {
    // ...
    @OneToMany(mappedBy = "vocaBook")
    @JsonManagedReference // 추가
    private List<Voca> vocas = new ArrayList<>();
    // ...
}

@Entity
@Getter
@NoArgsConstructor
public class Voca {
    // ...
    @ManyToOne
    @JsonBackReference // 추가
    private VocaBook vocaBook;
    // ...
}
```

**`@JsonManagedReference`, `@JsonBackReference`, `@JsonIdentityInfo` 등의 어노테이션을 사용하여 순환 참조 문제를 해결했음**

`@JsonManagedReference`는 순환 참조의 '부모' 쪽에 두고, `@JsonBackReference`는 '자식' 쪽에 둡니다.

이렇게 하면, `VocaBook`을 JSON으로 변환할 때 `Voca` 리스트가 포함되지만, 각 `Voca`는 다시 `VocaBook`을 참조하지 않게 됩니다. 이로써 무한루프 문제를 해결할 수 있습니다.

이 외에도 `@JsonIdentityInfo` 어노테이션을 사용하여 순환 참조 문제를 해결할 수 있습니다. 이 어노테이션은 엔티티의 ID를 이용하여 순환 참조를 방지합니다.

### LazyInitializationException - JJY

### 오류 발견

아래 코드를 테스트하던 중 LazyInitializationException이 발생했습니다.

```java
public GrammarBookResponseDto getUserWrongGrammarBook(String userName, String grammarBookName) {
    Long userId = getUserIdByUserName(userName);
    List<UserGrammarStatus> userGrammarStatuses = this.userGrammarStatusRepository.findByUserId(userId);
    Long grammarBookId = this.grammarBookService.getGrammarBookIdByGrammarBookName(grammarBookName);

    List<GrammarDto> grammarDtos = new ArrayList<>();
    for (UserGrammarStatus userGrammarStatus : userGrammarStatuses) {
        if (userGrammarStatus.getGrammarBookId() != null && userGrammarStatus.getGrammarBookId().equals(grammarBookId)) {
            grammarDtos.add(this.grammarService.getGrammar(userGrammarStatus.getWrongGrammarId()));
        }
    }
    return GrammarBookResponseDto.builder()
            .id(grammarBookId)
            .name(grammarBookName)
            .grammars(grammarDtos)
            .build();
}
```

오류 로그는 다음과 같습니다.

```
org.hibernate.LazyInitializationException: could not initialize proxy [com.wordwave.grammarbook.GrammarBook#14] - no Session
	at org.hibernate.proxy.AbstractLazyInitializer.initialize(AbstractLazyInitializer.java:164)
	at org.hibernate.proxy.AbstractLazyInitializer.getImplementation(AbstractLazyInitializer.java:310)
	at org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor.intercept(ByteBuddyInterceptor.java:44)
	at org.hibernate.proxy.ProxyConfiguration$InterceptorDispatcher.intercept(ProxyConfiguration.java:102)
	at com.wordwave.grammarbook.GrammarBook$HibernateProxy$a5pHvLS3.getName(Unknown Source)
	at com.wordwave.grammar.GrammarService.getGrammar(GrammarService.java:29)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:713)
	at com.wordwave.grammar.GrammarService$$SpringCGLIB$$0.getGrammar(<generated>)
	at com.wordwave.grammar.UserGrammarStatusService.getUserWrongGrammarBook(UserGrammarStatusService.java:63)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:713)
	at com.wordwave.grammar.UserGrammarStatusService$$SpringCGLIB$$0.getUserWrongGrammarBook(<generated>)
	at com.wordwave.grammar.UserGrammarStatusServiceTest.getUserWrongGrammarBookTest(UserGrammarStatusServiceTest.java:46)
	...
```

### 오류 원인

`org.hibernate.LazyInitializationException`은 준영속 상태의 프록시를 초기화하면 발생합니다.

> 준영속(detached) 상태란, 엔티티 객체가 영속성 컨텍스트에 있다가 분리된 상태입니다. 준영속 상태의 엔티티 객체는 영속성 컨텍스트의 기능을 사용할 수 없습니다.
> 

> 프록시 초기화란, 영속 상태의 프록시 객체의 메서드를 이용하려 할때 프록시 객체가 영속성 컨텍스트에 요청해 실제 엔티티 객체를 데이터베이스에서 불러와 참조하는 것입니다.
> 

for문 안에서 `getGrammar()`를 여러 번 반복하는 동안, 동일한 GrammarBook과 연관관계를 맺고 있는 여러 Grammar가 존재할 수 있습니다.

만약 `getGrammar()`가 호출되어 GrammarBook에 접근하여 grammarBookName을 가져오기 위해 GrammarBook 프록시 객체를 초기화하고, 필요한 데이터를 가져온뒤 메서드가 종료되었다고 해봅시다. 이때 영속성 컨텍스트에서는 해당 GrammarBook 엔티티 객체와 프록시 객체는 준영속 상태가 되지만, 프록시 객체는 PK값을 갖고 있습니다. 

그 뒤에 또 `getGrammar()`가 호출되고, 해당 Grammar가 이전과 같은 GrammarBook에 접근한다면 JPA는 같은 PK값을 가진 프록시 객체를 먼저 이용하려고 듭니다.

그리고 `getName()`으로 grammarBookName값을 가져오려고 하는데, PK값이 아닌 데이터에 접근하려면 프록시를 초기화해야 합니다. 하지만 이미 이 프록시 객체는 준영속 상태여서 영속성 컨텍스트에 프록시 초기화 요청을 하지 못합니다. 그래서 `org.hibernate.LazyInitializationException`가 발생했다고 생각합니다.

### 오류 해결

문제의 메서드에 `@Transactional`을 붙이면 메서드가 끝날때까지 메서드 실행중 생성되는 영속성 컨텍스트내 엔티티 객체를 제거하지 않습니다.

### **`Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: java.lang.IllegalArgumentException:`**

### 문제

```jsx
@GetMapping("{vocaBookId}")
	public ResponseEntity<?> getVocaBookDetail(@PathVariable long vocaBookId){
		try {
			Map<Long,List<String>> categories = vocaBookService.getCategoriesOfVocaBook(vocaBookId);
			return ResponseEntity.ok().body(categories);
		} catch (Exception e) {	
			e.printStackTrace();
			return ResponseEntity.badRequest().body("VocaBook 불러오기 실패!");
		}
	}
```

```jsx
@Query("select v.category from Voca v where v.vocaBook.id = :vocaBookId")
    List<String> findCategoriesByVocaBookId(@Param("vocaBookId") long vocaBookId);
```

****`@Param` 애너테이션이 올바르게 사용되지 않았을 때 발생하는 오류 였는데,
`@Param` 애너테이션은 메서드의 매개변수를 SQL 쿼리의 파라미터로 바인딩할 때 사용하는데, 이때 매개변수 이름과 `@Param`의 값이 일치해야 합니다.

### 해결

```java
@GetMapping("{vocaBookId}")
	public ResponseEntity<?> getVocaBookDetail(@PathVariable("vocaBookId") long vocaBookId){
		try {
			Map<Long,List<String>> categories = vocaBookService.getCategoriesOfVocaBook(vocaBookId);
			return ResponseEntity.ok().body(categories);
		} catch (Exception e) {	
			e.printStackTrace();
			return ResponseEntity.badRequest().body("VocaBook 불러오기 실패!");
		}
	}
```

위의 코드에서 `@PathVariable("vocaBookId")`는 URL의 `{vocaBookId}` 부분을 `long vocaBookId` 매개변수에 바인딩합니다. 따라서 클라이언트가 `/api/vocabook/1`과 같은 URL로 요청을 보내면, `vocaBookId` 매개변수는 `1`이라는 값을 가지게 됩니다.

따라서, `@PathVariable` 애너테이션에 매개변수의 이름을 명시함으로써 문제가 해결되었습니다. 이제 클라이언트는 `vocaBookId`를 통해 특정 단어장의 세부 정보를 요청할 수 있습니다.

## 프론트

---

### **redux-devtools-extension 의 의존성 충돌 문제**

**참고**

[패키지 의존성 충돌 버전 에러 해결 ERESOLVE unable to resolve dependency tree](https://disco-biscuit.tistory.com/68)

redux-devtools-extension 해당 라이브러리는
redux 패키지랑 호환되는 버전이 **`^3.1.0 || ^4.0.0`** 만 가능하다

### 해결법

pakeage.json에서 redux 버전을 다운그레이드 한다.

여기서 나는 4.0.0로 다운그레이드 했다.

그 이후 터미널에서

**`npm install -force`**

해당 명령어를 입력 후 재설치 했다.

`npm install --save redux-devtools-extension`

### 더 좋은 해결법

<aside>
💡 **Redux Toolkit  을 쓰자
해당 라이브러리에 어차피** redux-devtools-extension 내장됐다.
**`npm install @reduxjs/toolkit`**

</aside>

### 전역 상태관리가 새로고침(Redirect) 해야만 반영 되는 문제

### 문제

로그인중(로그인유지)라는 상태가 전역적으로 유지는 됐지만,

이것이 새로고침을 한번 해줘야 반영이되는 불편함이 생겼다.

### 해결

```jsx
import LayoutContainer from "./containers/LayoutContainer";
import GrammarPage from "./pages/GrammarPage";
import { Navigate, Route, Routes } from "react-router-dom";
import NotFoundPage from "./pages/NotFoundPage";
import HomePage from "./pages/HomePage"
import LoginPage from "./pages/LoginPage";
import { useEffect, useState } from "react";
import { useSelector } from "react-redux";

function App() {
  const [loging,setLoging] = useState(sessionStorage.getItem('isLoging') || '');
  const { isLoging } = useSelector(state=>state.auth);

  useEffect(() => {
    if(isLoging) return setLoging(true);
  }, [loging,isLoging]);

  console.log('is Login : '+sessionStorage.getItem('isLoging'));

  return (
    <Routes>
      <Route path="/" element={<LayoutContainer />}>
        <Route index element={<HomePage />} />
        <Route path="*" element={<NotFoundPage />} />
        <Route path="grammar" element={sessionStorage.getItem('isLoging') ? <GrammarPage /> : <Navigate to="/login" />} />
        <Route path="login" element={sessionStorage.getItem('isLoging') === null || sessionStorage.getItem('isLoging') === "false" ? <LoginPage /> : <Navigate to="/" />} />
        {/* <Route path="grammar" element={isLoging ? <GrammarPage /> : <Navigate to="/login" />} />
        <Route path="login" element={!isLoging ? <LoginPage /> : <Navigate to="/" />} /> */}
      </Route>
    </Routes>
  );
}

export default App;
```

session에 있는 로그인유무 상태 값을 App.js에서 스토어에서 가져온 값에따라
지속적으로 업데이트를 useEffect를 통해 해주었다.

### 적용된 커스텀 폰트가 시스템 폰트가 잠시 로드 되다가, 다시 나오는 문제

### 문제

적용된 커스텀 폰트가 바로 적용되어야 하는데,

리다이렉트 되거나, 다른 컴포넌트가 랜더링 될떄, 잠시 시스템폰트가 로드 되다가,

커스텀 폰트가 나오는 불쾌한 현상이 있었다.

### 해결

```jsx
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <link rel="icon" href="%PUBLIC_URL%/favicon.ico" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="theme-color" content="#000000" />
    <meta
      name="description"
      content="Web site created using create-react-app"
    />
    <link rel="apple-touch-icon" href="%PUBLIC_URL%/apple-icon-57x57.png" />
    <link rel="manifest" href="%PUBLIC_URL%/manifest.json" />
    <link rel="preload" href="./resources/GmarketSansTTFLight.ttf" as="font" type="font/ttf" crossorigin="anonymous">
    <title>WORDWAVE</title>
  </head>
  <body>
    <div id="root"></div>
  </body>
</html>
```

`<link rel="preload" href="./resources/GmarketSansTTFLight.ttf" as="font" type="font/ttf" crossorigin="anonymous">`
해당 코드로 페이지가 로드 되자마자 폰트를 가져오게 했고,

```jsx
const GlobalStyle = createGlobalStyle`
@font-face {
    font-family: 'GmarketSansTTFLight';
    src: url(${GmarketSansTTFLight}) format('truetype');
    font-weight: normal;
    font-style: normal;
    font-display: 'optional';
}
```

`font-display: 'optional';` 

이러한 옵션을 걸어주었다.

<aside>
<img src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24.png" alt="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24.png" width="40px" /> `optional`은 브라우저에게 웹 폰트 로드를 시도하되, 로드가 오래 걸리는 경우 시스템 폰트를 계속 사용하도록 지시합니다. 이 방법은 웹 폰트가 로드되기 전에 시스템 폰트가 보이는 시간을 최소화하므로, 웹 폰트 로딩으로 인한 레이아웃 변경을 방지할 수 있습니다.

</aside>

### 리덕스의 전역 상태관리 매커니즘이 새로고침 되면 초기화 되는 문제

### 문제

로그인중, 로그인한 사용자의 정보를 useSelector에 값을 할당하여 전역적으로 관리할려고 했었다, 이렇게 하면 로그인한 사용자의 정보를 다양한 로직에 활용할려고 했었다.

하지만 처음 실행 할떄는 기능이 잘 수행하지만, 새로고침(리다이렉트) 만 하면

useSelector에 담은 state들이 초기화되는 문제를 겪었다.

### 해결

[Persist state with Redux Persist using Redux Toolkit in React - LogRocket Blog](https://blog.logrocket.com/persist-state-redux-persist-redux-toolkit-react/)

react-persist 라는 영속성을 지원하는 라이브러리를 설치한 후, 해결했다.

```
import React from "react";
import ReactDOM from "react-dom/client";
// import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter } from "react-router-dom";
import { createGlobalStyle } from "styled-components";
import GmarketSansTTFLight from "./resources/GmarketSansTTFLight.ttf";
import WaveEffect from "./components/WaveEffect";
import { configureStore } from "@reduxjs/toolkit";
import rootReducer from "./modules";
import logger from "redux-logger";
import { Provider } from "react-redux";
import 'bootstrap/dist/css/bootstrap.min.css';
import storage from 'redux-persist/lib/storage';
import persistReducer from "redux-persist/es/persistReducer";
import { PersistGate } from "redux-persist/integration/react";
import persistStore from "redux-persist/es/persistStore";

const root = ReactDOM.createRoot(document.getElementById("root"));
const GlobalStyle = createGlobalStyle`
@font-face {
    font-family: 'GmarketSansTTFLight';
    src: url(${GmarketSansTTFLight}) format('truetype');
    font-weight: normal;
    font-style: normal;
    font-display: 'opional';
}

#root {
    font-family: 'GmarketSansTTFLight', sans-serif;
    background: linear-gradient(to right, #89CFF0 0%, #B2FFFF 50%, #89CFF0 100%);
    justify-content: center;
    align-items: center;
    overflow-x: hidden;
    overflow-y: auto;
    position: relative;
}
`;

const persistConfig = {
  key: 'root',
  storage,
};
const persistedReducer = persistReducer(persistConfig, rootReducer);

const store = configureStore({
  reducer: persistedReducer,
  middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(logger)
});

const persistor = persistStore(store);

root.render(
  <BrowserRouter>
    <GlobalStyle />
    <WaveEffect />
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <App />
      </PersistGate>
    </Provider>
  </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
```

<aside>
<img src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24.png" alt="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24.png" width="40px" /> `redux-persist` 라이브러리는 Redux 상태를 브라우저의 로컬 스토리지 또는 세션 스토리지에 영속적으로 저장하기 위해 사용하는 라이브러리입니다.

</aside>

### `persistConfig`

이는 `redux-persist`의 설정 객체입니다. 여기에서 'root'라는 키와 세션 스토리지를 사용하도록 설정하고 있습니다. 키는 스토리지에 저장될 때 사용되는 키를 나타내며, 

`storage`는 사용할 스토리지 유형을 나타냅니다.

### `persistedReducer`

`persistReducer` 함수는 `persistConfig`와 원래의 리듀서 (`rootReducer`)를 인자로 받아서 새로운 리듀서를 생성합니다. 이 리듀서는 원래의 리듀서와 동일한 방식으로 동작하지만, 추가적으로 액션이 디스패치되면 현재 상태를 스토리지에 저장하고, 앱이 시작될 때 스토리지에서 상태를 불러오는 기능을 가집니다.

### `store`

이는 `configureStore` 함수를 사용하여 스토어를 생성합니다. 여기에서는 `persistedReducer`를 리듀서로 사용하고 있습니다. 이렇게 하면 스토어의 상태가 액션을 디스패치할 때마다 자동으로 스토리지에 저장됩니다.

### `persistore`

`persistStore` 함수는 스토어를 인자로 받아서 persistor 객체를 생성합니다. 이 객체는 `PersistGate` 컴포넌트에 필요합니다.

### `PersistGate`

이 컴포넌트는 앱이 시작될 때 스토리지에서 상태를 불러오는 동안 **로딩 화면**을 표시하도록 하는 역할을 합니다. 상태를 불러오는 작업이 완료되면 자식 컴포넌트를 렌더링합니다.  `PersistGate` 

컴포넌트의 `loading` prop에는 상태를 불러오는 동안 표시할 컴포넌트를 지정할 수 있습니다.

### redux-persist 비직렬화 액션 값 오류 - JJY

### 오류 발견

리액트 앱 실행시 콘솔창에 다음과 같은 오류 로그가 나타납니다.

```java
A non-serializable value was detected in an action, in the path: `register`. Value: ƒ register(key) {
    _pStore.dispatch({
      type: _constants__WEBPACK_IMPORTED_MODULE_2__["REGISTER"],
      key: key
    });
  }
```

### 오류 원인

로그만 보면redux는 state, action에 직렬화가 불가능한 값을 전달할 수 없어 발생하는 오류입니다.
하지만 기능은 정상적으로 작동합니다.
더 찾아본 결과, redux-persist의 고유 문제인것 같습니다. 

[non-serializable value error · Issue #988 · rt2zz/redux-persist](https://github.com/rt2zz/redux-persist/issues/988)

persist의 몇가지 액션들에서 발생하는 오류였습니다. redux toolkit 공식 문서에서도 이에 대한 설정을 추가해 놓았습니다.

[Usage Guide | Redux Toolkit](https://redux-toolkit.js.org/usage/usage-guide#use-with-redux-persist)

### 오류 해결

persist의 몇몇 액션들에 대해서 직렬화 체크를 무시하도록 설정하면 됩니다.

configureStore를 다음과 같이 수정합니다.

```jsx
import {
  FLUSH,
  REHYDRATE,
  PAUSE,
  PERSIST,
  PURGE,
  REGISTER,
} from "redux-persist";

...

const store = configureStore({
  reducer: persistedReducer,
  devTools: process.env.NODE_ENV !== "production",
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({
      serializableCheck: {
        ignoredActions: [FLUSH, REHYDRATE, PAUSE, PERSIST, PURGE, REGISTER],
      },
    }).concat(sagaMiddleware, logger),
});
```

### axios 요청 주소 403 에러 문제 - JJY

### 오류 발견

id값으로 grammarbook을 가져오는 axios GET 요청에서 403 에러가 발생했습니다.

```jsx
export const getGrammarBookById = async (id) => {
  const response = await axios.get(`api/grammarbook/${id}`);
  return response.data;
};
```

http://localhost:3000/grammarbooks/api/grammarbook/{id}로 요청을 보내고 있었고, 백엔드에서 열어둔 요청 주소는 http://localhost:3000/api/grammarbook/{id}여서 AxiosError {message: 'Request failed with status code 403', name: 'AxiosError', code: 'ERR_BAD_REQUEST', config: {…}, request: XMLHttpRequest, …}가 발생했습니다.

### 오류 원인

아주 단순한 오류입니다. axios의 요청 주소에 상대경로를 지정했기 때문입니다. 

+ 403 오류 원인은 매우 다양합니다. 이 경우는 잘못된 경로로 요청을 보냈기 때문입니다.

**요청 주소가 `/`로 시작하지 않으면 axios는 현재 페이지에 요청 주소를 붙여서 요청을 날립니다.**

### 오류 해결

요청 주소에 `/`만 붙여주면 정상적으로 작동합니다.

```jsx
export const getGrammarBookById = async (id) => {
  const response = await axios.get(`/api/grammarbook/${id}`);
  return response.data;
};
```

### 클라이언트가 DB에 없는 데이터를 요청하는 문제 - JJY

### 오류 발견

URL 파라미터에서 파싱한 grammarbook의 id로 해당 id를 가진 grammarbook을 요청하는 API가 있었습니다.

```jsx
export const getGrammarBookById = async (id) => {
  const response = await axios.get(`/api/grammarbook/${id}`);
  return response.data;
};
```

백엔드에서 테스트를 하다가 기존에 존재하던 grammarbook을 지우고 새로 생성했습니다.
그래서 리액트가 당연히 새로 생성된 grammarbook의 id로 요청할거라 생각했지만, 이미 삭제된 grammarbook의 id로 요청해 데이터를 받아오지 못했습니다.

### 오류 원인

redux-persist가 상태값을 브라우저 로컬 스토리지에 저장하도록 설정했기 때문이라고 추정합니다.

```jsx
import storage from "redux-persist/lib/storage";
...
const persistConfig = {
  key: "root",
  storage, //로컬 스토리지에 state 저장
};
```

### 오류 해결

grammarbook의 이름은 거의 바뀌지 않을 것이므로 id대신 grammarBookName으로 변경했습니다.

이에따라 URL 파싱을 grammarBookName으로 해오기 위해 라우트도 수정했습니다.

```jsx
export const getGrammarBookById = async (grammarBookName) => {
  const response = await axios.get(`/api/grammarbook/${grammarBookName}`);
  return response.data;
};
```

같은 grammarBookName이 수정된다면 어떻게 될지 살펴볼 필요가 있습니다.

### axios 객체 직렬화 오류 ✨✨

```
A non-serializable value was detected in an action, in the path: `payload.headers`. Value: AxiosHeadersaccess-control-allow-headers: "*"access-control-allow-methods: "*"access-control-allow-origin: "*"cache-control: "no-cache, no-store, max-age=0, must-revalidate"connection: "close"content-encoding: "gzip"content-type: "application/json"date: "Wed, 07 Feb 2024 08:22:42 GMT"expires: "0"pragma: "no-cache"transfer-encoding: "chunked"vary: "Accept-Encoding"x-content-type-options: "nosniff"x-frame-options: "SAMEORIGIN"x-powered-by: "Express"x-xss-protection: "0"clear: (...)concat: (...)constructor: (...)delete: (...)get: (...)getAccept: (...)getAcceptEncoding: (...)getAuthorization: (...)getContentLength: (...)getContentType: (...)getUserAgent: (...)has: (...)hasAccept: (...)hasAcceptEncoding: (...)hasAuthorization: (...)hasContentLength: (...)hasContentType: (...)hasUserAgent: (...)normalize: (...)set: (...)setAccept: (...)setAcceptEncoding: (...)setAuthorization: (...)setContentLength: (...)setContentType: (...)setUserAgent: (...)toJSON: (...)toString: (...)Symbol(Symbol.toStringTag): (...)[[Prototype]]: Object 
Take a look at the logic that dispatched this action:
```

위에서 제시된 오류는 `Axios` 요청의 결과로 받은 `headers` 객체가 `Redux` 상태로 저장되면서 발생하는 것으로 보입니다. `Axios` 요청의 결과 객체는 `data`, `status`, `statusText`, `headers`, `config` 등 여러가지 속성을 가지고 있는데, 그 중 `data`만이 우리가 직접적으로 사용하는 API 응답 결과다.
****

### 해결

```jsx
export async function getVocaBooksAPI() {
  const response = await axios.get('/api/vocabooks');
  return response.data; // data 속성만 반환합니다.
}
```

response에 data객체를 추가했다.

### redux null오류

<aside>
💡 **개발자 실수 : redux 문법 오류**

</aside>

```sql
yield all([call(vocaSaga)]);
  yield all([call(vocaBookSaga)]);
```

rootsaga를

```sql
import createSagaMiddleware from "redux-saga";
import { all, call } from "redux-saga/effects";
import vocaBookSaga from "./voca/vocaBookSaga";
import vocaSaga from "./voca/vocaSaga";

const sagaMiddleware = createSagaMiddleware();

export function* rootSaga() {
  yield all([call(vocaSaga), call(vocaBookSaga)]);
}

export default sagaMiddleware;
```

이 방식으로 수정하니 되었다.

### **cannot update a component ('...') while rendering a different component ('...') - JJY**

`다른 컴포넌트를 랜더링하는 도중에 컴포넌트를 업데이트 할 수 없다`는 경고입니다.

## 보안

---

### CD단계에서 주의점

[[스프링] 배포용 서버에 데이터베이스 Schema 및 Data 초기 설정하기](https://leveloper.tistory.com/38)

- 요약 : 배포 단계에서 Hibernate SQL 보여주는 부분을 none으로 처리한다.

## 메소드내에 매개변수를 들고올떄는..

<aside>
<img src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24%201.png" alt="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24%201.png" width="40px" /> **요약 :** `final`로 선언된 객체는 메소드 내에서 변경되지 않으므로, **예기치 않은 사이드 이펙트(side effect)나 데이터 변조를 방지**할 수 있다.

</aside>

```java
package com.wordwave.user;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
	private UserRepository userRepository;
	
	public SiteUser create(final SiteUser user) {
		if(user == null || user.getUserName() == null) {
			throw new RuntimeException("Invalid arguments");
		}
		final String userName = user.getUserName();
		if(userRepository.existsByUserName(userName)) {
			log.warn("UserName is already exists {}",userName);
			throw new RuntimeException("UserName is already exists");
		}
		
		return userRepository.save(user);
	}
	
}
```

`final` 키워드를 사용하여 메소드의 매개변수를 선언하는 것은, **그 매개변수가 메소드 내에서 변경되지 않도록 하는 것**입니다. 

이는 특히 중요한 객체나 엔티티를 다루는 경우에 유용할 수 있습니다. 왜냐하면, 이런 방식으로 코드를 작성하면, 해당 객체의 상태가 예기치 않게 변경되는 것을 방지할 수 있기 때문입니다.

## CSRF 설정

```java
package com.wordwave;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
	        .csrf().disable()
	        .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
	            .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
	        .headers((headers) -> headers
	                    .addHeaderWriter(new XFrameOptionsHeaderWriter(
	                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
            
        ;
        return http.build();
    }
    

}
```

CI 단계에는, 해당 설정을 비활성화 했으나,

**CD단계에서는 활성화 해야함!**

[Spring Boot 3.1(Spring 6.1) Security Config: 'csrf()' is deprecated and marked for removal](https://velog.io/@letsdev/Spring-Boot-3.1Spring-6.1-Security-Config-csrf-is-deprecated-and-marked-for-removal)

### Spring Security 6.2.0에서 **is deprecated and marked for removal 경고 - JJY**

### 오류 발견

스프링부트 빌드(애플리케이션 실행)시 다음과 같은 경고가 발생합니다.

```
C:\github\WORDWAVE\src\main\java\com\wordwave\security\SecurityConfig.java:35: warning: [removal] cors() in HttpSecurity has been deprecated and marked for removal
        http.cors()
            ^
C:\github\WORDWAVE\src\main\java\com\wordwave\security\SecurityConfig.java:36: warning: [removal] and() in SecurityConfigurerAdapter has been deprecated and marked for removal
            .and()
            ^
  where B,O are type-variables:
    B extends SecurityBuilder<O> declared in class SecurityConfigurerAdapter
    O extends Object declared in class SecurityConfigurerAdapter
C:\github\WORDWAVE\src\main\java\com\wordwave\security\SecurityConfig.java:37: warning: [removal] httpBasic() in HttpSecurity has been deprecated and marked for removal
            .httpBasic().disable()
            ^
C:\github\WORDWAVE\src\main\java\com\wordwave\security\SecurityConfig.java:38: warning: [removal] sessionManagement() in HttpSecurity has been deprecated and marked for removal
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ^
C:\github\WORDWAVE\src\main\java\com\wordwave\security\SecurityConfig.java:39: warning: [removal] and() in SecurityConfigurerAdapter has been deprecated and marked for removal
            .and()
            ^
  where B,O are type-variables:
    B extends SecurityBuilder<O> declared in class SecurityConfigurerAdapter
    O extends Object declared in class SecurityConfigurerAdapter
C:\github\WORDWAVE\src\main\java\com\wordwave\security\SecurityConfig.java:40: warning: [removal] authorizeHttpRequests() in HttpSecurity has been deprecated and marked for removal
            .authorizeHttpRequests()
            ^
Note: Some input files use or override a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
7 warnings
```

### 오류 원인

spring security 6.0이하 버전에서 사용된 메서드들이 6.1이상 버전부터는 deprecated되며 제거 대상이 되었습니다.

이는 6.1버전부터 메서드 체이닝을 지양하고 함수형 프로그래밍을 지향하기 때문입니다. 본래 함수형 방식을 지원했지만 사람들이 잘 안썼다고 합니다.

### 오류 해결

```java
http.cors()
		.and()
		.httpBasic().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeHttpRequests()
		.requestMatchers("/", "/api/**","/h2-console/**").permitAll()
		.requestMatchers(new AntPathRequestMatcher("/**/*.html")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/**/*.css")).permitAll()
		.requestMatchers(new AntPathRequestMatcher("/**/*.js")).permitAll()
		.anyRequest().authenticated();
```

위 코드는 `SecurityConfig` 클래스에 있는 `SecurityFilterChain` 설정의 일부입니다.

위에서 deprecated 부분은 `cors()`, `and()`, `httpBasic()`, `sessionManagement()`, `authorizeHttpRequests()`입니다.

이를 아래와 같이 수정할 수 있습니다.

+resources디렉터리에 있는 이미지들을 못불러와서 requestMatchers에 `"/static/**"`경로를 추가했습니다.

```java
http.cors(AbstractHttpConfigurer::disable)
		.httpBasic(HttpBasicConfigurer::disable)
		.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
		        .requestMatchers("/", "/api/**","/h2-console/**", "/static/**").permitAll()
		        .requestMatchers(new AntPathRequestMatcher("/**/*.html")).permitAll()
		        .requestMatchers(new AntPathRequestMatcher("/**/*.css")).permitAll()
		        .requestMatchers(new AntPathRequestMatcher("/**/*.js")).permitAll()
		        .anyRequest().authenticated());
```

---

### 비슷한 오류 발견

SecurityConfig 클래스에 지정한 `@EnableGlobalMethodSecurity(prePostEnabled = true)`에 아래와 같이 deprecated 경고가 발생합니다.

'org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity' is deprecated

### 오류 해결

`@EnableGlobalMethodSecurity`대신 `@EnableMethodSecurity`를 사용하면 됩니다. 그리고`prePostEnabled = true`를 지정할 필요 없습니다. 왜냐하면 기본값이 true이기 때문입니다.

참고)

[@EnableGlobalMethodSecurity is deprecated in the new spring boot 3.0](https://stackoverflow.com/questions/74910066/enableglobalmethodsecurity-is-deprecated-in-the-new-spring-boot-3-0)

### 효율적인 정적자원 인증 - JJY

[[Spring Security] 정적 자원 ignore하기](https://velog.io/@yevini118/Spring-Security-정적-자원-ignore하기)

위 포스트에서는 **필터를 거치는 `permitAll()`보다 필터를 거치지 않는`ignore()`가 효율적**이라고 합니다. 왜그런지는 공부가 더 필요할 것 같습니다.

일단 아래처럼 적용할 수 있겠습니다. 일부 json과 ico가 frontend/build/에 들어있어 static/** 경로에서 못찾는 오류가 발생해 따로 경로를 추가했습니다.

```java
package com.wordwave.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableMethodSecurity
public class SecurityConfig {
    
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        http
        .csrf(AbstractHttpConfigurer::disable)
        .headers((headers) -> headers
            .addHeaderWriter(new XFrameOptionsHeaderWriter(
                XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)));

        http.cors(AbstractHttpConfigurer::disable)
            .httpBasic(HttpBasicConfigurer::disable)
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                    .requestMatchers("/", "/api/**").permitAll()
                    .anyRequest().authenticated());
        
        http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class);
        
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
                .requestMatchers(new AntPathRequestMatcher("/static/**"))
                .requestMatchers(new AntPathRequestMatcher("/**/*.html"))
                .requestMatchers(new AntPathRequestMatcher("/**/*.css"))
                .requestMatchers(new AntPathRequestMatcher("/**/*.js"))
                .requestMatchers(new AntPathRequestMatcher("/**/*.json"))
                .requestMatchers(new AntPathRequestMatcher("/**/*.ico"));
    }
}
```

## 이유 : 메서닝체이닝 → 함수형문법으로 변경 (성능 시점)

### jwt 메서드 deprecated 경고 - JJY

### 오류 발견

security > TokenProvider.java에서 총 3개의 deprecated 경고를 발견했습니다.

- `signWith`: *'signWith(io.jsonwebtoken.SignatureAlgorithm, java.lang.String)' is deprecated*
- *`parser`: 'parser()' is deprecated*
- `setSigningKey`: *'setSigningKey(java.lang.String)' is deprecated*

### 오류 원인

**문자열 혹은 바이트를 인수로 받는** `signWith`메서드는 안전하지 않은 원시적인 암호 문자열을 키 인수로 사용하기 때문에 deprecated 대상이라고 합니다. `setSigningKey`도 비슷한 이유인 것 같습니다.

### 오류 해결

아래 예시처럼 Key객체를 `signWith`의 인수로 넣어주면 됩니다. 이때, Key 알고리즘은 Key객체를 생성할때 넣어주거나 `signWith`의 두번째 인자로 넣어줘도 됩니다. 

```java
private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
 
return Jwts.builder()
		// header에 들어갈 내용 및 서명을 하기 위한 SECRET_KEY
		// payload에 들어갈 내용
		.signWith(key)
		.setSubject(userEntity.getId()) // sub
		.setIssuer("demo app") // iss
		.setIssuedAt(new Date()) // iat
		.setExpiration(expiryDate) // exp
		.compact();
```

`parser`와 `setSigningKey`는 아래 예시처럼 수정하면 됩니다.

- `parser` → `parserBuilder`로 변경
- `setSigningKey`에 문자열 대신 Key객체 넣기

```java
Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
```

자세한 수정 방법은 아래 포스트를 참고하기 바랍니다.

[jwt signWith deprecated 오류](https://leeeehhjj.tistory.com/61)

[[JWT] Spring Boot 환경에서 JWT(Json Web Token)생성 하기](https://erjuer.tistory.com/87)

[JJWT signWith deprecated 오류해결](https://lenagend.tistory.com/17)

AJN 추가

### **"Authorization"이라는 헤더를 axios의 기본 헤더에 추가하는 이유**

"Authorization"이라는 헤더를 axios의 기본 헤더에 추가하는 이유는, 서버에 요청을 보낼 때마다 해당 요청이 인증된 요청임을 서버에게 알리기 위함입니다.

JWT 토큰을 사용하는 경우, 사용자가 로그인을 하면 서버에서 JWT 토큰을 발급해줍니다. 이 토큰은 사용자의 인증 정보를 담고 있으며, 이를 사용자가 서버에 요청을 보낼 때마다 이 토큰을 요청 헤더에 포함시켜서 보내게 됩니다. 이렇게 하면 서버는 헤더에 포함된 토큰을 확인하여 해당 요청이 유효한 요청인지를 판단하게 됩니다.

"Authorization" 헤더는 이런 인증 토큰을 포함시키기 위한 헤더입니다. 일반적으로 "Bearer {토큰}"과 같은 형태의 값을 가지게 됩니다. 이 값을 axios의 기본 헤더에 추가해두면, axios를 통해 서버에 보내는 모든 요청에 이 헤더가 자동으로 포함되게 됩니다. 이렇게 하면 로그인한 사용자의 모든 요청이 인증된 요청으로 처리될 수 있습니다.

따라서 axios 기본 헤더에 "Authorization"을 추가하는 것은, 로그인한 사용자가 서버에 보내는 요청이 인증된 요청임을 표시하기 위한 것입니다. 이를 통해 서버는 요청을 보낸 클라이언트가 누구인지를 식별하고, 그에 맞는 응답을 보낼 수 있게 됩니다.

### JWT 토큰 저장을 어디에다가 보관하는게 가장 보안이 강할까?

### 공격 종류에 대해서 궁금하다면..

1. XSS 공격
    
    공격자(해커)가 클라이언트 브라우저에 Javascript를 삽입해 실행하는 공격이다. 공격자가 `<input>`을 통해 Javascript를 서버로 전송해 서버에서 스크립트를 실행하거나, url에 Javascript를 적어 클라이언트에서 스크립트 실행이 가능하다면 공격자가 사이트에 스크립트를 삽입해 XSS 공격을 할 수 있다. 이때 공격자는 Javascript를 통해 사이트의 글로벌 변숫값을 가져오거나 그 값을 이용해 사이트인 척 API 콜을 요청할 수도 있다. 다시 말하면 공격자의 코드가 내 사이트의 로직인 척 행동할 수 있다는 거다.
    
2. CSRF 공격
    
    공격자가 다른 사이트에서 우리 사이트의 API 콜을 요청해 실행하는 공격이다. API 콜을 요청할 수 있는 클라이언트 도메인이 누구인지 서버에서 통제하고 있지 않다면 CSRF가 가능한데, 이때 공격자가 클라이언트에 저장된 유저 인증정보를 서버에 보낼 수 있다면, 제대로 로그인한 것처럼 유저의 정보를 변경하거나 유저만 가능한 액션들을 수행할 수 있다. 예를 들어 CSRF에 취약한 은행 사이트가 있다면 로그인한 척 계좌 비밀번호를 바꾸거나 송금을 보낼 수 있는 것이다.
    

<aside>
<img src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24.png" alt="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24.png" width="40px" /> **결론 : 정답은 없다.**
(JWT 토큰 저장 위치에 관한 "가장" 보안적인 방법을 지정하는 것은 어렵습니다. 왜냐하면 선택하는 저장 위치마다 장단점이 있고, 그로 인한 보안 위험도 다르기 때문입니다.)

</aside>

### 1. localStorage에 저장

### 👍 장점

**CSRF 공격에는 안전하다.**

그 이유는 자동으로 request에 담기는 쿠키와는 다르게

js 코드에 의해 헤더에 담기므로 XSS를 뚫지 않는 이상

공격자가 정상적인 사용자인 척 request를 보내기가 어렵다.

### 👎 단점

**XSS에 취약하다.**

공격자가 localStorage에 접근하는 Js 코드 한 줄만 주입하면

localStorage를 공격자가 내 집처럼 드나들 수 있다.

### 2. cookie에 저장

### 👍 장점

**XSS 공격으로부터 localStorage에 비해 안전하다.**

쿠키의 httpOnly 옵션을 사용하면 Js에서 쿠키에 접근 자체가 불가능하다.

그래서 XSS 공격으로 쿠키 정보를 탈취할 수 없다.

(httpOnly 옵션은 서버에서 설정할 수 있음)

하지만 **XSS 공격으로부터 완전히 안전한 것은 아니다.**

httpOnly 옵션으로 쿠키의 내용을 볼 수 없다 해도

js로 request를 보낼 수 있으므로 자동으로 request에 실리는 쿠키의 특성 상

사용자의 컴퓨터에서 요청을 위조할 수 있기 때문.

공격자가 귀찮을 뿐이지 XSS가 뚫린다면 httpOnly cookie도 안전하진 않다.

참고 : ['About XSS Attack' 부분 참고](https://dev.to/cotter/localstorage-vs-cookies-all-you-need-to-know-about-storing-jwt-tokens-securely-in-the-front-end-15id)

### 👎 단점

**CSRF 공격에 취약하다.**

자동으로 http request에 담아서 보내기 때문에

공격자가 request url만 안다면

사용자가 관련 link를 클릭하도록 유도하여 request를 위조하기 쉽다.

## 해결

현재 프로젝트에서는 

쿠키에 저장하는 방식을 채택했고, 브라우저-localStoreage에 탐색을 못하게끔,

httponly옵션을 넣었다.

쿠키방식은 CSRF방식에 취약하니, 배포단계에 CSRF 설정을 허용하도록 하겠다.

### **Jwts.parserBuilder().setSigningKey(JWT_SECRET_KEY).build().parseClaimsJws(token);**

### 문제

어려운 용어가 있어서 코드 분석을 해보았다.

### 해결

<aside>
<img src="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24.png" alt="WORDWAVE%20(%E1%84%80%E1%85%AE%E1%84%92%E1%85%A7%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC)%20da49925431104687ad541e065bb9d7be/FM_24.png" width="40px" /> **'파싱'이란 어떤 데이터를 분석하고 이해하는 과정을 말합니다. 
주어진 데이터를 구조에 따라 분해하고, 그 의미를 해석하는 것이죠.**

</aside>

`Jwts.parserBuilder().setSigningKey(JWT_SECRET_KEY).build().parseClaimsJws(token);`

`Jwts.parserBuilder()`: JWT를 파싱하기 위한 빌더를 생성합니다. **빌더 패턴은 복잡한 객체를 생성할 때 사용하는 디자인 패턴**으로, 빌더를 통해 원하는 설정을 하고 나서 객체를 생성합니다.

`setSigningKey(JWT_SECRET_KEY)`: 파싱할 때 사용할 서명 키를 설정합니다. JWT는 서명 키를 사용하여 토큰이 변조되지 않았음을 검증합니다. 따라서 토큰을 생성할 때 사용한 서명 키와 동일한 키를 사용해야 합니다.

`build()`: 설정이 완료되면 빌더를 통해 JWT 파서를 생성합니다.

`parseClaimsJws(token)`: 생성한 파서를 사용하여 주어진 JWT를 파싱합니다. 파싱 결과로 `Jws<Claims>` 객체가 반환되는데, 이 객체를 통해 토큰의 헤더, 페이로드, 서명을 얻을 수 있습니다.

따라서 이 코드는 주어진 JWT를 서명 키 `JWT_SECRET_KEY`로 검증하고 파싱하는 작업을 수행합니다. 이후 반환된 `Jws<Claims>` 객체를 통해 토큰의 정보를 사용할 수 있습니다.

### JWT 토큰 유효성 검사로직을 상시 실행하는데, 비로그인 사용자에게도 오류창을
띄워서 불편하게 하는 문제를 해결해보자

### App.js

```java
const { isLoging } = useSelector(state => state.auth);

  const dispatch = useDispatch();
  useEffect(()=>{
    if(isLoging) return;
    try {
      dispatch(isLoggedIn());
    } catch (error) {
      console.log('현재 로그인 상태가 아닙니다.');
    }
  },[dispatch,isLoging]);
```

### [백엔드] UserController.java

```java
@PostMapping("/validateToken")
	public ResponseEntity<?> validateToken(
			HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			ResponseDTO responseDTO = ResponseDTO.builder()
					.error("Cookie is empty")
					.build();
			return ResponseEntity.status(404).body(responseDTO);
		}
	    String token = null;
	    for (Cookie cookie : cookies) {
	        if (cookie.getName().equals("token")) {
	            token = cookie.getValue();
	            break;
	        }
	    }
		
	    if (token == null) {
	        ResponseDTO responseDTO = ResponseDTO.builder()
	                .error("Token is empty")
	                .build();
	        return ResponseEntity.status(404).body(responseDTO);
	    }
	    //토큰을 찾았을떄 검사시작
	    try {
			Jwts.parserBuilder().setSigningKey(JWT_SECRET_KEY).build().parseClaimsJws(token);
		} catch (JwtException e) {
			ResponseDTO responseDTO = ResponseDTO.builder()
					.error("Token is invalid")
					.build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	    
	    
		return ResponseEntity.ok().body("validate success");
	}
```

### 문제

로그인한 사용자 (인증된 사용자)만 접속가능하게 하려는 조건부 라우팅을 구현하려했다.

인증 여부를 백엔드에서 API를 만들어 호출한 후,

App.js에서 호출 하고, 그에 대한 유무를 state로 받아서 해당 state 값에 따라
조건부 라우터기능을 구현하려는데,
**로그인된 사용자임에도 불구하고, url 이동이 안됨.**

**비로그인 사용자에게 앱 시작 첫 화면부터 오류 팝업창 출력**

이러한 문제들이 생겼다.

### 해결

```jsx
export const login = (username, password) => async dispatch => {
  dispatch({ type: LOGIN_REQUEST });
  try {
    const response = await authAPI.loginApi(username, password);
    dispatch({ type: LOGIN_SUCCESS, payload: response.data });
    sessionStorage.setItem('isLoging', true);
    return response.data;
  } catch (e) {
    dispatch({ type: LOGIN_FAILURE, error: e });
    throw e;
  }
};
```

스프링에서 중간에 DTO를 만들어서 해결하는것에서 아이디어를 따와서

로그인에 대한 유무만 세션에 저장시켜서

안전도 챙기고, 전역적인 설정(로그인 유지)도 챙겼다.

### 토큰이 유효한지 검증하는 api를 호출했으나, 비로그인 사용자에게도 오류를 호출하는건에 대하여

### 문제

현재 로그인된 사용자의 토큰이 유요한지 검증하는 API 및 액션함수를 디스패치 하는데,

문제는 비로그인 된 사용자는 토큰이 없는데도 불구하고, 해당 사용자에게 까지

오류를 호출시켜서 불편함을 겪었다.

### 해결

```jsx
export const isLoggedIn = () => async dispatch => {
  dispatch({ type : IS_LOGGED_IN });
  try {
    const response = await authAPI.validateTokenApi();
    dispatch({ type : IS_LOGGED_IN_SUCCESS, payload: response.data});
    console.log('validate success');
    return response.data;
  } catch (e) {
    if (e.response && e.response.status === 401) {//비로그인 사용자 예외처리
      dispatch({ type: LOGOUT });
      console.log('비로그인 사용자임(토큰없음)');
    } else {
      dispatch({ type : IS_LOGGED_IN_FAILURE, error: e});
      throw e;
    }
  }
}
```

아예 남아있는 쓰래기값 데이터들을 LOGOUT 액션함수를 디스패치를 통해 없앴고,

진짜 인증되지 않은 사용자에게만 error를 던지도록

if-else문을 사용했다.

### JWT토큰을 쿠키 저장방식을 사용해도 크롬 탭을 닫아도 자동 로그아웃이 되는가
&
크롬탭을 닫고 다시 열었을떄 왜 USER정보만 안나오는가

### 해결

`import storage from 'redux-persist/lib/storage’`
STOREAGE 즉 store 상태값을을 localStoraage로 변경했다.