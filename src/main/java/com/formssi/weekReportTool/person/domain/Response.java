package com.formssi.weekReportTool.person.domain;

import java.io.Serializable;

import lombok.Data;
@Data
public class Response  implements Serializable{
	
	   private static final long serialVersionUID = 2848121507506141448L;
	   private int code;
	   private String msg;
	   private Object data;
	   

}
