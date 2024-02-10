package com.training.redhat.ui;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


@ManagedBean(name = "hello", eager = true)
public class Hello 
{

	private String name;
    private String salary;
    private int age;
    
    private String res;
    
	public void validate()
    {
		
		User user = new User();
		user.setName(name);
		user.setSalary(salary);;
		user.setAge(age);
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		int flag=0;
		res="";
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		for (ConstraintViolation<User> violation : violations) {
		    res += violation.getMessage() + "; "; 
		    flag = 1;
		}	
		if(flag==0)
			res = "Validation Completed successfully...";
		
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
}
