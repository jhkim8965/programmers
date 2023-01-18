package co.kr.school.programmers.testing.hashcode;

public class HashCodeStudy {

    public HashCodeStudy() {
        mainPorcess();
    }

    private void mainPorcess() {
//        User user = new User("muzi");
//
//        System.out.println("user.hashCode() = " + user.hashCode());
//        System.out.println("muzi.hashCode() = " + "muzi".hashCode());
    }

    static class User_overridden {
        String id = "";
        int reportedCount = 0;

        public User_overridden(String id) {
            this.id = id;
        }

        public void reported() {
            reportedCount++;
        }

        @Override
        public int hashCode() {
            return this.id.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            // First, checking address same or not between objects.
            if(this == obj) return true;

            // Second, checking given object is null or not.
            if(obj == null) return false;

            // Third, checking type same or not between objects.
            if(this.getClass() != obj.getClass()) return false;

            // Finally, checking value same or not between objects.
            // If you want adding some conditions, you just append below condition what you want.
            // In this test case, it needs only ID field checking.
            User_overridden userOverrided = (User_overridden) obj;
            return id == userOverrided.id;
        }
    }

    static class User {
        String id = "";
        int reportedCount = 0;

        public User(String id) {
            this.id = id;
        }

        public void reported() {
            reportedCount++;
        }
    }
}
