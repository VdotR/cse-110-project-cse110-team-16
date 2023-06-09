package com.example.cse110_team16_project.Database;

public class MockResponseBodyBuilder {


    public static class Get{
        private String latitude = "";
        private String longitude = "";
        private String label = "";
        private String public_code = "";

        public Get(){}

        public Get addLatitude(String latitude){
            this.latitude = latitude;
            return this;
        }

        public Get addLongitude(String longitude){
            this.longitude = longitude;
            return this;
        }

        public Get addLabel(String label){
            this.label = label;
            return this;
        }

        public Get addPublicCode(String public_code){
            this.public_code = public_code;
            return this;
        }

        public String build(){
            return "{" + "latitude: \"" + latitude + "\"," +
                    "longitude: \"" + longitude + "\"," +
            "label: \"" + label + "\"," +
                    "public_code: \"" + public_code + "\"}";

        }
    }
    public static String Not_Found(){
        return "{\n" +
                "  \"detail\": \"Location not found.\"\n" +
                "}";
    }
}
