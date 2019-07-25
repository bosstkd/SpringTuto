package com.studies;

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
		
		
		
		pr.save(new Produit("Pc portable",(int) (Math.random() * 74020 + 7500), (int)(Math.random() * 50 + 1)));
		pr.save(new Produit("Imprimante HP",(int) (Math.random() * 74020 + 7500), (int)(Math.random() * 50 + 1)));
		pr.save(new Produit("Huawei Modem",(int) (Math.random() * 74020 + 7500), (int)(Math.random() * 50 + 1)));
		pr.save(new Produit("Huawei Y6",(int) (Math.random() * 74020 + 7500), (int)(Math.random() * 50 + 1)));
		
		
		
	}

}
