## Object

java.lang.Object 클래스는
자바의 모든 클래스의 최고 조상 클래스이다.

자바의 모든 오브젝트(배열 객체 포함)는 직간접적으로 Object 클래스의 속성과 메소드를 상속하고 있다.

Object클래스를 반드시 사용해야하는 것은 아니지만
만약 사용해야한다면 작성하고 있는 클래스에서 오버라이딩해야하는 경우가많다.

![](http://cfile4.uf.tistory.com/image/247E3A405850DEBD0A6E5C)


- Object 클래스의 주요 메소드
 + protected Object clone() throws CloneNotSupportedException
 + public boolean equals(Object obj)
 + protected void finalize() throws Throwable
 + public final Class<?> getClass()
 + public int hashCode()
 + public String toString()


출처: http://micropilot.tistory.com/3052 []
