package com.example.thenewipad.formatFolder;


import java.util.ArrayList;
import java.util.List;

public class BusStopRoute {

    /**
     * RouteUID : TXG1
     * RouteID : 1
     * RouteName : {"Zh_tw":"1","En":"1"}
     * Operators : [{"OperatorID":"15","OperatorName":{"Zh_tw":"中台灣客運","En":"Ct Bus Co., Ltd."},"OperatorCode":"CenterTaiwanBus","OperatorNo":"0401"},{"OperatorID":"3","OperatorName":{"Zh_tw":"統聯客運","En":"United Highway Bus Co., Ltd."},"OperatorCode":"UnitedHighwayBus","OperatorNo":"1201"}]
     * SubRouteUID : TXG1
     * SubRouteID : 1
     * SubRouteName : {"Zh_tw":"1","En":"1"}
     * Direction : 0
     * City : Taichung
     * CityCode : TXG
     * Stops : [{"StopUID":"TXG19262","StopID":"19262","StopName":{"Zh_tw":"臺中刑務所演武場","En":"Budokan Martial Arts Hall"},"StopBoarding":0,"StopSequence":1,"StopPosition":{"PositionLat":24.13478,"PositionLon":120.67383,"GeoHash":"wsmc61852"},"StationGroupID":"6212","LocationCityCode":"TXG"},{"StopUID":"TXG19234","StopID":"19234","StopName":{"Zh_tw":"忠孝國小","En":"Chung-Hsiao Elementary School"},"StopBoarding":0,"StopSequence":2,"StopPosition":{"PositionLat":24.137095,"PositionLon":120.674093333333,"GeoHash":"wsmc6400y"},"StationGroupID":"0210","LocationCityCode":"TXG"},{"StopUID":"TXG19233","StopID":"19233","StopName":{"Zh_tw":"臺中科大民生校區","En":"NTCUST(Minsheng Campus)"},"StopBoarding":0,"StopSequence":3,"StopPosition":{"PositionLat":24.138995,"PositionLon":120.676037,"GeoHash":"wsmc643eg"},"StationGroupID":"0209","LocationCityCode":"TXG"},{"StopUID":"TXG19229","StopID":"19229","StopName":{"Zh_tw":"臺中州廳","En":"Taichung Prefectural Hall"},"StopBoarding":0,"StopSequence":4,"StopPosition":{"PositionLat":24.1389604613,"PositionLon":120.678420067,"GeoHash":"wsmc6477e"},"StationGroupID":"4416","LocationCityCode":"TXG"},{"StopUID":"TXG19230","StopID":"19230","StopName":{"Zh_tw":"民權繼光街口","En":"Minquan-Jiguang Intersection"},"StopBoarding":0,"StopSequence":5,"StopPosition":{"PositionLat":24.137061,"PositionLon":120.680952,"GeoHash":"wsmc64j0t"},"StationGroupID":"4284","LocationCityCode":"TXG"},{"StopUID":"TXG7352","StopID":"7352","StopName":{"Zh_tw":"臺中車站(民族路口)","En":"Taichung Station(Minzu Intersection)"},"StopBoarding":0,"StopSequence":6,"StopPosition":{"PositionLat":24.136519,"PositionLon":120.683912,"GeoHash":"wsmc61zm6"},"StationGroupID":"6510","LocationCityCode":"TXG"},{"StopUID":"TXG6","StopID":"6","StopName":{"Zh_tw":"干城站","En":"Gancheng Station"},"StopBoarding":0,"StopSequence":7,"StopPosition":{"PositionLat":24.1410166666667,"PositionLon":120.686101666667,"GeoHash":"wsmc668zt"},"StationGroupID":"0402","LocationCityCode":"TXG"},{"StopUID":"TXG5","StopID":"5","StopName":{"Zh_tw":"臺中公園(雙十路)","En":"Taichung Park(Shuangshi Rd.)"},"StopBoarding":0,"StopSequence":8,"StopPosition":{"PositionLat":24.1440633333333,"PositionLon":120.686125,"GeoHash":"wsmc672cq"},"StationGroupID":"4544","LocationCityCode":"TXG"},{"StopUID":"TXG16189","StopID":"16189","StopName":{"Zh_tw":"中興堂","En":"Chunghsing Hall"},"StopBoarding":0,"StopSequence":9,"StopPosition":{"PositionLat":24.146258,"PositionLon":120.684481,"GeoHash":"wsmc65xy0"},"StationGroupID":"1513","LocationCityCode":"TXG"},{"StopUID":"TXG7","StopID":"7","StopName":{"Zh_tw":"國立臺中科技大學","En":"National Taichung University of Science and Techno"},"StopBoarding":0,"StopSequence":10,"StopPosition":{"PositionLat":24.1494683333333,"PositionLon":120.683925,"GeoHash":"wsmc6hr2g"},"StationGroupID":"0045","LocationCityCode":"TXG"},{"StopUID":"TXG20","StopID":"20","StopName":{"Zh_tw":"中友百貨","En":"Chungyo Department Store"},"StopBoarding":0,"StopSequence":11,"StopPosition":{"PositionLat":24.1525483333333,"PositionLon":120.685153333333,"GeoHash":"wsmc6kb4z"},"StationGroupID":"0046","LocationCityCode":"TXG"},{"StopUID":"TXG19","StopID":"19","StopName":{"Zh_tw":"一心市場","En":"Yixin Market"},"StopBoarding":0,"StopSequence":12,"StopPosition":{"PositionLat":24.1541983333333,"PositionLon":120.685866666667,"GeoHash":"wsmc6m0u2"},"StationGroupID":"0047","LocationCityCode":"TXG"},{"StopUID":"TXG18","StopID":"18","StopName":{"Zh_tw":"三民錦中街口","En":"Sanmin-Jinzhong Intersection"},"StopBoarding":0,"StopSequence":13,"StopPosition":{"PositionLat":24.1552783333333,"PositionLon":120.68695,"GeoHash":"wsmc6m3d9"},"StationGroupID":"0934","LocationCityCode":"TXG"},{"StopUID":"TXG17","StopID":"17","StopName":{"Zh_tw":"新民高中(三民路)","En":"Shin-min Senior High School(Sanmin Rd.)"},"StopBoarding":0,"StopSequence":14,"StopPosition":{"PositionLat":24.1563966666667,"PositionLon":120.688281666667,"GeoHash":"wsmc6md90"},"StationGroupID":"4399","LocationCityCode":"TXG"},{"StopUID":"TXG16","StopID":"16","StopName":{"Zh_tw":"寶覺寺","En":"Baojue Temple"},"StopBoarding":0,"StopSequence":15,"StopPosition":{"PositionLat":24.15782,"PositionLon":120.689946666667,"GeoHash":"wsmc6mg9x"},"StationGroupID":"0960","LocationCityCode":"TXG"},{"StopUID":"TXG15","StopID":"15","StopName":{"Zh_tw":"監理站","En":"Motor Vehicles Office"},"StopBoarding":0,"StopSequence":16,"StopPosition":{"PositionLat":24.1610566666667,"PositionLon":120.692268333333,"GeoHash":"wsmc6qmkm"},"StationGroupID":"0892","LocationCityCode":"TXG"},{"StopUID":"TXG14","StopID":"14","StopName":{"Zh_tw":"北屯國小(北屯路)","En":"Beitun Elementary School(Beitun Rd.)"},"StopBoarding":0,"StopSequence":17,"StopPosition":{"PositionLat":24.1630883333333,"PositionLon":120.693236666667,"GeoHash":"wsmc6qy0h"},"StationGroupID":"5405","LocationCityCode":"TXG"},{"StopUID":"TXG67","StopID":"67","StopName":{"Zh_tw":"北屯","En":"Beitun"},"StopBoarding":0,"StopSequence":18,"StopPosition":{"PositionLat":24.1653033333333,"PositionLon":120.694553333333,"GeoHash":"wsmc6rpj4"},"StationGroupID":"0492","LocationCityCode":"TXG"},{"StopUID":"TXG12","StopID":"12","StopName":{"Zh_tw":"三光國中","En":"Sanguang junior high school"},"StopBoarding":0,"StopSequence":19,"StopPosition":{"PositionLat":24.1680233333333,"PositionLon":120.696393333333,"GeoHash":"wsmc6x8kv"},"StationGroupID":"5511","LocationCityCode":"TXG"},{"StopUID":"TXG11","StopID":"11","StopName":{"Zh_tw":"大坑口","En":"Dakengkou"},"StopBoarding":0,"StopSequence":20,"StopPosition":{"PositionLat":24.169653,"PositionLon":120.697361,"GeoHash":"wsmc6xcnk"},"StationGroupID":"0103","LocationCityCode":"TXG"},{"StopUID":"TXG10","StopID":"10","StopName":{"Zh_tw":"聯安醫院","En":"Lian-an Hospital"},"StopBoarding":0,"StopSequence":21,"StopPosition":{"PositionLat":24.170258,"PositionLon":120.69865,"GeoHash":"wsmcd841f"},"StationGroupID":"0222","LocationCityCode":"TXG"},{"StopUID":"TXG22","StopID":"22","StopName":{"Zh_tw":"東光國小","En":"Dongguang Elementary School"},"StopBoarding":0,"StopSequence":22,"StopPosition":{"PositionLat":24.169897,"PositionLon":120.701892,"GeoHash":"wsmc6xurv"},"StationGroupID":"4312","LocationCityCode":"TXG"},{"StopUID":"TXG12476","StopID":"12476","StopName":{"Zh_tw":"東山旱溪西路口","En":"Dongshan-Hanxi W. Intersection"},"StopBoarding":0,"StopSequence":23,"StopPosition":{"PositionLat":24.16954,"PositionLon":120.704422,"GeoHash":"wsmc6xymb"},"StationGroupID":"0284","LocationCityCode":"TXG"},{"StopUID":"TXG9","StopID":"9","StopName":{"Zh_tw":"玫瑰新村","En":"Rose Community"},"StopBoarding":0,"StopSequence":24,"StopPosition":{"PositionLat":24.1695783333333,"PositionLon":120.706738333333,"GeoHash":"wsmc6xzvy"},"StationGroupID":"0679","LocationCityCode":"TXG"},{"StopUID":"TXG21","StopID":"21","StopName":{"Zh_tw":"水景里","En":"Shuijing Village"},"StopBoarding":0,"StopSequence":25,"StopPosition":{"PositionLat":24.1703783333333,"PositionLon":120.70838,"GeoHash":"wsmcdb14t"},"StationGroupID":"0484","LocationCityCode":"TXG"},{"StopUID":"TXG2","StopID":"2","StopName":{"Zh_tw":"三和社區","En":"Sanhe Community"},"StopBoarding":0,"StopSequence":26,"StopPosition":{"PositionLat":24.17121,"PositionLon":120.709553333333,"GeoHash":"wsmcdb4p8"},"StationGroupID":"0325","LocationCityCode":"TXG"},{"StopUID":"TXG3","StopID":"3","StopName":{"Zh_tw":"水景頭","En":"Shuijingtou"},"StopBoarding":0,"StopSequence":27,"StopPosition":{"PositionLat":24.17208,"PositionLon":120.711086666667,"GeoHash":"wsmcdb7hs"},"StationGroupID":"0485","LocationCityCode":"TXG"},{"StopUID":"TXG34","StopID":"34","StopName":{"Zh_tw":"大華新村","En":"Dahua Community"},"StopBoarding":0,"StopSequence":28,"StopPosition":{"PositionLat":24.1737933333333,"PositionLon":120.714403333333,"GeoHash":"wsmcdbtw9"},"StationGroupID":"0365","LocationCityCode":"TXG"},{"StopUID":"TXG33","StopID":"33","StopName":{"Zh_tw":"建功國小","En":"Jien Kong Elementary School"},"StopBoarding":0,"StopSequence":29,"StopPosition":{"PositionLat":24.1754783333333,"PositionLon":120.717335,"GeoHash":"wsmcdcp8m"},"StationGroupID":"0703","LocationCityCode":"TXG"},{"StopUID":"TXG32","StopID":"32","StopName":{"Zh_tw":"軍功里","En":"Jungong Village"},"StopBoarding":0,"StopSequence":30,"StopPosition":{"PositionLat":24.1759,"PositionLon":120.71985,"GeoHash":"wsmce11db"},"StationGroupID":"0727","LocationCityCode":"TXG"},{"StopUID":"TXG31","StopID":"31","StopName":{"Zh_tw":"和平里(東山路)","En":"Heping Village(Dongshan Rd.)"},"StopBoarding":0,"StopSequence":31,"StopPosition":{"PositionLat":24.17601,"PositionLon":120.722056666667,"GeoHash":"wsmce1557"},"StationGroupID":"4592","LocationCityCode":"TXG"},{"StopUID":"TXG30","StopID":"30","StopName":{"Zh_tw":"東山建和路口","En":"Dongshan-Jianhe Intersection"},"StopBoarding":0,"StopSequence":32,"StopPosition":{"PositionLat":24.176140005,"PositionLon":120.724521875,"GeoHash":"wsmce1huj"},"StationGroupID":"6132","LocationCityCode":"TXG"},{"StopUID":"TXG29","StopID":"29","StopName":{"Zh_tw":"正覺寺","En":"Zhengjue Temple"},"StopBoarding":0,"StopSequence":33,"StopPosition":{"PositionLat":24.1764972599,"PositionLon":120.727214813,"GeoHash":"wsmce1ny7"},"StationGroupID":"0555","LocationCityCode":"TXG"},{"StopUID":"TXG22375","StopID":"22375","StopName":{"Zh_tw":"東山松竹路口","En":"Dongshan-Songzhu Intersection"},"StopBoarding":0,"StopSequence":34,"StopPosition":{"PositionLat":24.176836,"PositionLon":120.728954,"GeoHash":"wsmce320k"},"StationGroupID":"6522","LocationCityCode":"TXG"},{"StopUID":"TXG28","StopID":"28","StopName":{"Zh_tw":"大坑9號步道","En":"Dakeng Trail NO.9"},"StopBoarding":0,"StopSequence":35,"StopPosition":{"PositionLat":24.1770116666667,"PositionLon":120.731861666667,"GeoHash":"wsmce3632"},"StationGroupID":"6467","LocationCityCode":"TXG"},{"StopUID":"TXG36","StopID":"36","StopName":{"Zh_tw":"台電東山所","En":"Taipower Dongshan Office"},"StopBoarding":0,"StopSequence":36,"StopPosition":{"PositionLat":24.1771166666667,"PositionLon":120.734638333333,"GeoHash":"wsmce3k3b"},"StationGroupID":"0534","LocationCityCode":"TXG"},{"StopUID":"TXG35","StopID":"35","StopName":{"Zh_tw":"梨仔園","En":"Liziyuan"},"StopBoarding":0,"StopSequence":37,"StopPosition":{"PositionLat":24.17767,"PositionLon":120.735648333333,"GeoHash":"wsmce3mj0"},"StationGroupID":"0768","LocationCityCode":"TXG"},{"StopUID":"TXG18297","StopID":"18297","StopName":{"Zh_tw":"逢甲橋","En":"Fengjia Bridge"},"StopBoarding":0,"StopSequence":38,"StopPosition":{"PositionLat":24.17841667,"PositionLon":120.7372117,"GeoHash":"wsmce3w1k"},"StationGroupID":"0784","LocationCityCode":"TXG"},{"StopUID":"TXG26","StopID":"26","StopName":{"Zh_tw":"大坑圓環","En":"Dakeng Traffic Circle"},"StopBoarding":0,"StopSequence":39,"StopPosition":{"PositionLat":24.178629,"PositionLon":120.73918,"GeoHash":"wsmce3xdd"},"StationGroupID":"0350","LocationCityCode":"TXG"},{"StopUID":"TXG25","StopID":"25","StopName":{"Zh_tw":"大坑橋","En":"Dakeng Bridge"},"StopBoarding":0,"StopSequence":40,"StopPosition":{"PositionLat":24.1777433333333,"PositionLon":120.73951,"GeoHash":"wsmce3rvd"},"StationGroupID":"0351","LocationCityCode":"TXG"},{"StopUID":"TXG24","StopID":"24","StopName":{"Zh_tw":"樂達利山莊","En":"Ledali Community"},"StopBoarding":0,"StopSequence":41,"StopPosition":{"PositionLat":24.1762232015,"PositionLon":120.738002658,"GeoHash":"wsmce3nsx"},"StationGroupID":"0917","LocationCityCode":"TXG"},{"StopUID":"TXG1695","StopID":"1695","StopName":{"Zh_tw":"中臺科技大學校區","En":"C.T.U.S.T. Campus"},"StopBoarding":0,"StopSequence":42,"StopPosition":{"PositionLat":24.1742095947266,"PositionLon":120.735488891602,"GeoHash":"wsmce2ubu"},"StationGroupID":"6019","LocationCityCode":"TXG"}]
     * UpdateTime : 2021-01-18T12:05:17+08:00
     * VersionID : 326
     */

