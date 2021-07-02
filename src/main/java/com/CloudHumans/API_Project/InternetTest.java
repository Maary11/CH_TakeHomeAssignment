package com.CloudHumans.API_Project;

public class InternetTest {
    private float download_speed;
    private float upload_speed;

    public InternetTest(float download_speed, float upload_speed) {
        this.download_speed = download_speed;
        this.upload_speed = upload_speed;
    }

    public InternetTest() {
    }

    public float getDownload_speed() {
        return download_speed;
    }

    public void setDownload_speed(float download_speed) {
        this.download_speed = download_speed;
    }

    public float getUpload_speed() {
        return upload_speed;
    }

    public void setUpload_speed(float upload_speed) {
        this.upload_speed = upload_speed;
    }
}
