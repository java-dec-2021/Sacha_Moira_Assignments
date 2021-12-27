package com.sacha.languages.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;

@Entity
@Table(name="languages")
public class Languages {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
    private Long id;
	
	@Size(min = 2, max = 20, message="Language should be between 2-200")
	private String languageName;
	
	@NotEmpty
	private String creatorName;
	private String version;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}
