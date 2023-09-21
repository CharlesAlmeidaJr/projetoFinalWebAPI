package com.funtec.projetoFinalWebAPI.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class LoginForm {
	
	private String login;
	private String senha;

}
