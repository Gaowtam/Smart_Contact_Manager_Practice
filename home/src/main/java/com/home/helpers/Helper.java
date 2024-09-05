package com.home.helpers;


import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class Helper {
    public static String getEmailOfLoggedInUser(Authentication authentication)
    {
        // Principal principal=(Principal)authentication.getPrincipal();

        // AuthenticationPrincipal principal=(AuthenticationPrincipal)authentication.getPrincipal();


        // if(principal instanceof OAuth2AuthenticatedPrincipal)
        if( authentication instanceof OAuth2AuthenticationToken)
        {
            var  aOAuth2AuthenticationToken=(OAuth2AuthenticationToken)authentication;
            var clientId=aOAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

            var oauth2User=(OAuth2User)authentication.getPrincipal();
            String userName="";

            if(clientId.equalsIgnoreCase("google"))
            {
                //sign with google

                System.out.println("Getting email from google");
                userName=oauth2User.getAttribute("email").toString();
            }

            else if(clientId.equalsIgnoreCase("github"))
            {
                //sign with github
                System.out.println("Getting email from github");

                userName=oauth2User.getAttribute("email")!=null?
                oauth2User.getAttribute("email").toString() : oauth2User.getAttribute("login").toString()+"@gmail.com";
            }

            //sign with facebook

            return userName;
        }
        else
        {
            System.out.println("Getting data from local database");
            // return principal.getName();
            return authentication.getName(); 
        }
    }
}
