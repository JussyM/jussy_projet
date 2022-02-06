#!/bin/bash
#dezipper un fichier dans un dossier et le supprimer après le fichier zip bien sur :)
echo -n "nom du dossier: "
read source
read $*
if mkdir $source
mv $* $source
cd $source
then
unzip $*
rm -rf *$*
fi
