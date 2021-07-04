package com.formssi.weekReportTool.person.domain;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("PersonData")
public class PersonData implements Serializable{
	
   private static final long serialVersionUID = 2848121507506557568L;
   @XStreamAsAttribute
   @XStreamAlias("sum")
   private String sum;//总人数
   @XStreamAsAttribute
   @XStreamAlias("dept")
   private String dept;//部门
   @XStreamImplicit(itemFieldName = "Person")
   private List<Person> person;
   
   
	
}
