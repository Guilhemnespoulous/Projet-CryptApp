# CryptApp
![Image Acceuil](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/acceuil.png) ![Image détails](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/details.png)
## Description :

CryptApp est une application mobile codée avec Java qui permet de consulter des informations mises à jour en temps réel sur de très nombreuses cryptomonnaies.
J'ai toujours été très interressé par les cryptomonnaies et donc cela m'a semblé être une bonne idée de créer une application qui permet de montrer leur valeur étant donné que cela varie beaucoup, ainsi que d'autres informations intéressantes.
La capitalisation sur les cryptomonnaies augmente constament ces dernères années pour atteindre 237 milliard de $ en 2020.

## Installation
Pour installer l'application il faut:
1. Disposer d'une version android >16. Affichage optimal des features avec une version >21.
2. Prendre la branche :[Final Release](https://coinranking.com/)

## Api utilisée :
![Image Coinranking](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/Coinranking.png)

J'ai utilisé l'api "Coinranking" cette API gratuite est très complète.
Le site web officiel de l'API est :
[Cliquez ici](https://coinranking.com/)

## Features :
* La page d'accueil comporte une RecyclerView qui contiens une liste des différentes cryptomonnaies.
Il y est indiqué leur nom, leur symbole ainsi que leur logo quand il est disponible sur le site.

* Quand on clique sur une cryptomonnaie, des détails sont affichés concernant cette dernière: Son nom, son logo, sa valeur, son rang (classement par capitalisation), le site web officiel de la monnaie, une description de la monnaie.

* On peut remarquer que la couleur de la fenêtre des détails s'adapte à la coueleur officielle de la cryptomonnaie fournie par l'api. Par exemple pour le bitcoin la fenêtre prend des colorations orange (barre de notification et de navigation)

* L'utilisateur peur cliquer sur la flèche qui apparaît dans la barre suppérieure afin de revenir à la page d'accueil si il le souhaite.

## Elements techniques :

* Ecran avec liste d'éléments
![Image acceuil2](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/acceuil2.png)

* Ecran avec le détail d'un élément sélectionné
![Image Détail2](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/detail2.png)

* Appel à une API rest [Coinranking](https://coinranking.com/)
* Stockage des données en cache
![Image Cache](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/cache.png)

* Architecture en MVC
![Image mvc](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/mvc.png)

* Respect des principes SOLID

* Utilisation de Singletons (classe Injection)
![Image singletons](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/singletons.png)


## Urilisation du GitFlow