package com.travlerrr.hqweather.mvp.model.entity;

import java.util.List;

//搜索城市的返回值
public class SearchCityEntity {


    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean {
        /**
         * basic : [{"cid":"CN101210106","location":"余杭","parent_city":"杭州","admin_area":"浙江","cnty":"中国","lat":"30.42118645","lon":"120.30173492","tz":"+8.00","type":"city"},{"cid":"CN101210101","location":"杭州","parent_city":"杭州","admin_area":"浙江","cnty":"中国","lat":"30.28745842","lon":"120.15357971","tz":"+8.00","type":"city"},{"cid":"CN10121010103A","location":"杭州极地海洋公园","parent_city":"杭州","admin_area":"杭州","cnty":"中国","lat":"30.13999939","lon":"120.22000122","tz":"+8.00","type":"scenic"},{"cid":"CN10121010802A","location":"杭州龙门古镇","parent_city":"杭州","admin_area":"杭州","cnty":"中国","lat":"29.89999962","lon":"119.94000244","tz":"+8.00","type":"scenic"},{"cid":"CN10121010803A","location":"杭州野生动物世界","parent_city":"杭州","admin_area":"杭州","cnty":"中国","lat":"30.13999939","lon":"119.98000336","tz":"+8.00","type":"scenic"},{"cid":"CN101230705","location":"上杭","parent_city":"龙岩","admin_area":"福建","cnty":"中国","lat":"25.05001831","lon":"116.42477417","tz":"+8.00","type":"city"},{"cid":"BW933759","location":"杭济","parent_city":"杭济","admin_area":"杭济区","cnty":"博茨瓦纳","lat":"-21.70100021","lon":"21.64599991","tz":"+2.00","type":"city"},{"cid":"CN101080709","location":"杭锦旗","parent_city":"鄂尔多斯","admin_area":"内蒙古","cnty":"中国","lat":"39.83178711","lon":"108.7363205","tz":"+8.00","type":"city"},{"cid":"CN10121010109A","location":"西湖","parent_city":"杭州","admin_area":"杭州","cnty":"中国","lat":"30.23999977","lon":"120.13999939","tz":"+8.00","type":"scenic"},{"cid":"CN10121010702A","location":"浙西大峡谷","parent_city":"杭州","admin_area":"杭州","cnty":"中国","lat":"30.19000053","lon":"119.12000275","tz":"+8.00","type":"scenic"}]
         * status : ok
         */

        private String status;
        private List<BasicBean> basic;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<BasicBean> getBasic() {
            return basic;
        }

        public void setBasic(List<BasicBean> basic) {
            this.basic = basic;
        }

        public static class BasicBean {
            /**
             * cid : CN101210106
             * location : 余杭
             * parent_city : 杭州
             * admin_area : 浙江
             * cnty : 中国
             * lat : 30.42118645
             * lon : 120.30173492
             * tz : +8.00
             * type : city
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;
            private String type;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
