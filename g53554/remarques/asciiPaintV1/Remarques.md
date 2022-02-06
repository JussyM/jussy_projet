# AsciiPaint

## Divers

- Git : **gitignore** incomplet, dossier target présent sur le dépôt
- Javadoc :  incomplète. En-tête de classe absent. Les phrases commencent par des majuscules et se terminent et par des points dans la documentation. Description de la méthode `newRectangle` absente.
- **attention** aux conventions de nommages des packages : https://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html
- Pourquoi avoir supprimé le fichier des remarques du blackJack ?

## Controller

- certains attributs ont une visibilité package, quelle en est l'utilité ?
- gestion des erreurs étrange (la gestion du catch) : 
  - si je crée un cercle correctement et que j'appuie sur show, le programme affiche le cercle et s'arrête
  - si je fais une erreur lors de mon encodage d'un cercle, et qu'ensuite  je crée un cercle correctement et que j'appuie sur show, le programme affiche le cercle mais ne s'arrête pas
- tous les point sont des centre d'après le nom des variables ?
- pourquoi un casting est nécessaire  : `paperDrawing.printShape((Paper) paper);`, comment s'en passer ?

## Model

- on peut construire un cercle dont le rayon est négatif (ou nulle)
- on peut construire un rectangle dont la longueur/largeur est négative (ou nulle)
- je ne suis pas convaincu que les caractères 0 représentant l'absence de forme permettent une bonne visualisation
- 

## View

- la variable string dans la méthode `match` porte à confusion à la première lecture, un nom du type `regex` améliorait la lisibilité
- j'ai l'impression que la génération de la regex apporte plus de complexité que d'avantages, on pourrait  à chaque embranchement de la méthode `match` vérifiez directement le contenu de la variable input et retourner `false` en cas d'incohérences. Quels avantages as-tu perçus ?
- un test du type `if (instance.charAt(0) == 's' && instance.charAt(1) != 'h')` est sensible au modifications/ajouts sur le long terme. par exemple si tu ajoutes une commande qui se nomme `find shapeAt 2 2` ce test va devoir être modifié
- `stringConvertToInt` : l'utilisation d'une exception ignorée n'est pas conseillée, un test via une expression régulière serait pertinent dans ce cas
- `printShape` : ne devrait pas utiliser la méthode `toString` de la variable `paper`, te rappelles-tu pourquoi ?

## Analyse de code

Commence par jeter un œil aux remarques générées par Intelliji dans la page index.html

Reviens-vers moi si il y a des remarques que tu ne comprends pas ou que tu ne trouves pas appropriées

## Réflexion

Dans la classe `Point`, faut-il définir une méthode `boolean isLeftTo(Point other)` qui retourne vrai si le point est à gauche du point passé en paramètre ?

La méthode `isInside` de la classe `Rectangle` ne serait-elle pas plus simple ?

La responsabilisé de la classe `Point` sur ses attributs `x` et `y` ne serait-elle pas respectée de cette façon ?

## Fonctionnement

- afficher la liste des commandes autorisées aiderait l'utilisateur





