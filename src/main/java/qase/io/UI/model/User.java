package qase.io.UI.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
