package nakayama.tech.com.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nakayama.tech.com.form.LoginForm;

/**
 * 初期画面遷移時のコントローラー
 *
 * FROM：ルート
 * TO:home.jsp
 *
 */
@Controller
public class EnterController {


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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		// トップページに遷移するのみ
		return "top";
	}
}
