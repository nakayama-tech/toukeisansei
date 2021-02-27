package nakayama.tech.com.dbutil;

import nakayama.tech.com.form.RegistForm;

/**
 *
 * 更新用SQL作成ユーティリティクラス
 *
 * @author a_nak
 *
 */
public class UpdateSQL {
	/**
	 *
	 * ユーザ情報テーブルINSERT用SQL
	 * ※会員登録
	 *
	 * @param form
	 * @return
	 */
	public String createUserInfoSQL(RegistForm form) {

		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO user_info (user_id, password, user_name, regist_time, yuryo_kaiin_regist_date, taikenban_regist_date, kaiin_status)");
		sb.append("VALUES('");
		sb.append(form.getMailAddress());
		sb.append("','");
		sb.append(form.getPassword());
		sb.append("','");
		sb.append(form.getName());
		sb.append("',now(),null, null, '0')");

		return sb.toString();
	}
}
