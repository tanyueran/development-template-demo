package com.github.tanyueran.entity;

import javax.validation.constraints.NotEmpty;

// 角色
public class Role {
	// 主键
	@NotEmpty(message = "id不可为空")
	private String id;

	@NotEmpty(message = "角色code值不可为空")
	private String roleCode;

	@NotEmpty(message = "角色名称不可为空")
	private String roleName;

	@NotEmpty(message = "角色说明")
	private String note;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Role() {
	}

	public Role(@NotEmpty(message = "id不可为空") String id, @NotEmpty(message = "角色code值不可为空") String roleCode, @NotEmpty(message = "角色名称不可为空") String roleName, @NotEmpty(message = "角色说明") String note) {
		this.id = id;
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.note = note;
	}

	@Override
	public String toString() {
		return "Role{" +
			"id='" + id + '\'' +
			", roleCode='" + roleCode + '\'' +
			", roleName='" + roleName + '\'' +
			", note='" + note + '\'' +
			'}';
	}
}