    private String RouteUID;
    private String RouteID;
    private RouteNameDTO RouteName;
    private String SubRouteUID;
    private String SubRouteID;
    private SubRouteNameDTO SubRouteName;
    private int Direction;
    private String City;
    private String CityCode;
    private String UpdateTime;
    private int VersionID;
    private List<OperatorsDTO> Operators;
    private List<StopsDTO> Stops;

    public String getRouteUID() {
        return RouteUID;
    }

    public void setRouteUID(String RouteUID) {
        this.RouteUID = RouteUID;
    }

    public String getRouteID() {
        return RouteID;
    }

    public void setRouteID(String RouteID) {
        this.RouteID = RouteID;
    }

    public RouteNameDTO getRouteName() {
        return RouteName;
    }

    public void setRouteName(RouteNameDTO RouteName) {
        this.RouteName = RouteName;
    }

    public String getSubRouteUID() {
        return SubRouteUID;
    }

    public void setSubRouteUID(String SubRouteUID) {
        this.SubRouteUID = SubRouteUID;
    }

    public String getSubRouteID() {
        return SubRouteID;
    }

    public void setSubRouteID(String SubRouteID) {
        this.SubRouteID = SubRouteID;
    }

    public SubRouteNameDTO getSubRouteName() {
        return SubRouteName;
    }

