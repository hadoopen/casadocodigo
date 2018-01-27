package br.com.casadocodigo.loja.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;

//atribuindo mapeamento do quem vend da url com /products
//usando esse mapeamento todos os metodos ja conhecem no RequestMapping o /products
//isso server para não termos que ficar repetindo o /products em todos os métodos
//Exemplo métodos form, ao invés de digitar /products/form, digitamos apenas /form
//automaticamente o eclipse coloca antes o produts, ai fica products/form por tras dos panos

@RequestMapping("/products")
@Controller
public class ProductsController {
	
	@Autowired //Entrega uma instancia do objeto ProducDAO
	private ProductDAO productDao = new ProductDAO();
	
 
	@Autowired
	private FileSaver fileSaver;
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public ModelAndView form(Product product){
		
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("types",BookType.values());
		
		System.out.println("teste");
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@Transactional
	@CacheEvict(value="lastProducts",allEntries=true)
	public ModelAndView save(MultipartFile summary,
			@Valid Product product,
			BindingResult results,
			RedirectAttributes attr){
			
		
		if(results.hasErrors()){
			return form(product);
		}
		
		
		String webPath = fileSaver.write("uploaded-summaries",summary);
		product.setSummaryPath(webPath);
		
		
//		ModelAndView modelAndView = new ModelAndView("redirect:products");
	//	attr.addFlashAttribute("msg","Produto Salvo com Sucesso");
		productDao.save(product);
		
		//System.out.println("Cadastrando o produto: " + product);
		//return modelAndView;
		attr.addFlashAttribute("sucesso","Produto cadastrado com sucesso");
		return new ModelAndView("redirect:products");
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@Cacheable(value="lastProducts")
	public ModelAndView list(){
		
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("produtos",productDao.list());
		
		return modelAndView;
	}
	
 
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public ModelAndView show(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("products/show");
		modelAndView.addObject("product",productDao.find(id));
		return modelAndView;
	}
	
	
}
