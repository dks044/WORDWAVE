package com.wordwave.voca;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class VocaDAOImpl implements VocaDAO {

    
	private final VocaRepository vocaRepository;
	
	@Override
	public Voca createVoca(VocaDTO vocaDTO) {
	    Voca voca = new Voca();
	    voca.changeWord(vocaDTO.getKorWord(), vocaDTO.getEngWord());
	    voca.changeCategory(vocaDTO.getCategory());
	    return voca;
	}
	
	@Override
	public Voca save(Voca voca) {
	    return vocaRepository.save(voca);
	}

}
