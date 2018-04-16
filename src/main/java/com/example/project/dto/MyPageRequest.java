package com.example.project.dto;

public class MyPageRequest {

    private int numberPage;

    private int sizePage;

    public MyPageRequest(){
    }

    public MyPageRequest(int numberPage, int sizePage) {
        this.numberPage = numberPage;
        this.sizePage = sizePage;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public int getSizePage() {
        return sizePage;
    }

    public void setSizePage(int sizePage) {
        this.sizePage = sizePage;
    }
}
