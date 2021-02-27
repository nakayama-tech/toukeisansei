package nakayama.tech.com.form;

import javax.validation.constraints.NotNull;

/**
 *
 * 新規会員登録のForm
 *
 * @author 中山 憲
 *
 */
public class LoginForm {

	/** ログインID */
	@NotNull
	private String loginId;

	/** 入力パスワード */
	@NotNull
	private String passwd;

	/**
	 *
	 * Set：メールアドレス
	 *
	 * @param LoginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
    }

	/**
	 *
	 * Set：パスワード
	 *
	 * @param Passwd
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
    }

	/**
	 *
	 * Get：メールアドレス
	 *
	 * @return
	 */
	public String getLoginId() {
		return loginId;
    }

	/**
	 *
	 * Get：パスワード
	 *
	 * @return
	 */
	public String getPasswd() {
		return passwd;
    }
}
