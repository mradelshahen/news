package com.example.newsapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, List<News> newsList) {
        super(context, 0, newsList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        News currentNews = getItem(position);


        ImageView imageView = listItemView.findViewById(R.id.img);
        String formattedImage = currentNews.getmImg();
        URL url = null;
        try {
            url = new URL(formattedImage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp;
        if (url != null) {
            try {
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                imageView.setImageBitmap(bmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        TextView categoryView = listItemView.findViewById(R.id.category);
        String formattedCategory = currentNews.getmCategory();

        categoryView.setText(formattedCategory);

        TextView aboutView = listItemView.findViewById(R.id.about);
        String formattedAbout = currentNews.getmAbout();

        aboutView.setText(formattedAbout);

        TextView contributorView = listItemView.findViewById(R.id.date);
        String formattedContributor = currentNews.getmContributor();

        String date = currentNews.getmDate();


        String input = date.substring(0, 10);
        SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat sdfOut = new SimpleDateFormat("mm-dd-yyyy");
        Date date1 = null;
        try {
            date1 = sdfIn.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = sdfOut.format(date1);


        if (formattedContributor != null && !formattedContributor.isEmpty()) {
            String authordate = ("by " + formattedContributor + "  /  " + formattedDate);
            contributorView.setText(authordate);
        } else {
            contributorView.setText(formattedDate);
        }


        return listItemView;
    }
}
