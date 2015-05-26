package spring.mvc.vo;

import org.springframework.web.multipart.MultipartFile;

public class SingleUpload {
	private String title;
	private MultipartFile upfile;
	private String info;

	public SingleUpload() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getUpfile() {
		return upfile;
	}

	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
