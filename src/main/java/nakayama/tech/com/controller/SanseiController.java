package nakayama.tech.com.controller;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nakayama.tech.com.db.DbConnect;
import nakayama.tech.com.dbutil.SearchSQL;
import nakayama.tech.com.form.LoginForm;
import nakayama.tech.com.form.RegistForm;
import nakayama.tech.com.form.SearchForm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SanseiController {

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
	 * Model(Regist)の初期化
	 *
	 * @return
	 */
	@ModelAttribute
	public SearchForm setSearchForm() {
		SearchForm form = new SearchForm();
       return form;
   }

	/**
	 * トップ画面遷移時のコントローラ
	 *
	 * FROM：home.jsp
	 * TO:top.jsp
	 *
	 */
	@RequestMapping(value = "doAction", params = "login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String login(@Validated @ModelAttribute("loginForm")
					LoginForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "top";
        }

		SearchSQL ss = new SearchSQL();
		String sql = ss.searchLoginUserInfoSQL(form);
        DbConnect dbc = null;
		Vector list = null;

		try{
			dbc = new DbConnect();
			dbc.dbConnect();
			list = dbc.dbSearch(sql);
			if(list.size() > 0) {
				Hashtable ht = (Hashtable)list.get(0);
				System.out.println((String)ht.get("user_id"));
				System.out.println((String)ht.get("password"));
				System.out.println((String)ht.get("user_name"));
				System.out.println((String)ht.get("regist_time"));
				System.out.println((String)ht.get("taikenban_regist_date"));
				System.out.println((String)ht.get("yuryo_kaiin_regist_date"));
				System.out.println((String)ht.get("kaiin_status"));
			} else {
				model.addAttribute("errMsg","ログインIDまたはパスワードに誤りがあります");
				return "top";
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			dbc.dbClose();
		}

		return "loginTop";
	}
	/**
	 *
	 * 新規登録画面遷移時のコントローラ
	 *
	 * FROM：home.jsp
	 * TO:top.jsp
	 *
	 */
	@RequestMapping(value = "doAction", params = "regist", method = RequestMethod.POST)
	String regist(Locale locale, Model model) {

		// 新規登録ページに遷移するのみ
		return "regist";
	}
}
