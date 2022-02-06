using System;

namespace Model
{
   
    public class Date
    {
        public int getDay()
        {
            return this.day;
        }
        public int getMonth()
        {
            return this.month;
        }
        public int getYear()
        {
            return this.year;
        }
        private int day;
        private int month;
        private int year;

        public Date(int day, int month, int year)
        {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    
}