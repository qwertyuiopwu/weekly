package com.formssi.weekReportTool.person.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.formssi.weekReportTool.person.domain.PersonData;
import com.formssi.weekReportTool.person.domain.Person;
import com.formssi.weekReportTool.person.domain.Response;
import com.formssi.weekReportTool.person.service.PersonService;

@Controller
@RequestMapping("person/")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("getPersonData")
	@ResponseBody
	public PersonData getPersonData() {
		
		return personService.getPerson();
	}
	@GetMapping("perPerson")
	public String perPerson(Model model) {
		PersonData p = personService.getPerson();
		model.addAttribute("personData", p);
		return "person/person";
	}
	
	@PostMapping("submitPerson")
	@ResponseBody
	public Response submitPerson(Model model,PersonData personData) {
		PersonData pd = new PersonData();
		pd.setSum(personData.getSum());
		pd.setDept(personData.getDept());
		List<Person> person = new ArrayList<>();
		if(personData.getPerson()!=null) {
			for(Person p:personData.getPerson()) {
				if(p!=null) {
					if((p.getEmail()!=null && p.getName()!=null) && (!p.getEmail().equals("") && !p.getName().equals(""))) {
						person.add(p);
					}				
				}
			}
		}
		
		pd.setPerson(person);
		/*
		 * System.out.println(personData); System.out.println(pd);
		 */
	
		Boolean flag = personService.update(pd); 
		Response response = new Response();
		if(flag) {
			response.setCode(200);
			response.setMsg("提交成功");
		}else {
			response.setCode(500);
			response.setMsg("提交失败");
		}
		return response;
	}
}
