package co.kr.school.programmers.beginner.lessons.lv1;

import lombok.Builder;
import lombok.Data;

import java.util.*;

public class Lesson_42576 {
    private final String[] participant = {
            "mislav", "stanko", "mislav", "ana"
    };

    private final String[] completion = {
            "stanko", "ana", "mislav"
    };

    public Lesson_42576() {
        Solution solution = new Solution(participant, completion);
    }

    static class Solution {
        public Solution(String[] participant, String[] completion) {
            solution(participant, completion);
        }

        // 내가 푼 정답
//        private String solution(String[] participant, String[] completion) {
//            sortRunnerInfo(participant, completion);
//            return getIncompletion(participant, completion);
//        }
//
//        private void sortRunnerInfo(String[] participants, String[] completions) {
//            Arrays.sort(participants);
//            Arrays.sort(completions);
//        }
//
//        private String getIncompletion(String[] participants, String[] completions) {
//            String inCompletion = "";
//
//            for (int index = 0; index < participants.length; ++index) {
//                if (index == completions.length) {
//                    inCompletion = participants[index];
//                    break;
//                }
//
//                if (!participants[index].equals(completions[index])) {
//                    inCompletion = participants[index];
//                    break;
//                }
//            }
//
//            return inCompletion;
//        }

        // 보다좋은 다른 답안
        private String solution(String[] participant, String[] completion) {
            String answer = "";

            HashMap<String, Integer> hm = new HashMap<>();
            for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
            for (String player : completion) hm.put(player, hm.get(player) - 1);

            for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                if (entry.getValue() != 0){
                    answer = entry.getKey();
                    break;
                }
            }

            return answer;
        }
    }
}
