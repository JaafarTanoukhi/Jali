package com.jali.endpoints.Auth;

public class AuthModels {
    
    public class SignupBody{
        public String name;
        public String age;
    }
    
    public class SingnupResponse{
        public String name;
        public boolean hasSignedup;
        
    }
}
