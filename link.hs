module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
    where

import Point
import City
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link
newL = Lin

connectsL :: City -> Link -> Bool
connectsL ciudad (Lin city1 city2 _) = ciudad == city1 || ciudad == city2

linksL :: City -> City -> Link -> Bool
linksL ciudad1 ciudad2 conexion = connectsL ciudad1 conexion && connectsL ciudad2 conexion

capacityL :: Link -> Int
capacityL (Lin _ _ quality) = capacityQ quality 

delayL :: Link -> Float
delayL (Lin _ _ quality) = delayQ quality

