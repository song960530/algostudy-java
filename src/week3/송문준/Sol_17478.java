package week3.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_17478 {
    static final String[] fakeMesssages = new String[]{
            "\"재귀함수가 뭔가요?\"\n"
            , "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
            , "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
            , "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"
    };

    static final String[] realMessages = new String[]{
            "\"재귀함수가 뭔가요?\"\n"
            , "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"
    };

    static final String firstMessage = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    static final String finalMessage = "라고 답변하였지.\n";
    static final String prefix = "____";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rootCnt = Integer.parseInt(br.readLine());
        int childCnt = rootCnt;

        System.out.println(makeMessage(rootCnt, childCnt));
    }

    private static String makeMessage(int rootCnt, int childCnt) {
        StringBuilder sb = new StringBuilder();

        if (rootCnt == childCnt)
            sb.append(firstMessage);

        if (childCnt != 0) {
            for (String message : fakeMesssages) {
                for (int i = rootCnt; i > childCnt; i--) {
                    sb.append(prefix);
                }
                sb.append(message);
            }

            sb.append(makeMessage(rootCnt, childCnt - 1));
        } else {
            for (String message : realMessages) {
                for (int i = rootCnt; i > childCnt; i--) {
                    sb.append(prefix);
                }
                sb.append(message);
            }
        }

        for (int i = rootCnt; i > childCnt; i--) {
            sb.append(prefix);
        }

        sb.append(rootCnt == childCnt ? finalMessage.substring(0, finalMessage.lastIndexOf("\n")) : finalMessage);

        return sb.toString();
    }
}
