package controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import repositories.Configs;
import repositories.Request;
import repositories.StringRegistros;

@Controller
public class Ativos {

	private String recurso = "ativos/";
	
	@RequestMapping("/ativos")
	public ModelAndView index(Model model) {
	
		Request req = new Request();
		String resposta = req.listar( Configs.getBaseUrl()+recurso );
		StringRegistros stringRegistros = new StringRegistros(resposta);
		ArrayList<String[]> lista = stringRegistros.getListaRegistros();
		
		model.addAttribute("lista",lista);
		
		return new ModelAndView("ativos");
	}
	
	@RequestMapping("/deletarAtivo/{id}")
	public String deletarAtivo(@PathVariable("id") int id) {
		
		Request req = new Request();
		String resposta = req.delRequest(Configs.getBaseUrl()+recurso+id);
		
		return "redirect:/ativos";
		
	}
	
}
