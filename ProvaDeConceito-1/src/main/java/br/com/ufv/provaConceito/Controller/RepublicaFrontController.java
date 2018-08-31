package br.com.ufv.provaConceito.Controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.ufv.provaConceito.Models.Republica;
import br.com.ufv.provaConceito.repository.RepublicaRepository;


@Controller
public class RepublicaFrontController {
	
	@Autowired
	RepublicaRepository republicaRepo;
	
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
		republicaRepo.querySave(republica.getId(), republica.getEmail(), republica.getEndereco(), republica.getLotacao(), republica.getNome(), republica.getValorAluguel(), republica.getValorDespesas());
//		republicaRepo.save(republica);
		modelAndView.setViewName("redirect:/cadastroRepublica");
		
		
		return modelAndView;
	}

}
