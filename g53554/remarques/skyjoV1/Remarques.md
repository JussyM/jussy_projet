# Skyjo - Remise 1

## Divers

- Git : gitignore à revoir, le dossier target est déposé sur le serveur 
- ajoute un fichier ReadMe afin de décrire ton projet/dépôt
- **attention** aux conventions de nommages des packages (le package Skyjo) : https://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html
- Javadoc : en ordre
- traduction du mot défausse : https://www.wordreference.com/fren/d%C3%A9fausse
- réfléchi à la visibilité à accorder aux différentes méthodes : `public`, `private`, `protected` ou `package` ?

## Analyse de code

Commence par jeter un œil aux remarques générées par Intelliji dans la page index.html

Reviens-vers moi si il y a des remarques que tu ne comprends pas ou que tu ne trouves pas appropriées

## View

- `SkyjoVBox`, `MiddlePane`, ``PlayerGridPane`` devrait vérifier que son paramètre n'est pas null

- pour la méthode `createVbox` n'est pas gérée par le constructeur ? Y-a-t-il une raison ?

- j'ai l'impression que dans ton design `PlayerGridPane` est plus `VBox` que `GridPane`

- `localGridPane` pourrait être une classe à part entière, sa construction semble occuper par mal de lignes de code

- afin de définir une taille fixe pour tes boutons, tu peux utiliser les méthodes suivantes :

  - ```
    button.setMinSize(90, 130);
    button.setMaxSize(90, 130);
    ```

## Model

- `Deck`
  - pourquoi la méthode `return12Card` n'enlève pas les cartes de la liste principale?  j'ai l'impression que ça simplifierai la classe `Game`
- `Game`
  - les accesseur doivent retourner des copies défensives
- `Player`
  - le constructeur devrait vérifier que le paramètre n'est pas null ou vide
