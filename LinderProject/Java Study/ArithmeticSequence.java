
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack; // stack의 push pop을 사용 가능하게 함


public class helloworld{

    public static void main(String[] args) throws IOException { //커맨드 라인 실행
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // butteredReader 문자 입력스트림으로부터 문자를 읽어들이거나 출력스트림으로 문자를 내보낼때
        // InputStreamReader 바이트 스트림에서 문자스트림으로
        // 애초에 ButteredReader을 사용하기 위한 선언이다.

        int commandNum = Integer.parseInt(br.readLine()); //입력 들어온것을 int형으로 변환시켜준다.
        int[] command = new int[commandNum]; //int형 배열로 바꿔주고.. commandNum은 입력받을 값이다.
        	for (int i = 0; i < commandNum; i++) { // 들어온 개수만큼
            command[i] = Integer.parseInt(br.readLine()); //입력해서.. 정수형으로 변환 후에 command배열에 넣는다.
            //애초에 command배열의 commandNum개수만큼 넣어준다.
        }
        init(command); //stack 구현함수
        br.close(); //마지막에는 무조건 써줘야하는듯.
    }

    private static void init(int[] command) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;                        //num을 1씩 증가시키면서 temp(command입력값)와 비교하면서 push, pop한다.
        int size = command.length;
        StringBuilder sb = new StringBuilder(); //string과 마찬가지로 문자열을 담는 역활을 한다. 하지만 차이점이 있음. -> 문자열 수정가능
        for (int i = 0; i < size; i++) {
            int temp = command[i];
            while (true) {
                if (num < temp) {            //입력값이 작으면 num을 1증가시키고 스택에 넣는다.
                    sb.append("+\n");
                    stack.push(++num);
                    /*

                     * 8 4 3 6 8 7 5 2 1
                     * 8 입력
                     * 갯수만큼 입력
                     * 배열이 들어오고
                     * 스택 준비
                     * 배열크기 보고 큭만큼 command는 이미 들어있는 배열의 내용
                     * command 배열 0 일때 4 그리고 temp는 0
                     * i가 0일때 command[0] 그리고 temp에 넣으니까 temp = 4
                     * num은 0이잖아 그러니까 num이 4보다 작을떄까지 늘어난다.
                     * 그리고 sb(StringBuilder은 문자열을 받는건데, append를통햇 sb의 문자열을 계속 늘려준다.
                     * 그리고 stack arraylist 배열에 num을 증가시키며 push를 해준다. 그러면 num은 1 2 3 4 가 들어가지
                     * num++이 아니고 ++num이니까
                     * 그리고 이제 num과 temp가 같아지면
                     * 아래 else if 문으로 이동, 안에서 if 문으로 구별
                     * stack이 비어있거나, temp의 숫자가 stack의 꼭대기 숫자와 같지않다면,
                     * (꺼내려고 하는값과 스택의 top에 있는 값과 같은지를 비교한다.) - top에 있는거랑 같으면 중복인거니까
                     * NO가 출력이된다.
                     * 위와같은 에러가 없으면, (4에 도달시)
                     * -를 출력하고 stack에서 제일 위의 숫자를 꺼낸다. (4)
                     * 그리고 break니까 while문을 빠져나온다.
                     * 그리고 i=1 이고,
                     *
                     * * 1이되고,  command[1] = 3
                     * num < temp    4 < 3 이므로 if else로 가서.. 첫번쨰는 해당안되므로 -가 출력되고, pop되서
                     * 다음 2가 빠져나간다.
                     * 그리고 6이 들어간다.
                     * i = 2  temp = command[2] = 6
                     * 4 < 6 이므로 append, push... 이런식으로 반복된다.
                     * */

                } else if (num >= temp) {    //입력값(temp)이 num보다 같거나 작아진다는 것 = 스택에 temp값이 존재하는것 = 그 값을 빼서 수열을 만들수 있음.
                    if (stack.isEmpty() || temp != stack.peek()) {   //스택이 비었거나, 꺼내려고하는 값과 스택의 top에 있는 값과 같은지 비교
                        System.out.println("NO");
                        return;
                    } else {
                        sb.append("-\n");
                        stack.pop();        //입력값(temp)이 num보다 같거나 작아지면 스택에 있는 값을 꺼내서 수열을 만들 수 있다.
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
