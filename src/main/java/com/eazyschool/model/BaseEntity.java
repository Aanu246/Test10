package com.eazyschool.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BaseEntity {
	private LocalDateTime createdAt;
	private String createdBy;
	private LocalDateTime updateAt;
	private String updatedBy;
	
	

}
