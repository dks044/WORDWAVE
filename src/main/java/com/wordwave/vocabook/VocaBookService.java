package com.wordwave.vocabook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.wordwave.voca.VocaDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VocaBookService {
	private final VocaBookRepository vocaBookRepository;
	
	//DTO를 VocaBook으로
	public void create(VocaBookDTO vocaBookDTO) {
		VocaBook vb = VocaBook.builder()
						.name(vocaBookDTO.getName())
						.imageURL(vocaBookDTO.getImageURL())
						.build();
		vocaBookRepository.save(vb);
	}
	
	
	public Map<Long,String> getVocaBookNameList(){
		Map<Long,String> vocaBookNames = new HashMap<>();
		List<VocaBook> vocaBookList = vocaBookRepository.findAll();
		for(VocaBook vb : vocaBookList) vocaBookNames.put(vb.getId(), vb.getName());
		return vocaBookNames;
	}
	
	public List<VocaBookDTO> getVocaBookDTOList(){
		List<VocaBookDTO> vocaBookDTOList = new ArrayList<>();
		Map<Long,String> vocaBookNames = getVocaBookNameList();
		for(Map.Entry<Long,String> entry : vocaBookNames.entrySet()) {
			Long key = entry.getKey(); String value = entry.getValue();
			Optional<VocaBook> vocaBook = vocaBookRepository.findById(key);
			VocaBookDTO vb = VocaBookDTO.builder()
									    .id(key)
									    .name(value)
									    .imageURL(vocaBook.get().getImageURL())
									    .build();
			vocaBookDTOList.add(vb);
		}
		return vocaBookDTOList;
	}
	
	public VocaBookDTO getCategoriesOfVocaBook(long vocaBookId) {
	    List<String> categories = vocaBookRepository.findCategoriesByVocaBookId(vocaBookId);
	    VocaBook vocaBook = vocaBookRepository.findById(vocaBookId).get();
	    
	    // 숫자 부분을 기준으로 정렬하는 커스텀 Comparator 정렬((chapter1, chapter2, chapter3 ..)
	    //TODO: 정렬이 필요한 단어장에 사용.
	    Comparator<String> customComparator = new Comparator<String>() {
	        @Override
	        public int compare(String o1, String o2) {
	            int number1 = extractNumber(o1);
	            int number2 = extractNumber(o2);
	            return Integer.compare(number1, number2);
	        }
	        
	        // 문자열에서 숫자 부분만 추출하는 메소드
	        private int extractNumber(String category) {
	            String number = category.replaceAll("\\D+", ""); // 숫자가 아닌 문자를 제거
	            return Integer.parseInt(number);
	        }
	    };
	    
	    
	    if(vocaBook.getName().equals("BASIC")) {
	    	// 커스텀 Comparator를 사용하는 TreeSet (chapter1, chapter2, chapter3 ..)
	    	Set<String> distinctCategories = new TreeSet<>(customComparator);	    	
	    }
	    Set<String> distinctCategories = new TreeSet<>();	
	    distinctCategories.addAll(categories);
	    for(String category : categories) distinctCategories.add(category);
	    String name = vocaBookRepository.findById(vocaBookId).get().getName();
	    VocaBookDTO vocaBookDTO = VocaBookDTO.builder()
	    						.id(vocaBookId)
	    						.name(name)
	    						.categories(distinctCategories)
	    						.build();
	    return vocaBookDTO;
	}
	
	

}
