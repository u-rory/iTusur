    package com.example.gpo;

    import android.content.Context;
    import android.content.SharedPreferences;
    import android.net.ConnectivityManager;
    import android.net.NetworkInfo;
    import android.os.AsyncTask;
    import android.os.Bundle;
    import android.support.v4.app.Fragment;
    import android.support.v4.app.FragmentManager;
    import android.support.v4.app.FragmentTransaction;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Toast;

    import com.example.gpo.Data.Day;
    import com.example.gpo.db.DatabaseHandler;

    import org.jsoup.Jsoup;
    import org.jsoup.nodes.Document;
    import org.jsoup.nodes.Element;
    import org.jsoup.select.Elements;
    import java.io.IOException;
    import java.util.Calendar;
    import java.util.Date;

    public class podgruzon extends Fragment {
        View rootView;
        private static final String PREFS_FILE = "Account";
        private static final String PREF_NAME = "Name";
        private static final String PREF_FAC = "Faculty";
        SharedPreferences settings;
        DatabaseHandler db;
        public Elements content2,content3,content4,content5,day1,day2,day3,day4,day5,day6;
        int week;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_podgruzon, container, false);
            db = new DatabaseHandler(getContext());
            return rootView;
        }
        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            if(isOnline()) {
                Date date = new Date();
                Calendar currentCalendar = Calendar.getInstance();
                currentCalendar.setTime(date);
                int Date = currentCalendar.get(Calendar.DAY_OF_MONTH);
                int Month = currentCalendar.get(Calendar.MONTH);
                int Year = currentCalendar.get(Calendar.YEAR);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.set(Calendar.DAY_OF_MONTH, Date);
                calendar.set(Calendar.YEAR, Year);
                calendar.add(Calendar.MONTH, Month + 1);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(date);
                calendar2.set(Calendar.DAY_OF_MONTH, 30);
                calendar2.set(Calendar.YEAR, 2010);
                calendar2.add(Calendar.MONTH, 8);
                long diff = calendar.getTimeInMillis() - calendar2.getTimeInMillis();
                long seconds = diff / 1000;
                long minutes = seconds / 60;
                long hours = minutes / 60;
                long days = hours / 24;
                week = (int) (days / 7) + 1;
                podgruzon.ParseTitle parseTitle = new podgruzon.ParseTitle();
                parseTitle.execute();
            }
            else
            {
                Toast.makeText(getActivity(), "Connection problem", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.content, new timetable()).commit();
            }
        }
        public class ParseTitle extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... arg) {
                db.deleteAllDay();
                Document doc;
                try {
                    settings = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
                    String name = settings.getString(PREF_NAME, "545");
                    String fac = settings.getString(PREF_FAC, "fvs");
                    for (int i = 0; i < 2; i++) {
                        if (week % 2 != 0) {
                            if (i == 0) {
                                doc = Jsoup.connect("https://timetable.tusur.ru/faculties/" + fac + "/groups/" + name + "?week_id=" + week).get();
                            } else {
                                doc = Jsoup.connect("https://timetable.tusur.ru/faculties/" + fac + "/groups/" + name + "?week_id=" + (week + 1)).get();
                            }
                        } else {
                            if (i == 1) {
                                doc = Jsoup.connect("https://timetable.tusur.ru/faculties/" + fac + "/groups/" + name + "?week_id=" + week).get();
                            } else {
                                doc = Jsoup.connect("https://timetable.tusur.ru/faculties/" + fac + "/groups/" + name + "?week_id=" + (week + 1)).get();
                            }
                        }
                        content2 = doc.select("div.training > span.group");
                        content3 = doc.select("div.training > span.auditoriums");
                        content4 = doc.select("div.training > span.kind");
                        content5 = doc.select("div.training > span.discipline");
                        day1 = doc.select("td.lesson_cell.day_1");
                        day2 = doc.select("td.lesson_cell.day_2");
                        day3 = doc.select("td.lesson_cell.day_3");
                        day4 = doc.select("td.lesson_cell.day_4");
                        day5 = doc.select("td.lesson_cell.day_5");
                        day6 = doc.select("td.lesson_cell.day_6");
                        int dayc = 0;
                        int countday=0;

                        String[][] raspis = new String[42][2];
                        String[][] raspis2 = new String[84][5];
                        for (Element contents : day1) {
                            if (dayc < 7) {
                                raspis[countday][0] = contents.text();
                                dayc++;
                                countday++;
                            }
                        }
                        dayc = 0;
                        for (Element contents : day2) {
                            if (dayc < 7) {
                                raspis[countday][0] = contents.text();
                                dayc++;
                                countday++;
                            }
                        }
                        dayc = 0;
                        for (Element contents : day3) {
                            if (dayc < 7) {
                                raspis[countday][0] = contents.text();
                                dayc++;
                                countday++;
                            }
                        }
                        dayc = 0;
                        for (Element contents : day4) {
                            if (dayc < 7) {
                                raspis[countday][0] = contents.text();
                                dayc++;
                                countday++;
                            }
                        }
                        dayc = 0;
                        for (Element contents : day5) {
                            if (dayc < 7) {
                                raspis[countday][0] = contents.text();
                                dayc++;
                                countday++;
                            }
                        }
                        dayc = 0;
                        for (Element contents : day6) {
                            if (dayc < 7) {
                                raspis[countday][0] = contents.text();
                                dayc++;
                                countday++;
                            }
                        }
                        int daycformini = 0;
                        for (Element hz : content2) {
                            if (daycformini <42) {
                                raspis2[daycformini][0] = hz.text();
                                daycformini++;
                            }
                        }
                        daycformini = 0;
                        for (Element hz : content3) {
                            if (daycformini < 42) {
                                raspis2[daycformini][1] = hz.text();
                                daycformini++;
                            }
                        }
                        daycformini = 0;
                        for (Element hz : content4) {
                            if (daycformini < 42) {
                                raspis2[daycformini][2] = hz.text();
                                daycformini++;
                            }
                        }
                        daycformini = 0;
                        for (Element hz : content5) {
                            if (daycformini < 42) {
                                raspis2[daycformini][3] = hz.text();
                                daycformini++;
                            }
                        }
                        int g=0;
                        for (int dayc2 = 0; dayc2 < 42; dayc2++)
                        {
                            if(!raspis[dayc2][0].contains("Нет занятий")) {
                                db.addDay(new Day(raspis2[g][3], raspis2[g][2], raspis2[g][1], raspis2[g][0]));
                                g++;
                            }
                            else
                            {
                                db.addDay(new Day("Нет занятий", "Нет занятий", "Нет занятий", "Нет занятий"));
                            }

                    }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (getFragmentManager() != null) {
                    if (getFragmentManager().beginTransaction() != null) {
                        getFragmentManager().beginTransaction().replace(R.id.content, new timetable()).commit();
                    }
                }
            }
        }
        public boolean isOnline() {
            ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnectedOrConnecting();
        }
    }
