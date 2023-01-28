package co.kr.school.programmers.testing.primitive;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrimitiveStudyTest {
    PrimitiveStudy primitiveStudy = new PrimitiveStudy();

    @Test
    @DisplayName("Checking addresses between Primitive variables of different type each other")
    void primitiveTest() {
        int testInt = 100;
        System.out.println("System.identityHashCode(testInt) = " + System.identityHashCode(testInt));

        int address = System.identityHashCode(testInt);
        System.out.println("address = " + address);

        testInt = primitiveStudy.getPrimitiveValue(testInt);
        System.out.println("after -> System.identityHashCode(testInt) = " + System.identityHashCode(testInt));

        assertThat(address).isNotEqualTo(System.identityHashCode(testInt));
    }
}