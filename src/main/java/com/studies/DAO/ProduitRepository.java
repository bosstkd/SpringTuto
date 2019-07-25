package com.studies.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
