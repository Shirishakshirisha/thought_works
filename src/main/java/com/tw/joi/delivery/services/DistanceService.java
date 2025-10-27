package com.tw.joi.delivery.services;
import com.tw.joi.delivery.model.DistanceMap;
import com.tw.joi.delivery.staticData.*;
import java.util.*;

public class DistanceService {
    private final List<DistanceMap> distanceMaps;

    public DistanceService(){
        this.distanceMaps = StaticData.distanceMap;
    }

    public Integer getDistance(String zoneFrom, String zoneTo){
        for(DistanceMap map : distanceMaps){
            if(map.getZoneFrom().equals(zoneFrom) && map.getZoneTo().equals(zoneTo)){
                return map.getDistance();
            }
        }


        for(DistanceMap map : distanceMaps){
            if(map.getZoneFrom().equals(zoneTo) && map.getZoneTo().equals(zoneFrom)){
                return map.getDistance();
            }
        }

        throw new IllegalArgumentException("Distance not fount between " + zoneFrom + "and" + zoneTo);
    }


}
