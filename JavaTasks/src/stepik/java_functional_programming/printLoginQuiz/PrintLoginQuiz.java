package stepik.java_functional_programming.printLoginQuiz;

import java.util.*;
import java.util.stream.Collectors;

class PrintLoginQuiz {

    public static void printLoginIfPro(Set<User> users, String id) {
        // write your code here
        List<User> proUsers = users.stream()
                .filter(user -> user.getAccount().isPresent())
                .filter(user -> id.equals(user.getAccount().get().getId()))
                .filter(user -> "pro".equals(user.getAccount().get().getType())).toList();
        proUsers.forEach(user -> System.out.println(user.getLogin()));
    }

    class Account {
        private String id;
        private String type;

        public Account(String id, String type) {
            this.id = id;
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }
    }

    class User {
        private String login;
        private Account account;

        public User(String login, Account account) {
            this.login = login;
            this.account = account;
        }

        public String getLogin() {
            return login;
        }

        public Optional<Account> getAccount() {
            return Optional.ofNullable(account);
        }
    }
}
