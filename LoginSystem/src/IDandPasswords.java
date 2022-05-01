import java.util.HashMap;

public class IDandPasswords {
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	public IDandPasswords() {
		
		logininfo.put("Admin", "Password");
		logininfo.put("User2", "U2Password");
		logininfo.put("User3", "U3Password");
		logininfo.put("User4", "U4Password")
	}
	
	protected HashMap<String, String> getLogininfo() {
		return logininfo;
	}
	

}
