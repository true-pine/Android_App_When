# 언제쿨도냐 - 리그오브레전드 챔피언 궁극기 및 소환사주문 재사용대기시간을 확인하는 어플
![previewImage](https://github.com/true-pine/Android_App_When/blob/master/docs/preview.webp)
### 1. 개발배경  
게임의 승패에 영향을 많이 주는 영웅의 궁극기와 상대방의 소환사 주문을 체크하여 게임의 승리에 도움이 되는 어플이 없을까? 라는 생각에서 개발
### 2. 주요기능  
- 리그오브레전드의 영웅 선택시 궁극기 이미지 표시
- 상대방의 소환사 주문 선택 가능
- 재사용대기시간에 영향을 미치는 요소 적용 및 수정 가능
- 전체 세팅 초기화 및 전적검색 사이트 연동
### 3. 핵심기술  
- 챔피언 선택 Activity와 메인 Activity 간의 데이터 전달을 통해 view에 올바른 값을 적용
- Adapter의 Filter를 적용하여 RecyclerView Item 검색(초성 검색도 적용)
### 4. 배운 점  
- Activity간의 데이터 전달
- RecyclerView, Adapter, ViewHolder를 통한 item 출력
- Custom Layout을 Dialog에 적용시킨 Custom Dialog 적용
- Activity의 Width와 Height를 수정하여 다이얼로그화하여 적용
