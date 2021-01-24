package com.example.thenewipad.formatFolder;

import java.util.List;

public class BusRoute {
    /**
     * RouteUID : TXG1
     * RouteID : 1
     * HasSubRoutes : true
     * Operators : [{"OperatorID":"15","OperatorName":{"Zh_tw":"中台灣客運","En":"Ct Bus Co., Ltd."},"OperatorCode":"CenterTaiwanBus","OperatorNo":"0401"},{"OperatorID":"3","OperatorName":{"Zh_tw":"統聯客運","En":"United Highway Bus Co., Ltd."},"OperatorCode":"UnitedHighwayBus","OperatorNo":"1201"}]
     * AuthorityID : 007
     * ProviderID : 007
     * SubRoutes : [{"SubRouteUID":"TXG1","SubRouteID":"1","OperatorIDs":["15","3"],"SubRouteName":{"Zh_tw":"1","En":"1"},"Headsign":"臺中刑務所演武場 - 中臺科技大學校區","Direction":0},{"SubRouteUID":"TXG1","SubRouteID":"1","OperatorIDs":["15","3"],"SubRouteName":{"Zh_tw":"1","En":"1"},"Headsign":"臺中刑務所演武場 - 中臺科技大學校區","Direction":1}]
     * BusRouteType : 11
     * RouteName : {"Zh_tw":"1","En":"1"}
     * DepartureStopNameZh : 臺中刑務所演武場
     * DepartureStopNameEn : Budokan Martial Arts Hall
     * DestinationStopNameZh : 中臺科技大學校區
     * DestinationStopNameEn : C.T.U.S.T. Campus
     * RouteMapImageUrl : https://citybus.taichung.gov.tw/ebus/route-map/1
     * City : Taichung
     * CityCode : TXG
     * UpdateTime : 2021-01-18T12:05:17+08:00
     * VersionID : 326
     */

    private String RouteUID;
    private String RouteID;
    private boolean HasSubRoutes;
    private String AuthorityID;
    private String ProviderID;
    private int BusRouteType;
    private RouteNameDTO RouteName;
    private String DepartureStopNameZh;
    private String DepartureStopNameEn;
    private String DestinationStopNameZh;
    private String DestinationStopNameEn;
    private String RouteMapImageUrl;
    private String City;
    private String CityCode;
    private String UpdateTime;
    private int VersionID;
    private List<OperatorsDTO> Operators;
    private List<SubRoutesDTO> SubRoutes;

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

    public boolean isHasSubRoutes() {
        return HasSubRoutes;
    }

    public void setHasSubRoutes(boolean HasSubRoutes) {
        this.HasSubRoutes = HasSubRoutes;
    }

    public String getAuthorityID() {
        return AuthorityID;
    }

    public void setAuthorityID(String AuthorityID) {
        this.AuthorityID = AuthorityID;
    }

    public String getProviderID() {
        return ProviderID;
    }

    public void setProviderID(String ProviderID) {
        this.ProviderID = ProviderID;
    }

    public int getBusRouteType() {
        return BusRouteType;
    }

    public void setBusRouteType(int BusRouteType) {
        this.BusRouteType = BusRouteType;
    }

    public RouteNameDTO getRouteName() {
        return RouteName;
    }

    public void setRouteName(RouteNameDTO RouteName) {
        this.RouteName = RouteName;
    }

    public String getDepartureStopNameZh() {
        return DepartureStopNameZh;
    }

    public void setDepartureStopNameZh(String DepartureStopNameZh) {
        this.DepartureStopNameZh = DepartureStopNameZh;
    }

    public String getDepartureStopNameEn() {
        return DepartureStopNameEn;
    }

    public void setDepartureStopNameEn(String DepartureStopNameEn) {
        this.DepartureStopNameEn = DepartureStopNameEn;
    }

    public String getDestinationStopNameZh() {
        return DestinationStopNameZh;
    }

    public void setDestinationStopNameZh(String DestinationStopNameZh) {
        this.DestinationStopNameZh = DestinationStopNameZh;
    }

    public String getDestinationStopNameEn() {
        return DestinationStopNameEn;
    }

    public void setDestinationStopNameEn(String DestinationStopNameEn) {
        this.DestinationStopNameEn = DestinationStopNameEn;
    }

    public String getRouteMapImageUrl() {
        return RouteMapImageUrl;
    }

    public void setRouteMapImageUrl(String RouteMapImageUrl) {
        this.RouteMapImageUrl = RouteMapImageUrl;
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

    public List<SubRoutesDTO> getSubRoutes() {
        return SubRoutes;
    }

    public void setSubRoutes(List<SubRoutesDTO> SubRoutes) {
        this.SubRoutes = SubRoutes;
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

        @Override
        public String toString() {
            return Zh_tw;
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

    public static class SubRoutesDTO {
        /**
         * SubRouteUID : TXG1
         * SubRouteID : 1
         * OperatorIDs : ["15","3"]
         * SubRouteName : {"Zh_tw":"1","En":"1"}
         * Headsign : 臺中刑務所演武場 - 中臺科技大學校區
         * Direction : 0
         */

        private String SubRouteUID;
        private String SubRouteID;
        private SubRouteNameDTO SubRouteName;
        private String Headsign;
        private int Direction;
        private List<String> OperatorIDs;

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

        public String getHeadsign() {
            return Headsign;
        }

        public void setHeadsign(String Headsign) {
            this.Headsign = Headsign;
        }

        public int getDirection() {
            return Direction;
        }

        public void setDirection(int Direction) {
            this.Direction = Direction;
        }

        public List<String> getOperatorIDs() {
            return OperatorIDs;
        }

        public void setOperatorIDs(List<String> OperatorIDs) {
            this.OperatorIDs = OperatorIDs;
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

        @Override
        public String toString() {
            return Headsign;
        }
    }
    @Override
    public String toString() {
        return getRouteName() + "," + getSubRoutes().get(0);
    }
    /*{
     * 0701: [三村里, 合作國小...],
     * 1701: [合作國小, 三村里...]
     *}
     */
}
