package net.dummy.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name = DummyEntity.NAMED_QUERY_FINDALL_NAME, query = DummyEntity.NAMED_QUERY_FINDALL_JPQL),
		@NamedQuery(name = DummyEntity.NAMED_QUERY_BY_NAME_NAME, query = DummyEntity.NAMED_QUERY_BY_NAME_JPQL),
})
@Table(name = "DUMMY")
public class DummyEntity extends AbstractEntity {
	
	public static final String NAMED_QUERY_FINDALL_NAME			= "DUMMY_FINDALL";
	public static final String NAMED_QUERY_FINDALL_JPQL			= "SELECT d FROM DummyEntity d";
	
	public static final String NAMED_QUERY_BY_NAME_NAME			= "DUMMY_BY_NAME";
	public static final String NAMED_QUERY_BY_NAME_JPQL			= "SELECT d FROM DummyEntity d WHERE d.name =:name ";
	
	public static final String PARAMETER_NAME 		= "name";
	
	public static final String COLUMN_NAME_NAME			= "NAME";
	public static final String COLUMN_NAME_DESCRIPTION 	= "DESCRIPTION";
	
	private String name;
	private String description;
	
	@Column(name = COLUMN_NAME_NAME)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = COLUMN_NAME_DESCRIPTION)
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
