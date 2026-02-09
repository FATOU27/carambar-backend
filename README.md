Carambar  Application de Blagues

Mini application web permettant d’afficher, ajouter et consulter des blagues Carambar.
Projet Full-Stack : Spring Boot (API) + Angular (Front) + MySQL

Déploiement

 Frontend (GitHub Pages)
 https://fatou27.github.io/carambar-front/
 Backend API (Render)
 https://carambar-backend-rwtz.onrender.com/api/blagues
 Swagger  Documentation API
 https://carambar-backend-rwtz.onrender.com/swagger-ui/index.html
 
 Fonctionnalités
 
 Côté Client (Angular)
Affichage d’une blague aléatoire
Affichage de la liste complète
Ajout d'une nouvelle blague
Image de fond personnalisée

Côté Serveur (Spring Boot)

Endpoints REST :
GET /api/blagues affiche la liste des blagues
GET /api/blagues/random pour blague aléatoire
GET /api/blagues/{id} pour la  recherche par ID
POST /api/blagues pour  l'ajout d’une blague

Documentation Swagger
CORS configuré
Connection MySQL avec Railway
Technologies utilisées

Frontend
Angular 17
TypeScript
GitHub Pages (déploiement)
HTML / CSS

Backend
Java 17
Spring Boot 3
Spring Data JPA
Hibernate
MySQL Railway
Swagger / OpenAPI
Render (hébergement)

Installation locale

Backend
git clone https://github.com/FATOU27/carambar-backend.git
cd carambar-backend
mvn spring-boot:run

Frontend
git clone https://github.com/FATOU27/carambar-front.git
cd carambar-front
npm install
ng serve
