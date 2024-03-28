import java.util.regex.*;

public class Main_btt4_5 {
    public static void main(String[] args) {
        String username = "Abc Def";
        String email = "example@domain.com";
        String password = "Pass1234";

        if (username.isBlank() || email.isBlank() || password.isBlank()) {
            System.out.println(false);
        } else {
            if (!Pattern.matches("^[A-Z][a-zA-Z ]{14,29}$", username)) {
                System.out.println(false);
            } else {
                if (!Pattern.matches("^[a-z0-9](\\.?[a-z0-9]){0,}@([a-z]+\\.){1,}[a-z]{2,}$", email)) {
                    System.out.println(false);
                } else {
                    if (!Pattern.matches("^[A-Z][a-zA-Z0-9]{7,}$", password)) {
                        System.out.println(false);
                    } else {
                        System.out.println(username);
                        System.out.println(email);
                        System.out.println(password);
                    }
                }
            }
        }
    }
}
