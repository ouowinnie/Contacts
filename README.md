# 😏Contacts (연락처 앱)
#### 리사이클러뷰로 제작된 연락처 앱
#### [blog] 🔗 <https://velog.io/@ouowinnie/contactsApp>

<div><h3>✔ 별 아이콘 클릭 시 즐겨찾기 토글, 전화번호 클릭 시 해당 번호로 전화발신 구현</h3></div>

![230830_01](https://github.com/ouowinnie/Contacts/assets/139089298/5575b557-6d46-449d-84a8-5527d191a729)

<br>

- 메인 화면에는 RecyclerView 하나만 표시
- 연락처 아이템 레이아웃에는 사진, 이름, 전화번호를 표시하는 뷰
- 연락처 클래스: 사진, 이름, 전화번호, 즐겨찾는여부 필드
- 연락처 더미 데이터를 생성 
- 어댑터 클래스: RecyclerView.Adapter를 확장
- 연락처 데이터를 바인딩하는 로직이 포함 → ViewBinding 활용
- 데이터모델의 즐겨찾기 여부에 따라 viewType을 나눠 표시
- 메인 활동에서 RecyclerView를 어댑터와 연결하고, 더미 데이터를 로드하여 표시