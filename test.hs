module Test 
    where

import Region
import City
import Link
import Quality
import Tunel
import Point

resistencia = newC "Resistencia" (newP 1 2)
pergamino = newC "Pergamino" (newP 3 4)
buenosaires = newC "Buenos aires" (newP 5 6)
rosario = newC "Rosario" (newP 7 8)

argentina = newR 

argentina1= foundR argentina resistencia

argentina2 = foundR argentina1 pergamino

argentina3 = foundR argentina2 buenosaires

argentina4 = foundR argentina3 rosario

low = newQ "low" 4 2.3
medium = newQ "medium" 5 3.6
high = newQ "high" 7 5.6

argentina5 = linkR argentina4 resistencia pergamino low

argentina6 = linkR argentina5 pergamino buenosaires medium

argentina7 = linkR argentina6 buenosaires rosario high

citylist= [rosario,buenosaires,pergamino,resistencia]

argentina8 = tunelR argentina7 citylist

argentina9 = delayR argentina8 resistencia pergamino

argentina10 = availableCapacityForR argentina8 resistencia pergamino


{-
availableCapacityForR :: Region -> City -> City -> Int
availableCapacityForR (Reg [] _ _) _ _ = error "No hay links"
availableCapacityForR (Reg (cities : citiesRest) (l : linksRest) tunnels) city1 city2 =
  if linksL city1 city2 l
    then capacityL l - (usedCapacity l r)
    else availableCapacityForR (Reg citiesRest linksRest tunnels) city1 city2
-}