package nakayama.tech.com.dao;

import java.sql.Timestamp;

public class UserInfoDao {
	/** ユーザID（メールアドレス） */
	private String userId;
	/** パスワード */
	private String password;
	/** ユーザ名 */
	private String userName;
	/** 登録日 */
	private Timestamp registTime;
	/** 有料会員登録日 */
	private Timestamp yuryoKaiinRegistDate;
	/** 体験版登録日 */
	private String taikenbanRegistDate;
	/** 会員ステータス */
	private String kaiinStatus;

	/**
	 * ユーザID設定
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * パスワード設定
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ユーザ名設定
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * ユーザ新規登録日設定
	 * @param registTime
	 */
	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}

	/**
	 * 有料会員登録日設定
	 * @param yuryoKaiinRegistDate
	 */
	public void setYuryoKaiinRegistDate(Timestamp yuryoKaiinRegistDate) {
		this.yuryoKaiinRegistDate = yuryoKaiinRegistDate;
	}

	/**
	 * 体験版登録日設定
	 * @param taikenbanRegistDate
	 */
	public void setTaikenRegistDate(String taikenbanRegistDate) {
		this.taikenbanRegistDate = taikenbanRegistDate;
	}

	/**
	 * 会員ステータス設定
	 * @param kaiinStatus
	 */
	public void setKaiinStatus(String kaiinStatus) {
		this.kaiinStatus = kaiinStatus;
	}

	/**
	 * ユーザID取得
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * パスワードID取得
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * ユーザ名取得
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * 登録日取得
	 */
	public Timestamp getRegistTime() {
		return this.registTime;
	}

	/**
	 * 有料会員登録日取得
	 */
	public Timestamp getYuryoKaiinRegistDate() {
		return this.yuryoKaiinRegistDate;
	}

	/**
	 * 体験版登録日取得
	 */
	public String getTaikenRegistDate() {
		return this.taikenbanRegistDate;
	}

	/**
	 * 会員ステータス取得
	 */
	public String getKaiinStatus() {
		return this.kaiinStatus;
	}
}