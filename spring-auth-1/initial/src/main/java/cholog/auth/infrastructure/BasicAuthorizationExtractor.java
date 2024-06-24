package cholog.auth.infrastructure;

import cholog.auth.dto.AuthInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.codec.binary.Base64;


public class BasicAuthorizationExtractor implements AuthorizationExtractor<AuthInfo> {
    private static final String BASIC_TYPE = "Basic";
    private static final String DELIMITER = ":";

    @Override
    public AuthInfo extract(HttpServletRequest request) {
        String header = request.getHeader(AUTHORIZATION); // basic 포함X
        //getHeader(AUTHORIZATION): basic 포함

        if (header == null) {
            return null;
        }

        if ((header.toLowerCase().startsWith(BASIC_TYPE.toLowerCase()))) { // Basic으로 시작하는지 확인
            String authHeaderValue = header.substring(BASIC_TYPE.length()).trim(); // subsitring: 문자열 자르기(Basic문자열만큼 자름) / trim: 공백 없애기
            // authHeaderValue: 토큰만 남음
            byte[] decodedBytes = Base64.decodeBase64(authHeaderValue); // Base64: 암호화 방법 중 하나 / decodeBase64: 복호화(해독)
            String decodedString = new String(decodedBytes); // :을 기준으로
            System.out.println(decodedString);

            String[] credentials = decodedString.split(DELIMITER); // split: 매개변수 기준으로 문자열 쪼개서 배열에 저장
            // email, password에 따로 저장
            String email = credentials[0];
            String password = credentials[1];

            return new AuthInfo(email, password);
        }

        return null;
    }


}
