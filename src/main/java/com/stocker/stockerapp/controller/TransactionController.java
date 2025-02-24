package com.stocker.stockerapp.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;


import com.stocker.stockerapp.dto.*;
import com.stocker.stockerapp.entities.*;
import com.stocker.stockerapp.service.ProductService;
import com.stocker.stockerapp.service.TransactionService;
import com.stocker.stockerapp.utils.TransactionUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	TransactionService transactionService;

	@Autowired
	ProductService productService;

	@Autowired
	ModelMapper modelMapper;

//	@GetMapping("/getCients")
//	public List<ClientDTO> getClients(){
//		List<Client> clients = transactionService.getClient();
//		List<ClientDTO> clientsDTO = clients.stream()
//				.map(client -> modelMapper.map(client, ClientDTO.class))
//                .collect(Collectors.toList());
//
//		return clientsDTO;
//
//	}

	@GetMapping("/getFournisseurs")
	public List<FournisseurDTO> getFournisseurs(){
		logger.info("Start : getFournisseur");
		List<Fournisseur> fournisseurs = transactionService.getFournissseur();
		List<FournisseurDTO> clientsDTO = fournisseurs.stream()
				.map(four -> modelMapper.map(four, FournisseurDTO.class))
                .collect(Collectors.toList());
		logger.info("End : getFournisseur");
		return clientsDTO;
	}

	@GetMapping("/getClients")
	public List<ClientDTO> getClients(){
		logger.info("Start : getClients");
		List<Client> clients = transactionService.getClients();
		List<ClientDTO> clientsDTO = clients.stream()
				.map(client -> modelMapper.map(client, ClientDTO.class))
                .collect(Collectors.toList());
		logger.info("End : getClients");
		return clientsDTO;
	}

	@PostMapping(value = "/saveAchats", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AchatsDTO> saveAchats(@Valid @RequestBody Achats achats, BindingResult bindingResult  ) throws Exception   {
		if(bindingResult.hasErrors()) {
			logger.error("Error in saveAchats() : ", bindingResult.getAllErrors());
			return null;
		}else {
			try {
				String reference = TransactionUtils.preparReferenceAchats(achats.getAchatDate());
				achats.setReference(reference);
				Achats savedAchats = transactionService.saveAchats(achats);
				logger.info("save achat with reference : ---> "+savedAchats.getReference());
				AchatsDTO achatsDTO = modelMapper.map(savedAchats, AchatsDTO.class);
			    return ResponseEntity.ok(achatsDTO);
			}catch (Exception e) {
				e.getMessage();
				throw new NullPointerException();
			}
		}

	}



	@PostMapping(value = "/saveVentes", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<VentesDTO> saveVentes(@Valid @RequestBody Ventes ventes, BindingResult bindingResult  ) throws Exception  {
		if(bindingResult.hasErrors()) {
			logger.error("Error in saveAchats() : ", bindingResult.getAllErrors());
			return null;
		}else {
			try {
				String reference = TransactionUtils.preparReferenceVentes(ventes.getVenteDate());
				ventes.setReference(reference);
				Ventes savedVentes = transactionService.saveVentes(ventes);
				logger.info("save vente with reference : ---> "+savedVentes.getReference());
				VentesDTO ventesDTO = modelMapper.map(savedVentes, VentesDTO.class);
				return ResponseEntity.ok(ventesDTO);
			}catch (Exception e) {
				e.getMessage();
				throw new NullPointerException();
			}
		}

	}

	@PostMapping(value = "/saveProduit", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProduitDTO> saveProduit(@Valid @RequestBody Produit produit, BindingResult bindingResult  )  {
		if(bindingResult.hasErrors()) {
			logger.error("Error in saveAchats() : ", bindingResult.getAllErrors());
			return null;
		}else {

			String reference = TransactionUtils.preparReferenceProduit(new Date());
			produit.setReference(reference);
			Produit savedProduit = productService.saveProduit(produit);
			logger.info("save produit with reference : ---> "+savedProduit.getReference());
		    ProduitDTO produitDTO = modelMapper.map(savedProduit, ProduitDTO.class);
		    return ResponseEntity.ok(produitDTO);
		}

	}

	@GetMapping("/getAllCategories")
	public List<CategorieDTO> getAllCategories(){
		logger.info("Start : getAllCategories");
		List<Categorie> categorie = transactionService.getAllCategories();
		List<CategorieDTO>categorieDTO = categorie.stream()
				.map(cat -> modelMapper.map(cat, CategorieDTO.class))
                .collect(Collectors.toList());
		logger.info("End : getAllCategories");
		return categorieDTO;

	}

	@GetMapping("/getFournisseurByProduitId/{id}")
	public List<FournisseurDTO> getFournisseurByProduitId(@PathVariable(name = "id") Long id){
		logger.info("Start : getFournisseurByProduitId");
		List<Fournisseur> fournisseur = transactionService.getFournisseurByProduitId(id);
		List<FournisseurDTO> fournisseurDTO = fournisseur.stream()
				.map(four -> modelMapper.map(four, FournisseurDTO.class))
                .collect(Collectors.toList());
		logger.info("End : getFournisseurByProduitId");
		return fournisseurDTO;

	}

	@GetMapping("/getCategorieByDescription/{desc}")
	public CategorieDTO getCategorieByDescription(@PathVariable(name = "desc") String description){
		logger.info("Start : getCategorieByDescription {}",description);
		Categorie categorie = transactionService.getCategorieByDescription(description);
		//CategorieDTO categorieDTO = modelMapper.map(categorie, CategorieDTO.class);
		logger.info("End : getCategorieByDescription {}", categorie);
		return null;

	}

	@GetMapping("/getFournisseurById/{id}")
	public FournisseurDTO getFournisseurById(@PathVariable(name = "id") long id) {
		logger.info("Start : getFournisseurById {}",id);
		Fournisseur fournisseur = transactionService.getFournisseurById(id);
		FournisseurDTO fournisseurDTO = modelMapper.map(fournisseur, FournisseurDTO.class);
		logger.info("End : getFournisseurById {}", fournisseur);
		return fournisseurDTO;
	}

	@GetMapping("/getClientById/{id}")
	public ClientDTO getClientById(@PathVariable(name = "id") long id) {
		logger.info("Start : getClientById {}",id);
		Client client = transactionService.getClientById(id);
		ClientDTO clientDTO = modelMapper.map(client, ClientDTO.class);
		logger.info("End : getClientById ");
		return clientDTO;
	}



	@PostMapping("/saveFournisseur")
	public ResponseEntity<FournisseurDTO> saveFournisseur(@Valid @RequestBody Fournisseur fournisseur, BindingResult bindingResult) {
		logger.info("Start : saveFournisseur");
		if(bindingResult.hasErrors()) {
			logger.error("Error in saveFournisseur() : ", bindingResult.getAllErrors());
			return null;
		}else {
			logger.info("End : saveFournisseur");
			Fournisseur fournisseurSaved = transactionService.saveFournisseur(fournisseur);
			FournisseurDTO fournisseurDTO = new FournisseurDTO();
			fournisseurDTO = modelMapper.map(fournisseurSaved, FournisseurDTO.class);
		    return ResponseEntity.ok(fournisseurDTO);
		}
	}

	@PostMapping("/saveClient")
	public ResponseEntity<ClientDTO> saveClient(@Valid @RequestBody Client client, BindingResult bindingResult) {
		logger.info("Start : saveClient");
		if(bindingResult.hasErrors()) {
			logger.error("Error in saveClient() : ", bindingResult.getAllErrors());
			return null;
		}else {
			logger.info("End : saveClient");
			Client clientSaved = transactionService.saveClient(client);
			ClientDTO clientDTO = new ClientDTO();
			clientDTO = modelMapper.map(clientSaved, ClientDTO.class);
		    return ResponseEntity.ok(clientDTO);
		}
	}

	@PostMapping("/saveCategorie")
	public ResponseEntity<CategorieDTO> saveCategorie(@Valid @RequestBody Categorie catagorie, BindingResult bindingResult) {
		logger.info("Start : saveCategorie");
		if(bindingResult.hasErrors()) {
			logger.error("Error in saveCategorie() : ", bindingResult.getAllErrors());
			return null;
		}else {
			logger.info("End : saveCategorie");
			Categorie categorieSaved = transactionService.saveCategorie(catagorie);
			CategorieDTO categorieDTO = new CategorieDTO();
			categorieDTO = modelMapper.map(categorieSaved, CategorieDTO.class);
		    return ResponseEntity.ok(categorieDTO);
		}

	}

	@GetMapping("/getAllAchats")
	public List<AchatsDTO> getAllAchats(){
		logger.info("Start : getAllAchats");
		List<Achats> achats = transactionService.getAllAchats();
		List<AchatsDTO> achatsDTO = achats.stream()
				.map(achat -> modelMapper.map(achat, AchatsDTO.class))
                .collect(Collectors.toList());
		logger.info("End : getAllAchats");
		return achatsDTO;
	}

	@GetMapping("/getAllVentes")
	public List<VentesDTO> getAllVentes(){
		logger.info("Start : getAllVentes");
		List<Ventes> ventes = transactionService.getAllVentes();
		List<VentesDTO> ventesDTO = ventes.stream()
				.map(vente -> modelMapper.map(vente, VentesDTO.class))
                .collect(Collectors.toList());
		logger.info("End : getAllVentes");
		return ventesDTO;
	}

	@GetMapping("/getAllProduits")
	public List<ProduitDTO>  getAllProduits(){
		logger.info("Start : getAllProduits");
		List<Produit> produit = transactionService.getAllProduits();
		List<ProduitDTO> produitDTO = produit.stream()
				.map(prod -> modelMapper.map(prod, ProduitDTO.class))
                .collect(Collectors.toList());
		logger.info("End : getAllProduits");
		return produitDTO;
	}



	@PostMapping("/saveCredit")
	public ResponseEntity<CreditDTO> saveCredit(@Valid @RequestBody Credit creditline){
		Credit credit = transactionService.saveCredit(creditline);
		CreditDTO creditDTO;
		creditDTO = modelMapper.map(credit, CreditDTO.class);

		return ResponseEntity.ok(creditDTO);
	}

	@GetMapping("/getClientCredit")
	public ResponseEntity<List<CreditDTO>> getClientCredit(@Valid @RequestBody Client client){
			List<Credit> credits = transactionService.getClientCredits(client);
			List<CreditDTO> creditDTOS;
			creditDTOS = modelMapper.map(credits, List.class);
		return ResponseEntity.ok(creditDTOS);
	}

	@GetMapping("/getFournisseurCredit")
	public ResponseEntity<List<CreditDTO>> getFournisseurCredit(@Valid @RequestBody Fournisseur fournisseur){
		List<Credit> credits = transactionService.getFournisseurCredits(fournisseur);
		List<CreditDTO> creditDTOS;
		creditDTOS = modelMapper.map(credits, List.class);
		return ResponseEntity.ok(creditDTOS);
	}

	@GetMapping("/getCredits")
	public ResponseEntity<List<Credit>> getCredits(@Valid @RequestParam Boolean isClient){
		System.out.println(isClient);
		System.out.println("isClient");
		List<Credit> credits;
		if(isClient){
			credits = transactionService.getClientsCredits();
			System.out.println(credits.toString());
			return ResponseEntity.ok(credits);
		}else{
			credits = transactionService.getFournisseursCredits();
			System.out.println(credits.toString());
			return ResponseEntity.ok(credits);
		}
	}


	@GetMapping("/getClientCredits")
	public ResponseEntity<List<Credit>> getClientCredits(){
		List<Credit> credits = transactionService.getClientsCredits();
		System.out.println(credits.toString());
		return ResponseEntity.ok(credits);
	}

	@GetMapping("/getFournisseurCredits")
	public ResponseEntity<List<Credit>> getFournisseurCredits(){
		List<Credit> credits = transactionService.getFournisseursCredits();
		System.out.println(credits.toString());
		return ResponseEntity.ok(credits);
	}

	}