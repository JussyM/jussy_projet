
using System;

namespace Model
{
    class Program
    {
       public static Personne[] init()
        {
            var arrayOfPersonnes = new Personne[8];
            arrayOfPersonnes[0] = new Directeur("Midedji",
                "Juste", new Date(14, 10, 1997), 
                500000,"DG","JJCOM");
            arrayOfPersonnes[1] = new Chef("lola", "cul",
                new Date(10, 2, 2020), 5000, "haloa");
            arrayOfPersonnes[2] = new Chef("kdo", "alagbe",
                new Date(10, 2, 2020), 5000, "Fainéant");
            var j = 0;
            for (var i = 3; i < arrayOfPersonnes.Length; i++)
            {
                arrayOfPersonnes[i] = new Employer(nom()[j], prenom()[j], dates()[j], salaires()[j]);
                j++;
            }

            
            
            return arrayOfPersonnes;
        }

       public static void printWithFor(Personne[] personnes)
        {
            for (var i = 0; i < personnes.Length; i++)
            {
                personnes[i].displayInfo();
            }
        }
       public static void printWithForEach(Personne[] personnes)
        {
            foreach (var t in personnes)
            {
                t.displayInfo();
            }
        }

       private static String[] nom()
       {
           return new[] {"KUNTAKINTE", "DUPUIS", "DUPOND", "DUMONT", "DUCON"};
       }
       private static String[] prenom()
       {
           return new[] {"Lola", "PasLola", "STEPHANE", "PasStephane", "Ricardo"};
       }
       private static Date[] dates()
       {
           return new[] {new Date(10, 05, 2020), 
               new Date(11, 05, 2020), new Date(12, 10, 1998), 
               new Date(18,09,1897),new Date(01,10,1996)};
       }

       private static int[] salaires()
       {
           return new[] {1000, 1000, 500, 558, 2255};
       }
        
    }

}
