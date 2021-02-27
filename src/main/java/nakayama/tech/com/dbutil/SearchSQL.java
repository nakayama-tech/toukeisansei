package nakayama.tech.com.dbutil;

import nakayama.tech.com.form.LoginForm;

/**
 *
 * 更新用SQL作成ユーティリティクラス
 *
 * @author a_nak
 *
 */
public class SearchSQL {
	/**
	 *
	 * ユーザ情報テーブル検索用SQL
	 * ※ログイン時
	 *
	 * @param form
	 * @return
	 */
	public String searchLoginUserInfoSQL(LoginForm form) {

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT user_id, password FROM user_info where user_id = '");
		sb.append(form.getLoginId());
		sb.append("' AND password = '");
		sb.append(form.getPasswd());
		sb.append("'");

		return sb.toString();
	}
}
