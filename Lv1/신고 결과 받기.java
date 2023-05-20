import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; // id_list의 길이만큼 할당
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>(); // 인덱스로 사용하기 위한 map
        
        // id_list의 값들로 map 초기화
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            idxMap.put(name, i);
        }
        
        // 신고 결과를 split을 통해 구분하여 map에 추가
        for (String s: report) {
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            map.get(to).add(from);
        }
        
        // 신고를 당한 횟수가 k번 이상인 경우 answer에 추가
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);
            if (send.size() >= k) {
                for (String name: send) {
                    answer[idxMap.get(name)]++;
                }
            }
        }
        
        return answer;
    }
}