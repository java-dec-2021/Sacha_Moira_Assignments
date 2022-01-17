package com.sacha.dojoAndNinjas.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="dojos")
public class Dojos {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
    private Long id;
	
	@Size(min = 2, max = 20, message="Language should be between 2-200")
	private String dojoName;
	
	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninjas> ninjas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDojoName() {
		return dojoName;
	}
	public void setDojoName(String dojoName) {
		this.dojoName = dojoName;
	}
}
