# Array, ArrayList 둘의 차이

## Array
* 사이즈 - 초기화시 고정
  * int[] myArray = new int[6]
* 속도 - 초기화시 메모리에 할당되어 속도가 빠르다.
* 변경 - 사이즈 변경 불가
* 다차원 - 가능

## ArrayList
  * 초기화 시 사이즈를 표시하지 않음. 유동적
    * ArrayList<Integer> MyArrayList = new ArrayList<>();
  * 속도 - 추가시 메모리를 재할당하여 속도가 느리다.
  * 추가삭제 가능
    * add(), remove()로 가능
  * 다차원 - 불가능


  출처 - http://blog.naver.com/PostView.nhn?blogId=sangrime&logNo=220622445166
