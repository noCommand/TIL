FormUrlEncoded
form-encoded 데이터로 전송


## 기본 순서
 - gradle 추가
 - interface 생성
  - interface는 get에 대한 호출을 interface로 정의한 것이다. Post인 경우에는 get대신 post를 써주면 된다.
  - get의 옆의 주소 url은 base 주소와의 결합 형태로 생각하면 된다.
    - 만약 base의 주소가 "http://fdf.fd/post/1111" 이라고 한다면
    이 함수에 해당되는 주소는 http://fdf.fd/post/test가 된다. (@GET("test"))이므로

            public interface testInterface{

            @GET("test")
           Call<TestItem> getInfo(@Query("limit") int limit,
                              @Query("query") String query);
}


출처: http://yujuwon.tistory.com/entry/retrofit-적용하기 [Ju Factory]

- 수신될 json 포멧에 맞추어 item 객체를 정의한다.(Model)


    {"data": [{"column1" : "1"}, {"column2" : "2"}]}
    JSON 포멧이 이렇다면  

    public class TestItem {
      @SerializedName("data")
      public List<DataList> mDatalist;
    }

    public class DataList {
      @SerializedName("column1")
      private String column1 = "";

      @SerializedName("column2")
      private String column2 = "";
    }    

그리고 이제 아래와 같이 사용할 수 있다.

    Retrofit client = new Retrofit.Builder().baseUrl("baseurl").addConverterFactory(GsonConverterFactory.create()).build();

    testInterface service = client.create(testInterface.class);
    Call<TestItem> repos = service.getInfo(100, "today");

    repos.enqueue(new Callback<TestItem>() {
    @Override
    public void onResponse(Call<TestItem> call, Response<TestItem> response){
    TestItem item = (TestItem)response.body();
    ....
    }

    @Override
    public void onFailure(Call<TestItem> call, Throwable t) {
    ....
    }
    });


출처: http://yujuwon.tistory.com/entry/retrofit-적용하기 [Ju Factory]








 <hr/>
 - Call
  - retrofit에서 정의한 Http request와 response 한 쌍을 지닌 객체라고 생각하면 된다.
