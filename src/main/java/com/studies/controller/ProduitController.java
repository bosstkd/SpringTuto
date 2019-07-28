package com.studies.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studies.DAO.ProduitRepository;
import com.studies.entities.Produit;

@Controller
public class ProduitController {
	
	@Autowired
	private ProduitRepository pr;
	/* 
	 //Solution 1
	@RequestMapping(value="/user/index")
	public String index(Model model) {
		
		List<Produit> prdList = pr.findAll();
		
		model.addAttribute("listProduit", prdList);
		
		return "produits";
	}
	*/
	/*
	//Solution 2
	@RequestMapping(value="/user/index")
	public String index(Model model,
						@RequestParam (name = "page", defaultValue = "0") int p,
						@RequestParam (name = "size", defaultValue = "5") int s) 
	{
		Page<Produit> prdPage = pr.findAll(new PageRequest(p, s));
		
		int[] nbPages = new int[prdPage.getTotalPages()];
		
		model.addAttribute("listProduit", prdPage.getContent());
		model.addAttribute("pageActuel",p);
		model.addAttribute("size",s);
		model.addAttribute("nbPages",nbPages);
		return "produits";
	}
	*/
	
	@RequestMapping(value="/user/index")
	public String index(Model model,
						@RequestParam (name = "page", defaultValue = "0") int p,
						@RequestParam (name = "size", defaultValue = "5") int s,
						@RequestParam (name = "motCle", defaultValue = "") String mc) 
	{
		Page<Produit> prdPage = pr.findByDesignation("%"+mc+"%", new PageRequest(p, s));
		
		int[] nbPages = new int[prdPage.getTotalPages()];
		
		model.addAttribute("listProduit", prdPage.getContent());
		model.addAttribute("pageActuel",p);
		model.addAttribute("size",s);
		model.addAttribute("nbPages",nbPages);
		model.addAttribute("mc",mc);
		return "produits";
	}
	
	@RequestMapping(value="/admin/delete", method =RequestMethod.GET)
	public String delete(Model model,
						@RequestParam (name = "id", defaultValue = "0") Long id,
						@RequestParam (name = "page", defaultValue = "0") int p,
						@RequestParam (name = "size", defaultValue = "5") int s,
						@RequestParam (name = "motCle", defaultValue = "") String mc) 
	{
		
		pr.delete(pr.findOne(id));
		Page<Produit> prdPage = pr.findByDesignation("%"+mc+"%", new PageRequest(p, s));
		
		//int[] nbPages = new int[prdPage.getTotalPages()];
		
		model.addAttribute("listProduit", prdPage.getContent());
		model.addAttribute("pageActuel",p);
		model.addAttribute("size",s);
		//model.addAttribute("nbPages",nbPages);
		model.addAttribute("mc",mc);
		return "redirect:/user/index?page="+p+"&size="+s+"&motCle="+mc;
	}
	
	
	@RequestMapping(value = "/admin/insert", method =RequestMethod.GET)
	public String formProduit(Model model) {
		
		model.addAttribute("produit", new Produit());
		
		return "FormProduit";
	}
	
	@RequestMapping(value = "/admin/save", method =RequestMethod.POST)
	public String insertion(@Valid Produit produit, BindingResult bindingResult) 
	{
		if(bindingResult.hasErrors())
			return "FormProduit";
		
		pr.save(produit);  
		return "Confirmation";
	}
	
	@RequestMapping(value = "/admin/update", method =RequestMethod.GET)
	public String update(Model model, Long id) 
	{
		Produit p = pr.findOne(id);
		model.addAttribute("produit", p);
		return "EditProduit";
	}
	
	//page par defaut
	@RequestMapping(value="/")
	public String home() {
		return "redirect:/user/index";
	}
	
	@RequestMapping(value = "/nonautoriser")
	public String nonAutoriser() 
	{
		
		return "pageNonAutoriser";
	}
	
	@RequestMapping(value = "/login")
	public String login() 
	{
		
		return "login";
	}
	
	
}
