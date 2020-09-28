package bean;

public class TinyURLBean {
	
	protected int Id;
	protected int userId;
	protected String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	protected String url;
	protected String tinyURL;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTinyURL() {
		return tinyURL;
	}
	public void setTinyURL(String tinyURL) {
		this.tinyURL = tinyURL;
	}
	
	public TinyURLBean(int id, String username, String url, String tinyURL) {
		super();
		Id = id;
		this.username = username;
		this.url = url;
		this.tinyURL = tinyURL;
	}
	@Override
	public String toString() {
		return "TinyURLBean [Id=" + Id + ", userId=" + userId + ", url=" + url + ", tinyURL=" + tinyURL + "] \n";
	}
	
	
	
	
}
