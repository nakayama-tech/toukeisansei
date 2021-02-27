package nakayama.tech.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nakayama.tech.com.form.LoginForm;
import nakayama.tech.com.form.RegistForm;

/**
 * 新規会員登録画面遷移時のコントローラー
 *
 * FROM：/
 * TO:home.jsp
 *
 */
@Controller
public class RegistCompleteController {
	private static final Logger logger = LoggerFactory.getLogger(RegistCompleteController.class);

	/**
	 *
	 * Modelの初期化
	 *
	 * @return
	 */
	//@ModelAttribute
	public RegistForm setRegistForm() {
		RegistForm form = new RegistForm();
		return form;
	}

	/**
	 *
	 * Modelの初期化
	 *
	 * @return
	 */
	@ModelAttribute
	public LoginForm setLoginForm() {
		LoginForm form = new LoginForm();
	return form;
	}

	/**
	 *
	 * 新規ユーザ登録成功後TOP画面
	 *
	 *
	 * @param form 画面で取得したモデル（アドレス、パスワード）
	 * @param model  画面で取得したモデル（アドレス、パスワード）
	 * @return 登録完了画面
	 */
	@RequestMapping(value="toTop", params = "registComplete", method = RequestMethod.POST)
	public String regist() {

		return "top";
	}
}
