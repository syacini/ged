package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.Bibliotheque;

@Repository
public interface BibliothequeRepository extends JpaRepository<Bibliotheque, Byte> {

}
