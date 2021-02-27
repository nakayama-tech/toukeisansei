package nakayama.tech.com.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * 検索用のForm
 *
 * @author 中山 憲
 *
 */
public class SearchForm {

	/** 競馬場 */
	@NotEmpty(message="競馬場を選択してください。")
	private String keibajou;

	/** 芝・ダート区分 */
	@NotEmpty(message="芝・ダート区分を選択してください。")
	private String shibaDirt;

	/** 距離 */
	@NotEmpty(message="距離を選択してください。")
	private String kyori;

	/**
	 *
	 * Set：競馬場
	 *
	 * @param keibajou
	 */
	public void setKeibajou(String keibajou) {
		this.keibajou = keibajou;
	}

	/**
	 *
	 * Set：芝・ダート
	 *
	 * @param shibaDirt
	 */
	public void setShibaDirt(String shibaDirt) {
		this.shibaDirt = shibaDirt;
	}

	/**
	 *
	 * Set：距離
	 *
	 * @param kyori
	 */
	public void setKyori(String kyori) {
		this.kyori = kyori;
	}

	/**
	 *
	 * Get：競馬場
	 *
	 * @return
	 */
	public String getKeibajou() {
		return this.keibajou;
	}

	/**
	 *
	 * Get：芝・ダート区分
	 *
	 * @return
	 */
	public String getShibaDirt() {
		return this.shibaDirt;
	}

	/**
	 *
	 * Get：距離
	 *
	 * @return
	 */
	public String getKyori() {
		return this.kyori;
	}

}
