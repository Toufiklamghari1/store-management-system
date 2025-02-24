package com.stocker.stockerapp.service;

import java.util.List;

import javax.validation.Valid;


import com.stocker.stockerapp.entities.*;
import com.stocker.stockerapp.repo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	FournisseurRepository fournisseurRepository;

	@Autowired
	LigneAchatRepository ligneAchatRepository;

	@Autowired
	AchatsRepository achatsRepository;

	@Autowired
	CategorieRepository categorieRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	VentesRepository ventesRepository;

	@Autowired
	LigneVenteRepository ligneVenteRepository;

	@Autowired
	CreditRepository creditRepository;


	@Override
	public List<Fournisseur> getFournissseur() {
		return fournisseurRepository.findAll();
	}

	@Override
	public Achats saveAchats(Achats achats) {
		logger.info("TransactionServiceImpl -> save Achat ...");
		Achats achatsSave = achatsRepository.save(achats);
		logger.info("TransactionServiceImpl -> Achat Lignes  ...");
		achats.getLigneAchats().forEach(achat->{
			achat.setAchats(achats);
			Produit produit = achat.getProduit();
			Produit produitToUpdate = productRepository.getById(produit.getIdProduit());
			produitToUpdate.setNbrArticles(produit.getNbrArticles()+achat.getQuantite());
			logger.info("TransactionServiceImpl -> Update produit  ... {}", produitToUpdate.getLibelle());
			productRepository.save(produitToUpdate);
			ligneAchatRepository.save(achat);
		});
		return achatsSave;
	}

	@Override
	public List<Categorie> getAllCategories() {
		logger.info("TransactionServiceImpl -> getAllCategories ...");
		return categorieRepository.findAll();
	}

	@Override
	public Fournisseur saveFournisseur(Fournisseur fournisseur) {
		logger.info("TransactionServiceImpl -> saveFournisseur ...");
		return fournisseurRepository.save(fournisseur);

	}

	@Override
	public Categorie saveCategorie(Categorie catagorie) {
		return categorieRepository.save(catagorie);

	}

	@Override
	public Categorie getCategorieByDescription(String desc) {
		return categorieRepository.findByDescription(desc);
	}

	@Override
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client saveClient(Client client) {
		logger.info("TransactionServiceImpl -> saveClient ...");
		return clientRepository.save(client);
	}

	@Override
	public Ventes saveVentes(Ventes ventes) {
		logger.info("TransactionServiceImpl -> save Achat ...");
		Ventes ventesSave = ventesRepository.save(ventes);
		logger.info("TransactionServiceImpl -> Achat Lignes  ... {}",ventes.getLigneVentes().size());
		ventes.getLigneVentes().forEach(vente->{
			vente.setVentes(ventes);
			Produit produit = vente.getProduit();
			Produit produitToUpdate = productRepository.getById(produit.getIdProduit());
			produitToUpdate.setNbrArticles(produit.getNbrArticles()-vente.getQuantite());
			logger.info("TransactionServiceImpl -> Update produit  ... {} ... after vente", produitToUpdate.getLibelle());
			//productRepository.save(produitToUpdate);
			ligneVenteRepository.save(vente);
		});
		return ventesSave;
	}

	@Override
	public Credit saveCredit(Credit credit) {
		return creditRepository.save(credit);
	}

	@Override
	public List<Achats> getAllAchats() {
		return achatsRepository.findAll();
	}

	@Override
	public Fournisseur getFournisseurById(long id) {
		return fournisseurRepository.getById(id);
	}

	@Override
	public List<Ventes> getAllVentes() {
		return ventesRepository.findAll();
	}

	@Override
	public Client getClientById(long id) {
		return clientRepository.getById(id);
	}

	@Override
	public List<Produit> getAllProduits() {
		return productRepository.findAll();
	}

	@Override
	public List<Fournisseur> getFournisseurByProduitId(Long id) {
		return fournisseurRepository.findByProduitId(id);
	}


	@Override
	public List<Credit> getClientCredits(Client client) {
		return creditRepository.findCreditByClient(client);
	}

	@Override
	public List<Credit> getFournisseurCredits(Fournisseur fournisseur) {
		return creditRepository.findCreditByFournisseur(fournisseur);
	}

	@Override
	public List<Credit> getClientsCredits() {
		return creditRepository.findCreditByClientNotNull();
	}

	@Override
	public List<Credit> getFournisseursCredits() {
		return creditRepository.findCreditByFournisseurNotNull();
	}


}