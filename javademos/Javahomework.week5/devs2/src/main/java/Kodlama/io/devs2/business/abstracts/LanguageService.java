package Kodlama.io.devs2.business.abstracts;

import java.util.List;

import Kodlama.io.devs2.business.requests.CreateLanguageRequest;
import Kodlama.io.devs2.business.requests.DeleteLanguageRequest;
import Kodlama.io.devs2.business.requests.UpdateLanguageRequest;
import Kodlama.io.devs2.business.responses.languageResponses.GetAllLanguageResponse;
import Kodlama.io.devs2.business.responses.languageResponses.GetByIdLanguageResponse;

public interface LanguageService {
	List<GetAllLanguageResponse> getAll();
	GetByIdLanguageResponse getById(int id);
	void add(CreateLanguageRequest createLanguageRequest); 
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest);
}
