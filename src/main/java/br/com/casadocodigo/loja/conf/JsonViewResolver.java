package br.com.casadocodigo.loja.conf;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class JsonViewResolver implements ViewResolver {

	@Override
	public View resolveViewName(String arg0, Locale arg1) throws Exception {
		// TODO Auto-generated method stub
		
		MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
		mappingJackson2JsonView.setPrettyPrint(true);
		
		return mappingJackson2JsonView;
	}

}
