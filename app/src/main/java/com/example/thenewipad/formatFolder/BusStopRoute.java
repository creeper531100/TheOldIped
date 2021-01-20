package com.example.thenewipad.formatFolder;


import java.util.List;

public class BusStopRoute {

    /**
     * RouteName : {"Zh_tw":"1","En":"1"}
     * Direction : 0
     * Stops : [{"StopName":{"Zh_tw":"臺中刑務所演武場","En":"Budokan Martial Arts Hall"}}]
     */

    private RouteNameDTO RouteName;
    private int Direction;
    private List<StopsDTO> Stops;

    public RouteNameDTO getRouteName() {
        return RouteName;
    }

    public void setRouteName(RouteNameDTO RouteName) {
        this.RouteName = RouteName;
    }

    public int getDirection() {
        return Direction;
    }

    public void setDirection(int Direction) {
        this.Direction = Direction;
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

    public static class StopsDTO {
        /**
         * StopName : {"Zh_tw":"臺中刑務所演武場","En":"Budokan Martial Arts Hall"}
         */

        private StopNameDTO StopName;

        public StopNameDTO getStopName() {
            return StopName;
        }

        public void setStopName(StopNameDTO StopName) {
            this.StopName = StopName;
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
                return Zh_tw;
            }
        }

        @Override
        public String toString() {
            return  getStopName().getZh_tw();
        }
    }
}
