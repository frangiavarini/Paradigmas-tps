module Test 
    where

import Region
import City
import Link
import Quality
import Tunel
import Point


-- module Point

point1 = newP 1 2

point2 = newP 3 4

distance = difP point1 point2

-- module City

resistencia = newC "Resistencia" (newP 1 2)

pergamino = newC "Pergamino" (newP 3 4)

buenosaires = newC "Buenos aires" (newP 5 6)

rosario = newC "Rosario" (newP 7 8)

name = nameC resistencia

distanceCities = distanceC resistencia pergamino

-- module Quality

low = newQ "low" 4 2.3

medium = newQ "medium" 5 3.6

high = newQ "high" 7 5.6

capacity1 = capacityQ low

capacity2 = capacityQ medium

capacity3 = capacityQ high

delay1 = delayQ low

delay2 = delayQ medium

delay3 = delayQ high

-- module Link

link1 = newL pergamino resistencia medium

link2 = newL rosario buenosaires high

areConnectedByLink = connectsL pergamino link1

isCityInLink = linksL pergamino resistencia

capacity = capacityL link1

delay = delayL link1

-- module Tunel

tunel1 = newT [link1,link2] 

areConnected = connectsT pergamino resistencia tunel1

uses = usesT link1 tunel1

delaytunel = delayT tunel1

-- module Region

argentina = newR 

argentina1= foundR argentina resistencia

argentina2 = foundR argentina1 pergamino

argentina3 = foundR argentina2 buenosaires

argentina4 = foundR argentina3 rosario

argentina5 = linkR argentina4 resistencia pergamino low

argentina6 = linkR argentina5 pergamino buenosaires medium

argentina7 = linkR argentina6 buenosaires rosario high

citylist= [rosario,buenosaires,pergamino,resistencia]

argentina8 = tunelR argentina7 citylist

argentina9 = connectedR argentina8 buenosaires rosario

argentina10 = delayR argentina8 resistencia pergamino

argentina11 = availableCapacityForR argentina8 resistencia pergamino

argentina12 = linkedR argentina7 resistencia pergamino


testRegion = [
    foundR argentina resistencia, 
    linkR argentina4 resistencia pergamino low, 
    tunelR argentina7 citylist]

testPoint = [
    newP 1 2, 
    newP 3 4]

testCity = [
    newC "Resistencia" (newP 1 2),
    newC "Pergamino" (newP 3 4),
    newC "Buenos aires" (newP 5 6),
    newC "Rosario" (newP 7 8)]

testFloats = [
    difP point1 point2,
    distanceC resistencia pergamino,
    delayQ low,
    delayQ medium,
    delayQ high,
    delayL link1,
    delayT tunel1,
    delayR argentina8 resistencia pergamino]

testInts = [
    capacityQ low,
    capacityQ medium,
    capacityQ high,
    capacityL link1,
    availableCapacityForR argentina8 resistencia pergamino]

testBools = [
    connectsL pergamino link1,
    linksL pergamino resistencia link1,
    connectsT pergamino resistencia tunel1,
    usesT link1 tunel1, connectedR argentina8 buenosaires rosario,
    linkedR argentina7 resistencia pergamino]

