package com.reader.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reader.Entity.Reader;
import com.reader.repo.ReaderRepo;

@Service
public class ReaderServiceImpl implements ReaderService {
	
	@Autowired
	private ReaderRepo readerRepo;

	@Override
	public Reader createReader(Reader reader) {
		Reader createReader = readerRepo.save(reader);
		return createReader;
	}

	@Override
	public Reader getReaderbyremailid(String remailid) {
		Reader reader = readerRepo.findByremailid(remailid);
		return reader;
	}

	@Override
	public Reader getReaderbyReaderid(Integer Readerid) {
		Reader reader = readerRepo.findById(Readerid).orElse(null);
		return reader;
	}

	
	

}
