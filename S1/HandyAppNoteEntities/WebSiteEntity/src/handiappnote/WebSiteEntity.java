package handiappnote;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WebSiteEntity {
	
	@Id
	protected String URL;
	protected String keyWord;
	protected String id;
	
	/**
	 * @param uRL
	 * @param keyWord
	 */
	public WebSiteEntity(String uRL, String keyWord) {
		super();
		URL = uRL;
		this.keyWord = keyWord;
	}
	
	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}
	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}
	/**
	 * @return the keyWord
	 */
	public String getKeyWord() {
		return keyWord;
	}
	/**
	 * @param keyWord the keyWord to set
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
