package com.reader.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reader.Entity.Reader;

@Repository
public interface ReaderRepo extends JpaRepository<Reader, Integer> {
	
	Reader findByremailid(String remailid);
	
	

}
