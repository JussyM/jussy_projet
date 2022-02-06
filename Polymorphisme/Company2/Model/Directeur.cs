using System;

namespace Model
{
    public class Directeur : Chef
    {
        private String company;

        public Directeur(string name, string prenom, Date date, int salaire, string service, string company) : 
            base(name, prenom, date, salaire, service)
        {
            this.company = company;
        }

        public override void displayInfo()
        {
            Console.WriteLine("["+"Titre: "+"Directeur"+"] "+base.ToString()+"["+"Company: "+company+"]"+" ");
        }

        public String getCompany()
        {
            return this.company;
        }
    }
}