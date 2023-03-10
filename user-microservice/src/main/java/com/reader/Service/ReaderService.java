package com.reader.Service;

import com.reader.Entity.Reader;

public interface ReaderService {
	public Reader createReader(Reader reader);
	public Reader getReaderbyremailid(String remailid);
	public Reader getReaderbyReaderid(Integer Readerid);

}
