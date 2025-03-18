## 개요

콘솔 기반의 키오스크 프로그램입니다.

### Main
사용자 입력과 아래의 내용 콘솔 출력.


[ SHAKESHACK MENU ]
1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 종료                  | 종료

입력 숫자가 0이면 종료, 나머지 1, 2, 3, 4면 가격을 출력.

--- 

### MenuItem
메뉴를 객체로 관리
⚙️ getter와 ⚙️ toString 메서드로 내용 출력 가능.

---

### Kiosk
MenuItem 객체를 본 클래스에서 리스트로 관리
Main에서 진행되던 사용자 입력을 본 클래스에서 진행.

---

### SocialTypeForDiscount
유공자, 군인 등 신분에 따른 할인정책을 ENUM을 사용해 구현.

---
### Menu
메뉴를 관리하기 위한 리스트 모음


