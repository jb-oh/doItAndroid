package com.jeongbaeoh.constlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity {

    MonthAdapter adapter;
    TextView monthText;
    GridView monthView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        monthText = (TextView) findViewById(R.id.monthText);
        monthView = (GridView) findViewById(R.id.monthView);

        adapter = new MonthAdapter();
        monthView.setAdapter(adapter);

        monthText.setText(adapter.getCurYear()+"."+adapter.getCurMonth());

        Button monthPrev = (Button) findViewById(R.id.monthPrev);
        monthPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.setPrevMonth();
                adapter.notifyDataSetChanged();
                monthText.setText(adapter.getCurYear()+"."+adapter.getCurMonth());
            }
        });

        Button monthNext = (Button) findViewById(R.id.monthNext);
        monthNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.setNextMonth();
                adapter.notifyDataSetChanged();
                monthText.setText(adapter.getCurYear()+"."+adapter.getCurMonth());
            }
        });

    }

    class MonthAdapter extends BaseAdapter {
        MonthItem[] items;
        Calendar calendar;

        int firstDay;
        int lastDay;
        int curYear;
        int curMonth;

        public MonthAdapter() {
            items = new MonthItem[7 * 6];

            Date date = new Date();
            calendar = Calendar.getInstance();
            calendar.setTime(date);

            recalculate();
            resetDayNumbers();
        }

        public void setPrevMonth(){
            calendar.add(Calendar.MONTH, -1);

            recalculate();
            resetDayNumbers();
        }

        public void setNextMonth(){
            calendar.add(Calendar.MONTH, 1);

            recalculate();
            resetDayNumbers();
        }

        public int getCurYear() {
            return curYear;
        }

        public int getCurMonth() {
            return curMonth+1;
        }

        public void recalculate() {
            calendar.set(Calendar.DAY_OF_MONTH, 1);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            firstDay = getFirstDay(dayOfWeek);

            curYear = calendar.get(Calendar.YEAR);
            curMonth = calendar.get(Calendar.MONTH);
            lastDay = getLastDay();
        }

        public void resetDayNumbers() {
            String dayStr;
            for(int i=0; i<42; i++) {
                int dayNumber = (i+1) - firstDay;
                dayStr = String.valueOf(dayNumber);

                if(dayNumber < 1 || dayNumber > lastDay) {
                    dayStr = "";
                }

                items[i] = new MonthItem(dayStr);
            }
        }

        public int getFirstDay(int dayOfWeek) {
            int result = 0;
            if(dayOfWeek == Calendar.SUNDAY) {
                result = 0;
            } else if(dayOfWeek == Calendar.MONDAY) {
                result = 1;
            } else if(dayOfWeek == Calendar.TUESDAY) {
                result = 2;
            } else if(dayOfWeek == Calendar.WEDNESDAY) {
                result = 3;
            } else if(dayOfWeek == Calendar.THURSDAY) {
                result = 4;
            } else if(dayOfWeek == Calendar.FRIDAY) {
                result = 5;
            } else if(dayOfWeek == Calendar.SATURDAY) {
                result = 6;
            }
            return result;
        }

        public int getLastDay() {
            switch(curMonth) {
                case 0:
                case 2:
                case 4:
                case 6:
                case 7:
                case 9:
                case 11:
                    return 31;
                case 3:
                case 5:
                case 8:
                case 10:
                    return 30;
                case 1:
                    if(((curYear%4==0)&&(curYear%100!=0)) || (curYear%400==0)) {
                        return 29;
                    } else {
                        return 28;
                    }
                default:
                    return 0;
            }
        }

        @Override
        public int getCount() {
            return 42;
        }

        @Override
        public Object getItem(int i) {
            return items[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            MonthItemView view = null;
            if(convertView == null) {
                view = new MonthItemView(getApplicationContext());
            } else {
                view = (MonthItemView) convertView;
            }

            view.setDay(items[i].day);

            return view;

        }
    }
}
