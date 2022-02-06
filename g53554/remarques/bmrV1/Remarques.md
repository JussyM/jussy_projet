# BMR

## Divers

- Git : **gitignore** a mettre à jour : le dossier `g53554/BMR/target` a été déposé sur le serveur git
- **attention** aux conventions de nommages des packages : https://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html
- Javadoc :  incomplète.Description des valeurs de retours et des paramètres absente

## Analyse de code

Commence par jeter un œil aux remarques générées par Intelliji dans la page index.html

Reviens-vers moi si il y a des remarques que tu ne comprends pas ou que tu ne trouves pas appropriées

## Vues

- j'aurai renommer l'attribut `nodeList` en `textFieldList` pour que ça soit plus parlant, si la liste ne contient que des `TextField`, la déclaration de la liste peut se transformer en `List<TextField>`, ce qui évite le casting dans la méthode `textFieldElem` de `MyVBox`
- l'alimentation de la liste déroulante peut se faire via `choiceBox.getItems().addAll(ActivityLevel.values());`
- afin d'améliorer la lisibilité et permettre une meilleure encapsulation, tu peux
  - transformer `public class MyHBox` en `public class MyHBox extends HBox`
  - dans le constructeur de `MyHbox` ajouter les grilles à l'instance courante via `getChildren().addAll(leftPane,rightPane);`
  - supprimer les méthodes `getLeftPane` et `getRightPane` de `MyHBox`
  - supprimer la ligen de la méthode `wrapHbox` de `MyVbox` :`hBox.getChildren().addAll(myHBox.getLeftPane(), myHBox.getRightPane());`
- Pourquoi avoir ajouté un bouton `Cancel` ?
- Pour respecter le principe d’encapsulation la classe `MyHBox`  ne doit pas retourner la liste de ses nœuds, il faudrait plutôt ajouter une méthode qui retourne une liste d'entiers ou de double ou de booléen ou ajouter des méthodes comme : 
  - int getHeight()
  - int getSize()
  - int getAge()
  - boolean isMan()