package com.example.springboot.Url;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequeteRepository extends JpaRepository<Requete,Long> {
}
