package co.kr.school.programmers.beginner.lessons.lv1;

import java.util.*;

/**
 *개인정보 수집 유효기간
 *
 * 문제 설명
 * 고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다. 약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다. 당신은 각 개인정보가 어떤 약관으로 수집됐는지 알고 있습니다. 수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.
 *
 * 예를 들어, A라는 약관의 유효기간이 12 달이고, 2021년 1월 5일에 수집된 개인정보가 A약관으로 수집되었다면 해당 개인정보는 2022년 1월 4일까지 보관 가능하며 2022년 1월 5일부터 파기해야 할 개인정보입니다.
 * 당신은 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.
 *
 * 모든 달은 28일까지 있다고 가정합니다.
 *
 * 다음은 오늘 날짜가 2022.05.19일 때의 예시입니다.
 *
 * 약관 종류	유효기간
 * A	6 달
 * B	12 달
 * C	3 달
 * 번호	개인정보 수집 일자	약관 종류
 * 1	2021.05.02	A
 * 2	2021.07.01	B
 * 3	2022.02.19	C
 * 4	2022.02.20	C
 * 첫 번째 개인정보는 A약관에 의해 2021년 11월 1일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
 * 두 번째 개인정보는 B약관에 의해 2022년 6월 28일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.
 * 세 번째 개인정보는 C약관에 의해 2022년 5월 18일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
 * 네 번째 개인정보는 C약관에 의해 2022년 5월 19일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.
 * 따라서 파기해야 할 개인정보 번호는 [1, 3]입니다.
 *
 * 오늘 날짜를 의미하는 문자열 today, 약관의 유효기간을 담은 1차원 문자열 배열 terms와 수집된 개인정보의 정보를 담은 1차원 문자열 배열 privacies가 매개변수로 주어집니다. 이때 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * today는 "YYYY.MM.DD" 형태로 오늘 날짜를 나타냅니다.
 * 1 ≤ terms의 길이 ≤ 20
 * terms의 원소는 "약관 종류 유효기간" 형태의 약관 종류와 유효기간을 공백 하나로 구분한 문자열입니다.
 * 약관 종류는 A~Z중 알파벳 대문자 하나이며, terms 배열에서 약관 종류는 중복되지 않습니다.
 * 유효기간은 개인정보를 보관할 수 있는 달 수를 나타내는 정수이며, 1 이상 100 이하입니다.
 * 1 ≤ privacies의 길이 ≤ 100
 * privacies[i]는 i+1번 개인정보의 수집 일자와 약관 종류를 나타냅니다.
 * privacies의 원소는 "날짜 약관 종류" 형태의 날짜와 약관 종류를 공백 하나로 구분한 문자열입니다.
 * 날짜는 "YYYY.MM.DD" 형태의 개인정보가 수집된 날짜를 나타내며, today 이전의 날짜만 주어집니다.
 * privacies의 약관 종류는 항상 terms에 나타난 약관 종류만 주어집니다.
 * today와 privacies에 등장하는 날짜의 YYYY는 연도, MM은 월, DD는 일을 나타내며 점(.) 하나로 구분되어 있습니다.
 * 2000 ≤ YYYY ≤ 2022
 * 1 ≤ MM ≤ 12
 * MM이 한 자릿수인 경우 앞에 0이 붙습니다.
 * 1 ≤ DD ≤ 28
 * DD가 한 자릿수인 경우 앞에 0이 붙습니다.
 * 파기해야 할 개인정보가 하나 이상 존재하는 입력만 주어집니다.
 * 입출력 예
 * today	terms	privacies	result
 * "2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	[1, 3]
 * "2020.01.01"	["Z 3", "D 5"]	["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	[1, 4, 5]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 문제 예시와 같습니다.
 * 입출력 예 #2
 *
 * 약관 종류	유효기간
 * Z	3 달
 * D	5 달
 * 번호	개인정보 수집 일자	약관 종류
 * 1	2019.01.01	D
 * 2	2019.11.15	Z
 * 3	2019.08.02	D
 * 4	2019.07.01	D
 * 5	2018.12.28	Z
 * 오늘 날짜는 2020년 1월 1일입니다.
 *
 * 첫 번째 개인정보는 D약관에 의해 2019년 5월 28일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
 * 두 번째 개인정보는 Z약관에 의해 2020년 2월 14일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.
 * 세 번째 개인정보는 D약관에 의해 2020년 1월 1일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.
 * 네 번째 개인정보는 D약관에 의해 2019년 11월 28일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
 * 다섯 번째 개인정보는 Z약관에 의해 2019년 3월 27일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
 */

