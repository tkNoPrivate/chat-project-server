package com.example.chat.util;

public class MessageCode {

	/** ユーザーIDまはたパスワードが違います。 */
	public static final String AUTHENTICATION_FAILURE = "e.chat.authenticationFailure";

	/** ログインしていません。 */
	public static final String UNAUTHENTICATION = "e.chat.unauthenticated";

	/** {0}は使用されています。 */
	public static final String CONFLICT_INSERT = "e.chat.conflict.insert";

	/** {0}は更新されています。再度操作してください。 */
	public static final String CONFLICT_UPDATE = "e.chat.conflict.update";

	/** {0}は削除されています。再度操作してください。 */
	public static final String CONFLICT_DELETE = "e.chat.conflict.delete";

	/** 既にいいねされています。 */
	public static final String CONFLICT_INSERT_LIKE = "e.chat.conflict.insert.like";

	/** 既にいいねは削除されています。 */
	public static final String CONFLICT_DELETE_LIKE = "e.chat.conflict.delete.like";

	/** データが存在しません。 */
	public static final String NOT_FOUND = "e.chat.notFound";

	/** 現在のパスワードが一致しません。 */
	public static final String CONFILM_PASSWORD_MISMATCH = "e.chat.ConfirmPasswordMismatch";

	/** システムエラー */
	public static final String SYSTEM_ERROR = "e.chat.systemError";

}
