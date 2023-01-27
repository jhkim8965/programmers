package co.kr.school.programmers.testing.inherit;

import org.springframework.stereotype.Component;

@Component
public class InheritStudy {
    public void returnTest_CallMethod_ChildObjectAsParentObject() {
        ChildA childA = (ChildA) childObjectAsParentObject("A");
        ChildB childB = (ChildB) childObjectAsParentObject("B");

        childA.introduce();
        childB.introduce();
    }

    private Parent childObjectAsParentObject(String type) {
        if (type == "A") {
            return new ChildA();
        } else {
            return new ChildB();
        }
    }

    public Object checkingObjectAddress(Object object) {
        System.out.printf("%-20s %s\n", "Recieved this ", object);
        return object;
    }

    static class Parent {
        public void parentMethod() {
            System.out.println("this is parent's Method");
        }
    }

    static class ChildA extends Parent {
        public void introduce() {
            System.out.println("I'm ChildA");
        }
    }

    static class ChildB extends Parent {
        public void introduce() {
            System.out.println("I'm ChildB");
        }
    }
}
