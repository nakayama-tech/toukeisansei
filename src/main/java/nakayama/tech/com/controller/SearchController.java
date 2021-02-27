package nakayama.tech.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nakayama.tech.com.form.LoginForm;
import nakayama.tech.com.form.RegistForm;
import nakayama.tech.com.form.SearchForm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SearchController {

	//private static final Logger logger = LoggerFactory.getLogger(SanseiController.class);

	/**
	 *
	 * Model(Login)の初期化
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
	 * Model(Regist)の初期化
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
	 * Model(Search)の初期化
	 *
	 * @return
	 */
	@ModelAttribute
	public SearchForm setSearchForm() {
		SearchForm form = new SearchForm();
      return form;
  }

	/**
	 * 検索結果画面遷移時のコントローラ
	 *
	 * FROM：home.jsp
	 * TO:top.jsp
	 *
	 */
	@RequestMapping(value = "search", params = "search", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String search(@Validated @ModelAttribute("searchForm")
					SearchForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "loginTop";
        }
		return "searchResult";
	}
}
