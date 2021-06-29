package com.example.project.model;

public class LanguageDTO {

	private String languageId;
	private String languageName;
	private boolean isActived;

	public LanguageDTO() {
	}

	public LanguageDTO(String languageId, String languageName, boolean isActived) {
		this.languageId = languageId;
		this.languageName = languageName;
		this.isActived = isActived;
	}

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public boolean isActived() {
		return isActived;
	}

	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}

}
