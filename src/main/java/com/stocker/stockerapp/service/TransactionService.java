package com.stocker.stockerapp.service;

import com.stocker.stockerapp.entities.*;

import java.util.List;

public interface TransactionService {

	List<Fournisseur> getFournissseur();

	Achats saveAchats(Achats achats);
	List<Categorie> getAllCategories();
	Fournisseur saveFournisseur(Fournisseur fournisseur);
	Categorie saveCategorie(Categorie catagorie);
	Categorie getCategorieByDescription(String desc);
	List<Client> getClients();
	Client saveClient(Client client);


	Credit saveCredit(Credit credit);
	List<Credit> getClientCredits(Client client);
	List<Credit> getFournisseurCredits( Fournisseur fournisseur);
	List<Credit> getClientsCredits();
	List<Credit> getFournisseursCredits();


	Ventes saveVentes(Ventes ventes);

	List<Achats> getAllAchats();

	Fournisseur getFournisseurById(long id);

	List<Ventes> getAllVentes();

	Client getClientById(long id);

	List<Produit> getAllProduits();

	List<Fournisseur> getFournisseurByProduitId(Long id);




}