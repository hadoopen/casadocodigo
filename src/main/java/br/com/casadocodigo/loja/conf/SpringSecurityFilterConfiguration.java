package br.com.casadocodigo.loja.conf;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

//Boa pratica extender a classe com a configuração padrão para podermos alterar algumas
//coisa depois se precisarmos
public class SpringSecurityFilterConfiguration extends AbstractSecurityWebApplicationInitializer{

}
