import java.util.*;
import java.util.stream.LongStream;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int win = 0;
        for (int lotto: lottos) {
            if (lotto == 0) {
                cnt++;
                continue;
            }
            for (int win_num: win_nums) {
                if (win_num == lotto) {
                    win++;
                    break;
                }
            }
        }
        return new int[]{7-Math.max(win+cnt, 1), 7-Math.max(win, 1)};
    }

    public int[] 람다를사용한코드(int[] lottos, int[] win_nums) {
        return LongStream.of(
            (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(win_nums).anyMatch(w -> w == l) || l == 0).count(),
            (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(win_nums).anyMatch(w -> w == l)).count()
        ).mapToInt(op -> (int) (op > 6 ? op - 1 : op)).toArray();
    }

    public int[] 테스트14틀림(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int win = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                cnt++;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    win++;
                }
            }
        }
        answer[0] = 7 - (win + cnt);
        if (7 - win < 6) {
            answer[1] = 7 - win;
        } else {
            answer[1] = 6;
        }
        return answer;
    }
}

/*
 * 다른 사람들이 작성한 코드와 내 코드를 비교하니 반성을 많이 하게됨
 * 자바 공부 열심히 하기
 */