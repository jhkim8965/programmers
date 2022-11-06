package co.kr.school.programmers.beginner.lessons;

/**********************************************************************************
코딩테스트 입문 - 옹알이
 문제 설명
    머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다. 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 제한사항
     1 ≤ babbling의 길이 ≤ 10
     1 ≤ babbling[i]의 길이 ≤ 30
     문자열은 알파벳 소문자로만 이루어져 있습니다.
 입출력 예
     babbling	                                        result
     ["aya", "yee", "u", "maa"]	                        1
     ["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]	    2
 입출력 예 설명
     입출력 예 #1
        ["aya", "yee", "u", "maa"]에서 발음할 수 있는 것은 "aya"뿐입니다. 따라서 1을 return합니다.
     입출력 예 #2
        ["ayaye", "uuuma", "yeye", "yemawoo", "ayaayaa"]에서 발음할 수 있는 것은 "aya" + "ye" = "ayaye", "ye" + "ma" + "woo" = "yewoo"로 2개입니다. "yeye"는 같은 발음이 연속되므로 발음할 수 없습니다. 따라서 2을 return합니다.
 유의사항
    네 가지를 붙여 만들 수 있는 발음 이외에는 어떤 발음도 할 수 없는 것으로 규정합니다. 예를 들어 "woowo"는 "woo"는 발음할 수 있지만 "wo"를 발음할 수 없기 때문에 할 수 없는 발음입니다.
***********************************************************************************/
public class Lesson_120956 {

    public Lesson_120956() {
        String[] babbling = {"ayaye", "ayayewoomawooma", "yeye", "yemawoo", "ayaayaa"};
        String[] canSpeakWords = {"aya", "ye", "woo", "ma"};

        Solution solution = new Solution(babbling);
    }

    static class Solution {

        public Solution(String[] babbling) {
            solution(babbling);
        }

        public int solution(String[] babbling) {
            int answer = 0;

            if( validate(babbling) )
                answer = getAnswer(babbling);

            System.out.println("가능한 발음 결과 : " + answer);

            return answer;
        }

        private boolean validate(String[] babbling) {

            if( false == validateLengthOfBabbling(babbling) )
                return false;

            if( false == vlaidateLengthOfBabbWords(babbling) )
                return false;

            return true;
        }

        private boolean validateLengthOfBabbling(String[] babbling) {
            int length = babbling.length;
            return 1 <= length && length <= 10;
        }

        private boolean vlaidateLengthOfBabbWords(String[] babbling) {
            for( String words : babbling ) {
                if( false == vlaidateLengthOfBabbWord(words) )
                    return false;
            }

            return true;
        }

        private boolean vlaidateLengthOfBabbWord(String words) {
            int length = words.length();
            return 1 <= length && length <= 30;
        }

        private int getAnswer(String[] babbling) {

            String[] canSpeakWords = {"aya", "ye", "woo", "ma"};
            int result = 0;

            for( String words : babbling ) {

                System.out.println("words = " + words);

                if( isRepeatSpeack(words, canSpeakWords) )
                    continue;

                if( isCanSpeak(words, canSpeakWords) )
                    result++;
            }

            return result;
        }

        private boolean isRepeatSpeack(String words, String[] canSpeakWords) {

            int fromIndex = 0;
            for( String canSpeakWord : canSpeakWords ) {
                int foundIndex = words.indexOf(canSpeakWord, fromIndex);

                if( foundIndex > -1 ) {
                    fromIndex = foundIndex + canSpeakWord.length();

                    int repeatWords = words.indexOf(canSpeakWord, fromIndex);
                    if( repeatWords > -1 &&  fromIndex == repeatWords ) {
                        System.out.println("   연속된 발음은 불가합니다!");
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean isCanSpeak(String words, String[] canSpeakWords) {

            for( String canSpeakWord : canSpeakWords ) {
                int foundIndex = words.indexOf(canSpeakWord);

                if( foundIndex > -1 ) {
                    words = words.replace(canSpeakWord, "");
                }
            }

            if( words.length() == 0 )
                return true;
            else
                return false;
        }
    }
}
