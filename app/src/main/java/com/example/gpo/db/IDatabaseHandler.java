package com.example.gpo.db;

import com.example.gpo.Data.Day;
import com.example.gpo.Data.NEWSS;

import java.util.List;


public interface IDatabaseHandler {
        public void addDay(Day day);
        public void addNews(NEWSS newss);
        public List<Day> getAllDay();
        public List<NEWSS> getAllNews();
        public void deleteAllNews();
        public void deleteAllDay();
        public int getDaysCount();
        public int getNewsCount();
}
