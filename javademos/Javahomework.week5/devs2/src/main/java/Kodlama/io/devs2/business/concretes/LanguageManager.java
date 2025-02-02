package Kodlama.io.devs2.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.devs2.business.abstracts.LanguageService;
import Kodlama.io.devs2.business.requests.CreateLanguageRequest;
import Kodlama.io.devs2.business.requests.DeleteLanguageRequest;
import Kodlama.io.devs2.business.requests.UpdateLanguageRequest;
import Kodlama.io.devs2.business.responses.languageResponses.GetAllLanguageResponse;
import Kodlama.io.devs2.business.responses.languageResponses.GetByIdLanguageResponse;
import Kodlama.io.devs2.dataAccess.LanguageRepository;
import Kodlama.io.devs2.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;
	private Integer id;
	public LanguageManager(LanguageRepository languageRespository) {
		
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
List<Language> languages = languageRepository.findAll();
List<GetAllLanguageResponse> languageResponses = new ArrayList<>();

for(Language language : languages) {
	GetAllLanguageResponse response = new GetAllLanguageResponse();
	response.setName(language.getName());
	languageResponses.add(response);
}
return languageResponses;
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		Language language = languageRepository.findById(id).get();
		GetByIdLanguageResponse response = new GetByIdLanguageResponse();
		response.setName(language.getName());
		return response;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		if(languageExistValidator(createLanguageRequest) && LanguageNameValidator(createLanguageRequest)) {
			Language language = new Language();
			language.setName(createLanguageRequest.getName());
			languageRepository.save(language);
			
		}
		
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		languageRepository.deleteById(deleteLanguageRequest.getId());
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		if(!updateLanguageRequest.getName().isEmpty()) {
			Language language = languageRepository.findById(id).get();
			language.setName(updateLanguageRequest.getName());
			languageRepository.save(language);
		}
		
	}
	public boolean LanguageNameValidator(CreateLanguageRequest createLanguageRequest) {
		if(createLanguageRequest.getName().isEmpty())
			System.out.println("Programlama ismi boş olamaz.");
		return !createLanguageRequest.getName().isEmpty();	}
	public boolean languageExistValidator(CreateLanguageRequest createLanguageRequest) {
		for(Language tempLanguage : languageRepository.findAll()) {
			
		if
		(tempLanguage.getName().equalsIgnoreCase(createLanguageRequest.getName())) {
			System.out.println("Bu dil mevcut.");
			return false;
		}
		
		
	}
		return true;

	}
}
