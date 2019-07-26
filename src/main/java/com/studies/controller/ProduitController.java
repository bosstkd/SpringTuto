package com.studies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studies.DAO.ProduitRepository;
import com.studies.entities.Produit;

@Controller
public class ProduitController {
	
	@Autowired
	private ProduitRepository pr;
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		
		List<Produit> prdList = pr.findAll();
		
		model.addAttribute("listProduit", prdList);
		
		return "produits";
	}
	
	
}
