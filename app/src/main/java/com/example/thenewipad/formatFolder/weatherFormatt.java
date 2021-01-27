package com.example.thenewipad.formatFolder;

import java.util.List;

public class weatherFormatt {

    private String success;
    private ResultDTO result;
    private RecordsDTO records;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public RecordsDTO getRecords() {
        return records;
    }

    public void setRecords(RecordsDTO records) {
        this.records = records;
    }

    public static class ResultDTO {

        private String resource_id;
        private List<FieldsDTO> fields;

        public String getResource_id() {
            return resource_id;
        }

        public void setResource_id(String resource_id) {
            this.resource_id = resource_id;
        }

        public List<FieldsDTO> getFields() {
            return fields;
        }

        public void setFields(List<FieldsDTO> fields) {
            this.fields = fields;
        }

        public static class FieldsDTO {

            private String id;
            private String type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }

    public static class RecordsDTO {
        private List<LocationsDTO> locations;

        public List<LocationsDTO> getLocations() {
            return locations;
        }

        public void setLocations(List<LocationsDTO> locations) {
            this.locations = locations;
        }

        public static class LocationsDTO {

            private String datasetDescription;
            private String locationsName;
            private String dataid;
            private List<LocationDTO> location;

            public String getDatasetDescription() {
                return datasetDescription;
            }

            public void setDatasetDescription(String datasetDescription) {
                this.datasetDescription = datasetDescription;
            }

            public String getLocationsName() {
                return locationsName;
            }

            public void setLocationsName(String locationsName) {
                this.locationsName = locationsName;
            }

            public String getDataid() {
                return dataid;
            }

            public void setDataid(String dataid) {
                this.dataid = dataid;
            }

            public List<LocationDTO> getLocation() {
                return location;
            }

            public void setLocation(List<LocationDTO> location) {
                this.location = location;
            }

            public static class LocationDTO {

                private String locationName;
                private String geocode;
                private String lat;
                private String lon;
                private List<WeatherElementDTO> weatherElement;

                public String getLocationName() {
                    return locationName;
                }

                public void setLocationName(String locationName) {
                    this.locationName = locationName;
                }

                public String getGeocode() {
                    return geocode;
                }

                public void setGeocode(String geocode) {
                    this.geocode = geocode;
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

                public List<WeatherElementDTO> getWeatherElement() {
                    return weatherElement;
                }

                public void setWeatherElement(List<WeatherElementDTO> weatherElement) {
                    this.weatherElement = weatherElement;
                }

                public static class WeatherElementDTO {


                    private String elementName;
                    private String description;
                    private List<TimeDTO> time;

                    public String getElementName() {
                        return elementName;
                    }

                    public void setElementName(String elementName) {
                        this.elementName = elementName;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public List<TimeDTO> getTime() {
                        return time;
                    }

                    public void setTime(List<TimeDTO> time) {
                        this.time = time;
                    }

                    public static class TimeDTO {
                        /**
                         * startTime : 2021-01-27 06:00:00
                         * endTime : 2021-01-27 18:00:00
                         * elementValue : [{"value":"0","measures":"百分比"}]
                         */

                        private String startTime;
                        private String endTime;
                        private List<ElementValueDTO> elementValue;

                        public String getStartTime() {
                            return startTime;
                        }

                        public void setStartTime(String startTime) {
                            this.startTime = startTime;
                        }

                        public String getEndTime() {
                            return endTime;
                        }

                        public void setEndTime(String endTime) {
                            this.endTime = endTime;
                        }

                        public List<ElementValueDTO> getElementValue() {
                            return elementValue;
                        }

                        public void setElementValue(List<ElementValueDTO> elementValue) {
                            this.elementValue = elementValue;
                        }

                        public static class ElementValueDTO {

                            private String value;
                            private String measures;

                            public String getValue() {
                                return value;
                            }

                            public void setValue(String value) {
                                this.value = value;
                            }

                            public String getMeasures() {
                                return measures;
                            }

                            public void setMeasures(String measures) {
                                this.measures = measures;
                            }
                        }
                    }
                }
            }
        }
    }
}
