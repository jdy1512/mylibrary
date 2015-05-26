package spring.mvc.vo;

import java.util.List;

public class MultiUpload {
	private String title;
	private List upfile;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List getUpfile() {
		return upfile;
	}

	public void setUpfile(List upfile) {
		this.upfile = upfile;
	}

}
