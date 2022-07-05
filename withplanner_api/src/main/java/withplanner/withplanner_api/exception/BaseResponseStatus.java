package withplanner.withplanner_api.exception;

import lombok.Getter;

/**
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    /**
     * 2000 : Request 오류
     */

    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    INVALID_JWT(false, 2001, "유효하지 않은 JWT입니다."),
    INVALID_USER_JWT(false,2002,"권한이 없는 유저의 접근입니다."),
    DUPLICATE_USER_EMAIL(false, 2003, "중복되는 유저 이메일입니다"),
    NOT_EXISTS_PARTICIPANT(false,2004,"존재하지 않는 멤버입니다"),
    EMPTY_EMAIL(false,2005,"이메일 값을 입력해주세요"),
    EMPTY_PASSWORD(false,2006,"비밀번호 값을 입력해주세요"),
    NOT_EXISTS_EMAIL(false,2007,"존재하지 않는 이메일입니다."),



    /**
     * 3000 : Response 오류
     */


    /**
     * 4000 : Database, Server 오류
     */

    INTERNAL_SERVER_ERROR(false,4000,"서버 오류입니다.");


    // 5000 : 필요시 만들어서 쓰세요


    // 6000 : 필요시 만들어서 쓰세요


    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
