using System;

namespace Model
{
    public class Chef : Employer
    {
        private String service;

        public Chef(string name, string prenom, Date date, int salaire, string service) : 
            base(name, prenom, date, salaire)
        {
            this.service = service;
        }

        public override void displayInfo()
        {
            Console.WriteLine("["+"Titre: "+"Chef"+"] "+base.ToString()+"["+"Service: "+service+"]"+" ");
        }

        public String getService()
        {
            return this.service;
        }
    }
    
}