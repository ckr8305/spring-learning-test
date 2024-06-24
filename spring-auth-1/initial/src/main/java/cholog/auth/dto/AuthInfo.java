package cholog.auth.dto;

public class AuthInfo { // 얘는 하나의 dto
    private String email;
    private String password;

    public AuthInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
