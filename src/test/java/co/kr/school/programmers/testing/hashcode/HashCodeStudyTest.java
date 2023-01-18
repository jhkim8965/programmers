package co.kr.school.programmers.testing.hashcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class HashCodeStudyTest {

    @Test
    @DisplayName("Compare hashCode value between String and String in User Class")
    void hashCodeTest_simple() {
        // given
        HashCodeStudy.User_overridden userOverrided = new HashCodeStudy.User_overridden("neo");
        String anotherString = "neo";

        System.out.println("user.hashCode() = " + userOverrided.hashCode());
        System.out.println("anotherString.hashCode() = " + anotherString.hashCode());

        // then
        assertThat(userOverrided.hashCode()).isEqualTo(anotherString.hashCode());
    }

    @Test
    @DisplayName("Compare hashCode value between User classes")
    void hashCodeTest_userClasses() {
        // given
        HashCodeStudy.User neo = new HashCodeStudy.User("neo");
        HashCodeStudy.User neo2 = new HashCodeStudy.User("neo");
        neo.reported();

        // when
        Set<HashCodeStudy.User> userSet = new HashSet<>();
        userSet.add(neo);
        userSet.add(neo2);
        System.out.println("userSet.size() = " + userSet.size());

        // then
        assertThat(userSet.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Compare hashCode value between Custom User classes")
    void hashCodeTest_customUserClasses() {
        // given
        HashCodeStudy.User_overridden neo = new HashCodeStudy.User_overridden("neo");
        HashCodeStudy.User_overridden neo2 = new HashCodeStudy.User_overridden("neo");
        neo.reported();

        // when
        Set<HashCodeStudy.User_overridden> userOverridedSet = new HashSet<>();
        userOverridedSet.add(neo);
        userOverridedSet.add(neo2);
        System.out.println("userOverridedSet.size() = " + userOverridedSet.size());

        // then
        assertThat(userOverridedSet.size()).isEqualTo(1);
    }
}