# CryptApp *by Guilhem NESPOULOUS*
![Image Acceuil](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/acceuil.png) ![Image détails](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/details.png)
## Description :

CryptApp est une application mobile codée avec Java qui permet de consulter des informations mises à jour en temps réel sur de très nombreuses cryptomonnaies.
J'ai toujours été très interressé par les cryptomonnaies et donc cela m'a semblé être une bonne idée de créer une application qui permet de montrer leur valeur étant donné que cela varie beaucoup, ainsi que d'autres informations intéressantes.
La capitalisation sur les cryptomonnaies augmente constament ces dernères années pour atteindre 237 milliards de $ en 2020.

## Installation
Pour installer l'application il faut:
1. Disposer d'une version android >16. Affichage optimal des features avec une version >21.
2. Prendre la branche : [Final Release](https://github.com/Guilhemnespoulous/Projet-CryptApp/tree/FinalRelease)

## Api utilisée :
![Image Coinranking](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/Coinranking.png)

J'ai utilisé l'api "Coinranking". Cette API gratuite est très complète.
Le site web officiel de l'API est :
[Cliquez ici](https://coinranking.com/)

## Features :

![Image details3](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/details3.png)


* La page d'accueil comporte une RecyclerView qui contient une liste des différentes cryptomonnaies.
Il y est indiqué leur nom , leur symbole ainsi que leur logo quand il est disponible sur le site.

* Quand on clique sur une cryptomonnaie, des détails sont affichés concernant cette dernière: Son nom(1), son logo(2), sa valeur en $(3), son rang(4) (classement par capitalisation), le site web officiel de la monnaie(5), une description de la monnaie(6).

* On peut remarquer que la couleur de la fenêtre des détails s'adapte à la coueleur officielle de la cryptomonnaie fournie par l'api(7). Par exemple pour le bitcoin la fenêtre prend des colorations orange (barre de notification et de navigation)

* L'utilisateur peur cliquer sur la flèche(8) qui apparaît dans la barre suppérieure afin de revenir à la page d'accueil s'il le souhaite.

## Elements techniques :

* Ecran avec liste d'éléments

![Image acceuil2](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/accueil2.png)

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


## Utilisation du GitFlow

J'ai utilisé gitFlow afin de simplifier la gestion des versions et des features de ce projet.

![Image gitflow](https://raw.githubusercontent.com/Guilhemnespoulous/Projet-CryptApp/master/images/gitflow.png)