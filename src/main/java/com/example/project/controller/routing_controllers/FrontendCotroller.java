package com.example.project.controller.routing_controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendCotroller {

    @GetMapping("/public/index.html")
    public String getStartPage1() {
        return "/index.html";
    }

    @GetMapping("/public/settings")
    public String getSettingsPage1(){
        return "/Settings_Of_Page.html";
    }

    @GetMapping("/public/Settings_Of_Page.html")
    public String getSettingsPage2(){
        return "/Settings_Of_Page.html";
    }

    @GetMapping("/public/profile.html")
    public String getProfilePage(){
        return "/Profile.html";
    }

    @GetMapping("/public/Documentation.html")
    public String getDocumentationPage(){
        return "/Documentation.html";
    }

    @GetMapping("/public/Friends.html")
    public String getMessangerPage(){
        return "/Friends.html";
    }

    @GetMapping("/public/Planner.html")
    public String getPlannerPage(){
        return "/Planner.html";
    }

    @GetMapping("/public/FriendGallery.html")
    public String getFriendGalleryPage(){
        return "/FriendGallery.html";
    }

    @GetMapping("/public/Map.html")
    public String getMapPage(){
        return "/Map.html";
    }

    @GetMapping("/public/onesProfile.html")
    public String getOnesProfile(){
        return "/onesProfile.html";
    }

    @GetMapping("/public/PhotoPage.html")
    public String getPhotoPage(){
        return "/PhotoPage.html";
    }

    @GetMapping("/public/SavedFiles.html")
    public String getSavedFiles(){
        return "/SavedFiles.html";
    }

    @GetMapping("/public/VisitGalleryOfFriend.html")
    public String getVisitGalleryOfFriend(){
        return "/VisitGalleryOfFriend.html";
    }

    @GetMapping("/public/admin.html")
    public String getAdminPage(){
        return "/VisitGalleryOfFriend.html";
    }

}
