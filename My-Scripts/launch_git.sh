#!/bin/bash
#la fonction principal qui lance toute les commandes de git en fonctions des demandes
function main
{
echo -e "\033[36mTaper  u pour exécuter une seul commande de git ou a pour faire un depôt git complet\033[0m"
read ans
if [ $ans == "u" ]
then
lancerCmdGit
elif [ $ans == "a" ]
then
depotGit
else
echo -e "input non valable erreur fin programme"
fi
exit
}
#La fonction pour faire la part des choses entre un dépôt git classique ou un nouveau dépôt
function depotGit
{
echo -e "\033[36mNouveau dépôt Y/N:\033[0m "
read ans
if [ $ans == "y" ]
then
firstRepository
else [ $ans == "n" ]
depotGitClassic
fi
}
#la fonction pour lancer une seul commande git 
function lancerCmdGit
{
echo -e "c pour un add et commit"
echo -e "p1 pour un pull"
echo -e "p2 pour un push"
echo -e "r pour un remote"
read ans
case $ans in
c)
git add . && git commit
;;
p1)
git pull
;;
r)
echo -e "lien git"
read link
git remote add origin $link
;;
p2)
git push 
;;
*)
echo -e "input non valable erreur fin programme"
;;
esac
exit
}
#fonction pour le premier dépot 
function firstRepository
{
git init
git add .	
echo -e "\033[32mnom user du dépôt distant"
read userName
git config --global user.name $userName
echo -e "\033[32memail dépôt"
read email
git config --global user.email $email
echo -e "\033[32mconfig reussie...\033[0m"
git commit -a
echo -e "\033[32mCommit successfull\033[0m "
echo -e "\033[32mlien du dépôt git [par defaut le le dépôt se fera sur la branche master]\033[0m"
read link
git remote add origin $link
echo -e "\033[32mlancement du premier push vers le dépôt\033[0m"
sleep 1
git push -u origin master
echo -e "fin"
exit
}

function depotGitClassic
{
echo -e "lance des commandes git..."
git add . && git commit -a
echo -e "\033[32mgit add et commit réussi\033[0m\033[0m "
echo -e "\033[36mUn pull est-il nécessaire Y/N: \033[0m "
read ans2
if [ $ans2 == "y" ]
then
echo -e "\033[36mLien de votre dépôt git:\033[0m "
read path1
git pull $path1 
else [ $ans2 == "n" ]
echo -e "\033[36mRecherche de votre lien git ...\033[0m "
sleep 2
git push $path
echo -e "\033[32mPull successfull\033[0m "
fi
}

#appel de la fonction main 
main
