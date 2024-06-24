package cholog.auth.infrastructure;

import jakarta.servlet.http.HttpServletRequest;

public interface AuthorizationExtractor<T> { // 인터페이스
    String AUTHORIZATION = "Authorization"; // Authorization: 인증 시 헤더 키

    T extract(HttpServletRequest request);
}
