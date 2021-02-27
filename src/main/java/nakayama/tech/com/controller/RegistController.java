package nakayama.tech.com.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nakayama.tech.com.db.DbConnect;
import nakayama.tech.com.dbutil.UpdateSQL;
import nakayama.tech.com.form.RegistForm;

/**
 * 新規会員登録画面遷移時のコントローラー
 *
 * FROM：/
 * TO:home.jsp
 *
 */
@Controller
public class RegistController {
	private static final Logger logger = LoggerFactory.getLogger(RegistController.class);

	/**
	 *
	 * Modelの初期化
	 *
	 * @return
	 */
	@ModelAttribute
	public RegistForm setRegistForm() {
		RegistForm form = new RegistForm();
        return form;
    }

	/**
	 *
	 * 新規ユーザ登録
	 *
	 * ※Validationはクライアント、Modelで実施しているためここでは行わない
	 *
	 * @param form 画面で取得したモデル（アドレス、パスワード）
	 * @param model  画面で取得したモデル（アドレス、パスワード）
	 * @return 登録完了画面
	 */
	@RequestMapping(value = "newRegist", params="regist", method = RequestMethod.POST)
	public String regist(@Validated @ModelAttribute("registForm") RegistForm form,
							BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "regist";
        }

		//----------------------------------------------------
		// １．DBアクセス
		//----------------------------------------------------
		//----------------------------------------------------
		// ２．メールアドレス重複チェック
		//----------------------------------------------------
		//----------------------------------------------------
		// ３．パスワード暗号化
		//----------------------------------------------------
		//----------------------------------------------------
		// ４．DB登録
		//----------------------------------------------------
        DbConnect dbc = null;
        UpdateSQL us = new UpdateSQL();
		String sql = us.createUserInfoSQL(form);

		try{
			dbc = new DbConnect();
			dbc.dbConnect();
			dbc.dbInput(sql);
			dbc.dbCommit();
		}catch (SQLException e){
			if(e.getErrorCode() == 0) {
				model.addAttribute("errMsg","メールアドレスが登録済みです");
				return "regist";
			} else {
				model.addAttribute("errMsg","想定外のエラーが発生しました。お問合せフォームからお問合せください");
				return "regist";
			}
		}
		//----------------------------------------------------
		// ５．後処理
		//----------------------------------------------------
		finally {
			dbc.dbClose();
		}

		return "registOK";
	}
}
