package com.wordwave.voca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface VocaRepository extends JpaRepository<Voca, Long>{

}
