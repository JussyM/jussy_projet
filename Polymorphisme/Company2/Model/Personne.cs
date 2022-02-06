using System;

namespace Model
{
    public class Personne
    {
        
            private String name;
            private String prenom;
            private Date _date;

            public Personne(string name, string prenom, Date date)
            {
                this.name = name;
                this.prenom = prenom;
                _date = date;
            }

            public override string ToString()
            {
                return "["+"Nom: "+name+" "+"Prenom: "+prenom+" "+" Date of Birth: "
                       + _date.getDay()+"/"+_date.getMonth()+"/"+_date.getYear()+"]"+" ";
            }

            public virtual void displayInfo()
            {
                Console.WriteLine(this.ToString());
            }
    }
}