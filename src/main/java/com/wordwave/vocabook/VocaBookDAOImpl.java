package com.wordwave.vocabook;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class VocaBookDAOImpl implements VocaBookDAO {

	VocaBookRepository vocaBookRepository;
    
    @Override
    public VocaBook findById(Long id) {
        return vocaBookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid VocaBook ID"));
    }

}
