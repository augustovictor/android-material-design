package com.augustovictor.mdesign.Model;

import com.augustovictor.mdesign.R;

import java.util.ArrayList;

/**
 * Created by victoraweb on 5/26/16.
 */
public class Landscape {
    private int imageId;
    private String title;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static ArrayList<Landscape> getData() {
        ArrayList<Landscape> dataList = new ArrayList<>();

        int[] images = getImages();

        for(int i = 0; i < images.length; i++) {
            Landscape landscape = new Landscape();
            landscape.setImageId(images[i]);
            landscape.setTitle("land" + i);
            dataList.add(landscape);
        }

        return dataList;
    }

    public static int[] getImages() {
        int[] images = {
//                R.drawable.tb0, R.drawable.tb2, R.drawable.tb3, R.drawable.tb4, R.drawable.tb5, R.drawable.tb6, R.drawable.tb7, R.drawable.tb8, R.drawable.tb9, R.drawable.tb10,
//                R.drawable.tb11, R.drawable.tb12, R.drawable.tb13, R.drawable.tb14, R.drawable.tb15
                R.drawable.sample1, R.drawable.sample2, R.drawable.sample3, R.drawable.sample4, R.drawable.sample5, R.drawable.sample6, R.drawable.sample7, R.drawable.sample8,
                R.drawable.sample9, R.drawable.sample10
        };

        return images;
    }
}
