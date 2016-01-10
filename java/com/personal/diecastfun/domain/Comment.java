package com.personal.diecastfun.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Comments")
public class Comment {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  
	  private String message;
	  private String username;
	  
	  public String getMessage() {
	    return message;
	  }
	
	  public void setMessage(String message) {
	    this.message = message;
	  }
	
	  public String getUsername() {
	    return username;
	  }
	
	  public void setUsername(String username) {
	    this.username = username;
	  }

}
