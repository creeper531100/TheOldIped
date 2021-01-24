package com.example.thenewipad.formatFolder;

import java.util.List;

public class ArriveTime {


    /**
     * PlateNumb :
     * StopUID : TXG10286
     * StopID : 10286
     * StopName : {"Zh_tw":"臺中車站(成功路口)","En":"Taichung Station(Chenggong Intersection)"}
     * RouteUID : TXG701
     * RouteID : 701
     * RouteName : {"Zh_tw":"701","En":"701"}
     * SubRouteUID : TXG701
     * SubRouteID : 701
     * SubRouteName : {"Zh_tw":"701","En":"701"}
     * Direction : 1
     * StopSequence : 5
     * StopStatus : 1
     * NextBusTime : 2021-01-24T18:07:00+08:00
     * SrcUpdateTime : 2021-01-24T17:57:48+08:00
     * UpdateTime : 2021-01-24T17:59:24+08:00
     * EstimateTime : 480
     * Estimates : [{"PlateNumb":"EAA-855","EstimateTime":480,"IsLastBus":false}]
     */

    private String PlateNumb;
    private String StopUID;
    private String StopID;
    private StopNameDTO StopName;
    private String RouteUID;
    private String RouteID;
    private RouteNameDTO RouteName;
    private String SubRouteUID;
    private String SubRouteID;
    private SubRouteNameDTO SubRouteName;
    private int Direction;
    private int StopSequence;
    private int StopStatus;
    private String NextBusTime;
    private String SrcUpdateTime;
    private String UpdateTime;
    private int EstimateTime;
    private List<EstimatesDTO> Estimates;

    public String getPlateNumb() {
        return PlateNumb;
    }

    public void setPlateNumb(String PlateNumb) {
        this.PlateNumb = PlateNumb;
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

    public int getStopSequence() {
        return StopSequence;
    }

    public void setStopSequence(int StopSequence) {
        this.StopSequence = StopSequence;
    }

    public int getStopStatus() {
        return StopStatus;
    }

    public void setStopStatus(int StopStatus) {
        this.StopStatus = StopStatus;
    }

    public String getNextBusTime() {
        return NextBusTime;
    }

    public void setNextBusTime(String NextBusTime) {
        this.NextBusTime = NextBusTime;
    }

    public String getSrcUpdateTime() {
        return SrcUpdateTime;
    }

    public void setSrcUpdateTime(String SrcUpdateTime) {
        this.SrcUpdateTime = SrcUpdateTime;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public int getEstimateTime() {
        return EstimateTime;
    }

    public void setEstimateTime(int EstimateTime) {
        this.EstimateTime = EstimateTime;
    }

    public List<EstimatesDTO> getEstimates() {
        return Estimates;
    }

    public void setEstimates(List<EstimatesDTO> Estimates) {
        this.Estimates = Estimates;
    }

    public static class StopNameDTO {
        /**
         * Zh_tw : 臺中車站(成功路口)
         * En : Taichung Station(Chenggong Intersection)
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

    public static class RouteNameDTO {
        /**
         * Zh_tw : 701
         * En : 701
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
         * Zh_tw : 701
         * En : 701
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

    public static class EstimatesDTO {
        /**
         * PlateNumb : EAA-855
         * EstimateTime : 480
         * IsLastBus : false
         */

        private String PlateNumb;
        private int EstimateTime;
        private boolean IsLastBus;

        public String getPlateNumb() {
            return PlateNumb;
        }

        public void setPlateNumb(String PlateNumb) {
            this.PlateNumb = PlateNumb;
        }

        public int getEstimateTime() {
            return EstimateTime;
        }

        public void setEstimateTime(int EstimateTime) {
            this.EstimateTime = EstimateTime;
        }

        public boolean isIsLastBus() {
            return IsLastBus;
        }

        public void setIsLastBus(boolean IsLastBus) {
            this.IsLastBus = IsLastBus;
        }
    }
}
