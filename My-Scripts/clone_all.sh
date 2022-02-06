#!/bin/bash

git_repo_name=("Humbug-Terminal-Version" "Polymorphisme" "My_Scrips" "Jeu_De_Carte" "Memory" "StrategoJavaVersion")

for name in ${git_repo_name[@]}; do

git clone https://github.com/JussyM/$name.git
done
