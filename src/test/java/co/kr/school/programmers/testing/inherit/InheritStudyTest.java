package co.kr.school.programmers.testing.inherit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InheritStudyTest {
    InheritStudy inheritStudy = new InheritStudy();

    @Test
    @DisplayName("Can I use Child method? If I got returned Parent Object Type")
    void returnTest() {
        InheritStudy inheritStudy = new InheritStudy();
        inheritStudy.returnTest_CallMethod_ChildObjectAsParentObject();
    }

    @Test
    @DisplayName("Is the same address all of them?")
    void returnTest2() {
        InheritStudy.Parent parent = new InheritStudy.Parent();
        System.out.printf("%-20s %s\n", "Start with ", parent);
        InheritStudy.Parent finalParent = (InheritStudy.Parent) inheritStudy.checkingObjectAddress(parent);
        System.out.printf("%-20s %s\n", "Finaly got this ", finalParent);

        Assertions.assertThat(parent).isEqualTo(finalParent);
    }
}