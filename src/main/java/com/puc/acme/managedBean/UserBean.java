package com.puc.acme.managedBean;

 

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
 
 
 
@Scope("session")
@Named
@ManagedBean(name="userBo")
public class UserBean{
 
	 
 
	public String printMsgFromSpring() {
		return "Anderson";
	}
 
}