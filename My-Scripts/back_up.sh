#!/bin/bash
REPERTOIRE_SOURCE="/home/"
REPERTOIRE_DESTINATION="/sauvegarde/SauvHomeLieu/"
  
# Détecter la présence du volume de destination et interrompre l'opération si nécessaire
if [ ! -e "$REPERTOIRE_DESTINATION" ]
then
echo "Attention, le disque de sauvegarde n'est pas présent"
exit
fi
  
rsync -av --del --stats --filter "- .thumbnails/" --filter "- .Trash/" --filter "- *.tmp" --filter "- *.iso" --filter "- lost+found/" --filter "- .cache/" --filter "- .beagle/" $REPERTOIRE_SOURCE "$REPERTOIRE_DESTINATION"
  
echo "La commande de sauvegarde a terminé son travail..."
echo "Vérifiez dans le terminal s'il n'y a pas eu d'erreur !"
