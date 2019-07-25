package com.studies;

import java.util.List;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.studies.DAO.ProduitRepository;
import com.studies.entities.Produit;

@SpringBootApplication
public class SpringStudiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(SpringStudiesApplication.class, args);
		
		ProduitRepository pr = ctx.getBean(ProduitRepository.class);
		
		String[] marque = {"Dell","HP","Sony","Tochiba","IBM","Nokia"};
		String[] produit= {"Ordinateur","Laptop","Ecrant","Imprimante","Telephone portable","Disk dure"};
		
		
		for(int i = 0; i<5; i++) pr.save(new Produit(produit[ (int)(Math.random() * 5)]+" "+marque[ (int)(Math.random() * 5)],(int) (Math.random() * 74020 + 7500), (int)(Math.random() * 50 + 1)));
		
		List<Produit> lstPrd = pr.findAll();
		for(Produit prd:lstPrd) {
			System.out.println(prd.getDesignation());
		}
	}

}
