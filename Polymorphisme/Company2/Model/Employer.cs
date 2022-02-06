using System;

namespace Model
{
    public class Employer : Personne
    {
        private int salaire;
        public Employer(string name, string prenom, Date date, int salaire) : base(name, prenom, date)
        {
            this.salaire = salaire;
        }
        public int getSalaire()
        {
            return this.salaire;
        }

        public override void displayInfo()
        {
            Console.WriteLine("["+"Titre: "+"Employer"+"] "+base.ToString()+"["+"Salaire: "+salaire+"]"+" ");
        }
    }
    
}