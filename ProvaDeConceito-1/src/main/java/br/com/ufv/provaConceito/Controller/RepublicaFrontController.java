package br.com.ufv.provaConceito.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.ufv.provaConceito.Models.Republica;
import br.com.ufv.provaConceito.Models.User;
import br.com.ufv.provaConceito.Service.UserService;
import br.com.ufv.provaConceito.repository.RepublicaRepository;


@Controller
public class RepublicaFrontController {
	
	@Autowired
	RepublicaRepository republicaRepo;

	@Autowired
	UserService userService;
	
	@RequestMapping(value = {"/listaRepublica"}, method = RequestMethod.GET)
	public ModelAndView listaRepublica() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<Republica> republicas = republicaRepo.getRepublicaRepository();
		
		modelAndView.addObject("republicas", republicas);
		modelAndView.setViewName("listaRepublica");
		return modelAndView;
		
	}
	
	
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());
		
		ModelAndView modelAndView = new ModelAndView();
		
		republicaRepo.querySave(republica.getId(),
								republica.getEmail(), 
								republica.getEndereco(), 
								republica.getLotacao(), 
								republica.getNome(), 
								republica.getValorAluguel(), 
								republica.getValorDespesas(),
								user.getId()
		);
		modelAndView.setViewName("redirect:/cadastroRepublica");
		
		/*
		 * - INICIO
		 * Imprime no console as republicas cadastrados no banco de dados.
		 * -->não tem ligacao com o front-end.
		 */
		List<Republica> republicas = republicaRepo.getRepublicaRepository();
		System.out.println("Lista de Republicas no BD");
		
		for (Republica _republica : republicas) {
			System.out.printf("Proprietario: %s - Nome: %s - Email: %s\n\n", 
							  _republica.getUser().getNomeUsuario(),
							  _republica.getNome(),
							  _republica.getEmail()
			);
		}
		/*
		 * - FIM 
		 */
		
		
		return modelAndView;
	}
}
