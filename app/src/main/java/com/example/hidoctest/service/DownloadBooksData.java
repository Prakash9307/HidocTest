package com.example.hidoctest.service;

import android.app.Activity;
import android.app.ProgressDialog;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hidoctest.model.BookModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class DownloadBooksData
{

    Activity activity;
    onDownloadComplete listener;

    public DownloadBooksData(Activity activity,onDownloadComplete listener)
    {

        this.activity = activity;
        this.listener = listener;

    }

    public void downloadBook()
    {

        ArrayList<BookModel> al_books = new ArrayList<>();
        al_books.clear();

        final ProgressDialog pd = new ProgressDialog(activity);
        pd.setMessage("Downloading Books...");
        pd.show();

        String url = "https://www.googleapis.com/books/v1/volumes?q=quilting";

        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        StringRequest strReq = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONObject object = new JSONObject(response);
                            JSONArray array = object.getJSONArray("items");

                            for (int i=0;i<array.length();i++)
                            {
                                JSONObject root = array.getJSONObject(i);

                                JSONObject obj = root.getJSONObject("volumeInfo");
                                JSONObject img_links = null;
                                if (i!=8)
                                {
                                    img_links = obj.getJSONObject("imageLinks");
                                }
                                
                                String id = root.getString("id");
                                String kind = root.getString("kind");
                                String etag = root.getString("etag");
                                String title = obj.getString("title");
                                String subtitle = "";//obj.getString("subtitle");

                                JSONArray authors = obj.getJSONArray("authors");
                                String author = authors.get(0).toString();
//                                JSONObject auth = authors.getJSONObject(0);
                                String publisher = "";//obj.getString("publisher");
                                String publishdate = "";//obj.getString("publishedDate");
                                String desc = obj.getString("description");
                                String image = "";
                                if (i!=8)
                                {
                                    image = img_links.getString("smallThumbnail");
                                }
                                BookModel bookModel = new BookModel(id,kind,etag,title,
                                        subtitle,author,publisher,publishdate,desc,image);

                                al_books.add(bookModel);

                            }

                            if (al_books.size()>0)
                            {
                                listener.downloadComplete(al_books);
                            }
                            pd.dismiss();

                        }catch (Exception e)
                        {
                            listener.downloadFailed();
                            pd.dismiss();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        listener.downloadFailed();
                        System.out.println("ERROR=>"+error);
                        pd.dismiss();
                    }
                }
        );

        requestQueue.add(strReq);
    }


    public interface onDownloadComplete
    {
        void downloadComplete(ArrayList<BookModel>arrayList);
        void downloadFailed();
    }
}