    public void setSubRouteName(SubRouteNameDTO SubRouteName) {
        this.SubRouteName = SubRouteName;
    }

    public int getDirection() {
        return Direction;
    }

    public void setDirection(int Direction) {
        this.Direction = Direction;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String CityCode) {
        this.CityCode = CityCode;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public int getVersionID() {
        return VersionID;
    }

    public void setVersionID(int VersionID) {
        this.VersionID = VersionID;
    }

    public List<OperatorsDTO> getOperators() {
        return Operators;
    }

    public void setOperators(List<OperatorsDTO> Operators) {
        this.Operators = Operators;
    }

    public List<StopsDTO> getStops() {
        return Stops;
    }

    public void setStops(List<StopsDTO> Stops) {
        this.Stops = Stops;
    }

    public static class RouteNameDTO {
        /**
         * Zh_tw : 1
         * En : 1
         */

        private String Zh_tw;
        private String En;

        public String getZh_tw() {
            return Zh_tw;
        }

        public void setZh_tw(String Zh_tw) {
            this.Zh_tw = Zh_tw;
        }

        public String getEn() {
            return En;
        }

        public void setEn(String En) {
            this.En = En;
        }
    }

    public static class SubRouteNameDTO {
        /**
         * Zh_tw : 1
         * En : 1
         */

        private String Zh_tw;
        private String En;

        public String getZh_tw() {
            return Zh_tw;
        }

        public void setZh_tw(String Zh_tw) {
            this.Zh_tw = Zh_tw;
        }

        public String getEn() {
            return En;
        }

        public void setEn(String En) {
            this.En = En;
        }
    }

    public static class OperatorsDTO {
        /**
         * OperatorID : 15
         * OperatorName : {"Zh_tw":"中台灣客運","En":"Ct Bus Co., Ltd."}
         * OperatorCode : CenterTaiwanBus
         * OperatorNo : 0401
         */

        private String OperatorID;
        private OperatorNameDTO OperatorName;
        private String OperatorCode;
        private String OperatorNo;

        public String getOperatorID() {
            return OperatorID;
        }

        public void setOperatorID(String OperatorID) {
            this.OperatorID = OperatorID;
        }

        public OperatorNameDTO getOperatorName() {
            return OperatorName;
        }

        public void setOperatorName(OperatorNameDTO OperatorName) {
            this.OperatorName = OperatorName;
        }

        public String getOperatorCode() {
            return OperatorCode;
        }

        public void setOperatorCode(String OperatorCode) {
            this.OperatorCode = OperatorCode;
        }

        public String getOperatorNo() {
            return OperatorNo;
        }

        public void setOperatorNo(String OperatorNo) {
            this.OperatorNo = OperatorNo;
        }

        public static class OperatorNameDTO {
            /**
             * Zh_tw : 中台灣客運
             * En : Ct Bus Co., Ltd.
             */

            private String Zh_tw;
            private String En;

            public String getZh_tw() {
                return Zh_tw;
            }

            public void setZh_tw(String Zh_tw) {
                this.Zh_tw = Zh_tw;
            }

            public String getEn() {
                return En;
            }

            public void setEn(String En) {
                this.En = En;
            }
        }
    }

    public static class StopsDTO {
        /**
         * StopUID : TXG19262
         * StopID : 19262
         * StopName : {"Zh_tw":"臺中刑務所演武場","En":"Budokan Martial Arts Hall"}
         * StopBoarding : 0
         * StopSequence : 1
         * StopPosition : {"PositionLat":24.13478,"PositionLon":120.67383,"GeoHash":"wsmc61852"}
         * StationGroupID : 6212
         * LocationCityCode : TXG
         */

        private String StopUID;
        private String StopID;
        private StopNameDTO StopName;
        private int StopBoarding;
        private int StopSequence;
        private StopPositionDTO StopPosition;
        private String StationGroupID;
        private String LocationCityCode;

        public String getStopUID() {
            return StopUID;
        }

        public void setStopUID(String StopUID) {
            this.StopUID = StopUID;
        }

        public String getStopID() {
            return StopID;
        }

        public void setStopID(String StopID) {
            this.StopID = StopID;
        }

        public StopNameDTO getStopName() {
            return StopName;
        }

        public void setStopName(StopNameDTO StopName) {
            this.StopName = StopName;
        }

        public int getStopBoarding() {
            return StopBoarding;
        }

        public void setStopBoarding(int StopBoarding) {
            this.StopBoarding = StopBoarding;
        }

        public int getStopSequence() {
            return StopSequence;
        }

        public void setStopSequence(int StopSequence) {
            this.StopSequence = StopSequence;
        }

        public StopPositionDTO getStopPosition() {
            return StopPosition;
        }

        public void setStopPosition(StopPositionDTO StopPosition) {
            this.StopPosition = StopPosition;
        }

        public String getStationGroupID() {
            return StationGroupID;
        }

        public void setStationGroupID(String StationGroupID) {
            this.StationGroupID = StationGroupID;
        }

        public String getLocationCityCode() {
            return LocationCityCode;
        }

        public void setLocationCityCode(String LocationCityCode) {
            this.LocationCityCode = LocationCityCode;
        }

        public static class StopNameDTO {
            /**
             * Zh_tw : 臺中刑務所演武場
             * En : Budokan Martial Arts Hall
             */

            private String Zh_tw;
            private String En;

            public String getZh_tw() {
                return Zh_tw;
            }

            public void setZh_tw(String Zh_tw) {
                this.Zh_tw = Zh_tw;
            }

            public String getEn() {
                return En;
            }

            public void setEn(String En) {
                this.En = En;
            }

            @Override
            public String toString() {
                return getZh_tw();
            }
        }

        public static class StopPositionDTO {
            /**
             * PositionLat : 24.13478
             * PositionLon : 120.67383
             * GeoHash : wsmc61852
             */

            private double PositionLat;
            private double PositionLon;
            private String GeoHash;

            public double getPositionLat() {
                return PositionLat;
            }

            public void setPositionLat(double PositionLat) {
                this.PositionLat = PositionLat;
            }

            public double getPositionLon() {
                return PositionLon;
            }

            public void setPositionLon(double PositionLon) {
                this.PositionLon = PositionLon;
            }

            public String getGeoHash() {
                return GeoHash;
            }

            public void setGeoHash(String GeoHash) {
                this.GeoHash = GeoHash;
            }
        }

        @Override
        public String toString() {
            return getStopName().getZh_tw();
        }
    }

    @Override
    public String toString() {
        return getDirection() + getRouteName().Zh_tw + "," + getStops().toString();
    }

}
