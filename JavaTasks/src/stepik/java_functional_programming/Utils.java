package stepik.java_functional_programming;

import java.util.stream.Stream;

final class Utils {

    private Utils() { }

    public static Stream<User> generateUsers(int numberOfUsers) {
        return Stream.iterate(0, i -> i<numberOfUsers, i -> i + 1)
                .map((id) -> new User(id, "user" + id + "@gmail.com"));
    }
}

class User {
    private final long id;
    private final String email;

    User(long id, String email) {
        this.id = id;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
