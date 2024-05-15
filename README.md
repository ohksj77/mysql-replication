# mysql-replication
mysql로 master-slave를 구성해보자

## 아키텍처
- docker-compose
  - backend (springboot)
  - db_master (mysql)
  - db_slave (mysql)

## 실행 방법
```
docker-compose up -d
```

## 실행 결과
- replication 관련 로그
![](https://github.com/ohksj77/mysql-replication/assets/89020004/1a1c53ef-3343-4416-984e-81101931bca7)

## 추가 테스트한 부분
- record 를 통한 dto 활용
  - request body, response body 모두 정상 작동함을 확인
  - ![](https://github.com/ohksj77/mysql-replication/assets/89020004/4718c793-144a-4ef1-89a1-83419011d204)
  - ![](https://github.com/ohksj77/mysql-replication/assets/89020004/bbb4d944-7a01-489c-8405-5d719ff7626c)
- envelop 패턴을 위한 ResponseBodyAdvice 재정의
  - ![](https://github.com/ohksj77/mysql-replication/assets/89020004/faada3e2-0fbc-49f0-a900-983ba3288d5e)
  - ApiResponse<T> 를 통해 envelope 패턴을 구현하고 다음과 같이 컨트롤러에서 명시 안해도 ApiResponse 로 래핑하여 반환됨을 확인함
  - 예제를 따라하느라 제네릭에 Object를 넣어 의미가 없어졌지만, 이후 제네릭스럽게 테스트 해보고자 함
  - @RestControllerAdvice 클래스 내부 메서드의 반환 또한 ApiResponse<T>로 래핑되어 반환됨을 확인함
  - ![](https://github.com/ohksj77/mysql-replication/assets/89020004/5ffe9a46-82ed-4aa6-a130-dad0e70057d6)
- 간단한 cqrs 적용
  - 어노테이션 @Service와 @Transactional를 사용해 readOnly 설정을 조절하며 커스텀 어노테이션을 구성하여 서비스별로 접근하는 db를 다르게 가져감
  - query, command 패키지 분리

## 참고
- 간단한 CRUD 기능만 구현해두었으며, db replica와 추가 테스트한 부분에 집중하여 진행했습니다.
