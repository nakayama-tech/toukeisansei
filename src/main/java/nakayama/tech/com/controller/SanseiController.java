package nakayama.tech.com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nakayama.tech.com.model.SanseiForm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SanseiController {

	private static final Logger logger = LoggerFactory.getLogger(SanseiController.class);

	/**
	 * トップ画面遷移時のコントローラ
	 *
	 * FROM：home.jsp
	 * TO:top.jsp
	 *
	 */
	@RequestMapping(value = "doAction", params = "login", method = RequestMethod.POST)
	public String login(SanseiForm form, Model model) {
		/*=========================== DB ===========================*/
		Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        //接続文字列
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "riben731";

        try{
            //PostgreSQLへ接続
            conn = DriverManager.getConnection(url, user, password);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //SELECT文の実行
            stmt = conn.createStatement();
            String sql = "SELECT * FROM USER_INFO WHERE";
            rset = stmt.executeQuery(sql);

            //SELECT結果の受け取り
            while(rset.next()){
                String col = rset.getString(1);
                System.out.println(col);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(rset != null)rset.close();
                if(stmt != null)stmt.close();
                if(conn != null)conn.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

        }


        /*=========================== DB ===========================*/
		//Date date = new Date();
		//DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		//String formattedDate = dateFormat.format(date);

		//model.addAttribute("serverTime", formattedDate );

		return "loginTop";
	}
	/**
	 * 新規登録画面遷移時のコントローラ
	 *
	 * FROM：home.jsp
	 * TO:top.jsp
	 *
	 */
	@RequestMapping(value = "doAction", params = "regist", method = RequestMethod.POST)
	String regist(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "regist";
	}
}
