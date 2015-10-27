package net.dummy.dto.dummy;

import net.dummy.dto.AbstractDto;

public class DummyDto extends AbstractDto {
	
	private static final long serialVersionUID = -5355029409818552541L;
	
	private String name;
	private String description;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
