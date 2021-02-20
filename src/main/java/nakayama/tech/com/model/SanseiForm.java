package nakayama.tech.com.model;

import java.io.Serializable;

public class SanseiForm implements Serializable  {

	private String loginId;
	private String passwd;

	public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
	public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getLoginId() {
        return loginId;
    }
    public String getPasswd() {
        return passwd;
    }
}
