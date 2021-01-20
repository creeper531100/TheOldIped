package com.example.thenewipad.formatFolder;


import android.annotation.SuppressLint;

public class BusArriveStop {

    /**
     * PlateNumb : 079-U8
     * OperatorID : 1
     * RouteUID : TXG12
     * RouteID : 12
     * RouteName : {"Zh_tw":"12","En":"12"}
     * SubRouteUID : TXG12
     * SubRouteID : 12
     * SubRouteName : {"Zh_tw":"12","En":"12"}
     * Direction : 0
     * StopUID : TXG16189
     * StopID : 16189
     * StopName : {"Zh_tw":"中興堂","En":"Chunghsing Hall"}
     * StopSequence : 10
     * DutyStatus : 0
     * BusStatus : 0
     * A2EventType : 0
     * GPSTime : 2021-01-19T21:57:16+08:00
     * UpdateTime : 2021-01-19T21:57:36+08:00
     */

    private String PlateNumb;
    private String OperatorID;
    private String RouteUID;
    private String RouteID;
    private RouteNameDTO RouteName;
    private String SubRouteUID;
    private String SubRouteID;
    private SubRouteNameDTO SubRouteName;
    private int Direction;
    private String StopUID;
    private String StopID;
    private StopNameDTO StopName;
    private int StopSequence;
    private int DutyStatus;
    private int BusStatus;
    private int A2EventType;
    private String GPSTime;
    private String UpdateTime;

    public String getPlateNumb() {
        return PlateNumb;
    }

    public void setPlateNumb(String PlateNumb) {
        this.PlateNumb = PlateNumb;
    }

    public String getOperatorID() {
        return OperatorID;
    }

    public void setOperatorID(String OperatorID) {
        this.OperatorID = OperatorID;
    }

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

    public int getStopSequence() {
        return StopSequence;
    }

    public void setStopSequence(int StopSequence) {
        this.StopSequence = StopSequence;
    }

    public int getDutyStatus() {
        return DutyStatus;
    }

    public void setDutyStatus(int DutyStatus) {
        this.DutyStatus = DutyStatus;
    }

    public int getBusStatus() {
        return BusStatus;
    }

    public void setBusStatus(int BusStatus) {
        this.BusStatus = BusStatus;
    }

    public int getA2EventType() {
        return A2EventType;
    }

    public void setA2EventType(int A2EventType) {
        this.A2EventType = A2EventType;
    }

    public String getGPSTime() {
        return GPSTime;
    }

    public void setGPSTime(String GPSTime) {
        this.GPSTime = GPSTime;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public static class RouteNameDTO {
        /**
         * Zh_tw : 12
         * En : 12
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
         * Zh_tw : 12
         * En : 12
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

    public static class StopNameDTO {
        /**
         * Zh_tw : 中興堂
         * En : Chunghsing Hall
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
    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return RouteName.Zh_tw + "," +Direction + "," + StopName.Zh_tw  + "," + PlateNumb;
    }
}

