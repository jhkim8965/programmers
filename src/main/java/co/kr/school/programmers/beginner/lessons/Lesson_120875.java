package co.kr.school.programmers.beginner.lessons;

import java.util.*;

/**********************************************************************************
 코딩테스트 입문 :: 평행
 문제 설명
    점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
    [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
    주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.

 제한사항
     0 ≤ dots의 원소 ≤ 100
     dots의 길이 = 4
     dots의 원소의 길이 = 2
     dots의 원소는 [x, y] 형태이며 x, y는 정수입니다.
     서로 다른 두개 이상의 점이 겹치는 경우는 없습니다.
     두 직선이 겹치는 경우(일치하는 경우)에도 1을 return 해주세요.

 입출력 예
     dots	                                result
     [[1, 4], [9, 2], [3, 8], [10, 4]]	    1
     [[3, 5], [4, 1], [2, 4], [5, 10]]	    0

 입출력 예 설명
     입출력 예 #1
        점 [1, 4], [3, 8]을 잇고 [9, 2], [10, 4]를 이으면 두 선분은 평행합니다.
     입출력 예 #2
         점을 어떻게 연결해도 평행하지 않습니다.

 ※ 공지 - 2022년 9월 30일 제한 사항 및 테스트케이스가 수정되었습니다.
 ***********************************************************************************/
public class Lesson_120875 {

    public Lesson_120875() {

        Solution solution = new Solution();

        int[][] dotsCase1 = {{1, 4}, {9, 2}, {3, 8}, {10, 4}};
        solution.solution(dotsCase1);

        int[][] dotsCase2 = {{3, 5}, {4, 1}, {2, 4}, {5, 10}};
        solution.solution(dotsCase2);
    }

    static class Solution {

        public int solution(int[][] dots) {
            int answer = 0;

            answer = getAnswer(dots);
            System.out.println("answer = " + answer);

            return answer;
        }

        private int getAnswer(int[][] dots) {
            int result = 0;

            List<Double> slopeList = getSlopeList(dots);
            result = getMatchSlopeCnt(slopeList);

            return result;
        }

        private List<Double> getSlopeList(int[][] dots) {
            List<Double> slopeList = new ArrayList<Double>();

            slopeList.add(getSlope(dots[0], dots[1]));
            slopeList.add(getSlope(dots[0], dots[2]));
            slopeList.add(getSlope(dots[0], dots[3]));
            slopeList.add(getSlope(dots[1], dots[2]));
            slopeList.add(getSlope(dots[1], dots[3]));
            slopeList.add(getSlope(dots[2], dots[3]));

            return slopeList;
        }

        private Double getSlope(int[] dotA, int[] dotB) {
            Double slope = null;

            int x = dotB[0] - dotA[0];
            int y = dotB[1] - dotA[1];

            if( y != 0 )
                slope = (double) y / x;

            return slope;
        }

        private int getMatchSlopeCnt(List<Double> slopeList) {
            int result = 0;
            Map<Double, Integer> matchSlopeCnt = new HashMap<Double, Integer>();
            Double absSlope = null;

            for( Double slope : slopeList ) {
                if( slope == null )
                    absSlope = null;
                else
                    absSlope = Math.abs(slope);

                if( matchSlopeCnt.containsKey(absSlope) )
                    matchSlopeCnt.put(absSlope, matchSlopeCnt.get(absSlope) + 1);
                else
                    matchSlopeCnt.put(absSlope, 1);
            }
            
            for( Double key : matchSlopeCnt.keySet() ) {
                if( matchSlopeCnt.get(key) > 1 )
                    result += matchSlopeCnt.get(key) - 1;
            }

            return result;
        }
    }
}
