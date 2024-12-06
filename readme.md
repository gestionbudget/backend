# GestionBudget

GestionBudget est une application web basée sur Spring Boot qui permet de gérer des transactions financières.

## Table des Matières

- [Prérequis](#prérequis)
- [Installation](#installation)
- [Architecture du Projet](#architecture-du-projet)
- [API REST](#api-rest)
- [Lancement de l'Application](#lancement-de-lapplication)
- [Test de l'Application](#test-de-lapplication)
- [Contribution](#contribution)

## Prérequis

- Java 21 ou supérieur
- Maven 3.6+ ou Gradle 6+
- NeonPostgreSQL 

## Installation

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/gestionbudget/backend.git

2. Accédez au répertoire du projet :
   ```bash
   cd gestionbudget
   ```

3. Configurez votre base de données (ajustez `application.properties` pour vos paramètres).

## Architecture du Projet

- `elzo.dev.gestionbudget`: Contient la classe principale `GestionbudgetApplication`.
- `data.entities`: Contient les entités JPA du projet.
- `data.repositories`: Contient les interfaces des dépôts pour les accès aux données.
- `data.services`: Contient les services métier.
- `data.TransactionController`: Gère les appels API pour les transactions.

## API REST

Le projet expose des endpoints RESTful pour gérer les transactions.

- `POST /transactions`: Ajouter une nouvelle transaction.
- `GET /transactions`: Récupérer toutes les transactions.
- `GET /transactions/{id}`: Récupérer une transaction par ID.
- `PUT /transactions/{id}`: Mettre à jour une transaction par ID.
- `DELETE /transactions/{id}`: Supprimer une transaction par ID.
- `GET /transactions/balance`: Récupérer le solde total des transactions.

## Lancement de l'Application

Assurez-vous que votre base de données est crée.

Pour démarrer l'application :

```bash
mvn spring-boot:run
```

## Test de l'Application

Pour exécuter les tests, utilisez :

```bash
mvn test


## En cas deContribution

1. Fork du projet
2. Créez votre branche de fonctionnalité (`git checkout -b feature/AmazingFeature`)
3. Commitez vos changements (`git commit -m 'Add some AmazingFeature'`)
4. Poussez vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrez une demande de tirage (pull request)

