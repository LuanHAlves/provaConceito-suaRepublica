package br.com.ufv.provaConceito.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ufv.provaConceito.Models.Republica;



@Controller
public class RepublicaController {
	
	@RequestMapping(value = { "/cadastroRepublica" }, method = RequestMethod.GET)
	public ModelAndView cadastroRepublica() {
		Republica republica = new Republica();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("republica",republica);
		modelAndView.setViewName("cadastroRepublica");

		return modelAndView;
	}
	
	@RequestMapping(value = {"/cadastroRepublica"}, method = RequestMethod.POST)
	public ModelAndView cadastrarRepublica(@Valid Republica republica, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		modelAndView.addObject(auth.getName());
//		modelAndView.setViewName("cadastroRepublica");
		modelAndView.setViewName("redirect:/cadastroRepublica");
		
//		if(!bindingResult.hasErrors()) {
//			user.addFornecedor(fornecedor);
//			entityManager.merge(user);
//			redirectAttributes.addFlashAttribute("message", "Fornecedor cadastrado com sucesso.");
//		    redirectAttributes.addFlashAttribute("alertClass", "alert-success");
//		    
//			modelAndView.setViewName("redirect:/fornecedores/cadastrar");
//
//		}
//		else {
//			redirectAttributes.addFlashAttribute("message", "Verifique os campos e tente novamente.");
//		    redirectAttributes.addFlashAttribute("alertClass", "alert-warning");
//			modelAndView.setViewName("cadastro-fornecedores");
//		}
		
		return modelAndView;
	}

}
