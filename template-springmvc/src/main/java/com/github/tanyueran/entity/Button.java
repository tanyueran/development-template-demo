package com.github.tanyueran.entity;

import javax.validation.constraints.NotEmpty;

// 按钮
public class Button {
	@NotEmpty(message = "id不可为空")
	private String id;
	@NotEmpty(message = "按钮code不可为空")
	private String buttonCode;
	@NotEmpty(message = "按钮名称不可为空")
	private String buttonName;
	@NotEmpty(message = "所属菜单的id不可为空")
	private String menu_id;
	@NotEmpty(message = "按钮说明")
	private String note;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getButtonCode() {
		return buttonCode;
	}

	public void setButtonCode(String buttonCode) {
		this.buttonCode = buttonCode;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Button() {
	}

	public Button(@NotEmpty(message = "id不可为空") String id, @NotEmpty(message = "按钮code不可为空") String buttonCode, @NotEmpty(message = "按钮名称不可为空") String buttonName, @NotEmpty(message = "所属菜单的id不可为空") String menu_id, @NotEmpty(message = "按钮说明") String note) {
		this.id = id;
		this.buttonCode = buttonCode;
		this.buttonName = buttonName;
		this.menu_id = menu_id;
		this.note = note;
	}

	@Override
	public String toString() {
		return "Button{" +
			"id='" + id + '\'' +
			", buttonCode='" + buttonCode + '\'' +
			", buttonName='" + buttonName + '\'' +
			", menu_id='" + menu_id + '\'' +
			", note='" + note + '\'' +
			'}';
	}
}
