package br.com.ufv.provaConceito.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.ufv.provaConceito.Models.User;
import br.com.ufv.provaConceito.Service.UserService;


@Controller
public class LoginFrontController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");

		return modelAndView;
	}

	@RequestMapping(value = { "/registro" }, method = RequestMethod.GET)
	public ModelAndView cadastroRepublica() {
		User user = new User();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user",user);
		modelAndView.setViewName("cadastroUsuario");

		return modelAndView;
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
		User userExists = userService.findUserByUsername(user.getNomeUsuario());

		if (userExists != null) {
			bindingResult.rejectValue("nomeUsuario", "error.user",
					"*Já existe um usuário com esse nome");
		}
		
		if (!user.getSenha().equals(user.getConfirmacaoSenha())) {
			bindingResult.rejectValue("confirmacaoSenha", "error.user", "*As senhas não conferem");
		}
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("cadastroUsuario");
		} else {
			user.setConfirmacaoSenha(""); // Não precisa salvar o pass confirmado
			userService.saveUser(user);
//			modelAndView.addObject("successMessage", "Usuario foi registrado com sucesso!");
//			modelAndView.addObject("user", new User());
			modelAndView.setViewName("redirect:/login");

		}
		return modelAndView;
	}

}
