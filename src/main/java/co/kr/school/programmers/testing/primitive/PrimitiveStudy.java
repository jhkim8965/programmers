package co.kr.school.programmers.testing.primitive;

public class PrimitiveStudy {
    public int getPrimitiveValue(int parameter) {
        System.out.printf("%-20s %d\n", "getPrimitiveValue() -> ", System.identityHashCode(++parameter));
        return parameter;
    }
}