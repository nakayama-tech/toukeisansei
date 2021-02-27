package nakayama.tech.com.db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.Vector;

public class DbConnect {
	/** DB接続 */
	private Connection con = null;
	/** DB接続URL */
	private String url;
	/** DB接続ユーザ */
	private String user;
	/** DB接続パス */
	private String password;
	/** データ設定 */
	Vector vctData = null;

	/**
	 *
	 * コンストラクタ
	 *
	 */
	public DbConnect() {
		this.url = "jdbc:postgresql://localhost:5432/postgres";
		this.user = "postgres";
		this.password = "riben731";
	}

	/**
	 *
	 * DB接続
	 *
	 * @return
	 * @throws Exception
	 */
	public void dbConnect() throws SQLException {
		con = null;

		//PostgreSQLへ接続
		con = DriverManager.getConnection(url, user, password);

		//自動コミットOFF
		con.setAutoCommit(false);
	}

	public Vector dbSearch(String sql) throws SQLException {
		ResultSet rs = null;
		Statement stmt = null;
		Hashtable hshData = null;
		ResultSetMetaData rsmd = null;

		vctData = new Vector();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				hshData = new Hashtable();
				rsmd = rs.getMetaData();
				int column = rsmd.getColumnCount();
				for(int i = 1; i<= column; i++) {
					// カラム名取得
					String strName = rsmd.getColumnName(i);
					// データをObjectで取得
					Object obj = rs.getObject(i);
					if(obj == null) {
						obj = new String("");
					}
					// Objの型を調査
					String strClassName = obj.getClass().getName();

					// Obj⇒String返還
					String strData = new String("");
					if(strClassName.equals("java.sql.Timestamp")) {
						// date
						strData = ((Timestamp)obj).toString();
						// YYYYMMDD
						strData = strData.substring(0,4) + strData.substring(5,7) +
									strData.substring(8,10);
					} else if(strClassName.equals("java.lang.String")) {
						strData = (String)obj;
						strData = new String(strData);
					} else if(strClassName.equals("java.math.BigDecimal")) {
						// number型
						strData = ((BigDecimal)obj).toString();
					} else {
						strData = obj.toString();
					}

					// データ格納
					hshData.put(strName, strData);
				}
				vctData.add(hshData);
				hshData = null;
			}
		} catch(SQLException ex) {
			throw ex;
		} finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch(Exception ex) {
				}
				stmt = null;
				rs = null;
				rsmd = null;
				hshData = null;
			}
		}
		return vctData;

	}
	/**
	 *
	 * DB更新
	 * ※更新追加削除
	 *
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean dbInput(String sql) throws SQLException {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			//SELECT文の実行
			int rowCount = stmt.executeUpdate(sql);
			System.out.println(rowCount + "件登録しました");
		} catch (SQLException ex) {
			throw(ex);
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch(Exception ex) {
				}
				stmt = null;
			}
		}
		return true;
	}

	/**
	 *
	 * コミット
	 *
	 * @throws SQLException
	 */
	public void dbCommit() {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 *
	 * DB接続解除
	 *
	 * @throws SQLException
	 */
	public void dbClose() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
}