public class Lesson_150370 {
    int[] answer = {};

    public Lesson_150370(String today, String[] terms, String[] privacies) {
        this.answer = solution(today, terms, privacies);
    }

    public int[] getAnswer() {
        return answer;
    }

    private int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap       = convertTermsToMap(terms);
        List<PrivacyInfo> privacyInfoList   = setPrivacyInfoList(today, termsMap, privacies);

        return getDestroyingPrivacyInfoList(privacyInfoList);
    }

    private Map<String, Integer> convertTermsToMap(String[] terms) {
        Map<String, Integer> termsMap = new HashMap<>();

        for (String termsInfo : terms) {
            String[] term = termsInfo.split(" ");
            termsMap.put(term[0], Integer.valueOf(term[1]));
        }

        return termsMap;
    }

    private List<PrivacyInfo> setPrivacyInfoList(String today, Map<String, Integer> termsMap, String[] privacies) {
        List<PrivacyInfo> privacyInfoList = new ArrayList<>();

        int no = 1;
        for (String privacyInfo : privacies) {
            final String[] PRIVACY = privacyInfo.split(" ");
            final String COLLECTION_DATE = PRIVACY[0];
            final String TERMS_TYPE = PRIVACY[1];

            privacyInfoList.add(new PrivacyInfo(no++, COLLECTION_DATE, TERMS_TYPE)
                    .generateExprDate(termsMap.get(TERMS_TYPE))
                    .validateExprDate(today));
        }

        return privacyInfoList;
    }

    private int[] getDestroyingPrivacyInfoList(List<PrivacyInfo> privacyInfoList) {
        List<Integer> destroyingPrivacyList = new ArrayList<>();

        for (PrivacyInfo privacyInfo : privacyInfoList) {
            if (!privacyInfo.getIsValid()) {
                destroyingPrivacyList.add(privacyInfo.getNo());
            }
        }

        return destroyingPrivacyList.stream().mapToInt(no -> no).toArray();
    }

    private static class PrivacyInfo {
        private int no = -1;
        private String collectionDate = "";
        private String termsType = "";
        private String expirationDate = "";
        private Boolean isValid = false;

        public PrivacyInfo(int no, String collectionDate, String termsType) {
            this.no = no;
            this.collectionDate = collectionDate;
            this.termsType = termsType;
        }

        public PrivacyInfo generateExprDate(int term) {
            final String[] collectionDates = collectionDate.split("\\.");
            expirationDate = addMonth(collectionDates[0], collectionDates[1], collectionDates[2], term);

            return this;
        }

        private String addMonth(final String YEAR, final String MONTH, final String DATE, int term) {
            final int termMonth = Integer.parseInt(MONTH) + term;
            final int addedMonth = (termMonth % 12 == 0 ? 12 : termMonth % 12);
            final String MM = (addedMonth < 10 ? "0" : "") + String.valueOf(addedMonth);

            final int addingYear = (termMonth % 12 == 0 ? -1 : 0) + termMonth / 12;
            final int addedYear = Integer.parseInt(YEAR) + addingYear;
            final String YYYY = (addedYear < 10 ? "0" : "") + addedYear;

            return new String(new StringBuilder()
                                .append(YYYY).append(".")
                                .append(MM).append(".")
                                .append(DATE));
        }

        public PrivacyInfo validateExprDate(String today) {
            isValid = expirationDate.compareTo(today) > 0 ? true : false;

            return this;
        }

        public Boolean getIsValid() {
            return isValid;
        }

        public int getNo() {
            return no;
        }
    }
}
