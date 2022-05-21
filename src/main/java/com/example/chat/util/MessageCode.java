package com.example.chat.util;

public class MessageCode {

	/** ユーザーIDまはたパスワードが違います。 */
	public static final String AUTHENTICATION_FAILURE = "e.chat.authenticationFailure";

	/** ログインしていません。 */
	public static final String UNAUTHENTICATION = "e.chat.unauthenticated";

	/** その{0}は既に使用されています。 */
	public static final String CONFLICT = "e.chat.conflict";

	/** データが存在しません。 */
	public static final String NOT_FOUND = "e.chat.notFound";

	/** システムエラー */
	public static final String SYSTEM_ERROR = "e.chat.systemError";

}
