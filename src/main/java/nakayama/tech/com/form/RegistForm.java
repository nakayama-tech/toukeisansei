package nakayama.tech.com.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * 新規会員登録のForm
 *
 * @author 中山 憲
 *
 */
public class RegistForm {

	/** 入力メールアドレス */
	@NotEmpty(message="メールアドレスを入力してください。")
	private String mailAddress;

	/** 入力パスワード */
	@NotEmpty(message="パスワードを入力してください。")
	@Size(min=8,max=16,message="パスワードは{min}文字以上{max}文字以下です。")
	@Pattern(regexp="[a-zA-Z0-9]*",message="パスワードは英数である必要があります。")
	private String password;

	/** 入力メールアドレス */
	@NotEmpty(message="名前を入力してください。")
	private String name;

	/**
	 *
	 * Set：メールアドレス
	 *
	 * @param mailAddress
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
    }

	/**
	 *
	 * Set：パスワード
	 *
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
    }

	/**
	 *
	 * Set：名前
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
   }

	/**
	 *
	 * Get：メールアドレス
	 *
	 * @return
	 */
	public String getMailAddress() {
		return mailAddress;
    }

	/**
	 *
	 * Get：パスワード
	 *
	 * @return
	 */
	public String getPassword() {
		return password;
    }

	/**
	 *
	 * Get：名前
	 *
	 * @return
	 */
	public String getName() {
		return name;
   }
}
